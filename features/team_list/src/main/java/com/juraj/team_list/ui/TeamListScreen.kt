package com.juraj.team_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juraj.common.ui.BackButton
import com.juraj.team_list.navigation.TeamListActions
import org.koin.androidx.compose.koinViewModel

@Composable
fun TeamListRoute(actions: TeamListActions) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TeamListScreen(actions = actions)
        BackButton {
            actions.navigateUp()
        }
    }
}

@Composable
fun TeamListScreen(actions: TeamListActions, viewModel: TeamListViewModel = koinViewModel()) {
    val teamList = viewModel.teams.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(top = 80.dp)
        ) {
            items(teamList.value) { team ->
                Column(
                    Modifier
                        .padding(16.dp, 8.dp, 16.dp, 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            actions.goToTeamDetail(team.id)
                        }
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = team.fullName,
                        fontSize = 20.sp
                    )
                    team.city?.let {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it,
                        )
                    }
                }

            }
        }
    }
}