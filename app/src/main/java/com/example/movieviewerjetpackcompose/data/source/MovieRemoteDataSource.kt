package com.example.movieviewerjetpackcompose.data.source

import com.example.movieviewerjetpackcompose.data.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRemoteDataSource {
    fun getRandomMovie(): Flow<Movie>
}