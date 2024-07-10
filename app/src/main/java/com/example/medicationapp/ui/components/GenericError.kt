package com.example.medicationapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicationapp.R

@Composable
fun GenericError(
    title: String = stringResource(id = R.string.generic_error_title),
    message: String = stringResource(id = R.string.generic_error_message),
    onRetryClicked: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        onRetryClicked?.let {
            Spacer(modifier = Modifier.size(10.dp))
            DefaultButton(
                onClick = onRetryClicked,
                modifier = Modifier.widthIn(min = 200.dp),
                text = stringResource(id = R.string.generic_error_cta_title)
            )
        }

    }
}

@Preview
@Composable
private fun GenericErrorPreview() {
    GenericError(onRetryClicked = {})
}
