package com.cryoggen.domain.usecase

import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class GetListReviewsUseCase(private val moviesRepository: MoviesRepository) {
       fun execute(): Flow<List<Movie>>{
        return moviesRepository.getMovies()
    }
}