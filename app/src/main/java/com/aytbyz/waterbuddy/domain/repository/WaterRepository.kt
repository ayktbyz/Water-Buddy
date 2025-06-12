package com.aytbyz.waterbuddy.domain.repository

import com.aytbyz.waterbuddy.domain.model.WaterIntake

interface WaterRepository {
    suspend fun addWater(intake: WaterIntake)
    suspend fun getTodayIntakes(): List<WaterIntake>
    suspend fun getAllIntakes(): List<WaterIntake>
    suspend fun clearAll()
}