package com.juraj.home.ui

import androidx.lifecycle.ViewModel
import com.juraj.domain.players.GetPlayersUseCase
import com.juraj.model.players.Player
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel(
    private val getPlayersUseCase: GetPlayersUseCase
): ViewModel() {

    val players = MutableStateFlow<List<Player>>(emptyList())

    val error = MutableSharedFlow<String?>()

    init {
        //initPlayers()
    }

    /*private fun initPlayers() {
        viewModelScope.launch {
            getPlayersUseCase.getPlayers()
                .flowOn(Dispatchers.IO)
                .catch {
                    Log.d("BASKETX", "err: ${it.stackTraceToString()}")
                    error.emit(it.localizedMessage)
                }.collect {
                    players.emit(it)
                }
        }
    }*/
}