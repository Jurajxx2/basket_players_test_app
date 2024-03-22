package com.juraj.player_list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.juraj.player_list.ui.PlayerListRoute

const val playerListNavigationRoute = "player_list_route"

fun NavController.navigateToPlayerListScreen(navOptions: NavOptions? = null) {
    this.navigate(playerListNavigationRoute, navOptions)
}

fun NavGraphBuilder.playerListScreen(actions: PlayerListActions) {
    composable(route = playerListNavigationRoute) {
        PlayerListRoute(actions)
    }
}