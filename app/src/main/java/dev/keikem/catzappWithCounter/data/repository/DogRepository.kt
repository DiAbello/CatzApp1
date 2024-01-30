package dev.keikem.catzappWithCounter.data.repository

import dev.keikem.catzappWithCounter.DatabaseHolder
import dev.keikem.catzappWithCounter.NetworkHolder
import dev.keikem.catzappWithCounter.data.api.DogsApi
import dev.keikem.catzappWithCounter.data.local.Database
import dev.keikem.catzappWithCounter.data.local.entity.LocalDog

class DogRepository {

    private val database: Database? = DatabaseHolder.provideDb()
    private val dogsApi: DogsApi = NetworkHolder.provideDogApi

    suspend fun loadFromRemote(): String? = dogsApi.getDog()?.message

    fun loadFromLocal(): String? = database?.dogDao()?.get()?.imageUrl

    fun saveToLocal(dog: LocalDog) {
        database?.dogDao()?.set(dog)
    }
}