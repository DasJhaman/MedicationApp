package com.example.medicationapp.ui.dashboard.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicationapp.domain.models.AssociatedDrug

@Composable
fun AssociatedDrugCard(
    modifier: Modifier = Modifier,
    associatedDrug: AssociatedDrug,
    onDrugItemClick: (String, String) -> Unit = { a, b -> }
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable { onDrugItemClick(associatedDrug.drugName, associatedDrug.drugStrength) }
    ) {
        Column(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)) {
            Text(text = associatedDrug.drugName)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = associatedDrug.drugStrength)

        }

    }
}


@Preview
@Composable
fun AssociatedDrugCardPreview() {
    AssociatedDrugCard(
        associatedDrug = AssociatedDrug(
            drugStrength = "Name", drugDose = "500 mg",
            drugName = "Drug Name"
        )
    )
}