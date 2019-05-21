package com.example.u17lite.dataBeans

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Chapter::class, Comic::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun chapterDao(): ChapterDao
    abstract fun comicDao(): ComicDao

    companion object {
        private const val DATABASE_NAME = "comic-db"
        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            instance = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
            return instance!!
        }
    }

}