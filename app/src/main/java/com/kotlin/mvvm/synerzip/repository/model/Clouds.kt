package com.kotlin.mvvm.synerzip.repository.model

import com.google.gson.annotations.SerializedName


/**
 * Created by khermanasianil on 31,March,2021
 */

data class Clouds(
    @SerializedName("all") var all: Double? = 0.0,
)