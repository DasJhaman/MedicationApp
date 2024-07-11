package com.example.medicationapp.ui.drugdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.medicationapp.R
import com.example.medicationapp.ui.components.TopAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun DrugDetailsScreen(
    onNavigateBack: () -> Unit,
    drugDetailsScreenViewModel: DrugDetailsScreenViewModel = getViewModel()
) {
    val uiData by drugDetailsScreenViewModel.uiData.collectAsStateWithLifecycle()
    DrugDetailsScreenStateless(
        uiData = uiData,
        onNavigateBack = onNavigateBack
    )
}

@Composable
fun DrugDetailsScreenStateless(
    uiData: DrugDetailScreenUIData,
    onNavigateBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                screenTitle = stringResource(id = R.string.drug_details_screen_title),
                onNavigateBack = onNavigateBack
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

            Text(text = uiData.drugName, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = uiData.drugStrength, style = MaterialTheme.typography.titleLarge)
        }
    }
}