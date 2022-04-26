package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import io.reactivex.Observable

interface MoviesNetworkDataSource {
      fun getMovies(): Observable<NetworkVideoContainer>
}