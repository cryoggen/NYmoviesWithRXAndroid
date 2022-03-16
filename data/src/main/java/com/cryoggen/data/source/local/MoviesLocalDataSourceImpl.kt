package com.cryoggen.data.source.local

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.data.source.models.local.asDomainModel
import com.cryoggen.domain.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.Flow

class MoviesLocalDataSourceImpl(private val database: MoviesDatabase) : MoviesLocalDataSource {
    override fun getMovies(): Flow<List<Movie>> {
        val movies = database.moviesDao.getMovies().map {
            it.asDomainModel()
        }
        return movies
    }


    override suspend fun saveMovies(movies: List<DatabaseMovie>) {
        withContext(Dispatchers.IO) {
            database.moviesDao.insertAll(movies)
        }
    }


}