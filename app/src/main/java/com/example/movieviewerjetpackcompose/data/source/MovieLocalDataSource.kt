package com.example.movieviewerjetpackcompose.data.source

import com.example.movieviewer.data.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getMovie(id: String): Flow<Movie>
    fun getAllMovies(isFavorite: Boolean): Flow<List<Movie>>
    suspend fun insertMovie(movie: Movie)
    suspend fun updateMovie(id: String, isFavorite: Boolean)
    suspend fun deleteMovie(id: String)
}