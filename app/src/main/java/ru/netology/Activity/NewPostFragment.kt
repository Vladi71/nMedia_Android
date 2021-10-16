package ru.netology.Activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.snackbar.Snackbar
import ru.netology.AndroidUtils
import ru.netology.R
import ru.netology.StringArg
import ru.netology.databinding.FragmentNewPostBinding
import ru.netology.viewModel.PostViewModel
import java.io.File

class NewPostFragment : Fragment() {
    private val photoRequestCode = 1
    private val cameraRequestCode = 2

    companion object {
        var Bundle.textArg: String? by StringArg
    }

    private val viewModel: PostViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )

    private var fragmentBinding: FragmentNewPostBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.saveIv -> {
                fragmentBinding?.let {
                    viewModel.changeContent(it.contentEt.text.toString())
                    viewModel.save()
                    AndroidUtils.hideKeyboard(requireView())
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNewPostBinding.inflate(
            inflater,
            container,
            false
        )
        fragmentBinding = binding

        arguments?.textArg
            ?.let(binding.contentEt::setText)

        binding.contentEt.requestFocus()

        binding.pickPhoto.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(2048)
                .galleryOnly()
                .galleryMimeTypes(arrayOf(
                    "image/png",
                    "image/jpeg",
                ))
                .start(photoRequestCode)
            binding.buttonPanel.visibility = View.GONE
        }
        binding.addIv.setOnClickListener{
            if (!binding.buttonPanel.isVisible){
                binding.buttonPanel.visibility = View.VISIBLE
            }else{
                binding.buttonPanel.visibility = View.GONE
            }
        }
        binding.cancelIv.setOnClickListener {

            with(binding.contentEt) {
                viewModel.cancelChange()
                setText("")
                clearFocus()
                AndroidUtils.hideKeyboard(this)
                findNavController().navigateUp()
            }
        }

        binding.takePhoto.setOnClickListener {
            ImagePicker.with(this)
                .crop()
                .compress(2048)
                .cameraOnly()
                .start(cameraRequestCode)
            binding.buttonPanel.visibility = View.GONE
        }

        binding.cancelPhotoIm.setOnClickListener {
            viewModel.changePhoto(null, null)
        }

        viewModel.postCreated.observe(viewLifecycleOwner) {
            findNavController().navigateUp()
        }

        viewModel.photo.observe(viewLifecycleOwner) {
            if (it.uri == null) {
                binding.photoContainer.visibility = View.GONE
                return@observe
            }

            binding.photoContainer.visibility = View.VISIBLE
            binding.photoIv.setImageURI(it.uri)
        }

        binding.saveIv.setOnClickListener {
            if (TextUtils.isEmpty(binding.contentEt.text)) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.EnterTheText),
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            } else {
                val contentText = binding.contentEt.text.toString()

                viewModel.changeContent(contentText)
                viewModel.save()
                AndroidUtils.hideKeyboard(requireView())
            }
        }
        viewModel.postCreated.observe(viewLifecycleOwner) {
            viewModel.loadPosts()
            findNavController().navigateUp()
        }
        return binding.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == ImagePicker.RESULT_ERROR) {
            fragmentBinding?.let {
                Snackbar.make(it.root, ImagePicker.getError(data), Snackbar.LENGTH_LONG).show()
            }
            return
        }
        if (resultCode == Activity.RESULT_OK && requestCode == photoRequestCode) {
            val uri: Uri? = data?.data
            val file: File? = ImagePicker.getFile(data)
            viewModel.changePhoto(uri, file)
            return
        }
        if (resultCode == Activity.RESULT_OK && requestCode == cameraRequestCode) {
            val uri: Uri? = data?.data
            val file: File? = ImagePicker.getFile(data)
            viewModel.changePhoto(uri, file)
            return
        }
    }

    override fun onDestroyView() {
        fragmentBinding = null
        super.onDestroyView()
    }

}
