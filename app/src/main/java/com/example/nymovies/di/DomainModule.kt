package com.example.nymovies.di


import com.cryoggen.domain.usecase.GetListReviewsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetListReviewsUseCase(): GetListReviewsUseCase {
        return GetListReviewsUseCase()
    }

//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }

}