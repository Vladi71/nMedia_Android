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
import ru.netology.databinding.FragmentSignUpBinding
import ru.netology.viewModel.AuthViewModel
import ru.netology.viewModel.PostViewModel

@AndroidEntryPoint
class SignUpFragment : Fragment() {

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
        val binding = FragmentSignUpBinding.inflate(inflater, container, false)


        binding.backToThePostMb.setOnClickListener {

            with(binding.backToThePostMb) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                ru.netology.AndroidUtils.hideKeyboard(this)
                findNavController().navigate(R.id.action_signUpFragment_to_feedFragment)
            }
        }
        binding.singInTV.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }

        binding.registerBt.setOnClickListener {
            if (TextUtils.isEmpty(binding.loginEt.text) || TextUtils.isEmpty(binding.passwordEt.text)
                || TextUtils.isEmpty(binding.nameEt.text) || TextUtils.isEmpty(binding.repPasswordEt.text)
            ) {
                val toast = Toast.makeText(
                    requireContext(),
                    getString(R.string.fillInAllTheFields),
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                return@setOnClickListener

            } else if (binding.repPasswordEt.text.toString() != binding.passwordEt.text.toString()) {
                val toast = Toast.makeText(
                    requireContext(),
                    getString(R.string.passwordDoesnMatch),
                    Toast.LENGTH_SHORT
                )
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                return@setOnClickListener
            } else {

                authViewModel.updateSingUp(
                    binding.loginEt.text.toString(),
                    binding.passwordEt.text.toString(),
                    binding.nameEt.text.toString()
                )
                findNavController().navigate(R.id.action_signUpFragment_to_feedFragment)
            }
        }
        val adapter = PostAdapter(object : OnInteractionListener {
        })
        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest { state ->
                binding.swipeRefresh.isRefreshing =
                    state.refresh is LoadState.Loading ||
                            state.prepend is LoadState.Loading ||
                            state.append is LoadState.Loading
            }
        }
        binding.swipeRefresh.setOnRefreshListener(adapter::refresh)
        return binding.root
    }

}

