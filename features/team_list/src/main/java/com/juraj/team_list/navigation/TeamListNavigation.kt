package com.juraj.team_list.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.juraj.team_list.ui.TeamListRoute

const val teamListNavigationRoute = "team_list_route"

fun NavController.navigateToTeamListScreen(navOptions: NavOptions? = null) {
    this.navigate(teamListNavigationRoute, navOptions)
}

fun NavGraphBuilder.teamListScreen(actions: TeamListActions) {
    composable(route = teamListNavigationRoute) {
        TeamListRoute(actions)
    }
}