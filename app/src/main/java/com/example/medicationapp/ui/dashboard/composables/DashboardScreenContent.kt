package com.example.medicationapp.ui.dashboard.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicationapp.R
import com.example.medicationapp.domain.models.AssociatedDrug
import com.example.medicationapp.ui.dashboard.DashboardUIData

@Composable
fun DashboardScreenContent(
    modifier: Modifier = Modifier,
    dashboardUIData: DashboardUIData,
    onDrugItemClick: (String, String) -> Unit = { a, b -> }
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        dashboardUIData.userId?.let {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.welcome),
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            items(dashboardUIData.associateDrugs.size) {
                AssociatedDrugCard(
                    associatedDrug = dashboardUIData.associateDrugs[it],
                    onDrugItemClick = onDrugItemClick
                )
            }
        }

    }


}

@Preview
@Composable
fun DashboardScreenContentWithStatesPreview() {
    Column {
        DashboardScreenContent(
            dashboardUIData = DashboardUIData(
                userId = "Jhaman",
                associateDrugs = listOf(
                    AssociatedDrug(
                        drugDose = "DrugDose",
                        drugName = "DrugName",
                        drugStrength = "500mg"
                    ),
                    AssociatedDrug(
                        drugDose = "DrugDose",
                        drugName = "DrugName",
                        drugStrength = "500mg"
                    )
                )
            ),
        )
    }

}