package com.example.medicationapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.medicationapp.ui.dashboard.DashboardScreen
import com.example.medicationapp.ui.login.LoginScreen
import com.example.medicationapp.ui.navigation.ScreenRoutes.DashboardScreenRoute
import com.example.medicationapp.ui.navigation.ScreenRoutes.LoginScreenRoute


fun NavGraphBuilder.loginScreen(
    onSuccessfullyLoggedIn: (String) -> Unit,
) {
    composable(route = LoginScreenRoute) {
        LoginScreen(onSuccessfullyLoggedIn = onSuccessfullyLoggedIn)
    }
}


fun NavGraphBuilder.dashboardScreen() {
    composable(route = "${DashboardScreenRoute}/{${ArgumentsNameHelper.DashboardScreen.userId}}") {
        DashboardScreen()
    }
}