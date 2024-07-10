package com.example.medicationapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    labelTitle: String,
    value: String,
    enabled: Boolean = true,
    isError: Boolean = false,
    errorTitle: String? = null,
    maxLines: Int = Int.MAX_VALUE,
    textStyle: TextStyle = LocalTextStyle.current,
    textFieldHeight: Dp = 70.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit = {},
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        isError = isError,
        maxLines = maxLines,
        shape = MaterialTheme.shapes.medium,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        supportingText = {
            if (isError && errorTitle != null) {
                Text(
                    text = errorTitle,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        visualTransformation = visualTransformation,
        label = { Text(text = labelTitle, maxLines = 1) },
        textStyle = textStyle,
        modifier = modifier
            .fillMaxWidth()
            .height(textFieldHeight)
    )
}

@Preview
@Composable
private fun DefaultTextFieldPreview() {
    val value by remember { mutableStateOf("") }
    DefaultTextField(
        labelTitle = "Username",
        value = value,
        onValueChange = { },
    )
}

