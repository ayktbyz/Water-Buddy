package com.aytbyz.waterbuddy.domain.usecase

import com.aytbyz.waterbuddy.domain.model.WaterIntake
import com.aytbyz.waterbuddy.domain.repository.WaterRepository
import javax.inject.Inject

class AddWaterUseCase @Inject constructor(
    private val repository: WaterRepository
) {
    suspend operator fun invoke(amount: Double) {
        val intake = WaterIntake(
            amount = amount,
            timestamp = System.currentTimeMillis()
        )
        repository.addWater(intake)
    }
}