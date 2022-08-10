package com.vishnevskiypro.cleanexperiment.di

import android.content.Context
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import com.vishnevskiypro.cleanexperiment.presaentation.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class AppModule (val context: Context){

    @Provides
    fun provideContext() : Context {
        return context
    }

    @Provides
    fun provideMainViewFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase,
    ) : MainViewModelFactory {
        return MainViewModelFactory(getUserNameUseCase, saveUserNameUseCase)

    }







}