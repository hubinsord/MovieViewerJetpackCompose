package com.example.movieviewerjetpackcompose.domain.usecases

import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<Movie> = movieRepository.getRandomMovie()
}