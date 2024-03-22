package com.juraj.player_list

import com.juraj.player_list.paging.PlayerPagingSource
import com.juraj.player_list.ui.PlayerListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val playerListModule = module {
    viewModel { PlayerListViewModel(get()) }
    factory { PlayerPagingSource(get()) }
}