package ru.netology.repository

import ru.netology.api.PostsApi
import ru.netology.api.PostsApiService
import ru.netology.dto.AuthUser
import ru.netology.error.ApiError
import ru.netology.error.NetworkError
import ru.netology.error.UnknownError
import java.io.IOException

class UserRepositoryImpl() : UserRepository {
    override suspend fun loginUser(login: String, pass: String): AuthUser {
        try {
            val response = PostsApi.service.updateUser(login, pass)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            return response.body() ?: throw ApiError(response.code(), response.message())
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }
}