package ru.netology.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import ru.netology.SingleLiveEvent
import ru.netology.Utils
import ru.netology.nmedia.auth.AppAuth
import ru.netology.nmedia.auth.AuthState
import ru.netology.nmedia.viewmodel.UserModel
import ru.netology.repository.UserRepository
import ru.netology.repository.UserRepositoryImpl


class AuthViewModel : ViewModel() {

    private val _user = MutableSharedFlow<UserModel>()
    val user: LiveData<UserModel>
        get() = _user.asLiveData()

    private val repository: UserRepository = UserRepositoryImpl()

    val data: LiveData<AuthState> = AppAuth.getInstance()
        .authStateFlow
        .asLiveData(Dispatchers.Default)

    val authenticated: Boolean
        get() = AppAuth.getInstance().authStateFlow.value.id != 0L

    fun updateSingIn(login: String, pass: String) = viewModelScope.launch {
        try {
            _user.emit(UserModel(repository.loginUser(login, pass)))
        } catch (e: Exception) {
            _user.emit(UserModel(error = true, user = Utils.EmptyUser.emptyUser))
        }
    }

    fun updateSingUp(login: String, pass: String, name: String) = viewModelScope.launch {
        try {
            _user.emit(UserModel(repository.regUser(login, pass, name)))
        } catch (e: Exception) {
            _user.emit(UserModel(error = true, user = Utils.EmptyUser.emptyUser))
        }
    }
}