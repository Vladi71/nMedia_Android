package ru.netology.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.netology.dao.PostDao
import ru.netology.dto.Media
import ru.netology.dto.MediaUpload
import ru.netology.dto.Post
import ru.netology.entity.PostEntity


interface PostRepository {
    val data: Flow<PagingData<Post>>
    suspend fun likeById(id: Long)
    suspend fun unLikeById(id: Long)
    suspend fun removeById(id: Long)
    suspend fun save(post: Post)
    suspend fun getAll()
    suspend fun saveWithAttachment(post: Post, upload: MediaUpload)
    fun getNewerCount(id: Long): Flow<Int>
    suspend fun markPostToShow()
    suspend fun getPostById(id: Long): Post
    suspend fun upload(upload: MediaUpload): Media
}


