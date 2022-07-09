package com.vishnevskiypro.cleanexperiment.domain.usecases

import com.vishnevskiypro.cleanexperiment.domain.models.UserName
import com.vishnevskiypro.cleanexperiment.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}