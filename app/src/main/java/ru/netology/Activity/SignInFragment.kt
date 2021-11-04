package ru.netology.Activity

import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import ru.netology.AndroidUtils
import ru.netology.R
import ru.netology.databinding.FragmentSignInBinding
import ru.netology.viewModel.AuthViewModel
import ru.netology.viewModel.PostViewModel

class SignInFragment : Fragment() {


    private val viewModel: PostViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )
    private val authViewModel: AuthViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignInBinding.inflate(inflater, container, false)


        binding.backToThePostMb.setOnClickListener {

            with(binding.backToThePostMb) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                ru.netology.AndroidUtils.hideKeyboard(this)
                findNavController().navigateUp()
            }
        }

        binding.enterBt.setOnClickListener {
            if (TextUtils.isEmpty(binding.loginEt.text) || TextUtils.isEmpty(binding.passwordEt.text)) {
                val toast = Toast.makeText(
                    requireContext(),
                    getString(R.string.EnterTheLogAndPass),
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                return@setOnClickListener
            } else {
                authViewModel.updateUserAuth(
                    binding.loginEt.text.toString(),
                    binding.passwordEt.text.toString()
                )
                findNavController().navigateUp()
            }

        }
        return binding.root
    }

}

