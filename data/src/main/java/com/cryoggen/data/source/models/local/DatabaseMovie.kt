package com.cryoggen.data.source.models.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cryoggen.domain.models.Movie

@Entity
data class DatabaseMovie constructor(
    @PrimaryKey
    val src: String,
    val displayTitle: String,
    val summaryShort: String
)


fun List<DatabaseMovie>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            src = it.src,
            displayTitle = it.displayTitle,
            summaryShort = it.summaryShort
        )
    }
}
