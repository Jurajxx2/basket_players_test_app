package com.juraj.basketplayers.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.juraj.home.navigation.HomeActions
import com.juraj.home.navigation.homeNavigationRoute
import com.juraj.home.navigation.homeScreen
import com.juraj.player_detail.navigation.PlayerDetailActions
import com.juraj.player_detail.navigation.navigateToPlayerDetailScreen
import com.juraj.player_detail.navigation.playerDetailScreen
import com.juraj.player_list.navigation.PlayerListActions
import com.juraj.player_list.navigation.navigateToPlayerListScreen
import com.juraj.player_list.navigation.playerListScreen
import com.juraj.team_detail.navigation.TeamDetailActions
import com.juraj.team_detail.navigation.navigateToTeamDetailScreen
import com.juraj.team_detail.navigation.teamDetailScreen
import com.juraj.team_list.navigation.TeamListActions
import com.juraj.team_list.navigation.navigateToTeamListScreen
import com.juraj.team_list.navigation.teamListScreen

@Composable
fun BasketNavHost(
    navController: NavHostController,
) {
    NavHost(navController, startDestination = homeNavigationRoute) {
        homeScreen(
            actions = HomeActions(
                goToPlayerList = {
                    navController.navigateToPlayerListScreen()
                },
                goToTeamList = {
                    navController.navigateToTeamListScreen()
                }
            )
        )
        playerListScreen(
            actions = PlayerListActions(
                goToPlayerDetail = {
                    navController.navigateToPlayerDetailScreen(it)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        )
        playerDetailScreen(
            actions = PlayerDetailActions(
                goToTeamDetail = {
                    navController.navigateToTeamDetailScreen(it)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        )
        teamListScreen(
            actions = TeamListActions(
                goToTeamDetail = {
                    navController.navigateToTeamDetailScreen(it)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        )
        teamDetailScreen(
            actions = TeamDetailActions(
                navigateUp = {
                    navController.navigateUp()
                }
            )
        )
    }
}