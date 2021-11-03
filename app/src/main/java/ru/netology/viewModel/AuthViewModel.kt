package ru.netology.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.netology.SingleLiveEvent
import ru.netology.Utils
import ru.netology.dto.AuthUser
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.auth.AuthState
import ru.netology.nmedia.viewmodel.UserModel
import ru.netology.repository.UserRepository
import ru.netology.repository.UserRepositoryImpl


class AuthViewModel : ViewModel() {

    private val _user = SingleLiveEvent<UserModel>()
    private val repository: UserRepository = UserRepositoryImpl()

    val data: LiveData<AuthState> = AppAuth.getInstance()
        .authStateFlow
        .asLiveData(Dispatchers.Default)
    val authenticated: Boolean
        get() = AppAuth.getInstance().authStateFlow.value.id != 0L

    fun updateUserAuth(login: String, pass: String) = viewModelScope.launch {
        try {
            _user.value = UserModel(repository.loginUser(login, pass))
        } catch (e: Exception) {
            _user.value = UserModel(error = true, user = Utils.EmptyUser.emptyUser)
        }
    }

}