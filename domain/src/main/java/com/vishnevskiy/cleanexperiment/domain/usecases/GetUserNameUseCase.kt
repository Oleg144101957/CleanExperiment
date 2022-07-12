package com.vishnevskiy.cleanexperiment.domain.usecases

import com.vishnevskiy.cleanexperiment.domain.models.UserName
import com.vishnevskiy.cleanexperiment.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }
}