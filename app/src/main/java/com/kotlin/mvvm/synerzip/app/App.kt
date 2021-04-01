package com.kotlin.mvvm.synerzip.app

import com.facebook.stetho.Stetho
import com.kotlin.mvvm.synerzip.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Manasi on 31,March,2021
 */

class App : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder().application(this).build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

}