package com.cryoggen.data.repository
import com.cryoggen.data.source.local.MoviesLocalDataSource
import com.cryoggen.data.source.models.remote.asDatabaseModel
import com.cryoggen.data.source.remote.MoviesNetworkDataSource
import com.cryoggen.domain.models.Movie
import com.cryoggen.domain.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(private val moviesLocalDataSource: MoviesLocalDataSource,private val moviesNetworkDataSource: MoviesNetworkDataSource): MoviesRepository {
     override suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            val networkMovies = moviesNetworkDataSource.getMovies().asDatabaseModel()
            moviesLocalDataSource.saveMovies(networkMovies)
        }
    }

    override fun getMovies(): Flow<List<Movie>> {
        return moviesLocalDataSource.getMovies()
    }
}