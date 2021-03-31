package com.kotlin.mvvm.synerzip.ui.city

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.mvvm.R
import com.kotlin.mvvm.synerzip.repository.model.City
import com.kotlin.mvvm.synerzip.ui.BaseActivity
import com.kotlin.mvvm.synerzip.utils.ToastUtil
import com.kotlin.mvvm.synerzip.utils.extensions.load
import kotlinx.android.synthetic.main.activity_news_articles.*
import kotlinx.android.synthetic.main.empty_layout_news_article.*
import kotlinx.android.synthetic.main.progress_layout_news_article.*

/**
 * Created by Manasi on 31,March,2021
 */

class CityActivity : BaseActivity() {


    companion object {
        val KEY_COUNTRY_SHORT_KEY: String = "COUNTRY_SHORT_KEY"
    }

    private lateinit var adapter: CityAdapter

    private val cityArticleViewModel: CityViewModel by viewModels {
        viewModelFactory
    }

    /**
     * On Create Of Activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_articles)

        city_list.setEmptyView(empty_view)
        city_list.setProgressView(progress_view)

        adapter = CityAdapter()
        adapter.onCityClicked = {
            //TODO Your news item click invoked here
        }

        city_list.adapter = adapter
        city_list.layoutManager = LinearLayoutManager(this)

        //getNewsOfCountry(intent?.getStringExtra(KEY_COUNTRY_SHORT_KEY)!!)
        getSearchedCity("ar")
    }

    /**
     * Get Searched city data using Network & DB Bound Resource
     * Observing for data change from DB and Network Both
     */
    private fun getSearchedCity(cityName: String) {
        cityArticleViewModel.getNewsArticlesFromServer(cityName).observe(
            this,
            Observer {
                when {
                    it.status.isLoading() -> {
                        city_list.showProgressView()
                    }
                    it.status.isSuccessful() -> {
                        it?.load(city_list) { city ->
                            val cityDetails: List<City> = emptyList()
                            city?.let { it1 -> cityDetails.toMutableList().add(it1) }
                            adapter.replaceItems(cityDetails)
                        }
                    }
                    it.status.isError() -> {
                        if (it.errorMessage != null)
                            ToastUtil.showCustomToast(this, it.errorMessage.toString())
                    }
                }
            }
        )
    }
}
