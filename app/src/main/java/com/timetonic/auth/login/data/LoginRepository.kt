package com.timetonic.auth.login.data

import com.timetonic.auth.login.data.model.LoginModel
import com.timetonic.auth.login.data.network.LoginClient
import com.timetonic.auth.login.data.network.LoginService
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val loginService: LoginService) {

    suspend fun createAppKey(
        version: String,
        req: String,
        appname: String
    ): Response <LoginModel> {
        return loginService.createAppKey(version,req,appname)
    }

}