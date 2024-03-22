package com.juraj.player_detail.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juraj.common.network.NetworkResult
import com.juraj.domain.players.GetPlayerUseCase
import com.juraj.model.players.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class PlayerDetailViewModel(
    savedAStateHandle: SavedStateHandle,
    private val getPlayerUseCase: GetPlayerUseCase,
): ViewModel() {

    private val playerId: Long? = savedAStateHandle["playerId"]
    val player = MutableStateFlow<Player?>(null)
    val error = MutableSharedFlow<String?>()

    init {
        loadData()
    }

    fun loadData() {
        playerId?.let {
            viewModelScope.launch {
                getPlayerUseCase.getPlayer(it)
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
                        player.emit(it)
                    }
            }
        }
    }
}