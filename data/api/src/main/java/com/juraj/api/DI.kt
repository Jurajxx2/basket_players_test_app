package com.juraj.api

import com.juraj.api.players.PlayersApi
import com.juraj.api.teams.TeamsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .addInterceptor {

            val newRequest = it.request().newBuilder()
                .addHeader("Authorization", BuildConfig.BASKETBALL_API_KEY)
                .build()
            it.proceed(newRequest)
        }
        .build()
}


fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.balldontlie.io/v1/")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

fun providePlayersService(retrofit: Retrofit): PlayersApi =
    retrofit.create(PlayersApi::class.java)

fun provideTeamsService(retrofit: Retrofit): TeamsApi =
    retrofit.create(TeamsApi::class.java)


val networkModule= module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(),get()) }
    single { providePlayersService(get()) }
    single { provideTeamsService(get()) }
}