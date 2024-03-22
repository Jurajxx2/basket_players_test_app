package com.juraj.repositories.teams

import com.juraj.common.network.NetworkResult
import com.juraj.model.teams.Team
import kotlinx.coroutines.flow.Flow

interface TeamsRepository {

    fun getTeams(): Flow<NetworkResult<List<Team>>>

    fun getTeamById(teamId: Long): Flow<NetworkResult<Team>>
}