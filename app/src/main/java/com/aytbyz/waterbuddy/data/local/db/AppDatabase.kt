package com.aytbyz.waterbuddy.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aytbyz.waterbuddy.data.local.dao.WaterIntakeDao
import com.aytbyz.waterbuddy.data.local.entity.WaterIntakeEntity

@Database(entities = [WaterIntakeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun waterIntakeDao(): WaterIntakeDao
}