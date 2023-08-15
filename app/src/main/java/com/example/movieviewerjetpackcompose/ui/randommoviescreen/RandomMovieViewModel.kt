package com.example.movieviewerjetpackcompose.ui.randommoviescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.usecases.AddMovieUseCase
import com.example.movieviewerjetpackcompose.domain.usecases.GetRandomMovieUseCase
import com.example.movieviewerjetpackcompose.domain.usecases.UpdateMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomMovieViewModel @Inject constructor(
    private val getRandomMovieUseCase: GetRandomMovieUseCase,
    private val addMovieUseCase: AddMovieUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase,
) : ViewModel() {
    val movieFlow = MutableStateFlow<Movie>(Movie())

    init {
        refreshMovie()
    }

    fun refreshMovie() {
        viewModelScope.launch {
            getRandomMovieUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .catch {}
                .collect { movieFlow.value = it }
        }
    }

    fun favoriteClicked(isFavorite: Boolean) {
        addMovie(movieFlow.value)
        movieFlow.value = movieFlow.value.copy(isFavorite = !isFavorite)
        viewModelScope.launch {
            updateMovieUseCase.invoke(movieFlow.value.id, movieFlow.value.isFavorite)
        }
    }

    private fun addMovie(movie: Movie) {
        viewModelScope.launch {
            addMovieUseCase.invoke(movie)
        }
    }
}

data class MovieUiState(
    val movie: Movie,
    val isLoading: Boolean,
    val isError: Boolean
)