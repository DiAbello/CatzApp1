package dev.keikem.catzappWithCounter.domain.usecases

import dev.keikem.catzappWithCounter.data.local.entity.LocalCat
import dev.keikem.catzappWithCounter.data.repository.CatRepository

class GimmeACatRemoteUseCase {

    private val catRepository: CatRepository = CatRepository()

    suspend fun gimme(): String? {
        val catUrl = catRepository.loadFromRemote()
//        catRepository.saveToLocal(LocalCat(id = "1", imageUrl = catUrl))
        catUrl?.let { catRepository.saveToLocal(LocalCat(id = "1", imageUrl = it)) }
        return catUrl
    }
}