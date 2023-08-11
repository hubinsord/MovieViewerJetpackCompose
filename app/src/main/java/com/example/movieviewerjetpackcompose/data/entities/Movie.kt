package com.example.movieviewerjetpackcompose.data.entities

import com.example.movieviewerjetpackcompose.R

//import com.example.movieviewer.R

data class Movie(
    val id: String = "",
    val title: String = "",
    val releaseYear: String = "",
    val imageUrl: String = "",
    val isFavorite: Boolean = false
) {
    val favoriteDrawable
        get() = if (isFavorite) R.drawable.image_favorite_filled else R.drawable.image_favorite_outline
}

