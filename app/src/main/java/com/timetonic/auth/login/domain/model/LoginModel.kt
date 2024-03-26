package com.timetonic.auth.login.domain.model

import com.timetonic.auth.login.data.network.model.LoginResponse

data class LoginModel(
    val id: String,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val token: String,
)

fun LoginResponse.toDomain()= LoginModel(id, username, email, firstName, lastName, token)