package com.aytbyz.waterbuddy.domain.usecase

import com.aytbyz.waterbuddy.domain.repository.WaterRepository
import javax.inject.Inject

class GetDailyWaterIntakeUseCase @Inject constructor(
    private val repository: WaterRepository
) {
    suspend operator fun invoke(): Int {
        return repository.getTodayIntakes().sumOf { it.amountMl }
    }
}