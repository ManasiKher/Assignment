package com.kotlin.mvvm.synerzip.repository.api

import androidx.lifecycle.LiveData
import com.kotlin.mvvm.synerzip.repository.api.network.Resource
import com.kotlin.mvvm.synerzip.repository.model.City
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Manasi on 31,March,2021
 */

/**
 * Api services to communicate with server
 *
 */
interface ApiServices {

    /**
     * Fetch news articles from Google news using GET API Call on given Url
     * Url would be something like this top-headlines?country=my&apiKey=XYZ
     */
    @GET("data/2.5/weather")
    fun getCityDetails(@Query("q") cityName: String, @Query("APPID") appId:String): LiveData<Resource<City>>

}
