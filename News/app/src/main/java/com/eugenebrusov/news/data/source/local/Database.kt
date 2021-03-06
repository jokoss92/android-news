package com.eugenebrusov.news.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.eugenebrusov.news.data.model.NewsItem
import com.eugenebrusov.news.data.model.NewsSection

/**
 * The Room Database that contains the news and sections table.
 */
@Database(entities = arrayOf(NewsItem::class, NewsSection::class), version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun dao(): Dao

    companion object {

        private var INSTANCE: com.eugenebrusov.news.data.source.local.Database? = null

        @JvmStatic fun getInstance(context: Context) =
                INSTANCE ?: synchronized(Database::class.java) {
                    INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                            com.eugenebrusov.news.data.source.local.Database::class.java,
                            "News.db")
                            .build()
                }
    }
}