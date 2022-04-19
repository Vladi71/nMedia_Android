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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.netology.R
import ru.netology.adapter.OnInteractionListener
import ru.netology.adapter.PostAdapter
import ru.netology.databinding.FragmentSignInBinding
import ru.netology.nmedia.auth.AppAuth
import ru.netology.viewModel.AuthViewModel
import ru.netology.viewModel.PostViewModel

@AndroidEntryPoint
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
        var isNavigating = false
        binding.backToThePostMb.setOnClickListener {

            with(binding.backToThePostMb) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                ru.netology.AndroidUtils.hideKeyboard(this)
                findNavController().navigate(R.id.action_signInFragment_to_feedFragment)
            }
        }
        binding.singUpTV.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
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
                authViewModel.updateSingIn(
                    binding.loginEt.text.toString(),
                    binding.passwordEt.text.toString()
                )
                authViewModel.user.observe(viewLifecycleOwner) { state ->
                    if (state.error) {
                        val toast = Toast.makeText(
                            requireContext(),
                            getString(R.string.invalidTheLogAndPass),
                            Toast.LENGTH_SHORT
                        )
                        toast.setGravity(Gravity.CENTER, 0, 0)
                        toast.show()
                        return@observe
                    } else if (!isNavigating) {
                        isNavigating = true
                        findNavController().navigate(R.id.action_signInFragment_to_feedFragment)
                    }
                }
            }
        }
        return binding.root
    }
}

