package com.srmstudios.fidelity.data.network.model

import com.google.gson.annotations.SerializedName
import com.srmstudios.fidelity.data.database.entity.DatabaseSeason
import com.srmstudios.fidelity.ui.model.Season

data class JikanResponse(
    @SerializedName("request_hash") var requestHash: String? = null,
    @SerializedName("request_cached") var requestCached: Boolean? = null,
    @SerializedName("request_cache_expiry") var requestCacheExpiry: Int? = null,
    @SerializedName("results") var results: List<SeasonResponse>? = null,
    @SerializedName("last_page") var lastPage: Int? = null
)

data class SeasonResponse(
    @SerializedName("mal_id") var id: Int,
    @SerializedName("url") var url: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("airing") var airing: Boolean? = null,
    @SerializedName("synopsis") var synopsis: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("episodes") var episodes: Int? = null,
    @SerializedName("score") var score: Double? = null,
    @SerializedName("start_date") var startDate: String? = null,
    @SerializedName("end_date") var endDate: String? = null,
    @SerializedName("members") var members: Int? = null,
    @SerializedName("rated") var rated: String? = null
)

// Extension function to convert list of SeasonsResponse to list of DatabaseSeasons
fun List<SeasonResponse>.toDatabaseSeasons() = map {
    DatabaseSeason(
        id = it.id,
        url = it.url,
        imageUrl = it.imageUrl,
        title = it.title,
        airing = it.airing,
        synopsis = it.synopsis,
        type = it.type,
        episodes = it.episodes,
        score = it.score,
        startDate = it.startDate,
        endDate = it.endDate,
        members = it.members,
        rated = it.rated
    )
}

// Extension function to convert list of SeasonsResponse to list of Seasons
fun List<SeasonResponse>.toSeasons() = map {
    Season(
        id = it.id,
        url = it.url,
        imageUrl = it.imageUrl,
        title = it.title,
        airing = it.airing,
        synopsis = it.synopsis,
        type = it.type,
        episodes = it.episodes,
        score = it.score,
        startDate = it.startDate,
        endDate = it.endDate,
        members = it.members,
        rated = it.rated
    )
}