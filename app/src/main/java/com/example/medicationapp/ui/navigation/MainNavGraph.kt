package com.example.medicationapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.LoginScreenRoute
    ) {

        loginScreen(onSuccessfullyLoggedIn = {
            navController.navigateToDashboardScreen(it)
        })

        dashboardScreen(onDrugItemClick = { drugName, drugStrength ->
            navController.navigateToDrugItemDetailScreen(
                drugName = drugName,
                drugStrength = drugStrength
            )
        })

        drugDetailScreen(onNavigateBack = {
            navController.navigateUp()
        })
    }
}