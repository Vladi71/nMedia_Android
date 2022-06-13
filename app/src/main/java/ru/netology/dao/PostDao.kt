package ru.netology.dao


import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.netology.dto.Post
import ru.netology.entity.PostEntity
import ru.netology.nmedia.enumeration.AttachmentType

@Dao
interface PostDao {
    @Query("SELECT * FROM PostEntity WHERE showOrNot = 1  ORDER BY id DESC")
    fun getAll(): PagingSource<Int, PostEntity>

    @Query("SELECT COUNT(*) FROM PostEntity WHERE showOrNot = 0")
    suspend fun count(): Int

    @Query("UPDATE PostEntity Set showOrNot = :showOrNot WHERE showOrNot is not :showOrNot")
    suspend fun showOrNot(showOrNot: Boolean)

    @Query("""SELECT * FROM PostEntity WHERE id = :id""")
    suspend fun getPostById(id: Long): PostEntity

    @Query("SELECT COUNT(*) == 0 FROM PostEntity")
    suspend fun isEmpty(): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(posts: List<PostEntity>)

    @Query("DELETE FROM PostEntity WHERE id = :id")
    suspend fun removeById(id: Long)

    @Query(
        """
        UPDATE PostEntity SET
        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,
        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END
        WHERE id = :id
        """
    )
    suspend fun likeById(id: Long)

    class Converters {
        @TypeConverter
        fun toAttachmentType(value: String) = enumValueOf<AttachmentType>(value)

        @TypeConverter
        fun fromAttachmentType(value: AttachmentType) = value.name

    }
    @Query("DELETE FROM PostEntity")
    suspend fun removeAll()
}