package com.timetonic.auth.login.ui

sealed class LoginUiState<T> {

    class Loading<T> : LoginUiState<T>()

    data class Success<T>(val data: T) : LoginUiState<T>()

    data class Error<T>(val error: T) : LoginUiState<T>()

}