package com.vishnevskiypro.cleanexperiment.di

import com.vishnevskiypro.cleanexperiment.presaentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel <MainViewModel>{
        MainViewModel(
            getUserNameUseCase = get(),
            saveUserNameUseCase = get()
        )
    }
}