package com.example.movieviewerjetpackcompose.domain.di

import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import com.example.movieviewerjetpackcompose.domain.usecases.AddMovieUseCase
import com.example.movieviewerjetpackcompose.domain.usecases.GetMoviesListFromLocalUseCase
import com.example.movieviewerjetpackcompose.domain.usecases.GetRandomMovieUseCase
import com.example.movieviewerjetpackcompose.domain.usecases.UpdateMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGetRandomMovieUseCase(repository: MovieRepository) = GetRandomMovieUseCase(repository)

    @Singleton
    @Provides
    fun provideAddMovieUseCase(repository: MovieRepository) = AddMovieUseCase(repository)

    @Singleton
    @Provides
    fun provideGetMoviesListUseCase(repository: MovieRepository) = GetMoviesListFromLocalUseCase(repository)

    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(repository: MovieRepository) = UpdateMovieUseCase(repository)

}