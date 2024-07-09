package com.example.medicationapp.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.medicationapp.R
import com.example.medicationapp.ui.common.ContentState
import com.example.medicationapp.ui.components.TopAppBar
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = getViewModel()) {
    LoginScreenStateless(contentState = ContentState.ERROR)
}

@Composable
fun LoginScreenStateless(
    contentState: ContentState
) {
    Scaffold(
        topBar = {
            TopAppBar(
                screenTitle = stringResource(id = R.string.login),
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

        }
    }

}