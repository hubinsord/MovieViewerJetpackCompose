package com.example.movieviewerjetpackcompose.data.source.local

import com.example.movieviewer.data.entities.Movie
import com.example.movieviewerjetpackcompose.data.source.local.db.MovieDatabase
import com.example.movieviewerjetpackcompose.data.source.local.entities.toMovie
import com.example.movieviewerjetpackcompose.data.source.local.entities.toMovieDbEntity
import com.example.movieviewerjetpackcompose.data.source.MovieLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val movieDatabase: MovieDatabase
) : MovieLocalDataSource {
    private val movieDao = movieDatabase.getMovieDao()

    override fun getMovie(id: String): Flow<Movie> =
        movieDao.getMovie(id)
            .map { it.toMovie() }

    override fun getAllMovies(isFavorite: Boolean): Flow<List<Movie>> =
        movieDao.getAllMovies(isFavorite)
            .map { movieList ->
                movieList.map {
                    it.toMovie()
                }
            }

    override suspend fun insertMovie(movie: Movie) {
        movieDao.insertMovie(movie = movie.toMovieDbEntity())
    }

    override suspend fun updateMovie(id: String, isFavorite: Boolean) {
        movieDao.updateMovie(id, isFavorite)
    }

    override suspend fun deleteMovie(id: String) {
        movieDao.deleteMovie()
    }
}

