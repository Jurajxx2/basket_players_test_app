package com.juraj.player_detail

import com.juraj.player_detail.ui.PlayerDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val playerDetailModule = module {
    viewModel { PlayerDetailViewModel(get(), get()) }
}