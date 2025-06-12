package com.aytbyz.waterbuddy.data.repository

import com.aytbyz.waterbuddy.data.local.dao.WaterIntakeDao
import com.aytbyz.waterbuddy.data.mapper.toDomain
import com.aytbyz.waterbuddy.data.mapper.toEntity
import com.aytbyz.waterbuddy.domain.model.WaterIntake
import com.aytbyz.waterbuddy.domain.repository.WaterRepository
import javax.inject.Inject

class WaterRepositoryImpl @Inject constructor(
    private val dao: WaterIntakeDao
) : WaterRepository {

    override suspend fun addWater(intake: WaterIntake) {
        dao.insert(intake.toEntity())
    }

    override suspend fun getTodayIntakes(): List<WaterIntake> {
        return dao.getTodayIntakes().map { it.toDomain() }
    }

    override suspend fun getAllIntakes(): List<WaterIntake> {
        return dao.getAllIntakes().map { it.toDomain() }
    }
}