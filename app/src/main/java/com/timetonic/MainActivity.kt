package com.timetonic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.timetonic.auth.login.ui.LoginScreen
import com.timetonic.auth.login.ui.LoginViewModel
import com.timetonic.core.navigation.ui.Routes
import com.timetonic.landing.presentation.LandingScreen
import com.timetonic.ui.theme.TimeTonicTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            TimeTonicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = Routes.Login.route) {
                        composable(route = Routes.Login.route) {
                            LoginScreen(navController, viewModel = loginViewModel)
                        }
                        composable(route = Routes.Landing.route) {
                            LandingScreen(navController)
                        }
                    }
                }
            }
        }
    }
}



