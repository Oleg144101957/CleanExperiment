package com.vishnevskiypro.cleanexperiment.di

import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import dagger.Module
import dagger.Provides


@Module
class DomainModule {


    @Provides
    fun provideUserNameUseCase(userRepository: UserRepository) : GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }


    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase{
        return SaveUserNameUseCase(userRepository = userRepository)
    }


}