package com.example.medicationapp.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateToDashboardScreen(userId: String) {
    navigate("${ScreenRoutes.DashboardScreenRoute}/${userId}")

}