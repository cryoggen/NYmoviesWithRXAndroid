package com.example.nymovies.di

import android.content.Context
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase
import com.example.nymovies.presentation.adapters.MoviesListAdapter
import com.example.nymovies.presentation.viewmodel.MoviesListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMoviesListAdapter(): MoviesListAdapter {
        val adapter = MoviesListAdapter()
        adapter.movies = listOf()
        return adapter
    }

    @Provides
    fun provideMoviesListViewModelFactory(
        getListReviewsUseCase: GetListReviewsUseCase, refreshDataUseCase: RefreshDataUseCase
    ): MoviesListViewModelFactory {
        return MoviesListViewModelFactory(
            getListReviewsUseCase = getListReviewsUseCase, refreshDataUseCase = refreshDataUseCase
        )
    }
}