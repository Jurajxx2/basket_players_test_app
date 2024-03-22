package com.juraj.model.teams

data class Team(
    val abbreviation: String?,
    val city: String?,
    val conference: String?,
    val division: String?,
    val fullName: String,
    val id: Long,
    val name: String,
)