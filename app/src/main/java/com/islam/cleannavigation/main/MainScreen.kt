package com.islam.cleannavigation

import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.islam.cleannavigation.main.MainViewModel
import com.islam.cleannavigation.navigation_utils.Destination
import com.islam.cleannavigation.users_details.*
import com.islam.cleannavigation.ui.theme.CleanNavigationTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun MainScreen(mainViewModel: MainViewModel = hiltViewModel()) {

    val navController = rememberNavController()

    NavigationEffects(
        navigationChannel = mainViewModel.navigationChannel,
        navHostController = navController
    )
    CleanNavigationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHosts(navController = navController, startDestination = Destination.HomeScreen) {

                composable(destination = Destination.HomeScreen) {
                    HomeScreen()
                }
                composable(destination = Destination.UserScreen) {
                    UserScreen()
                }
                composable(destination = Destination.UserDetailsScreen) {
                    UserDetailsScreen()
                }
                composable(destination = Destination.MessagesScreen) {
                    MessagesScreen()
                }
                composable(destination = Destination.DetailsScreen) {
                    DetailsScreen()
                }
            }

        }
    }
}


@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigationBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }
                is NavigationIntent.NavigationTo -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popupToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}
