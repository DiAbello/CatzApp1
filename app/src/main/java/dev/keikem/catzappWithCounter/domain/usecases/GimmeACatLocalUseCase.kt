package dev.keikem.catzappWithCounter.domain.usecases

import dev.keikem.catzappWithCounter.data.repository.CatRepository

class GimmeACatLocalUseCase {

    private val catRepository: CatRepository = CatRepository()

    fun gimme(): String? = catRepository.loadFromLocal()
}