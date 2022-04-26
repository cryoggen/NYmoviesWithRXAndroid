package com.cryoggen.domain.usecase

import com.cryoggen.domain.repository.MoviesRepository

class RefreshDataUseCase(private val moviesRepository: MoviesRepository) {
     fun execute() {
        return moviesRepository.refreshMovies()
    }
}