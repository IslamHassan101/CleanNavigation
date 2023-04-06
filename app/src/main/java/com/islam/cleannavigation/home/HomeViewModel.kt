package com.islam.cleannavigation.home

import androidx.lifecycle.ViewModel
import com.islam.cleannavigation.AppNavigator
import com.islam.cleannavigation.navigation_utils.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val appNavigator: AppNavigator) : ViewModel() {

    suspend fun onNavigateToUsersButtonClicked() {
        appNavigator.tryNavigateTo(Destination.UserScreen())
    }

    suspend fun onNavigateToMessagesButtonClicked() {
        appNavigator.tryNavigateTo(Destination.MessagesScreen())
    }

    suspend fun onNavigateToDetailsButtonClicked() {
        appNavigator.tryNavigateTo(Destination.DetailsScreen())
    }
}