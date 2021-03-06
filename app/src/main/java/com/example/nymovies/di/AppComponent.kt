package com.example.nymovies.di

import com.example.nymovies.presentation.adapters.MoviesListAdapter
import com.example.nymovies.presentation.ui.MainActivity
import com.example.nymovies.presentation.ui.MoviesListFragment

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, DomainModule::class, NetworkModule::class, LocalBaseModule::class])
interface AppComponent {
    fun inject(moviesListFragment: MoviesListFragment)
    val moviesListAdapter: MoviesListAdapter

}