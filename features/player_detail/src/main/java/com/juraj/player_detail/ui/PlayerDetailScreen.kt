package com.juraj.player_detail.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.juraj.common.ui.BackButton
import com.juraj.common.ui.ItemDetailField
import com.juraj.player_detail.R
import com.juraj.player_detail.navigation.PlayerDetailActions
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlayerDetailRoute(actions: PlayerDetailActions) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PlayerDetailScreen(actions)
        BackButton {
            actions.navigateUp()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlayerDetailScreen(
    actions: PlayerDetailActions,
    viewModel: PlayerDetailViewModel = koinViewModel()
) {
    val playerState = viewModel.player.collectAsState()

    val errorState = viewModel.error.collectAsState(initial = null)

    if (errorState.value != null) {
        Toast.makeText(LocalContext.current, "${errorState.value}", Toast.LENGTH_SHORT)
            .show()
    }

    if (playerState.value == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    playerState.value?.let { player ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = 80.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)) {
                GlideImage(
                    modifier = Modifier
                        .width(240.dp)
                        .padding(horizontal = 24.dp),
                    contentScale = ContentScale.FillWidth,
                    model = player.photoUrl,
                    contentDescription = "",
                    requestBuilderTransform = {
                        it.diskCacheStrategy(DiskCacheStrategy.ALL)
                    }
                )
            }
            ItemDetailField(fieldName = stringResource(R.string.player_detail_name_field), data = "${player.firstName} ${player.lastName}")
            ItemDetailField(fieldName = stringResource(R.string.player_detail_college_field), data = "${player.college}")
            ItemDetailField(fieldName = stringResource(R.string.player_detail_country_field), data = "${player.country}")
            ItemDetailField(fieldName = stringResource(R.string.player_detail_height_field), data = "${player.height}")
            ItemDetailField(fieldName = stringResource(R.string.player_detail_position_field), data = "${player.position}")
            player.team?.let { team ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    text = stringResource(R.string.player_detail_team_title),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
                ItemDetailField(fieldName = stringResource(R.string.player_detail_team_field), data = team.fullName)
                ItemDetailField(fieldName = stringResource(R.string.player_detail_city_field), data = "${team.city}")
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onClick = { actions.goToTeamDetail(team.id) }) {
                    Text(text = stringResource(R.string.player_detail_show_more_info_button))
                }
            }
        }
    }
}

@Preview
@Composable
private fun PlayerDetailScreenPreview() {
    PlayerDetailScreen(actions = PlayerDetailActions({}, {}))
}