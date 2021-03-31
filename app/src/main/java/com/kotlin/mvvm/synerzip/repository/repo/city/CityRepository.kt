package com.kotlin.mvvm.synerzip.repository.repo.city

import android.content.Context
import androidx.lifecycle.LiveData
import com.kotlin.mvvm.BuildConfig
import com.kotlin.mvvm.synerzip.app.AppExecutors
import com.kotlin.mvvm.synerzip.repository.api.ApiServices
import com.kotlin.mvvm.synerzip.repository.api.network.NetworkResource
import com.kotlin.mvvm.synerzip.repository.api.network.Resource
import com.kotlin.mvvm.synerzip.repository.db.city.CityDao
import com.kotlin.mvvm.synerzip.repository.model.City
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Manasi on 31,March,2021
 */

/**
 * Repository abstracts the logic of fetching the data and persisting it for
 * offline. They are the data source as the single source of truth.
 *
 */

@Singleton
class CityRepository @Inject constructor(
    private val cityDao: CityDao,
    private val apiServices: ApiServices, private val context: Context,
    private val appExecutors: AppExecutors = AppExecutors()
) {
    val apiKey = BuildConfig.API_KEY

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     */
    fun getCityData(cityName: String): LiveData<Resource<List<City>?>>? {

     /*   return object : NetworkAndDBBoundResource<List<City>, City>(appExecutors) {
            override fun saveCallResult(item: NewsSource) {
                if (item.articles.isNotEmpty()) {
                    cityDao.deleteAllCities()
                    cityDao.insertArticles(item.articles)
                }
            }

            override fun shouldFetch(data: List<City>?) =
                (ConnectivityUtil.isConnected(context))

            override fun loadFromDb() = cityDao.getCities()

            override fun createCall() =
                apiServices.getCityDetails(cityName,apiKey)

        }.asLiveData()*/
        return null;
    }

    /**
     * Fetch the news articles from database if exist else fetch from web
     * and persist them in the database
     * LiveData<Resource<CityCource>>
     */
    fun getCityDetailsFromServerOnly(cityTitle: String):
            LiveData<Resource<City>> {
        return object : NetworkResource<City>() {
            override fun createCall(): LiveData<Resource<City>> {
                return apiServices.getCityDetails(cityTitle,apiKey)
            }

        }.asLiveData()
    }

}