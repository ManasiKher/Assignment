package com.kotlin.mvvm.synerzip.repository.model


import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class Wind(
    @SerializedName("speed") var speed: Double? = 0.0,
    @SerializedName("deg") var deg: Double? = 0.0,
)