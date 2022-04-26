package com.cryoggen.data.source.local

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.data.source.models.local.asDomainModel
import com.cryoggen.domain.models.Movie
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesLocalDataSourceImpl(private val database: MoviesDatabase) : MoviesLocalDataSource {
    override fun getMovies(): Observable<List<Movie>> {
        val movies = database.moviesDao.getMovies().map {
            it.asDomainModel()
        }
        return movies
    }


    override fun saveMovies(movies: List<DatabaseMovie>) {
            database.moviesDao.insertAll(movies)
    }


}