package com.kotlin.mvvm.synerzip.repository.model

import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class Main(
    @SerializedName("temp") var temp: Double? = 0.0,
    @SerializedName("feels_like") var feelsLike: Double? = 0.0,
    @SerializedName("temp_min") var tempMin: Double? = 0.0,
    @SerializedName("temp_max") var tempMax: Double? = 0.0,
    @SerializedName("pressure") var pressure: Double? = 0.0,
    @SerializedName("humidity") var humidity: Double? = 0.0,
)