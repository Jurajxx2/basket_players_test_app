package com.juraj.player_detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.juraj.player_detail.ui.PlayerDetailRoute

internal const val playerIdArgumentName = "{playerId}"
const val playerDetailNavigationRoute = "player_detail_route/$playerIdArgumentName"

fun NavController.navigateToPlayerDetailScreen(playerId: Long, navOptions: NavOptions? = null) {
    this.navigate(playerDetailNavigationRoute.replace(playerIdArgumentName, playerId.toString()), navOptions)
}

fun NavGraphBuilder.playerDetailScreen(actions: PlayerDetailActions) {
    composable(
        route = playerDetailNavigationRoute,
        arguments = listOf(navArgument("playerId") { type = NavType.LongType })
    ) {
        PlayerDetailRoute(actions)
    }
}