package com.example.nymovies.di

import com.cryoggen.data.repository.MoviesRepositoryImpl
import com.cryoggen.data.source.local.MoviesDatabase
import com.cryoggen.data.source.local.MoviesLocalDataSource
import com.cryoggen.data.source.local.MoviesLocalDataSourceImpl
import com.cryoggen.data.source.remote.MoviesNetworkDataSource
import com.cryoggen.data.source.remote.MoviesNetworkDataSourceImpl
import com.cryoggen.data.source.remote.MoviesService
import com.cryoggen.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideMoviesLocalDataSource(moviesDatabase:MoviesDatabase): MoviesLocalDataSource {
        return MoviesLocalDataSourceImpl(moviesDatabase)
    }

    @Provides
    fun provideMoviesNetworkDataSource(moviesService:MoviesService): MoviesNetworkDataSource {
        return MoviesNetworkDataSourceImpl(moviesService)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesLocalDataSource: MoviesLocalDataSource, moviesNetworkDataSource: MoviesNetworkDataSource): MoviesRepository {
        return MoviesRepositoryImpl(
            moviesLocalDataSource = moviesLocalDataSource,
            moviesNetworkDataSource = moviesNetworkDataSource
        )
    }

}