package com.example.medicationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.medicationapp.ui.navigation.MainComposable
import com.example.medicationapp.ui.theme.MedicationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedicationAppTheme {
                MainContent()
            }
        }
    }
}


@Composable
fun MainContent() {
    val navController: NavHostController = rememberNavController()
    MainComposable(navController = navController)
}