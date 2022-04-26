package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("reviews/all.json")

     fun getMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = "KNTBmlRvQoEcUIUCshRLkoBGRhUguu6S"
    ): Observable<NetworkVideoContainer>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api-key"
    }
}