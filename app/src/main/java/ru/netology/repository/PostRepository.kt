package ru.netology.repository


import ru.netology.dto.Post

interface PostRepository {
    fun getAll(): List<Post>
    fun likeById(id: Long): Post
    fun unLikeById(id: Long): Post
    fun removeById(id: Long)
    fun save(post: Post)

    fun getAllAsync(callback: Callback<List<Post>>)
    fun getPostAsync(id: Long, callback: Callback<Post>)
    fun likeByIdAsync(id: Long, callback: Callback<Post>)
    fun unLikeByIdAsync(id: Long, callback: Callback<Post>)
    fun saveAsync(post: Post, callback: Callback<Post>)
    fun removeAsync(id: Long, callback: Callback<Any>)

    interface Callback<T> {
        fun onSuccess(value: T) {}
        fun onError(e: Exception) {}
    }
}
