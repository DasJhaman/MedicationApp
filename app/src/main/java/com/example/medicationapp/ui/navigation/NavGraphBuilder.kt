package com.example.medicationapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.medicationapp.ui.login.LoginScreen
import com.example.medicationapp.ui.navigation.ScreenRoutes.LoginScreenRoute


fun NavGraphBuilder.loginScreen() {
    composable(route = LoginScreenRoute) {
        LoginScreen()
    }
}