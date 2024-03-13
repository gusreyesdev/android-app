package com.timetonic.core.navigation.ui

sealed class Routes(val route: String) {
    data object Login : Routes("login")
    data object Landing : Routes("landing")
}