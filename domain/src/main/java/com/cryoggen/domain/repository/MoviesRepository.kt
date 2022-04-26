package com.cryoggen.domain.repository

import com.cryoggen.domain.models.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
     fun refreshMovies(): Disposable?
    fun getMovies(): Observable<List<Movie>>
}