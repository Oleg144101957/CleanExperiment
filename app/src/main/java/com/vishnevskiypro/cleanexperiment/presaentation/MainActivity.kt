package com.vishnevskiypro.cleanexperiment.presaentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.vishnevskiypro.cleanexperiment.R
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiypro.cleanexperiment.data.storage.model.User
import com.vishnevskiypro.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiypro.cleanexperiment.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val user by lazy (LazyThreadSafetyMode.NONE){ User() }

    private val userRepository by lazy(LazyThreadSafetyMode.NONE){ UserRepositoryImpl() }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){ GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE){ SaveUserNameUseCase(userRepository) }

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