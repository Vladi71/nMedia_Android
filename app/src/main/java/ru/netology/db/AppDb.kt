package ru.netology.nmedia.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.netology.dao.PostDao
import ru.netology.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
@TypeConverters(PostDao.Converters::class)
abstract class AppDb : RoomDatabase() {
    abstract fun postDao(): PostDao

    companion object {
         fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDb::class.java, "app.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}