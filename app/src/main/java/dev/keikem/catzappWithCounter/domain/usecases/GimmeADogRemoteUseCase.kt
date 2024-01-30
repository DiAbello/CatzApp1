package dev.keikem.catzappWithCounter.domain.usecases

import dev.keikem.catzappWithCounter.data.local.entity.LocalDog
import dev.keikem.catzappWithCounter.data.repository.DogRepository

class GimmeADogRemoteUseCase {

    private val repository: DogRepository = DogRepository()

    suspend fun gimme(): String? {
        val dogUrl = repository.loadFromRemote()
        dogUrl?.let { repository.saveToLocal(LocalDog(id = "1", imageUrl = it)) }
        return dogUrl
    }
}