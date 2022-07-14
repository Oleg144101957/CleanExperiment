package com.vishnevskiypro.cleanexperiment.presaentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vishnevskiypro.cleanexperiment.R
import com.vishnevskiypro.cleanexperiment.data.repository.UserRepositoryImpl
import com.vishnevskiy.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository
import com.vishnevskiy.cleanexperiment.domain.usecases.GetUserNameUseCase
import com.vishnevskiy.cleanexperiment.domain.usecases.SaveUserNameUseCase
import com.vishnevskiypro.cleanexperiment.data.storage.sharedpref.SharedPrefUserStorage

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("AAAAA", "Acteivity created (onCreate)")
        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataView)
        val getButton = findViewById<Button>(R.id.buttonGet)
        val dataInput = findViewById<EditText>(R.id.dataInput)
        val saveButton = findViewById<Button>(R.id.buttonSave)

        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })



        getButton.setOnClickListener {
            vm.load()
        }

        saveButton.setOnClickListener {
            val text = dataInput.text.toString()
            vm.save(text)
        }


    }
}