package com.juraj.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.juraj.home.ui.HomeRoute

const val homeNavigationRoute = "home_route"

fun NavController.navigateToHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(actions: HomeActions) {
    composable(route = homeNavigationRoute) {
        HomeRoute(actions)
    }
}