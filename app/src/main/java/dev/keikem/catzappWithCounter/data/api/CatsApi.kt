package dev.keikem.catzappWithCounter.data.api

import dev.keikem.catzappWithCounter.data.remote.RemoteCat
import retrofit2.http.GET

interface CatsApi {

    @GET("/v1/images/search")
    suspend fun getCat(): List<RemoteCat>?
}