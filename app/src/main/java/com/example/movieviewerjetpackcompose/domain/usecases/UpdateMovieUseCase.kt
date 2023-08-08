package com.example.movieviewerjetpackcompose.domain.usecases

import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import javax.inject.Inject

class UpdateMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(id: String, isFavorite: Boolean){
        return repository.updateMovie(id, isFavorite)
    }
}