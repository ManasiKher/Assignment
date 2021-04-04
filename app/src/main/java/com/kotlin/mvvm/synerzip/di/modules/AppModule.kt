package com.kotlin.mvvm.synerzip.di.modules

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.kotlin.mvvm.BuildConfig
import com.kotlin.mvvm.synerzip.app.App
import com.kotlin.mvvm.synerzip.repository.api.ApiServices
import com.kotlin.mvvm.synerzip.repository.api.network.LiveDataCallAdapterFactoryForRetrofit
import com.kotlin.mvvm.synerzip.repository.db.AppDatabase
import com.kotlin.mvvm.synerzip.repository.db.city.CityDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Manasi on 31,March,2021
 */

@Module(includes = [PreferencesModule::class, ActivityModule::class, ViewModelModule::class])
class AppModule {

    /**
     * Static variables to hold base url's etc.
     */
    companion object {
        private const val BASE_URL = BuildConfig.BASE_URL
    }


    /**
     * Provides ApiServices client for Retrofit
     */
    @Singleton
    @Provides
    fun provideNewsService(): ApiServices {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactoryForRetrofit())
            .build()
            .create(ApiServices::class.java)
    }


    /**
     * Provides app AppDatabase
     */
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "news-db")
            .fallbackToDestructiveMigration().build()


    /**
     * Provides CityDao an object to access City table from Database
     */
    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): CityDao = db.cityDetailsDao()


    /**
     * Application application level context.
     */
    @Singleton
    @Provides
    fun provideContext(application: App): Context = application.applicationContext


    /**
     * Application resource provider, so that we can get the Drawable, Color, String etc at runtime
     */
    @Provides
    @Singleton
    fun providesResources(application: App): Resources = application.resources
}
