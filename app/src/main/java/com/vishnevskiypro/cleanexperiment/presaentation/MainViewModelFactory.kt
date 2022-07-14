package com.vishnevskiypro.cleanexperiment.presaentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiypro.cleanexperiment.data.storage.sharedpref.SharedPrefUserStorage

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory{

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        ) as T
    }


}