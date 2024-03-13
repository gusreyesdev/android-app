package com.timetonic.auth.login.domain

import com.timetonic.auth.login.data.LoginRepository
import com.timetonic.auth.login.data.model.LoginModel
import retrofit2.Response
import javax.inject.Inject

class CreateAppKeyUseCase @Inject constructor(private val repository: LoginRepository) {

    suspend operator fun invoke(
        version: String,
        req: String,
        appname: String
    ): Response<LoginModel> {
        return repository.createAppKey(version, req, appname)
    }



}