package ru.netology.repository



import kotlinx.coroutines.flow.Flow
import ru.netology.dao.PostDao
import ru.netology.dto.Post


interface PostRepository {
        val data: Flow<List<Post>>
        suspend fun likeById(id: Long)
        suspend fun unLikeById(id: Long)
        suspend fun removeById(id: Long)
        suspend fun save(post: Post)
        suspend fun getAll()
        fun getNewerCount(id: Long): Flow<Int>
        suspend fun markPostToShow()
        suspend fun getPostById(id: Long): PostDao
}


