package com.juraj.basketplayers

import android.app.Application
import com.juraj.api.networkModule
import com.juraj.domain.domainModule
import com.juraj.home.homeModule
import com.juraj.player_detail.playerDetailModule
import com.juraj.player_list.playerListModule
import com.juraj.repositories.repositoriesModule
import com.juraj.team_detail.teamDetailModule
import com.juraj.team_list.teamListModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class BasketballApplication : Application() {

    private val appModule = module {
        includes(networkModule, repositoriesModule, domainModule)
        includes(
            homeModule,
            playerListModule,
            playerDetailModule,
            teamListModule,
            teamDetailModule
        )
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BasketballApplication)
            androidLogger()
            modules(appModule)
        }
    }
}