package com.juraj.team_list

import com.juraj.team_list.ui.TeamListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamListModule = module {
    viewModel { TeamListViewModel(get()) }
}