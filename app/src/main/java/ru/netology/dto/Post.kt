package ru.netology.dto

import ru.netology.nmedia.enumeration.AttachmentType

data class Post(
    val id: Long,
    val author: String,
    val authorAvatar: String,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int = 0,
    val showOrNot: Boolean = false,
    var attachment: Attachment? = null,
)

data class Attachment(
    val url: String,
    val type: AttachmentType,
)

