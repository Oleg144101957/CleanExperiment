package com.vishnevskiy.cleanexperiment.domain.repository

import com.vishnevskiy.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiy.cleanexperiment.domain.models.UserName

interface UserRepository {

    fun saveName(user: SaveUserNameParam) : Boolean

    fun getName() : UserName


}