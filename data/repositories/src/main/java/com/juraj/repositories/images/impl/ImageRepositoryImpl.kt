package com.juraj.repositories.images.impl

import com.juraj.repositories.images.ImageRepository

//TODO implement some image api
class ImageRepositoryImpl: ImageRepository {

    override fun getImageUrlForPlayerId(playerId: Long): String {
        return "${BASE_URL}?random=$playerId"
    }

    companion object {
        private const val BASE_URL = "https://picsum.photos/200"
    }
}