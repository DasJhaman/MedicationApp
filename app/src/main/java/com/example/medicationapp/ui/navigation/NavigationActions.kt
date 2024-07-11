package com.example.medicationapp.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateToDashboardScreen(userId: String) {
    navigate("${ScreenRoutes.DashboardScreenRoute}/${userId}")
}

fun NavController.navigateToDrugItemDetailScreen(drugName: String, drugStrength:String) {
    navigate("${ScreenRoutes.DrugItemDetailScreen}/${ArgumentsNameHelper.DrugDetailScreen.drugName}=$drugName&${ArgumentsNameHelper.DrugDetailScreen.drugStrength}=$drugStrength")

}