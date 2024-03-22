package com.juraj.model.teams.mapping

import com.juraj.model.teams.Team
import com.juraj.model.teams.dto.TeamDto

fun TeamDto.toEntity() = Team(
    abbreviation, city, conference, division, fullName, id, name
)