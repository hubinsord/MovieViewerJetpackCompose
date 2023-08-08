package com.example.movieviewerjetpackcompose.data.source.remote

import com.example.movieviewer.data.entities.Movie
import com.example.movieviewer.data.source.remote.api.MoviesDatabaseRapidApi
import com.example.movieviewerjetpackcompose.data.source.remote.entities.toMovieEntity
import com.example.movieviewerjetpackcompose.data.source.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MoviesDatabaseRapidApi
) : MovieRemoteDataSource {

    override fun getRandomMovie(): Flow<Movie> =
        api.getRandomMovie()
            .map { it.toMovieEntity() }
}