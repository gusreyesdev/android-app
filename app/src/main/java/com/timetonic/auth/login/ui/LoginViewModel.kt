package com.timetonic.auth.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.timetonic.auth.login.data.model.LoginModel
import com.timetonic.auth.login.domain.CreateAppKeyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val createAppKeyUseCase: CreateAppKeyUseCase):ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLoginEnable: LiveData<Boolean> = _isLoginEnable

    private val _loginModel = MutableLiveData<LoginModel>()
    val loginModel: LiveData<LoginModel> = _loginModel

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 4
    }

    fun onCreateAppKeyModel(
        version: String,
        req: String,
        appname: String
    ) {
        viewModelScope.launch() {
            _isLoading.value = true
            val result = createAppKeyUseCase(version, req, appname)

            if (result.isSuccessful) {
                val body = result.body()!!

                if (body.status == "ok") {
                    _loginModel.value = body
                    Log.i("codedev", "2" + _loginModel.value.toString())
                }
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