package com.example.movieviewerjetpackcompose.domain.usecases

import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import javax.inject.Inject

class AddMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movie: Movie) {
        return repository.saveMovie(movie)
    }
}