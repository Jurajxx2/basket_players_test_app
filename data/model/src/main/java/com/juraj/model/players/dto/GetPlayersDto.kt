package com.juraj.model.players.dto


import com.google.gson.annotations.SerializedName

data class GetPlayersDto(
    @SerializedName("data")
    val data: List<PlayerDto>,
    @SerializedName("meta")
    val meta: Meta
) {
    data class Meta(
        @SerializedName("next_cursor")
        val nextCursor: Int,
        @SerializedName("per_page")
        val perPage: Int
    )
}
