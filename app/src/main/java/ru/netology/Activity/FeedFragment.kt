package ru.netology.Activity


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import ru.netology.Activity.PhotoFragment.Companion.urlArg
import ru.netology.R
import ru.netology.adapter.OnInteractionListener
import ru.netology.adapter.PostAdapter
import ru.netology.databinding.FragmentFeedBinding
import ru.netology.dto.Post
import ru.netology.viewModel.PostViewModel

class FeedFragment : Fragment() {


    private val viewModel: PostViewModel by viewModels(
        ownerProducer = ::requireParentFragment
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val binding = FragmentFeedBinding.inflate(inflater, container, false)



        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshPosts()
            binding.swipeRefresh.setColorSchemeResources(
                android.R.color.holo_red_dark,
                android.R.color.holo_blue_dark
            )
            binding.newPostsChip.visibility = View.GONE
        }

        val adapter = PostAdapter(object : OnInteractionListener {


            override fun onLike(post: Post) {
                if (!post.likedByMe) {
                    viewModel.likeById(post.id)
                } else {
                    viewModel.unLikeById(post.id)
                }
            }


            override fun onRemove(post: Post) {
                viewModel.removeById(post.id)
            }

            override fun onEdit(post: Post) {
                viewModel.edit(post)
                val bundle = Bundle()
                bundle.putString("text", post.content)
                findNavController().navigate(R.id.action_feedFragment_to_editPostFragment, bundle)
            }

            override fun onCancelEdit(post: Post) {
                viewModel.cancelChange()

            }

            override fun onOpenPost(post: Post) {
                viewModel.openPost(post)
                val bundle = Bundle()
                bundle.putLong("id", post.id)
                findNavController().navigate(R.id.action_feedFragment_to_postFragment, bundle)
            }
            override fun onOpenPhoto(post: Post) {
                viewModel.openPost(post)
                val bundle = Bundle()
                bundle.putString("id",post.attachment?.url )
                findNavController().navigate(R.id.action_feedFragment_to_photoFragment, bundle)
            }


        })
        binding.listPost.adapter = adapter
        viewModel.dataState.observe(viewLifecycleOwner) { state ->
            binding.progress.isVisible = state.loading
            binding.swipeRefresh.isRefreshing = state.refreshing
            binding.errorGroup.isVisible = state.error
        }

        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it.posts)
            binding.emptyText.isVisible = it.empty
        }

        binding.retryButton.setOnClickListener {
            viewModel.loadPosts()
        }
        viewModel.edited.observe(viewLifecycleOwner) { post ->
            if (post.id == 0L) {
                return@observe
            }
        }
        viewModel.newerCount.observe(viewLifecycleOwner) { state ->
            println(state)
        }

        viewModel.newerCount.observe(viewLifecycleOwner, { state ->
            when {
                state != 0 -> binding.newPostsChip.visibility = View.VISIBLE
                else -> binding.newPostsChip.visibility = View.GONE
            }
        })

        binding.newPostsChip.setOnClickListener {
            viewModel.run {
                makeReadPosts()
                loadPosts()
            }
            binding.listPost.smoothSnapToPosition(0)
            it.visibility = View.GONE
        }

        binding.addPostView.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_newPostFragment)
        }


        return binding.root
    }

    private fun RecyclerView.smoothSnapToPosition(
        position: Int,
        snapMode: Int = LinearSmoothScroller.SNAP_TO_START
    ) {
        val smoothScroller = object : LinearSmoothScroller(this.context) {
            override fun getVerticalSnapPreference(): Int = snapMode
            override fun getHorizontalSnapPreference(): Int = snapMode
        }
        smoothScroller.targetPosition = position
        layoutManager?.startSmoothScroll(smoothScroller)
    }
}



