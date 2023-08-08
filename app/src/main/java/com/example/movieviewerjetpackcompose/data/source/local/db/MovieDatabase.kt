package com.example.movieviewerjetpackcompose.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieviewerjetpackcompose.data.source.local.dao.MovieDao
import com.example.movieviewerjetpackcompose.data.source.local.entities.MovieDbEntity

@Database(entities = [MovieDbEntity::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao
}