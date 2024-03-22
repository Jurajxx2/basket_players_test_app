package com.juraj.model.teams.dto

import com.google.gson.annotations.SerializedName

data class GetTeamDto(
    @SerializedName("data") val data: TeamDto
)