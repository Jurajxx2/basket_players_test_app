package com.juraj.domain.players

import com.juraj.common.network.NetworkResult
import com.juraj.model.players.Player
import com.juraj.repositories.players.PlayersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetPlayerUseCase(
    private val playersRepository: PlayersRepository,
) {
    suspend fun getPlayer(playerId: Long): Flow<NetworkResult<Player>> = playersRepository.getPlayer(playerId)
}