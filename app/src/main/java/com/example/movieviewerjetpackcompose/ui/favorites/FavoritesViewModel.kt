package com.example.movieviewerjetpackcompose.ui.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieviewerjetpackcompose.data.entities.Movie
import com.example.movieviewerjetpackcompose.domain.usecases.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
) : ViewModel() {


    private val _moviesStateFlow = getMoviesUseCase.invoke(false)
        .flowOn(Dispatchers.IO)
        .catch {  }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
    val moviesStateFlow get() = _moviesStateFlow

//     fun getMovies() {
//        viewModelScope.launch {
//            getMoviesUseCase.invoke(false)
//                .flowOn(Dispatchers.IO)
//                .catch { }
//                .collect {
//                    Timber.tag("TEST01").d("movieList: $it" )
//                    _moviesStateFlow.value = it
//                }
//        }
}

