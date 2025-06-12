package com.aytbyz.waterbuddy.data.mapper

import com.aytbyz.waterbuddy.data.local.entity.WaterIntakeEntity
import com.aytbyz.waterbuddy.domain.model.WaterIntake

fun WaterIntakeEntity.toDomain(): WaterIntake =
    WaterIntake(
        id = this.id,
        amount = this.amount,
        timestamp = this.timestamp
    )

fun WaterIntake.toEntity(): WaterIntakeEntity =
    WaterIntakeEntity(id = id, amount = amount, timestamp = timestamp)