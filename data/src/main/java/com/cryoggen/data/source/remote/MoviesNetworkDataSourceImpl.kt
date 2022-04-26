package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import io.reactivex.Observable

class MoviesNetworkDataSourceImpl(private val moviesService: MoviesService) :
    MoviesNetworkDataSource {
    override  fun getMovies(): Observable<NetworkVideoContainer> =
            moviesService.getMovies()

}