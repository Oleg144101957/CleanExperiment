package com.vishnevskiypro.cleanexperiment.presaentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vishnevskiy.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase

) : ViewModel() {
    //Класс, который может жить в течении всей жизни приложения

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive : LiveData<String> = resultLiveMutable

    init {
        Log.d("AAAAA", "VM craeted")
    }

    override fun onCleared() {
        Log.d("AAAAA", "onCleared VM")
        super.onCleared()
    }

    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }

}