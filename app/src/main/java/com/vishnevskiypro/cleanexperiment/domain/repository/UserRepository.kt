package com.vishnevskiypro.cleanexperiment.domain.repository

import com.vishnevskiypro.cleanexperiment.domain.models.SaveUserNameParam
import com.vishnevskiypro.cleanexperiment.domain.models.UserName

interface UserRepository {

    fun saveName(user: SaveUserNameParam) : Boolean

    fun getName() : UserName


}