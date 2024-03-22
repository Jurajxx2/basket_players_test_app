package com.juraj.domain.teams

import com.juraj.common.network.NetworkResult
import com.juraj.model.teams.Team
import com.juraj.repositories.teams.TeamsRepository
import kotlinx.coroutines.flow.Flow

class GetTeamUseCase(
    private val teamsRepository: TeamsRepository
) {
    fun getTeamById(teamId: Long): Flow<NetworkResult<Team>> = teamsRepository.getTeamById(teamId)
}