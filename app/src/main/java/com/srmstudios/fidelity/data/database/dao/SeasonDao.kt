package com.srmstudios.fidelity.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.srmstudios.fidelity.data.database.entity.DatabaseSeason
import kotlinx.coroutines.flow.Flow

@Dao
interface SeasonDao {

    // We are only caching the seasons for the home screen
    // We will be searching the seasons only from the network

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(seasons: List<DatabaseSeason>)

    @Query("SELECT * FROM season")
    fun getSeasons(): Flow<List<DatabaseSeason>>

}