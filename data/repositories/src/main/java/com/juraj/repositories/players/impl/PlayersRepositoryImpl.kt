package com.juraj.repositories.players.impl

import com.juraj.api.players.PlayersApi
import com.juraj.common.network.ErrorResult
import com.juraj.common.network.NetworkResult
import com.juraj.model.players.Player
import com.juraj.model.players.Players
import com.juraj.model.players.mapping.toEntity
import com.juraj.model.players.mapping.toPlayers
import com.juraj.repositories.images.ImageRepository
import com.juraj.repositories.players.PlayersRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//TODO implement database caching in repository
class PlayersRepositoryImpl(
    private val playersApi: PlayersApi,
    private val imageRepository: ImageRepository,
): PlayersRepository {

     override suspend fun getPlayers(pageSize: Int, cursor: Int): NetworkResult<Players> {
        return try {
            coroutineScope {
                NetworkResult.Success(
                    playersApi.getPlayers(pageSize, cursor).toPlayers {
                        imageRepository.getImageUrlForPlayerId(it.id)
                    }
                )
            }
        } catch (e: Exception) {
            NetworkResult.Error(ErrorResult(e.stackTraceToString(), e))
        }
    }

    override suspend fun getPlayer(playerId: Long): Flow<NetworkResult<Player>> = flow {
        emit(try {
            NetworkResult.Success(playersApi.getPlayerById(playerId).data.toEntity {
                imageRepository.getImageUrlForPlayerId(it.id)
            })
        } catch (e: Exception) {
            NetworkResult.Error(ErrorResult(e.stackTraceToString(), e))
        })
    }
}