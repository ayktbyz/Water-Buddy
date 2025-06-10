package com.aytbyz.waterbuddy.domain.usecase

import com.aytbyz.waterbuddy.domain.model.WaterIntake
import com.aytbyz.waterbuddy.domain.repository.WaterRepository
import javax.inject.Inject

class GetAllWaterIntakesUseCase @Inject constructor(
    private val repository: WaterRepository
) {
    suspend operator fun invoke(): List<WaterIntake> {
        return repository.getAllIntakes()
    }
}