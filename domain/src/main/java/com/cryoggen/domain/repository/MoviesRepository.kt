package com.cryoggen.domain.repository

import com.cryoggen.domain.models.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
     fun refreshMovies()
    fun getMovies(): Observable<List<Movie>>
}