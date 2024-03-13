package com.timetonic.auth.login.ui

import com.timetonic.auth.login.data.model.LoginModel

sealed interface LoginUiState {
    object Loading:LoginUiState

    data class Error(val throwable: Throwable):LoginUiState

    data class Success(val loginModel: LoginModel):LoginUiState
}