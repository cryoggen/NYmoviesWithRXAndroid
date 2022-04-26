package com.example.nymovies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.usecase.GetListReviewsUseCase
import com.cryoggen.domain.usecase.RefreshDataUseCase
import io.reactivex.Flowable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MoviesListViewModel(
    private val getListReviewsUseCase: GetListReviewsUseCase,
    private val refreshDataUseCase: RefreshDataUseCase
) : ViewModel() {
    fun getMovies(): Observable<List<Movie>> = getListReviewsUseCase.execute()
    fun refreshData() = refreshDataUseCase.execute()

    init {
        refreshData()
    }
}
