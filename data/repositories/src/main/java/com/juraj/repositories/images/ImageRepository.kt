package com.juraj.repositories.images

interface ImageRepository {

    fun getImageUrlForPlayerId(playerId: Long): String
}