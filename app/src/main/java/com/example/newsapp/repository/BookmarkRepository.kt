package com.example.newsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.database.Bookmark
import com.example.newsapp.database.BookmarkDao
import java.util.concurrent.Executors

class BookmarkRepository(
    private val bookmarkDao: BookmarkDao
) {
    fun insert(bookmark: Bookmark): Long {
        return bookmarkDao.insert(bookmark)
    }

    fun delete(bookmark: Bookmark) {
        bookmarkDao.delete(bookmark)
    }

    fun exists(
        author: String?,
        title: String,
        source: String?
    ): LiveData<Boolean> {
        val data = MutableLiveData<Boolean>()
        Executors.newSingleThreadExecutor().execute {
            data.postValue(
                bookmarkDao.exists(
                    author,
                    title,
                    source
                )
            )
        }
        return data
    }
}