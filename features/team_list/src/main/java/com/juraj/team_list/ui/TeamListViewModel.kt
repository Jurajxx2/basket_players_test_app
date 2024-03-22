package com.juraj.team_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juraj.common.network.NetworkResult
import com.juraj.domain.teams.GetTeamsUseCase
import com.juraj.model.teams.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.launch

class TeamListViewModel(
    private val getTeamsUseCase: GetTeamsUseCase,
): ViewModel() {

    val teams = MutableStateFlow<List<Team>>(emptyList())
    val error = MutableSharedFlow<String?>()

    init {
        initTeams()
    }

    private fun initTeams() {
        viewModelScope.launch {
            getTeamsUseCase.getTeams()
                .flowOn(Dispatchers.IO)
                .mapNotNull {
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
                    teams.emit(it)
                }
        }
    }
}