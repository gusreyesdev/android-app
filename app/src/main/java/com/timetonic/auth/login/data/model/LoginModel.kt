package com.timetonic.auth.login.data.model

import com.google.gson.annotations.SerializedName

data class LoginModel (

    @SerializedName("status") val status: String,
    @SerializedName("appkey") val appkey: String,
    @SerializedName("oauthkey") val oauthkey: String,
    @SerializedName("o_u") val o_u: String,
    @SerializedName("sesskey") val sesskey: String

    //val authenticate: Boolean = false
)