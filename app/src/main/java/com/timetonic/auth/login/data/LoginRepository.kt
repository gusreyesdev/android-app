package com.timetonic.auth.login.data


import com.timetonic.auth.login.data.network.datasource.LoginService
import com.timetonic.auth.login.data.network.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val loginService: LoginService,
    //private val loginDao: LoginDao
) {
    suspend fun login(
        username: String,
        password: String,
    ): Response<LoginResponse> {
       return loginService.login(username, password)
    }

}