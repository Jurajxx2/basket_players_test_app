package com.juraj.domain

import com.juraj.domain.players.GetPlayerUseCase
import com.juraj.domain.players.GetPlayersUseCase
import com.juraj.domain.teams.GetTeamUseCase
import com.juraj.domain.teams.GetTeamsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPlayersUseCase(get()) }
    factory { GetPlayerUseCase(get()) }
    factory { GetTeamsUseCase(get()) }
    factory { GetTeamUseCase(get()) }
}