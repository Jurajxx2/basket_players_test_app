package com.juraj.model.players

class Players(
    val data: List<Player>,
    val meta: Meta,
) {
    data class Meta(
        val nextCursor: Int,
        val perPage: Int
    )
}