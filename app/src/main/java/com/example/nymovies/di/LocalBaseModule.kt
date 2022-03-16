package com.example.nymovies.di

import android.content.Context
import com.cryoggen.data.source.local.MoviesDatabase
import com.cryoggen.data.source.local.getDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context): MoviesDatabase {
        return getDatabase(context)
    }

}