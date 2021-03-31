package com.kotlin.mvvm.synerzip.repository.model

import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class SystemData(
    @SerializedName("type") var type: Double? = 0.0,
    @SerializedName("id") var systemId: Double? = 0.0,
    @SerializedName("country") var country: String? = "",
    @SerializedName("sunrise") var sunrise: Long? = 0,
    @SerializedName("sunset") var sunset: Long? = 0,
)