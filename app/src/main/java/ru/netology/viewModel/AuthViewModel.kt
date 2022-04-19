package ru.netology.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appAuth: AppAuth,
    private val repository: UserRepository
) : ViewModel() {

    private val _user = MutableSharedFlow<UserModel>()
    val user: LiveData<UserModel>
        get() = _user.asLiveData()

    val data: LiveData<AuthState> = appAuth
        .authStateFlow
        .asLiveData(Dispatchers.Default)

    val authenticated: Boolean
        get() = appAuth.authStateFlow.value.id != 0L

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