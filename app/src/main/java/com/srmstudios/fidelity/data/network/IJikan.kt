package com.srmstudios.fidelity.data.network

import com.srmstudios.fidelity.data.network.model.JikanResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IJikan {

    @GET("/v3/search/anime")
    suspend fun getMovies(
        @Query("q") query: String
    ): JikanResponse

}