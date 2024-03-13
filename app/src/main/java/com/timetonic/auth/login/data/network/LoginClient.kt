package com.timetonic.auth.login.data.network


import com.timetonic.auth.login.data.model.LoginModel
import com.timetonic.core.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginClient {
    @GET(Constants.API)
    suspend fun createAppKey(
        @Query("version") version: String,
        @Query("req") req: String,
        @Query("appname") appname: String
    ): Response<LoginModel>
}