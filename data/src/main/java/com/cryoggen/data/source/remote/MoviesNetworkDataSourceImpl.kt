package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.NetworkVideoContainer

class MoviesNetworkDataSourceImpl(private val moviesService: MoviesService) :
    MoviesNetworkDataSource {
    override suspend fun getMovies(): NetworkVideoContainer {
        var movies = NetworkVideoContainer(listOf())
        try {
            movies = moviesService.getMovies()
        } catch (e: Exception) {

        }
        return movies
    }
}