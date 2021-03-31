package com.kotlin.mvvm.synerzip.repository.model

import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class Weather(
    @SerializedName("id") var weatherId: Double? = 0.0,
    @SerializedName("main") var main: String? = "",
    @SerializedName("description") var description: String? = "",
    @SerializedName("icon") var icon: String? = "",
)