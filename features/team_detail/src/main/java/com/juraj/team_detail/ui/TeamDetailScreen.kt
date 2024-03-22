package com.juraj.team_detail.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.juraj.common.ui.BackButton
import com.juraj.common.ui.ItemDetailField
import com.juraj.team_detail.R
import com.juraj.team_detail.navigation.TeamDetailActions
import org.koin.androidx.compose.koinViewModel

@Composable
fun TeamDetailRoute(actions: TeamDetailActions) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TeamDetailScreen(actions)
        BackButton {
            actions.navigateUp()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TeamDetailScreen(actions: TeamDetailActions, viewModel: TeamDetailViewModel = koinViewModel()) {
    val teamState = viewModel.team.collectAsState()

    val errorState = viewModel.error.collectAsState(initial = null)

    if (errorState.value != null) {
        Toast.makeText(LocalContext.current, "${errorState.value}", Toast.LENGTH_SHORT)
            .show()
    }

    if (teamState.value == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    teamState.value?.let { team ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 80.dp)
        ) {
            ItemDetailField(fieldName = stringResource(R.string.team_detail_name_field), data = team.fullName)
            ItemDetailField(fieldName = stringResource(R.string.team_detail_city_field), data = "${team.city}")
            ItemDetailField(fieldName = stringResource(R.string.team_detail_conference_field), data = "${team.conference}")
            ItemDetailField(fieldName = stringResource(R.string.team_detail_division_field), data = "${team.division}")
        }
    }
}