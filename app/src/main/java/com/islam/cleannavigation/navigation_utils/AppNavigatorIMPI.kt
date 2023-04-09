package com.islam.cleannavigation.navigation_utils

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject


class AppNavigatorIMPI @Inject constructor() : AppNavigator {

    override val navigationChannel = Channel<NavigationIntent>(
        capacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_LATEST
    )

    override suspend fun navigateBack(route: String?, inclusive: Boolean) {
        navigationChannel.send(
            NavigationIntent.NavigationBack(
                route = route,
                inclusive = inclusive
            )
        )
    }

    override suspend fun tryNavigateBack(route: String?, inclusive: Boolean) {
        navigationChannel.trySend(
            NavigationIntent.NavigationBack(
                route = route,
                inclusive = inclusive
            )
        )
    }

    override suspend fun navigationTo(
        route: String,
        popupToRoute: String?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        navigationChannel.send(
            NavigationIntent.NavigationTo(
                route = route,
                popupToRoute = popupToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop
            )
        )
    }

    override suspend fun tryNavigateTo(
        route: String,
        popupToRoute: String?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        navigationChannel.trySend(
            NavigationIntent.NavigationTo(
                route = route,
                popupToRoute = popupToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop
            )
        )
    }

}