package com.example.movieviewerjetpackcompose.ui.randommoviescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.usecases.GetRandomMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomMovieViewModel @Inject constructor(
    private val getRandomMovieUseCase: GetRandomMovieUseCase
) : ViewModel() {
    init {
        refreshMovie()
    }

    val movieFlow = MutableStateFlow<Movie>(Movie())

    fun refreshMovie() {
        viewModelScope.launch {
            getRandomMovieUseCase.invoke()
                .flowOn(Dispatchers.IO)
                .catch {}
                .collect { movieFlow.value = it }
        }
    }

    fun favoriteClicked(isFavorite: Boolean) {
            movieFlow.value = movieFlow.value.copy(isFavorite = !isFavorite)
    }
}

data class MovieUiState(
    val movie: Movie,
    val isLoading: Boolean,
    val isError: Boolean
)