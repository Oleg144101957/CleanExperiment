package com.vishnevskiypro.cleanexperiment.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.vishnevskiypro.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanexperiment.domain.models.UserName
import com.vishnevskiypro.cleanexperiment.domain.repository.UserRepository


private const val SHARED_PREF_NAME = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_SECOND_NAME = "secondName"
private const val DEFAULT_NAME = "default"

class UserRepositoryImpl(private val context: Context) : UserRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserNameParam: SaveUserNameParam) : Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveUserNameParam.name).apply()
        return true
    }

    override fun getName() : UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME, "Default last name") ?: DEFAULT_NAME

        return UserName(firstName, secondName)
    }

}