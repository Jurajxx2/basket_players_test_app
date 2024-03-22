package com.juraj.model.teams.dto

import com.google.gson.annotations.SerializedName

data class TeamDto(
    @SerializedName("abbreviation")
    val abbreviation: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("conference")
    val conference: String?,
    @SerializedName("division")
    val division: String?,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
)