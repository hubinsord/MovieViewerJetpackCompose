package com.example.movieviewerjetpackcompose.domain.usecases

import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(isFavorite: Boolean): Flow<List<Movie>> {
        return repository.getMovies(isFavorite)
    }
}