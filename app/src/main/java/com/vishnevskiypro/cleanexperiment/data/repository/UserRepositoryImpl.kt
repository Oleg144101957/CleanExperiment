package com.vishnevskiypro.cleanexperiment.data.repository

import com.vishnevskiypro.cleanexperiment.data.storage.model.User
import com.vishnevskiypro.cleanexperiment.data.storage.UserStorage
import com.vishnevskiypro.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanexperiment.domain.models.UserName
import com.vishnevskiypro.cleanexperiment.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository{

    override fun saveName(saveUserNameParam: SaveUserNameParam) : Boolean {

        val user = mapToStorage(saveUserNameParam)

        val result = userStorage.save(user)
        return result
    }

    override fun getName() : UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveUserNameParam: SaveUserNameParam): User {
        return User(saveUserNameParam.name, "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }
}