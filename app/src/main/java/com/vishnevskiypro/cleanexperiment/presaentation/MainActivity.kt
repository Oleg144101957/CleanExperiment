package com.vishnevskiypro.cleanexperiment.presaentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.vishnevskiypro.cleanexperiment.R
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiy.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import com.vishnevskiypro.cleanexperiment.data.storage.sharedpref.SharedPrefUserStorage

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(applicationContext))
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetUserNameUseCase(userRepository = userRepository)
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataView)
        val getButton = findViewById<Button>(R.id.buttonGet)
        val dataInput = findViewById<EditText>(R.id.dataInput)
        val saveButton = findViewById<Button>(R.id.buttonSave)


        getButton.setOnClickListener {

            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }

        saveButton.setOnClickListener {
            val text = dataInput.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(params)

            dataTextView.text = "Save result = ${result}"
        }


    }
}