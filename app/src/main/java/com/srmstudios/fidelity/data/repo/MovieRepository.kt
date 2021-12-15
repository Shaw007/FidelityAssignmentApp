package com.srmstudios.fidelity.data.repo

import com.srmstudios.fidelity.data.database.JikanDatabase
import com.srmstudios.fidelity.data.network.IJikan
import com.srmstudios.fidelity.data.network.model.toDatabaseSeasons
import com.srmstudios.fidelity.util.Resource
import com.srmstudios.fidelity.util.Util
import com.srmstudios.fidelity.util.networkBoundResource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val iJikan: IJikan,
    private val jikanDatabase: JikanDatabase
) {

    // this method is used to fetch seasons for the home screen
    // first we query the local database to check if we have seasons cached
    // the database will serve as the single source of truth
    fun getMovies() = networkBoundResource(
        query = {
            // query local database
            jikanDatabase.getSeasonDao().getSeasons()
        },
        fetch = {
            // fetch seasons from network
            iJikan.getMovies(Util.DEFAULT_HOME_QUERY)
        },
        saveFetchResult = {
            // save seasons fetched from the network to local database
            it.results?.let { seasons ->
                jikanDatabase.getSeasonDao().insert(seasons.toDatabaseSeasons())
            }
        }
    )

    // this method is used to search seasons from the network only
    // we are not caching searched seasons in the local database
    fun searchMovies(query: String) = flow {
        if (query.isNotBlank()) {
            emit(Resource.Loading(listOf()))
            try {
                val response = iJikan.getMovies(query)
                emit(Resource.Success(response.results))
            } catch (throwable: Throwable) {
                emit(Resource.Error(throwable, null))
            }
        }
    }
}








