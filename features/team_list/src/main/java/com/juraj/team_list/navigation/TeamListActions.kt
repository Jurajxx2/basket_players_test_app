package com.juraj.team_list.navigation

class TeamListActions(
    val goToTeamDetail: (Long) -> Unit,
    val navigateUp: () -> Unit,
)