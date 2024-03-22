package com.juraj.model.players.dto

import com.google.gson.annotations.SerializedName

data class GetPlayerDto(
    @SerializedName("data")
    val data: PlayerDto,
)