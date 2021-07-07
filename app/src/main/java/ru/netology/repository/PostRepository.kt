package ru.netology.repository


import ru.netology.dto.Post

interface PostRepository {
    fun getAllAsync(callback: Callback<List<Post>>)
    fun getPostAsync(id: Long, callback: Callback<Post>)
    fun likeById(id: Long, callback: Callback<Post>)
    fun unLikeById(id: Long, callback: Callback<Post>)
    fun removeById(id: Long, callback: Callback<Unit>)
    fun save(post: Post, callback: Callback<Post>)


    interface Callback<T> {
        fun onSuccess(posts: T) {}
        fun onError(e: Exception) {}
    }
}
class BadConnectionException(message:String): Exception(message)
