package dev.keikem.catzappWithCounter.data.repository

import dev.keikem.catzappWithCounter.DatabaseHolder
import dev.keikem.catzappWithCounter.NetworkHolder
import dev.keikem.catzappWithCounter.data.local.entity.LocalCat

class CatRepository {

    private val database = DatabaseHolder.provideDb()
    private val catsApi = NetworkHolder.provideCatApi

    suspend fun loadFromRemote(): String? = catsApi.getCat()?.get(0)?.url

    fun loadFromLocal(): String? = database?.catDao()?.get()?.imageUrl

    fun saveToLocal(cat: LocalCat) {
        database?.catDao()?.set(cat)
    }
}