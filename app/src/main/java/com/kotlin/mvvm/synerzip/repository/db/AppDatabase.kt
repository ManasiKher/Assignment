package com.kotlin.mvvm.synerzip.repository.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kotlin.mvvm.synerzip.repository.db.city.CityDao
import com.kotlin.mvvm.synerzip.repository.model.City
import com.kotlin.mvvm.synerzip.repository.model.Converters


/**
 * Created by Manasi on 31,March,2021
 */

/**
 * App Database
 * Define all entities and access doa's here/ Each entity is a table.
 */
@Database(entities = [City::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get DAO's
     */
    abstract fun cityDetailsDao(): CityDao
}