package com.vishnevskiypro.cleanexperiment.presaentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.vishnevskiypro.cleanexperiment.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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