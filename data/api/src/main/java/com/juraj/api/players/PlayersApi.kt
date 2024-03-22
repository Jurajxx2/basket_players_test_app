package com.juraj.api.players

import com.juraj.model.players.dto.GetPlayerDto
import com.juraj.model.players.dto.GetPlayersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayersApi {
    @GET("players")
    suspend fun getPlayers(@Query("per_page") pageSize: Int, @Query("cursor") cursor: Int): GetPlayersDto

    @GET("players/{id}")
    suspend fun getPlayerById(@Path("id") playerId: Long): GetPlayerDto
}