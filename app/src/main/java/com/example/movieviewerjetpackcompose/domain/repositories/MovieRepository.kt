package com.example.movieviewerjetpackcompose.domain.repositories

import com.example.movieviewer.data.entities.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getRandomMovie(): Flow<Movie>
    fun getMovie(id: String): Flow<Movie>
    fun getMovies(isFavorite: Boolean): Flow<List<Movie>>
    suspend fun saveMovie(movie: Movie)
    suspend fun updateMovie(id: String, isFavorite: Boolean)
}
