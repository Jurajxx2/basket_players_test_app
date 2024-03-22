package com.juraj.team_detail

import com.juraj.team_detail.ui.TeamDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamDetailModule = module {
    viewModel { TeamDetailViewModel(get(), get()) }
}