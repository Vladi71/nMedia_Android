package ru.netology.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.SingleLiveEvent
import ru.netology.dto.Post
import ru.netology.model.FeedModel
import ru.netology.repository.PostRepository
import ru.netology.repository.PostRepositoryImpl
import java.io.IOException
import java.util.concurrent.Executors


private val empty = Post(
    id = 0,
    author = "",
    authorAvatar = "netology.jpg",
    content = "",
    published = 0,
    likedByMe = false,
    likes = 0
)

class PostViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostRepository = PostRepositoryImpl()
    private val _data = MutableLiveData(FeedModel())
    val data: LiveData<FeedModel>
        get() = _data
    val edited = MutableLiveData(empty)
    private val _postCreated = SingleLiveEvent<Unit>()
    val postCreated: LiveData<Unit>
        get() = _postCreated


    init {
        loadPosts()
    }

    fun loadPosts() {
        _data.value = FeedModel(loading = true)
        repository.getAllAsync(object : PostRepository.Callback<List<Post>> {
            override fun onSuccess(posts: List<Post>) {
                _data.postValue(FeedModel(posts = posts, empty = posts.isEmpty()))
            }

            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))
            }
        })
    }

    fun save() {
        edited.value?.let {
            repository.saveAsync(it, object : PostRepository.Callback<Post> {
                override fun onSuccess(post: Post) {
                    _data.postValue(
                        FeedModel(posts = _data.value?.posts
                            .orEmpty().map { if (it.id == post.id) post else it })
                    )

                }

                override fun onError(e: Exception) {
                    _postCreated.postValue(Unit)
                }
            })
            edited.value = empty
        }
    }


    fun edit(post: Post) {
        edited.value = post
    }

    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.content == text) {
            return
        }
        edited.value = edited.value?.copy(content = text)
    }

    fun likeById(id: Long) {
        repository.likeByIdAsync(id, object : PostRepository.Callback<Post> {
            override fun onSuccess(value: Post) {
                val updatedPost = repository.likeById(id)
                _data.postValue(
                    _data.value?.copy(posts = _data.value?.posts.orEmpty()
                        .map { if (it.id != updatedPost.id) it else updatedPost }
                    )
                )
            }

            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))
            }
        })
    }

    fun unLikeById(id: Long) {
        repository.unLikeByIdAsync(id, object : PostRepository.Callback<Post> {
            override fun onSuccess(value: Post) {
                val updatedPost = repository.unLikeById(id)
                _data.postValue(
                    _data.value?.copy(posts = _data.value?.posts.orEmpty()
                        .map { if (it.id != updatedPost.id) it else updatedPost }
                    )
                )
            }

            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))
            }
        })

    }


    fun removeById(id: Long) {
        val old = _data.value?.posts.orEmpty()
        repository.removeAsync(id, object : PostRepository.Callback<Any> {
            override fun onSuccess(value: Any) {

                _data.postValue(
                    _data.value?.copy(posts = _data.value?.posts.orEmpty()
                        .filter { it.id != id }
                    )
                )
                try {
                    repository.removeById(id)
                } catch (e: IOException) {
                    _data.postValue(_data.value?.copy(posts = old))
                    return
                }
            }
            override fun onError(e: Exception) {
                _data.postValue(FeedModel(error = true))

            }
        })

    }


    fun openPost(post: Post) {
        edited.value = post
    }

    fun cancelChange() {
        edited.value = edited.value
    }
}

