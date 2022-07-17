package com.vishnevskiypro.cleanexperiment.di

import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiypro.cleanexperiment.data.storage.UserStorage
import com.vishnevskiypro.cleanexperiment.data.storage.sharedpref.SharedPrefUserStorage
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}