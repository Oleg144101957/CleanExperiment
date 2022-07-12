package com.vishnevskiy.cleanexperiment.domain.usecases

import com.vishnevskiy.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        val result: Boolean = userRepository.saveName(param)
        return result
    }
}