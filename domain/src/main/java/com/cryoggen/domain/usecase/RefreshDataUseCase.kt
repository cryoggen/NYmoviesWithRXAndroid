package com.cryoggen.domain.usecase

import com.cryoggen.domain.repository.MoviesRepository
import io.reactivex.disposables.Disposable

class RefreshDataUseCase(private val moviesRepository: MoviesRepository) {
     fun execute(): Disposable? {
        return moviesRepository.refreshMovies()
    }
}