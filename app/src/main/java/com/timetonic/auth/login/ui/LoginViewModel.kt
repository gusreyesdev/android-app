package com.timetonic.auth.login.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.timetonic.auth.login.data.network.model.LoginResponse
import com.timetonic.auth.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) :
    ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _loginData = MutableLiveData<LoginResponse>()
    val loginData: LiveData<LoginResponse> = _loginData

    fun onLoginChanged(username: String, password: String) {
        _username.value = username
        _password.value = password
        _isLoginEnable.value = enableLogin(username, password)
    }

    private fun enableLogin(username: String, password: String): Boolean {
        return username.length > 1 && password.length > 1

        // return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 4
    }

    fun login(
        username: String,
        password: String
    ) {

        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(username, password)

            //Log.i("codedev", "result" + result)

            if (result.isSuccessful) {

                Log.i("codedev", "body" + result.body())

               // _loginData.value = body[0]

               // Log.i("codedev", "model" + _loginData.value.toString())

            }
            _isLoading.value = false
        }
    }

    fun onHandleLogin(navController: NavController) {
        /*
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!,password.value!!)

            if(result){

                navController.navigate(Routes.Landing.route)

                _isLoading.value = false

            }

        }
         */

    }


}