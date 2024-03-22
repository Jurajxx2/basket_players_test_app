package com.juraj.model.players.mapping

import com.juraj.model.players.Player
import com.juraj.model.players.Players
import com.juraj.model.players.dto.GetPlayersDto
import com.juraj.model.players.dto.PlayerDto
import com.juraj.model.teams.mapping.toEntity
import kotlin.coroutines.CoroutineContext

fun GetPlayersDto.toPlayers(provideImageUrl: (PlayerDto) -> String) = Players(
    data.map {
        it.toEntity(provideImageUrl)
    },
    meta.toEntity()
)

fun PlayerDto.toEntity(provideImageUrl: (PlayerDto) -> String) = Player(
    college,
    country,
    draftNumber,
    draftRound,
    draftYear,
    firstName,
    height,
    id,
    jerseyNumber,
    lastName,
    position,
    team?.toEntity(),
    weight,
    provideImageUrl(this)
)

fun GetPlayersDto.Meta.toEntity() = Players.Meta(
    nextCursor, perPage
)

