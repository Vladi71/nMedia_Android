package ru.netology.repository

import ru.netology.api.PostsApi
import ru.netology.dto.AuthUser
import ru.netology.error.ApiError
import ru.netology.error.NetworkError
import ru.netology.error.UnknownError
import ru.netology.nmedia.auth.AppAuth
import java.io.IOException

class UserRepositoryImpl() : UserRepository {

    private fun setAuth(id: Long, token: String) {
        AppAuth.getInstance().setAuth(id, token)
    }

    override suspend fun loginUser(login: String, pass: String): AuthUser {
        try {
            val response = PostsApi.service.updateUser(login, pass)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            setAuth(body.id, body.token)
            return response.body() ?: throw ApiError(response.code(), response.message())
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }

    override suspend fun regUser(login: String, pass: String, name: String): AuthUser {
        try {
            val response = PostsApi.service.registerUser(login, pass, name)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            loginUser(login, pass)
            return response.body() ?: throw ApiError(response.code(), response.message())
        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {
            throw UnknownError
        }
    }
}
