package ru.netology.entity

import android.text.Html
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.dto.Attachment
import ru.netology.dto.Post

@Entity
class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val author: String,
    val authorAvatar: String,
    val content: String,
    val published: Long,
    val likedByMe: Boolean,
    val likes: Int,
    val showOrNot: Boolean = false

) {
    fun toDto() = Post(
        id, author, authorAvatar, content, published, likedByMe, likes, showOrNot
    )

    companion object {
        fun fromDto(post: Post): PostEntity = with(post) {
            PostEntity(
                id, author,
                authorAvatar,
                content,
                published,
                likedByMe,
                likes,
                true
            )
        }

        fun fromApi(dto: Post) =
            PostEntity(
                dto.id,
                dto.author,
                dto.authorAvatar,
                dto.content,
                dto.published,
                dto.likedByMe,
                dto.likes,
                false
            )

    }
}

fun List<PostEntity>.toDto(): List<Post> = map(PostEntity::toDto)
fun List<Post>.toEntity(): List<PostEntity> = map(PostEntity::fromDto)
fun List<Post>.toApiEntity(): List<PostEntity> = map(PostEntity::fromApi)