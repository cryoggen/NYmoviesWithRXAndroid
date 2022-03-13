
package com.cryoggen.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.RoomDatabase
import com.cryoggen.data.source.models.local.DatabaseMovie

@Dao
interface MoviesDao {
    @Query("select * from DatabaseMovie")
    fun getVideos(): LiveData<List<DatabaseMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg videos: DatabaseMovie)
}

@Database(entities = [DatabaseMovie::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract val moviesDao: MoviesDao
}

private lateinit var INSTANCE: MoviesDatabase

fun getDatabase(context: Context): MoviesDatabase {
    synchronized(MoviesDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MoviesDatabase::class.java,
                "movies"
            ).build()
        }
    }
    return INSTANCE
}