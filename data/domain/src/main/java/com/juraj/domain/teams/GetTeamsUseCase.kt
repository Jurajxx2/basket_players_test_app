package com.juraj.domain.teams

import com.juraj.common.network.NetworkResult
import com.juraj.model.teams.Team
import com.juraj.repositories.teams.TeamsRepository
import kotlinx.coroutines.flow.Flow

class GetTeamsUseCase(
    private val teamsRepository: TeamsRepository
) {
    fun getTeams(): Flow<NetworkResult<List<Team>>> = teamsRepository.getTeams()
}