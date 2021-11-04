package ru.netology.nmedia.viewmodel

import ru.netology.Utils
import ru.netology.dto.AuthUser

data class UserModel(
    val user: AuthUser = Utils.EmptyUser.emptyUser,
    val error: Boolean = false
)
