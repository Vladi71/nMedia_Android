package ru.netology.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.iid.FirebaseInstanceId
import ru.netology.R
import ru.netology.databinding.ActivityAppBinding
import ru.netology.nmedia.auth.AppAuth
import ru.netology.viewModel.AuthViewModel

class AppActivity : AppCompatActivity() {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)


        intent?.let {
            if (it.action != Intent.ACTION_SEND) {
                return@let
            }

            val text = it.getStringExtra(Intent.EXTRA_TEXT)
            if (text.isNullOrBlank()) {
                Snackbar.make(binding.root, R.string.error_empty_content, LENGTH_INDEFINITE)
                    .setAction(android.R.string.ok) {
                        finish()
                    }
                    .show()
                return@let
            }
        }
        viewModel.data.observe(this) {
            invalidateOptionsMenu()
        }
        checkGoogleApiAvailability()
    }



    private fun checkGoogleApiAvailability() {
        with(GoogleApiAvailability.getInstance()) {
            val code = isGooglePlayServicesAvailable(this@AppActivity)
            if (code == ConnectionResult.SUCCESS) {
                return@with
            }
            if (isUserResolvableError(code)) {
                getErrorDialog(this@AppActivity, code, 9000).show()
                return
            }
            Toast.makeText(this@AppActivity, R.string.google_play_unavailable, Toast.LENGTH_LONG)
                .show()
        }

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            println(it.token)
        }
    }
}

