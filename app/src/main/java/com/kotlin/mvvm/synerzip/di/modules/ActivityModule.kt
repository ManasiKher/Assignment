package com.kotlin.mvvm.synerzip.di.modules
import com.kotlin.mvvm.synerzip.ui.city.CityActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Manasi on 31,March,2021
 */

/**
 * All your Activities participating in DI would be listed here.
 */
@Module(includes = []) // Including Fragment Module Available For Activities
abstract class ActivityModule {

    /**
     * Marking Activities to be available to contributes for Android Injector
     */
    @ContributesAndroidInjector
    abstract fun contributeNewsArticlesActivity(): CityActivity

}
