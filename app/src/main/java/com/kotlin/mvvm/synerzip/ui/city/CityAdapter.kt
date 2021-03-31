package com.kotlin.mvvm.synerzip.ui.city

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.kotlin.mvvm.R
import com.kotlin.mvvm.synerzip.repository.model.City
import com.kotlin.mvvm.synerzip.utils.extensions.inflate
import kotlinx.android.synthetic.main.row_news_article.view.*

/**
 * Created by Manasi on 31,March,2021
 */

/**
 * The City adapter to show the city in a list.
 */
class CityAdapter : RecyclerView.Adapter<CityAdapter.CityHolder>() {

    /**
     * List of news articles
     */
    private var cityDetails: List<City> = emptyList()


    var onCityClicked: ((City) -> Unit)? = null

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CityHolder(parent.inflate(R.layout.row_news_article))

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(cityHolder: CityHolder, position: Int) =
        cityHolder.bind(cityDetails[position])

    /**
     * Number of items in the list to display
     */
    override fun getItemCount() = cityDetails.size

    /**
     * View Holder Pattern
     */
    inner class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /**
         * Binds the UI with the data and handles clicks
         */
        fun bind(city: City) = with(itemView) {
            tvNewsItemTitle.text = city.name
            tvNewsAuthor.text = city.id.toString()
            //TODO: need to format date
            tvListItemDateTime.text = city.timezone.toString()

            Glide.with(context)
                .load("https://tse2.mm.bing.net/th?id=OIP.LxpdqDoY3j9mhOnpYsTgJAHaE8&pid=Api&P=0&w=227&h=152")
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_banner_image)
                        .error(R.drawable.loading_banner_image)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(ivNewsImage)

            itemView.setOnClickListener {
                onCityClicked?.invoke(city)
            }

        }
    }

    /**
     * Swap function to set new data on updating
     */
    fun replaceItems(items: List<City>) {
        cityDetails = items
        notifyDataSetChanged()
    }
}