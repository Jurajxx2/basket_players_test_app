package com.juraj.team_detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.juraj.team_detail.ui.TeamDetailRoute

internal const val teamIdArgumentName = "{teamId}"
const val teamDetailNavigationRoute = "team_detail_route/$teamIdArgumentName"

fun NavController.navigateToTeamDetailScreen(teamId: Long, navOptions: NavOptions? = null) {
    this.navigate(teamDetailNavigationRoute.replace(teamIdArgumentName, teamId.toString()), navOptions)
}

fun NavGraphBuilder.teamDetailScreen(actions: TeamDetailActions) {
    composable(
        route = teamDetailNavigationRoute,
        arguments = listOf(navArgument("teamId") { type = NavType.LongType })
    ) {
        TeamDetailRoute(actions)
    }
}