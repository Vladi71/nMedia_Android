package ru.netology.dto

import ru.netology.nmedia.enumeration.AttachmentType

sealed interface FeedItem {
    val id: Long
}

data class Ad(
    override val id: Long,
    val image: String,
):FeedItem

data class Post(
    override val id: Long,
    val authorId: Long,
    val author: String,
    val authorAvatar: String,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int = 0,
    val showOrNot: Boolean = false,
    var attachment: Attachment? = null,
    val ownedByMe: Boolean = false,
) : FeedItem

data class Attachment(
    val url: String,
    val type: AttachmentType,
)

