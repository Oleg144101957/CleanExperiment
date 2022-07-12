package com.vishnevskiypro.cleanexperiment.data.storage

import com.vishnevskiypro.cleanexperiment.data.storage.model.User

interface UserStorage {
    fun save(user: User) : Boolean
    fun get(): User

}