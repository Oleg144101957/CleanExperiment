package com.vishnevskiypro.cleanexperiment.di

import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module{

    factory <GetUserNameUseCase>{
        GetUserNameUseCase(userRepository = get())
    }

    factory <SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}