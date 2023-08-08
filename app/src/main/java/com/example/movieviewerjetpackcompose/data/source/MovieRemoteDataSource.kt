package com.example.movieviewerjetpackcompose.data.source

import com.example.movieviewer.data.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    fun getRandomMovie(): Flow<Movie>
}