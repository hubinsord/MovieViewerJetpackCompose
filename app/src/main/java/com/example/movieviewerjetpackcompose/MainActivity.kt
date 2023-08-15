package com.example.movieviewerjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieviewerjetpackcompose.ui.favorites.FavoritesScreen
import com.example.movieviewerjetpackcompose.ui.randommoviescreen.RandomMovieScreen
import com.example.movieviewerjetpackcompose.ui.theme.MovieViewerJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieViewerJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val pages = listOf(Page.RandomMovieScreen, Page.FavoritesScreen)
//                    val pagerState = rememberPagerState(0, 0f)
                    HorizontalPager(pageCount = pages.size) {
                        when (pages[it]) {
                            Page.RandomMovieScreen -> RandomMovieScreen()
                            Page.FavoritesScreen -> FavoritesScreen()
                        }
                    }
//                    FavoritesScreen()
                }
            }
        }
    }
}

sealed class Page {
    object RandomMovieScreen : Page()
    object FavoritesScreen : Page()

}


