package com.juraj.model.teams.dto

import com.google.gson.annotations.SerializedName

data class GetTeamsDto(
    @SerializedName("data") val data: List<TeamDto>
)