package com.example.nymovies.di

import com.cryoggen.data.source.remote.MoviesService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideNYTimesAPI(moshi: Moshi): MoviesService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(MoviesService::class.java)

    }

    companion object {
        private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"
    }
}