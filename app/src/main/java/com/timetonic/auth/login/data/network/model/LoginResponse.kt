package com.timetonic.auth.login.data.network.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("id") val id: String,
    @SerializedName("username") val username: String,
    @SerializedName("email") val email: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("token") val token: String,
)