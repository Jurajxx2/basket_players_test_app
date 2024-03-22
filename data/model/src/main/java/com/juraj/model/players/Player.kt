package com.juraj.model.players

import com.juraj.model.teams.Team

data class Player(
    val college: String?,
    val country: String?,
    val draftNumber: Int?,
    val draftRound: Int?,
    val draftYear: Int?,
    val firstName: String,
    val height: String?,
    val id: Long,
    val jerseyNumber: String?,
    val lastName: String,
    val position: String?,
    val team: Team?,
    val weight: String?,
    val photoUrl: String?,
)