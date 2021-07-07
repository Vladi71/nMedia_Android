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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFeedBinding.inflate(inflater, container, false)

        binding.swipeRefresh.setOnRefreshListener {
            viewModel.loadPosts()
            binding.swipeRefresh.isRefreshing = false
            binding.swipeRefresh.setColorSchemeResources(
                android.R.color.holo_purple
            )
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

        })
        binding.listPost.adapter = adapter
        viewModel.data.observe(viewLifecycleOwner, { state ->
            adapter.submitList(state.posts)
            if (state.internetError) {
                intError()
                binding.errorGroup.isVisible = true
            }
            binding.progress.isVisible = state.loading
            binding.errorGroup.isVisible = state.error
            binding.emptyText.isVisible = state.empty

        })

        binding.retryButton.setOnClickListener {
            viewModel.loadPosts()
        }
        viewModel.edited.observe(viewLifecycleOwner) { post ->
            if (post.id == 0L) {
                return@observe
            }
        }

        binding.addPostView.setOnClickListener {
            findNavController().navigate(R.id.action_feedFragment_to_newPostFragment)
        }

        return binding.root
    }
    fun intError(){
        Toast.makeText(
            requireContext(),
            getString(R.string.IntError),
            Toast.LENGTH_SHORT
        ).show()
    }


}



