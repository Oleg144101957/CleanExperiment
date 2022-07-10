package com.vishnevskiypro.cleanexperiment.data.storage.sharedpref

import android.content.Context
import com.vishnevskiypro.cleanexperiment.data.storage.UserStorage
import com.vishnevskiypro.cleanexperiment.data.storage.model.User

private const val SHARED_PREF_NAME = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_SECOND_NAME = "secondName"
private const val DEFAULT_FIRST_NAME = "default first name"
private const val DEFAULT_LAST_NAME = "default last name"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: DEFAULT_FIRST_NAME
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME, "Default last name") ?: DEFAULT_LAST_NAME

        return User(firstName, secondName)
    }

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_SECOND_NAME, user.lastName).apply()
        return true
    }
}