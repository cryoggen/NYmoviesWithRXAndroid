package com.cryoggen.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase
import com.example.nymovies.presentation.viewmodel.MoviesListViewModel


class MoviesListViewModelFactory(val getListReviewsUseCase: GetListReviewsUseCase, val refreshDataUseCase: RefreshDataUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesListViewModel(
            getListReviewsUseCase = getListReviewsUseCase, refreshDataUseCase = refreshDataUseCase
        ) as T
    }

}

