package com.example.medicationapp.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.medicationapp.R
import com.example.medicationapp.ui.components.TopAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun DashboardScreen(dashboardScreenViewModel: DashboardScreenViewModel = getViewModel()) {
    val uiData by dashboardScreenViewModel.uiData.collectAsStateWithLifecycle()
    DashboardScreenStateless(uiData)

}

@Composable
fun DashboardScreenStateless(uiData: DashboardUIData) {
    Scaffold(
        topBar = {
            TopAppBar(
                screenTitle = stringResource(id = R.string.dashboard_screen_title),
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Text(text = uiData.userId?: "UnKnown")
        }
    }
}