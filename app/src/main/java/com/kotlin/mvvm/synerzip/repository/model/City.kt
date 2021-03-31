package com.kotlin.mvvm.synerzip.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

/**
 * By default, Room uses the class name as the database table name. If you want the table to have a different name, set the tableName
 * property of the @Entity annotation, as shown in the following code snippet:
 * @Entity(tableName = "city_table")
 */
@Entity(tableName = "city_table")
data class City(
    @PrimaryKey(autoGenerate = true) var key: Int = 0,
    @ColumnInfo(name = "coord") var coord: Coordinates? = null,
    @ColumnInfo(name = "weather") var weather: List<Weather>? = null,
    @ColumnInfo(name = "base") var base: String? = null,
    @ColumnInfo(name = "main") var main: Main? = null,
    @ColumnInfo(name = "visibility") var visibility: Double? = 0.0,
    @ColumnInfo(name = "wind") var wind: Wind? = null,
    @ColumnInfo(name = "clouds") var clouds: Clouds? = null,
    @ColumnInfo(name = "sys") var systemData: SystemData? = null,
    @ColumnInfo(name = "dt") var dt: Long? = null,
    @ColumnInfo(name = "timezone") var timezone: Double? = 0.0,
    @ColumnInfo(name = "id") var id: Double? = 0.0,
    @ColumnInfo(name = "name") var name: String? = "",
    @ColumnInfo(name = "cod") var cod: Double? = 0.0,
)