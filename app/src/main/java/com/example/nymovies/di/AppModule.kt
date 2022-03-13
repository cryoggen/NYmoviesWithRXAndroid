package com.example.nymovies.di

import android.content.Context
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.example.nymovies.presentation.adapters.MoviesListAdapter
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMoviesListAdapter(getListReviewsUseCase: GetListReviewsUseCase): MoviesListAdapter {
        val adapter = MoviesListAdapter()
        adapter.movies = getListReviewsUseCase.execute()
        return adapter
    }
}