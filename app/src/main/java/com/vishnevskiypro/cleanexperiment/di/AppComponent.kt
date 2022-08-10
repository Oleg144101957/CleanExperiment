package com.vishnevskiypro.cleanexperiment.di

import com.vishnevskiypro.cleanexperiment.presaentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}