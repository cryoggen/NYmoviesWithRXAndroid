package com.cryoggen.domain.repository

import com.cryoggen.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    suspend fun refreshMovies()
    fun getMovies(): Flow<List<Movie>>
}