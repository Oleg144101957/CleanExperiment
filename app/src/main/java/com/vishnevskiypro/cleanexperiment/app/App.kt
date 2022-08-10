package com.vishnevskiypro.cleanexperiment.app

import android.app.Application
import com.vishnevskiypro.cleanexperiment.di.AppComponent
import com.vishnevskiypro.cleanexperiment.di.AppModule
import com.vishnevskiypro.cleanexperiment.di.DaggerAppComponent

class App : Application(){

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()


    }

}