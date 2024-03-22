package com.juraj.player_list.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.juraj.common.ui.BackButton
import com.juraj.player_list.R
import com.juraj.player_list.navigation.PlayerListActions
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlayerListRoute(actions: PlayerListActions) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        PlayerListScreen(actions = actions)
        BackButton {
            actions.navigateUp()
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlayerListScreen(actions: PlayerListActions, viewModel: PlayerListViewModel = koinViewModel()) {
    val playerList = viewModel.users.collectAsLazyPagingItems()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            contentPadding = PaddingValues(top = 80.dp)
        ) {
            items(playerList.itemCount) {
                val item = playerList[it] ?: return@items
                PlayerListItem(
                    photoUrl = item.photoUrl,
                    firstName = item.firstName,
                    lastName = item.lastName,
                    teamName = item.team?.fullName,
                    position = item.position
                ) {
                    actions.goToPlayerDetail(item.id)
                }
            }
        }
        when {
            playerList.loadState.refresh is LoadState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }

            }
            playerList.loadState.append is LoadState.Loading -> {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            playerList.loadState.append is LoadState.Error -> {
                Toast.makeText(LocalContext.current,
                    stringResource(R.string.error_contact_us), Toast.LENGTH_SHORT).show()

            }
        }
    }
}

@Preview
@Composable
private fun PlayerListScreenPreview() {
    PlayerListScreen(actions = PlayerListActions({}, {}))
}