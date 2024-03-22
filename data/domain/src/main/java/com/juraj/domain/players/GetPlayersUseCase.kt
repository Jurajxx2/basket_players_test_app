package com.juraj.domain.players

import com.juraj.common.network.NetworkResult
import com.juraj.model.players.Player
import com.juraj.model.players.Players
import com.juraj.repositories.players.PlayersRepository

class GetPlayersUseCase(
    private val playersRepository: PlayersRepository
) {
    suspend fun getPlayers(pageSize: Int, cursor: Int): NetworkResult<Players> =
        playersRepository.getPlayers(pageSize, cursor)
}