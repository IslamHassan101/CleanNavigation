package com.islam.cleannavigation.navigation_utils

import kotlinx.coroutines.channels.Channel

interface AppNavigator {

    val navigationChannel: Channel<NavigationIntent>

    suspend fun navigateBack(route: String? = null, inclusive: Boolean = false)

    suspend fun tryNavigateBack(route: String? = null, inclusive: Boolean = false)

    suspend fun navigationTo(
        route: String,
        popupToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false
    )

    suspend fun tryNavigateTo(
        route: String,
        popupToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false
    )
}

sealed class NavigationIntent {
    data class NavigationBack(val route: String? = null, val inclusive: Boolean = false) :
        NavigationIntent()

    data class NavigationTo(
        val route: String,
        val popupToRoute: String? = null,
        val inclusive: Boolean = false,
        val isSingleTop: Boolean = false,
    ) : NavigationIntent()
}