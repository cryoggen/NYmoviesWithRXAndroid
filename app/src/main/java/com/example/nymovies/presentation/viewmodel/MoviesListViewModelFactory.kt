package com.example.nymovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase


class MoviesListViewModelFactory(
    private val getListReviewsUseCase: GetListReviewsUseCase,
    private val refreshDataUseCase: RefreshDataUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesListViewModel(
            getListReviewsUseCase = getListReviewsUseCase, refreshDataUseCase = refreshDataUseCase
        ) as T
    }

}

