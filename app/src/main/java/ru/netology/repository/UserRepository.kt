package ru.netology.repository

import ru.netology.dto.AuthUser

interface UserRepository {
    suspend fun loginUser(login: String, pass: String) : AuthUser
}