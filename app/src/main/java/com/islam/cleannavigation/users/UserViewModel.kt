package com.islam.cleannavigation

import androidx.lifecycle.ViewModel
import com.islam.cleannavigation.navigation_utils.Destination
import com.islam.cleannavigation.users.User
import com.islam.cleannavigation.users.UsersViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(private val appNavigator: AppNavigator) : ViewModel() {

    private val _viewState = MutableStateFlow(UsersViewState())
    val viewState = _viewState.asStateFlow()

     fun onBackButtonClicked() {
        appNavigator.navigateBack()
    }

     fun onUserRowClicked(user: User) {
        appNavigator.tryNavigateTo(
            Destination.UserDetailsScreen(
                firstName = user.firstName,
                lastName = user.lastName
            )
        )
    }
}