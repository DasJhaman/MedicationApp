package com.example.medicationapp.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateToDashboardScreen(userId: String) {
    this.navigate("${ScreenRoutes.DashboardScreenRoute}/${ArgumentsNameHelper.DashboardScreen.userId}=$userId")
}