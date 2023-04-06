package com.islam.cleannavigation.users_details

import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.islam.cleannavigation.UsersViewModel

@Composable
fun UserScreen(usersViewModel: UsersViewModel = hiltViewModel()) {
    val viewState = usersViewModel.viewState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            IconButton(onClick = {usersViewModel.onBackButtonClicked()}) {

            }
        }

    }
}
