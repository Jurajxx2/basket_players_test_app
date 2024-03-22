package com.juraj.player_list.navigation

class PlayerListActions(
    val goToPlayerDetail: (Long) -> Unit,
    val navigateUp: () -> Unit,
)