package com.example.nymovies.di


import com.cryoggen.domain.repository.MoviesRepository
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetListReviewsUseCase(moviesRepository: MoviesRepository): GetListReviewsUseCase {
        return GetListReviewsUseCase(moviesRepository)
    }


    @Provides
    fun provideRefreshDataUseCase(moviesRepository: MoviesRepository): RefreshDataUseCase {
        return RefreshDataUseCase(moviesRepository)
    }


}