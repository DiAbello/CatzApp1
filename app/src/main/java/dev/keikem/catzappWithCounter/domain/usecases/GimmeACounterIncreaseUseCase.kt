package dev.keikem.catzappWithCounter.domain.usecases

import dev.keikem.catzappWithCounter.data.local.entity.LocalCounter
import dev.keikem.catzappWithCounter.data.repository.CounterRepository

class GimmeACounterIncreaseUseCase {

    private val counterRepository: CounterRepository = CounterRepository()

    fun gimme(): String {
        var countNum = counterRepository.loadFromLocal()?.toIntOrNull()
        if(countNum == null) {
            counterRepository.saveToLocal(LocalCounter(id = "1", countedNumber = "1"))
            countNum = 1;
        } else {
            countNum += 1
        }
        counterRepository.saveToLocal(LocalCounter(id = "1", countedNumber = countNum.toString()))
        return countNum.toString()
    }
}