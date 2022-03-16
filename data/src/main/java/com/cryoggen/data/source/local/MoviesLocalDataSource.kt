package com.cryoggen.data.source.local

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.domain.models.Movie
import kotlinx.coroutines.flow.Flow


interface MoviesLocalDataSource {
     fun getMovies(): Flow<List<Movie>>
    suspend fun saveMovies(movies:List<DatabaseMovie>)
}