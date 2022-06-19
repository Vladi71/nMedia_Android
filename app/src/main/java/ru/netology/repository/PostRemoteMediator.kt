package ru.netology.repository

import androidx.paging.*
import androidx.room.withTransaction
import ru.netology.api.ApiService
import ru.netology.dao.PostDao
import ru.netology.dao.PostRemoteKeyDao
import ru.netology.entity.PostEntity
import ru.netology.entity.PostRemoteKeyEntity
import ru.netology.error.ApiError
import ru.netology.nmedia.db.AppDb
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PostRemoteMediator @Inject constructor(
    private val service: ApiService,
    private val postDao: PostDao,
    private val postRemoteKeyDao: PostRemoteKeyDao,
    private val db: AppDb
) : RemoteMediator<Int, PostEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PostEntity>
    ): MediatorResult {
        try {
            val response = when (loadType) {
                LoadType.REFRESH -> {
                    val id: Long? = postRemoteKeyDao.max()

                    if (id != null) {
                        service.getAfter(id, state.config.initialLoadSize)
                    } else {
                        service.getLatest(state.config.initialLoadSize)
                    }
                }
                LoadType.PREPEND -> service.getAfter(
                    postRemoteKeyDao.max() ?: return MediatorResult.Success(true),
                    state.config.pageSize
                )
                LoadType.APPEND -> service.getBefore(
                    postRemoteKeyDao.min() ?: return MediatorResult.Success(false),
                    state.config.pageSize
                )
            }

            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiError(
                response.code(),
                response.message(),
            )

            db.withTransaction {
                when (loadType) {
                    LoadType.REFRESH -> {
                        postRemoteKeyDao.insert(
                            listOf(
                                PostRemoteKeyEntity(
                                    type = PostRemoteKeyEntity.KeyType.AFTER,
                                    id = body.first().id,
                                ),
                                PostRemoteKeyEntity(
                                    type = PostRemoteKeyEntity.KeyType.AFTER,
                                    id = body.last().id,
                                )
                            )
                        )
                    }
                    LoadType.APPEND -> {
                        postRemoteKeyDao.insert(
                            PostRemoteKeyEntity(
                                type = PostRemoteKeyEntity.KeyType.AFTER,
                                id = body.last().id,
                            )
                        )
                    }
                }
            }
            postDao.insert(body.map(PostEntity::fromDto))
            return MediatorResult.Success(body.isEmpty())
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}
