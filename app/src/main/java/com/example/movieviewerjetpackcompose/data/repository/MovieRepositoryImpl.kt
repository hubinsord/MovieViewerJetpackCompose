package com.example.movieviewerjetpackcompose.data.repository

import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.data.source.MovieLocalDataSource
import com.example.movieviewerjetpackcompose.data.source.MovieRemoteDataSource
import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieLocalDataSource
) : MovieRepository {

    override fun getRandomMovie(): Flow<Movie> {
        return remoteDataSource.getRandomMovie()
    }

    override fun getMovie(id: String): Flow<Movie> {
        return localDataSource.getMovie(id)
    }

    override fun getMovies(isFavorite: Boolean): Flow<List<Movie>> {
        return localDataSource.getAllMovies(isFavorite)
    }

    override suspend fun saveMovie(movie: Movie) {
        localDataSource.insertMovie(movie)
    }

    override suspend fun updateMovie(id: String, isFavorite: Boolean) {
        localDataSource.updateMovie(id, isFavorite)
    }


}