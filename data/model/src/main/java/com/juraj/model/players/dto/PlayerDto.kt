package com.juraj.model.players.dto

import com.google.gson.annotations.SerializedName
import com.juraj.model.teams.dto.TeamDto

data class PlayerDto(
    @SerializedName("college")
    val college: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("draft_number")
    val draftNumber: Int?,
    @SerializedName("draft_round")
    val draftRound: Int?,
    @SerializedName("draft_year")
    val draftYear: Int?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("height")
    val height: String?,
    @SerializedName("id")
    val id: Long,
    @SerializedName("jersey_number")
    val jerseyNumber: String?,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("position")
    val position: String?,
    @SerializedName("team")
    val team: TeamDto?,
    @SerializedName("weight")
    val weight: String?,
)