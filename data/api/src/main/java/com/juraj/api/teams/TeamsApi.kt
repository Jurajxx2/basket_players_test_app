package com.juraj.api.teams

import com.juraj.model.teams.dto.GetTeamDto
import com.juraj.model.teams.dto.GetTeamsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsApi {

    @GET("teams")
    suspend fun getTeams(): GetTeamsDto

    @GET("teams/{id}")
    suspend fun getTeamById(@Path("id") teamId: Long): GetTeamDto
}