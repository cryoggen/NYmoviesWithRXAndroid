package com.cryoggen.data.source.local

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.domain.models.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow


interface MoviesLocalDataSource {
    fun getMovies(): Observable<List<Movie>>
    fun saveMovies(movies: List<DatabaseMovie>)
}