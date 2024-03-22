package com.juraj.player_list.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.juraj.common.network.NetworkResult
import com.juraj.domain.players.GetPlayersUseCase
import com.juraj.model.players.Player
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

const val PAGE_SIZE = 35

class PlayerPagingSource(
    private val getPlayersUseCase: GetPlayersUseCase,
) : PagingSource<Int, Player>(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO

    override suspend fun load(
        params: LoadParams<Int>,
    ): LoadResult<Int, Player> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = getPlayersUseCase.getPlayers(PAGE_SIZE, nextPageNumber)

            if (response is NetworkResult.Success) {
                LoadResult.Page(
                    data = response.data.data,
                    prevKey = if (nextPageNumber == 0) null else (nextPageNumber - PAGE_SIZE).coerceAtLeast(
                        0
                    ),
                    nextKey = if (response.data.data.isEmpty()) null else response.data.meta.nextCursor,
                )
            } else {
                LoadResult.Error((response as NetworkResult.Error).error.throwable ?: Exception())
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Player>): Int? =
        state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
}
