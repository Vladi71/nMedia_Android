package ru.netology.nmedia.viewmodel

import ru.netology.Utils
import ru.netology.dto.AuthUser
import ru.netology.viewModel.AuthViewModel

data class UserModel(
    val user: AuthUser = Utils.EmptyUser.emptyUser,
    val error: Boolean = false
)
