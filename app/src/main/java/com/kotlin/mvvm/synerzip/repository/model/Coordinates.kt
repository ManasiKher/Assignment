package com.kotlin.mvvm.synerzip.repository.model

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class Coordinates(
    @ColumnInfo(name = "lon") var longitude: Double? = 0.0,
    @ColumnInfo(name = "lat") var lattitude: Double? = 0.0,
)