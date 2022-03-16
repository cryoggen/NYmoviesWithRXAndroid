package com.cryoggen.data.source.remote

import com.cryoggen.data.source.models.remote.MultiMedia
import com.cryoggen.data.source.models.remote.NetworkVideoContainer
import com.cryoggen.data.source.models.remote.Review
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("reviews/all.json")

    suspend fun getMovies(
        @Query("api-key") apiKey: String = "KNTBmlRvQoEcUIUCshRLkoBGRhUguu6S"
    ): NetworkVideoContainer

    companion object {
        private const val QUERY_PARAM_OFFSET = "offset"
        private const val QUERY_PARAM_API_KEY = "api-key"
    }
}