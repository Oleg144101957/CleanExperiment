package com.vishnevskiypro.cleanexperiment.domain.usecases

import com.vishnevskiypro.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanexperiment.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        val result: Boolean = userRepository.saveName(param)
        return result
    }
}