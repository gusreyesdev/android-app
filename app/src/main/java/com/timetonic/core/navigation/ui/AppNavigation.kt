package com.timetonic.core.navigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.timetonic.auth.login.ui.LoginScreen

@Composable
fun AppNavigationGraph() {

    val navController = rememberNavController()
    
    NavHost(navController = navController , startDestination = Routes.LOGIN_SCREEN ) {
        composable( route= Routes.LOGIN_SCREEN){
            LoginScreen(navController)
        }
    }
}