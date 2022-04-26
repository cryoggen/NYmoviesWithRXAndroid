package com.cryoggen.domain.usecase

import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.repository.MoviesRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

class GetListReviewsUseCase(private val moviesRepository: MoviesRepository) {
    fun execute(): Observable<List<Movie>> {
        return moviesRepository.getMovies()
    }
}