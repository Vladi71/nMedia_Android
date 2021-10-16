package ru.netology.Activity


import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.netology.R
import ru.netology.StringArg
import ru.netology.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {

    private var fragmentBinding: FragmentPhotoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val activity = requireActivity()
        if (activity is AppActivity) {
            val statusBarColor = ContextCompat.getColor(requireActivity(), R.color.black)
            activity.window.statusBarColor = statusBarColor
            activity.supportActionBar?.setBackgroundDrawable(ColorDrawable(statusBarColor))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentPhotoBinding.inflate(inflater, container, false)

        binding.backToThePostMb.setOnClickListener {
            findNavController().navigateUp()
        }
        fragmentBinding = binding
        val id = arguments?.getString("id")
        val urlImg = "http://10.0.2.2:9999/media/${id}"
        Glide.with(binding.photoV)
            .load(urlImg)
            .placeholder(R.drawable.ic_baseline_cloud_download_24)
            .error(R.drawable.ic_baseline_image_24)
            .timeout(10000)
            .into(binding.photoV)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBinding = null
        val activity = requireActivity()
        if (activity is AppActivity) {
            val statusBarColor =
                ContextCompat.getColor(requireActivity(), R.color.design_default_color_primary_dark)
            activity.supportActionBar?.setBackgroundDrawable(ColorDrawable(statusBarColor))
            activity.window.statusBarColor = statusBarColor


        }
    }
}
