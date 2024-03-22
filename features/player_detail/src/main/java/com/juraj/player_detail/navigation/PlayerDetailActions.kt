package com.juraj.player_detail.navigation

class PlayerDetailActions(
    val goToTeamDetail: (Long) -> Unit,
    val navigateUp: () -> Unit,
)