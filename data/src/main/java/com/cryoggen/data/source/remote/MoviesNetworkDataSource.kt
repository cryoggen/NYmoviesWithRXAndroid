package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import javax.inject.Inject

interface MoviesNetworkDataSource {
    suspend fun getMovies(): NetworkVideoContainer
}