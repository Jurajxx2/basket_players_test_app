package com.juraj.repositories

import com.juraj.repositories.images.ImageRepository
import com.juraj.repositories.images.impl.ImageRepositoryImpl
import com.juraj.repositories.players.PlayersRepository
import com.juraj.repositories.players.impl.PlayersRepositoryImpl
import com.juraj.repositories.teams.TeamsRepository
import com.juraj.repositories.teams.impl.TeamsRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<PlayersRepository> { PlayersRepositoryImpl(get(), get()) }
    single<TeamsRepository> { TeamsRepositoryImpl(get()) }
    single<ImageRepository> { ImageRepositoryImpl() }
}