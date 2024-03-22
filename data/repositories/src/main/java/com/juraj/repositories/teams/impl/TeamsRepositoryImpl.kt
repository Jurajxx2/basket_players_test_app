package com.juraj.repositories.teams.impl

import com.juraj.api.teams.TeamsApi
import com.juraj.common.network.ErrorResult
import com.juraj.common.network.NetworkResult
import com.juraj.model.players.mapping.toEntity
import com.juraj.model.teams.Team
import com.juraj.model.teams.mapping.toEntity
import com.juraj.repositories.teams.TeamsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//TODO implement database caching in repository
class TeamsRepositoryImpl(
    private val teamsApi: TeamsApi
) : TeamsRepository {

    override fun getTeams(): Flow<NetworkResult<List<Team>>> = flow {
        emit(
            try {
                NetworkResult.Success(teamsApi.getTeams().data.map { it.toEntity() })
            } catch (e: Exception) {
                NetworkResult.Error(
                    ErrorResult(e.stackTraceToString(), e)
                )
            }
        )
    }

    override fun getTeamById(teamId: Long): Flow<NetworkResult<Team>> = flow {
        emit(
            try {
                NetworkResult.Success(teamsApi.getTeamById(teamId).data.toEntity())
            } catch (e: Exception) {
                NetworkResult.Error(
                    ErrorResult(e.stackTraceToString(), e)
                )
            }
        )
    }
}