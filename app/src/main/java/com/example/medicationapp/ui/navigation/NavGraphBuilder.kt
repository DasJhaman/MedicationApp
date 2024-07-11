package com.example.medicationapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.medicationapp.ui.dashboard.DashboardScreen
import com.example.medicationapp.ui.drugdetails.DrugDetailsScreen
import com.example.medicationapp.ui.login.LoginScreen
import com.example.medicationapp.ui.navigation.ScreenRoutes.DashboardScreenRoute
import com.example.medicationapp.ui.navigation.ScreenRoutes.DrugItemDetailScreen
import com.example.medicationapp.ui.navigation.ScreenRoutes.LoginScreenRoute


fun NavGraphBuilder.loginScreen(
    onSuccessfullyLoggedIn: (String) -> Unit,
) {
    composable(route = LoginScreenRoute) {
        LoginScreen(onSuccessfullyLoggedIn = onSuccessfullyLoggedIn)
    }
}


fun NavGraphBuilder.dashboardScreen(onDrugItemClick: (String, String) -> Unit) {
    composable(route = "${DashboardScreenRoute}/{${ArgumentsNameHelper.DashboardScreen.userId}}") {
        DashboardScreen(onDrugItemClick = onDrugItemClick)
    }
}

fun NavGraphBuilder.drugDetailScreen() {
    composable(route = "${DrugItemDetailScreen}/${ArgumentsNameHelper.DrugDetailScreen.drugName}={${ArgumentsNameHelper.DrugDetailScreen.drugName}}&${ArgumentsNameHelper.DrugDetailScreen.drugStrength}={${ArgumentsNameHelper.DrugDetailScreen.drugStrength}}") {
        DrugDetailsScreen()
    }
}