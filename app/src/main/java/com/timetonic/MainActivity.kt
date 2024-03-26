package com.timetonic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.timetonic.auth.login.ui.LoginViewModel
import com.timetonic.core.navigation.ui.AppNavigationGraph
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

                    AppEntryPoint()
                    /*
                    NavHost(navController = navController, startDestination = Routes1.Login.route) {
                        composable(route = Routes1.Login.route) {
                            LoginScreen(navController, viewModel = loginViewModel)
                        }
                        composable(route = Routes1.Landing.route) {
                            LandingScreen(navController)
                        }
                    }
                    */
                }
            }
        }
    }
}

@Composable
fun AppEntryPoint() {
    AppNavigationGraph()
}


