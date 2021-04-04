package com.kotlin.mvvm.synerzip.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mvvm.synerzip.repository.api.network.Resource

import com.kotlin.mvvm.synerzip.repository.repo.city.CityRepository
import com.kotlin.mvvm.synerzip.repository.model.City
import javax.inject.Inject

/**
 * Created by Manasi on 31,March,2021
 */

/**
 * A container for [City] related data to show on the UI.
 */
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository
) : ViewModel() {

    /**
     * Loading cities from internet and database
     */
    private fun getCities(cityKey: String): LiveData<Resource<City?>>? =
        cityRepository.getCityData(cityKey)


    fun getCityDetails(countryKey: String) = getCities(countryKey)

    /**
     * Loading cities from internet only
     */
    private fun getCitiesFromOnlyServer(cityKey: String) =
        cityRepository.getCityDetailsFromServerOnly(cityKey)


}