package com.example.medicationapp.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.medicationapp.R
import com.example.medicationapp.ui.common.ContentState
import com.example.medicationapp.ui.components.GenericError
import com.example.medicationapp.ui.components.TopAppBar
import com.example.medicationapp.ui.dashboard.composables.DashboardScreenContent
import org.copernicus.ui.components.GenericLoading
import org.koin.androidx.compose.getViewModel

@Composable
fun DashboardScreen(
    onDrugItemClick: (String, String) -> Unit,
    dashboardScreenViewModel: DashboardScreenViewModel = getViewModel()
) {
    val uiData by dashboardScreenViewModel.uiData.collectAsStateWithLifecycle()
    DashboardScreenStateless(
        dashboardUIData = uiData,
        onDrugItemClick = onDrugItemClick
    )

}

@Composable
fun DashboardScreenStateless(
    dashboardUIData: DashboardUIData,
    onDrugItemClick: (String, String) -> Unit,
) {
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
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when (dashboardUIData.contentState) {
                ContentState.LOADING -> GenericLoading()
                ContentState.ERROR -> GenericError(onRetryClicked = {
                    // TODO: Call retry api..
                })

                ContentState.SUCCESS -> {
                    DashboardScreenContent(
                        dashboardUIData = dashboardUIData,
                        onDrugItemClick = onDrugItemClick
                    )
                }
            }

        }
    }
}