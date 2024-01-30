package dev.keikem.catzappWithCounter.data.api

import dev.keikem.catzappWithCounter.data.remote.RemoteDog
import retrofit2.http.GET

interface DogsApi {

    @GET("/api/breeds/image/random")
    suspend fun getDog(): RemoteDog?
}