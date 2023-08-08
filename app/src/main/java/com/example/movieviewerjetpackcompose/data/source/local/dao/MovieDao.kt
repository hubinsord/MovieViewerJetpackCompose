package com.example.movieviewerjetpackcompose.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieviewerjetpackcompose.data.source.local.entities.MovieDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM $DB_NAME WHERE id = :id")
    fun getMovie(id: String): Flow<MovieDbEntity>

    @Query("SELECT * FROM $DB_NAME WHERE isFavorite = :isFavorite")
    fun getAllMovies(isFavorite: Boolean): Flow<List<MovieDbEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: MovieDbEntity)

    @Query("UPDATE $DB_NAME SET isFavorite = :isFavorite WHERE id =:id")
    suspend fun updateMovie(id: String, isFavorite: Boolean)

    @Query("DELETE FROM $DB_NAME")
    suspend fun deleteMovie()

    companion object {
        const val DB_NAME = "MOVIE_TABLE"
    }
}