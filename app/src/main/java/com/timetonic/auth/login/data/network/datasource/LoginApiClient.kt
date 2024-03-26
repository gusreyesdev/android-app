package com.timetonic.auth.login.data.network.datasource


import com.timetonic.auth.login.data.network.model.LoginResponse
import com.timetonic.auth.login.domain.model.LoginModel
import com.timetonic.core.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApiClient {
    @FormUrlEncoded
    @POST(Constants.LOGIN)
    suspend fun login(
       @Field("username") username: String,
       @Field("password") password: String
    ): Response<LoginResponse>

    /* Get
    @GET(Constants.LOGIN)
    suspend fun login(
        @Query("username") version: String,
        @Query("password") req: String,
    ): Response<LoginResponse>
     */
}