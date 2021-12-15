package com.srmstudios.fidelity.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.srmstudios.fidelity.data.database.dao.SeasonDao
import com.srmstudios.fidelity.data.database.entity.DatabaseSeason
import com.srmstudios.fidelity.util.Util

@Database(entities = [DatabaseSeason::class], version = Util.DATABASE_VERSION, exportSchema = false)
abstract class JikanDatabase : RoomDatabase() {

    abstract fun getSeasonDao(): SeasonDao

}