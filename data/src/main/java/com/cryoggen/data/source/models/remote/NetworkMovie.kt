package com.cryoggen.data.source.models.remote

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.domain.models.Movie

data class NetworkVideoContainer(val movies: List<Review>)

data class Review(
    val displayTitle: String,
    val summaryShort: String,
    val multiMedia: MultiMedia
)

data class MultiMedia(val src: String)


fun NetworkVideoContainer.asDomainModel(): List<Movie> {
    return movies.map {
        Movie(
            displayTitle = it.displayTitle,
            summaryShort = it.summaryShort,
            src = it.multiMedia.src,
        )
    }
}

fun NetworkVideoContainer.asDatabaseModel(): Array<DatabaseMovie> {
    return movies.map {
        DatabaseMovie(
            displayTitle = it.displayTitle,
            summaryShort = it.summaryShort,
            src = it.multiMedia.src,
        )
    }.toTypedArray()
}
