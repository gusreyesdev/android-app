package com.timetonic.auth.login.data.network.datasource

import com.timetonic.auth.login.data.network.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
class LoginService @Inject constructor(private val loginApiClient: LoginApiClient){
    suspend fun login(username:String, password:String): Response<LoginResponse>{

        return withContext(Dispatchers.IO){
            loginApiClient.login(username, password)
        }
    }
}