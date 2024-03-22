package com.juraj.player_list.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.juraj.domain.players.GetPlayersUseCase
import com.juraj.model.players.Player
import com.juraj.player_list.paging.PAGE_SIZE
import com.juraj.player_list.paging.PlayerPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

class PlayerListViewModel(
    private val getPlayersUseCase: GetPlayersUseCase,
): ViewModel() {

    private val pager = Pager(
        PagingConfig(PAGE_SIZE),
    ) {
        PlayerPagingSource(
            getPlayersUseCase,
        )
    }

    val users: Flow<PagingData<Player>> = pager.flow.cachedIn(viewModelScope)
}