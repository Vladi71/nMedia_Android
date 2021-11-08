package ru.netology.repository

import ru.netology.dto.AuthUser

interface UserRepository {
    suspend fun loginUser(login: String, pass: String): AuthUser
    suspend fun regUser(login: String, pass: String, name: String): AuthUser
}