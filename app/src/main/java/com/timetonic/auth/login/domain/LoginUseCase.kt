package com.timetonic.auth.login.domain

import com.timetonic.auth.login.data.LoginRepository
import com.timetonic.auth.login.data.network.model.LoginResponse
import com.timetonic.auth.login.domain.model.LoginModel
import retrofit2.Response
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(
        username:String,
        password:String
    ): Response<LoginResponse> {
        return repository.login(username, password)
    }
}