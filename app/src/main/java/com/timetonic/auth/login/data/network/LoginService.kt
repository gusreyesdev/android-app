package com.timetonic.auth.login.data.network

import com.timetonic.auth.login.data.model.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class LoginService @Inject constructor(private val loginClient: LoginClient ):LoginClient {

    override suspend fun createAppKey(
        version: String,
        req: String,
        appname: String
    ): Response<LoginModel> {

        return withContext(Dispatchers.IO){
           loginClient.createAppKey(version,req,appname)
        }

    }

}