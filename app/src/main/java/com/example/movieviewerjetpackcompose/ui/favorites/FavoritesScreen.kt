package com.example.movieviewerjetpackcompose.ui.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.movieviewerjetpackcompose.data.entities.Movie
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val movies by viewModel.moviesStateFlow.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(movies) {
            MovieCard(movie = it)
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = movie.title,)
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(id = movie.favoriteDrawable),
                contentDescription = "refresh icon",
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@Preview
@Composable
fun MovieCardPreview() {
    MovieCard(movie = Movie(title = "title", isFavorite = true))
}