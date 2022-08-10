package com.vishnevskiypro.cleanexperiment.di

import android.content.Context
import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiypro.cleanexperiment.data.storage.UserStorage
import com.vishnevskiypro.cleanexperiment.data.storage.sharedpref.SharedPrefUserStorage
import dagger.Module
import dagger.Provides


@Module
class DataModule {


    @Provides
    fun provideUserStorage(context: Context) : UserStorage {
        return SharedPrefUserStorage(context = context)
    }


    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }
}