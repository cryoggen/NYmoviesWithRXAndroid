package com.cryoggen.data.repository

import android.util.Log
import com.cryoggen.data.source.local.MoviesLocalDataSource
import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import com.cryoggen.data.source.models.remote.asDatabaseModel
import com.cryoggen.data.source.remote.MoviesNetworkDataSource
import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.repository.MoviesRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.util.HalfSerializer.onNext
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(

    private val moviesLocalDataSource: MoviesLocalDataSource,
    private val moviesNetworkDataSource: MoviesNetworkDataSource
) : MoviesRepository {
    override fun refreshMovies(): Disposable? {
      val networkVideoContainer = moviesNetworkDataSource.getMovies()
            .subscribeOn(Schedulers.io())
            .subscribe {
                moviesLocalDataSource.saveMovies(it.asDatabaseModel())
            }
        return networkVideoContainer
    }

    override fun getMovies(): Observable<List<Movie>> {
        return moviesLocalDataSource.getMovies()
    }

//    private fun dataSource(): Observable<List<DatabaseMovie>> = Observable.create{ subscriber ->
//        subscriber.onNext(
//            moviesNetworkDataSource.getMovies().asDatabaseModel()
//        )
//
//    }

}