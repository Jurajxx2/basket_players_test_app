package com.juraj.team_detail.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juraj.common.network.NetworkResult
import com.juraj.domain.players.GetPlayerUseCase
import com.juraj.domain.teams.GetTeamUseCase
import com.juraj.model.players.Player
import com.juraj.model.teams.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class TeamDetailViewModel(
    savedAStateHandle: SavedStateHandle,
    private val getTeamUseCase: GetTeamUseCase,
): ViewModel() {

    private val teamId: Long? = savedAStateHandle["teamId"]
    val team = MutableStateFlow<Team?>(null)
    val error = MutableSharedFlow<String?>()

    init {
        loadData()
    }

    private fun loadData() {
        teamId?.let {
            viewModelScope.launch {
                getTeamUseCase.getTeamById(it)
                    .flowOn(Dispatchers.IO)
                    .map {
                        when (it) {
                            is NetworkResult.Success -> it.data
                            is NetworkResult.Error -> {
                                error.emit(it.error.throwable?.message)
                                null
                            }

                            else -> null
                        }
                    }
                    .catch {
                        error.emit(it.localizedMessage)
                    }.collect {
                        team.emit(it)
                    }
            }
        }
    }
}