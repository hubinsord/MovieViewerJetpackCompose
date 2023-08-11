package com.example.movieviewerjetpackcompose.data.repository.di

import com.example.movieviewerjetpackcompose.data.repository.MovieRepositoryImpl
import com.example.movieviewerjetpackcompose.data.source.MovieLocalDataSource
import com.example.movieviewerjetpackcompose.data.source.MovieRemoteDataSource
import com.example.movieviewerjetpackcompose.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        remoteDataSource: MovieRemoteDataSource,
        localDataSource: MovieLocalDataSource
        ): MovieRepository =
        MovieRepositoryImpl(remoteDataSource, localDataSource)
}