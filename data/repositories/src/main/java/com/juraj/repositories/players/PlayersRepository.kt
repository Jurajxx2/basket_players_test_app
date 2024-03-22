package com.juraj.repositories.players

import com.juraj.common.network.NetworkResult
import com.juraj.model.players.Player
import com.juraj.model.players.Players
import kotlinx.coroutines.flow.Flow

interface PlayersRepository {

    suspend fun getPlayers(pageSize: Int, cursor: Int): NetworkResult<Players>

    suspend fun getPlayer(playerId: Long): Flow<NetworkResult<Player>>
}