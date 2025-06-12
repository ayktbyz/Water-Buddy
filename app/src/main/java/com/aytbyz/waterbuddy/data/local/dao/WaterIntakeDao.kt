package com.aytbyz.waterbuddy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aytbyz.waterbuddy.data.local.entity.WaterIntakeEntity

@Dao
interface WaterIntakeDao {
    @Insert
    suspend fun insert(intake: WaterIntakeEntity)

    @Query("SELECT * FROM water_intake WHERE date(timestamp / 1000, 'unixepoch') = date('now')")
    suspend fun getTodayIntakes(): List<WaterIntakeEntity>

    @Query("SELECT * FROM water_intake ORDER BY timestamp DESC")
    suspend fun getAllIntakes(): List<WaterIntakeEntity>

    @Query("DELETE FROM water_intake")
    suspend fun clearAll()
}
