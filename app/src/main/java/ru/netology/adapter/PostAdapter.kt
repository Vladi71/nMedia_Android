package ru.netology.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.netology.BuildConfig
import ru.netology.R
import ru.netology.Utils
import ru.netology.databinding.CardAdBinding
import ru.netology.databinding.CardPostBinding
import ru.netology.dto.Ad
import ru.netology.dto.FeedItem
import ru.netology.dto.Post
import ru.netology.load

interface OnInteractionListener {
    fun onLike(post: Post) {}
    fun onRemove(post: Post) {}
    fun onEdit(post: Post) {}
    fun onCancelEdit(post: Post) {}
    fun onOpenPost(post: Post) {}
    fun onOpenPhoto(post: Post) {}
    fun onAdClick(ad: Ad) {}
}

class PostAdapter(
    private val onInteractionListener: OnInteractionListener,
) : PagingDataAdapter<FeedItem, RecyclerView.ViewHolder>(FeedItemDiffCallback()) {
    private val typeAd = 0
    private val typePost = 1


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Ad -> typeAd
            is Post -> typePost
            null -> throw IllegalArgumentException("unknown item type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            typeAd -> AdViewHolder(
                CardAdBinding.inflate(layoutInflater, parent, false),
                onInteractionListener
            )
            typePost -> PostViewHolder(
                CardPostBinding.inflate(layoutInflater, parent, false),
                onInteractionListener
            )
            else -> throw IllegalArgumentException("unknown view type: $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // FIXME: students will do in HW
        getItem(position)?.let {
            when (it) {
                is Post -> (holder as? PostViewHolder)?.bind(it)
                is Ad -> (holder as? AdViewHolder)?.bind(it)
            }
        }
    }


    class PostViewHolder(
        private val binding: CardPostBinding,
        private val OnInteractionListener: OnInteractionListener,

        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.apply {
                authorTv.text = post.author
                contentTv.text = post.content
                publishedTv.text = Utils.nowDate(post.published)
                likeIb.text = Utils.valueUpgrade(post.likes)
                likeIb.isChecked = post.likedByMe
                val url = "http://10.0.2.2:9999/avatars/${post.authorAvatar}"
                Glide.with(binding.avatarV)
                    .load(url)
                    .transform(RoundedCorners(80))
                    .placeholder(R.drawable.ic_baseline_cloud_download_24)
                    .error(R.drawable.ic_baseline_image_24)
                    .timeout(10000)
                    .into(binding.avatarV)

                val urlImg = "http://10.0.2.2:9999/media/${post.attachment?.url}"
                Glide.with(binding.imageIV)
                    .load(urlImg)
                    .placeholder(R.drawable.ic_baseline_cloud_download_24)
                    .error(R.drawable.ic_baseline_image_24)
                    .timeout(10000)
                    .into(binding.imageIV)

                if (post.attachment == null) {
                    imageIV.visibility = View.GONE
                } else {
                    imageIV.visibility = View.VISIBLE
                }

            }

            binding.likeIb.setOnClickListener {
                OnInteractionListener.onLike(post)
            }

            binding.contentTv.setOnClickListener {
                OnInteractionListener.onOpenPost(post)
            }
            binding.imageIV.setOnClickListener {
                OnInteractionListener.onOpenPhoto(post)
            }
            binding.menuIb.visibility = if (post.ownedByMe) View.VISIBLE else View.INVISIBLE
            binding.menuIb.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.options_post)
                    // TODO: if we don't have other options, just remove dots
                    menu.setGroupVisible(R.id.owned, post.ownedByMe)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.Remove -> {
                                OnInteractionListener.onRemove(post)
                                true
                            }
                            R.id.Edit -> {
                                OnInteractionListener.onEdit(post)
                                true
                            }
                            else -> false
                        }
                    }
                }.show()
            }
        }
    }

    class AdViewHolder(
        private val binding: CardAdBinding,
        private val onInteractionListener: OnInteractionListener,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ad: Ad) {
            binding.apply {
                image.load("${BuildConfig.BASE_URL}/media/${ad.image}")
                image.setOnClickListener {
                    onInteractionListener.onAdClick(ad)
                }
            }
        }
    }

    class FeedItemDiffCallback : DiffUtil.ItemCallback<FeedItem>() {
        override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
            if (oldItem::class != newItem::class) {
                return false
            }
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
            return oldItem == newItem
        }
    }
}

