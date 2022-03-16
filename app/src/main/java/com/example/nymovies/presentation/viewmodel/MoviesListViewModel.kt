package com.example.nymovies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val getListReviewsUseCase: GetListReviewsUseCase,
    private val refreshDataUseCase: RefreshDataUseCase
) : ViewModel() {
           fun getMovies():Flow<List<Movie>> = getListReviewsUseCase.execute()
init {
    viewModelScope.launch {
        refreshDataUseCase.execute()
    }
}
    }
