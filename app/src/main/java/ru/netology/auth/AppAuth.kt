package ru.netology.nmedia.auth

import android.content.Context
import android.content.SharedPreferences
import com.google.android.gms.common.api.Api
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import ru.netology.TOKEN_KAY
import ru.netology.api.ApiService
import ru.netology.dto.PushToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppAuth @Inject constructor(
    private val apiService: ApiService,
    private val prefs: SharedPreferences
) {

    private val idKey = "id"

    private val _authStateFlow: MutableStateFlow<AuthState>

    init {
        val id = prefs.getLong(idKey, 0)
        val token = prefs.getString(TOKEN_KAY, null)

        if (id == 0L || token == null) {
            _authStateFlow = MutableStateFlow(AuthState())
            with(prefs.edit()) {
                clear()
                apply()
            }
        } else {
            _authStateFlow = MutableStateFlow(AuthState(id, token))
        }
        sendPushToken()
    }

    val authStateFlow: StateFlow<AuthState> = _authStateFlow.asStateFlow()

    @Synchronized
    fun setAuth(id: Long, token: String) {
        _authStateFlow.value = AuthState(id, token)
        with(prefs.edit()) {
            putLong(idKey, id)
            putString(TOKEN_KAY, token)
            apply()
        }
        sendPushToken()
    }

    @Synchronized
    fun removeAuth() {
        _authStateFlow.value = AuthState()
        with(prefs.edit()) {
            clear()
            commit()
        }
        sendPushToken()
    }

    fun sendPushToken(token: String? = null) {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                val pushToken = PushToken(token ?: Firebase.messaging.token.await())
                apiService.save(pushToken)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}

data class AuthState(val id: Long = 0, val token: String? = null)