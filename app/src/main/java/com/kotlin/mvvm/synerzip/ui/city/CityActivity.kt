package com.kotlin.mvvm.synerzip.ui.city

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kotlin.mvvm.R
import com.kotlin.mvvm.synerzip.repository.model.City
import com.kotlin.mvvm.synerzip.ui.BaseActivity
import com.kotlin.mvvm.synerzip.utils.ToastUtil
import com.kotlin.mvvm.synerzip.utils.extensions.load
import kotlinx.android.synthetic.main.activity_city.*
import kotlinx.android.synthetic.main.empty_layout_city.*
import kotlinx.android.synthetic.main.progress_layout_city.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Manasi on 31,March,2021
 */

class CityActivity : BaseActivity() {

    private val cityArticleViewModel: CityViewModel by viewModels {
        viewModelFactory
    }
    /**
     * On Create Of Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        progress_view.visibility = View.INVISIBLE
        empty_view.visibility = View.VISIBLE
        layout_city_data.visibility = View.INVISIBLE

        search_city_name.isActivated = true
        search_city_name.onActionViewExpanded()
        search_city_name.isIconified = false
        search_city_name.clearFocus()

        search_city_name.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { getSearchedCity(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })
    }

    /**
     * Get Searched city data using Network & DB Bound Resource
     * Observing for data change from DB and Network Both
     */
    private fun getSearchedCity(cityName: String) {
        cityArticleViewModel.getCityDetails(cityName)?.observe(
            this,
            {
                when {
                    it.status.isLoading() -> {
                        progress_view.visibility = View.VISIBLE
                        empty_view.visibility = View.INVISIBLE
                        layout_city_data.visibility = View.INVISIBLE
                    }
                    it.status.isSuccessful() -> {
                        it?.load() { city ->
                            setDataInView(city)
                        }
                    }
                    it.status.isError() -> {
                        progress_view.visibility = View.INVISIBLE
                        empty_view.visibility = View.VISIBLE
                        layout_city_data.visibility = View.INVISIBLE
                        if (it.errorMessage != null)
                            ToastUtil.showCustomToast(this, it.errorMessage.toString())
                    }
                }
            }
        )
    }

    private fun setDataInView(city: City?) {
        progress_view.visibility = View.INVISIBLE
        empty_view.visibility = View.INVISIBLE
        layout_city_data.visibility = View.VISIBLE
        tvCityItemTitle.text = "This is: ${city?.name}"
        val cityWeather:String ="Weather details: Temperature is: ${city?.main?.temp.toString()}" + "\nWind Speed: ${city?.wind?.speed}"
        tvCityWeather.text = cityWeather
        val dateData = getDate(city?.dt,"dd-MM-yyyy")
        tvListItemDateTime.text = "Date: ${dateData}"
        tvItem.text = "TimeZone: ${city?.timezone}"

        Glide.with(this)
            .load("https://tse2.mm.bing.net/th?id=OIP.LxpdqDoY3j9mhOnpYsTgJAHaE8&pid=Api&P=0&w=227&h=152")
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_banner_image)
                    .error(R.drawable.loading_banner_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
            )
            .into(ivNewsImage)
    }


    fun getDate(milliSeconds: Long?, dateFormat: String?): String? {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat,Locale.US)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar: Calendar = Calendar.getInstance()
        milliSeconds?.let { calendar.timeInMillis = it }
        return formatter.format(calendar.time)
    }
}
