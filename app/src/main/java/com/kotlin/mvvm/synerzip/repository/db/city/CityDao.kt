package com.kotlin.mvvm.synerzip.repository.db.city

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.mvvm.synerzip.repository.model.City


/**
 * Created by Manasi on 31,March,2021
 */

/**
 * Abstracts access to the news database
 */
@Dao
interface CityDao {

    /**
     * Insert City into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(city: City)

    /**
     * Get city from database
     */
    @Query("SELECT * FROM city_table where name LIKE :title")
    fun getCities(title:String): LiveData<City>

    @Query("DELETE FROM city_table")
    abstract fun deleteAllCities()
}