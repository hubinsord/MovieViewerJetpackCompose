package com.example.movieviewerjetpackcompose.ui.randommoviescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieviewerjetpackcompose.R

@Composable
fun RandomMovieScreen(
    viewModel: RandomMovieViewModel = hiltViewModel()
) {
    val movie by viewModel.movieFlow.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            model = ImageRequest.Builder(LocalContext.current)
                .placeholder(R.drawable.image_placeholder)
                .data(movie.imageUrl)
                .build(),
            contentDescription = "ImageRequest example",

            )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.title)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.releaseYear)
        Spacer(
            modifier = Modifier
                .height(8.dp)
                .weight(1f, false)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 8.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.Bottom
        ) {
            IconButton(
                onClick = { viewModel.refreshMovie() },

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.image_refresh),
                    contentDescription = "refresh icon",
                    modifier = Modifier.size(70.dp)
                )
            }
            IconButton(onClick = { viewModel.favoriteClicked(movie.isFavorite) }) {
                Icon(
                    painter = painterResource(id = movie.favoriteDrawable),
                    contentDescription = "refresh icon",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RandomMovieScreenPreview() {
    Surface {
        RandomMovieScreen()
    }
}
