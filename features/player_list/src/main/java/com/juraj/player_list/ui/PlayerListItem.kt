package com.juraj.player_list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.engine.DiskCacheStrategy

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PlayerListItem(
    modifier: Modifier = Modifier,
    photoUrl: String?,
    firstName: String?,
    lastName: String?,
    teamName: String?,
    position: String?,
    onItemClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth().clickable {
            onItemClick()
        }
    ) {
        GlideImage(
            modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 8.dp).size(80.dp),
            model = photoUrl,
            contentDescription = "",
            requestBuilderTransform = {
                it.diskCacheStrategy(DiskCacheStrategy.ALL)
            }
        )
        Column(
            Modifier.padding(8.dp, 8.dp, 16.dp, 8.dp)
        ) {
            Text(
                text = "$firstName $lastName",
                fontSize = 20.sp,
            )
            position?.let {
                Text(
                    text =  it,
                )
            }
            teamName?.let {
                Text(
                    text =  it,
                )
            }
        }
    }
}