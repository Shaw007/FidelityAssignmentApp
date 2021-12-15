package com.srmstudios.fidelity.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.srmstudios.fidelity.ui.model.Season

@Entity(tableName = "season")
data class DatabaseSeason(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "url") var url: String? = null,
    @ColumnInfo(name = "image_url") var imageUrl: String? = null,
    @ColumnInfo(name = "title") var title: String? = null,
    @ColumnInfo(name = "airing") var airing: Boolean? = null,
    @ColumnInfo(name = "synopsis") var synopsis: String? = null,
    @ColumnInfo(name = "type") var type: String? = null,
    @ColumnInfo(name = "episodes") var episodes: Int? = null,
    @ColumnInfo(name = "score") var score: Double? = null,
    @ColumnInfo(name = "start_date") var startDate: String? = null,
    @ColumnInfo(name = "end_date") var endDate: String? = null,
    @ColumnInfo(name = "members") var members: Int? = null,
    @ColumnInfo(name = "rated") var rated: String? = null
)

// Extension function to convert list of DatabaseSeasons to list of Seasons
fun List<DatabaseSeason>.toSeasons() = map {
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

