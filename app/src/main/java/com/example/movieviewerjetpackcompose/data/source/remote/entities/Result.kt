package com.example.movieviewerjetpackcompose.data.source.remote.entities

import com.squareup.moshi.Json

data class Result(

    @Json(name = "_id")
    val _id: String,

    @Json(name = "id")
    val id: String,

    @Json(name = "primaryImage")
    val primaryImage: PrimaryImage,

    @Json(name = "releaseYear")
    val releaseYear: ReleaseYear,

    @Json(name = "titleText")
    val titleText: TitleText,

    )
