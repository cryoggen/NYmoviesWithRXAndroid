package com.cryoggen.data.source.models.remote

import com.cryoggen.data.source.models.local.DatabaseMovie
import com.cryoggen.domain.models.Movie

data class NetworkVideoContainer(val results: List<Review>)

data class Review(
    val display_title: String = "",
    val summary_short: String = "",
    val multimedia: MultiMedia = MultiMedia("")
)

data class MultiMedia(val src: String = "")


fun NetworkVideoContainer.asDomainModel(): List<Movie> {
    return results.map {
        Movie(
            displayTitle = it.display_title,
            summaryShort = it.summary_short,
            src = it.multimedia.src,
        )

    }
}

fun NetworkVideoContainer.asDatabaseModel(): List<DatabaseMovie> {
    return results.map {
        DatabaseMovie(
            displayTitle = it.display_title,
            summaryShort = it.summary_short,
            src = it.multimedia.src,
        )
    }
}
