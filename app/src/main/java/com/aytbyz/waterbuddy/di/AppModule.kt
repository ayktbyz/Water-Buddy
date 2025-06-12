package com.aytbyz.waterbuddy.di

import android.content.Context
import androidx.room.Room
import com.aytbyz.waterbuddy.data.local.dao.WaterIntakeDao
import com.aytbyz.waterbuddy.data.local.db.AppDatabase
import com.aytbyz.waterbuddy.data.repository.WaterRepositoryImpl
import com.aytbyz.waterbuddy.domain.repository.WaterRepository
import com.aytbyz.waterbuddy.domain.usecase.AddWaterUseCase
import com.aytbyz.waterbuddy.domain.usecase.GetAllWaterIntakesUseCase
import com.aytbyz.waterbuddy.domain.usecase.GetDailyWaterIntakeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "water_db").build()

    @Provides
    fun provideWaterDao(db: AppDatabase): WaterIntakeDao = db.waterIntakeDao()

    @Provides
    fun provideRepository(dao: WaterIntakeDao): WaterRepository = WaterRepositoryImpl(dao)

    @Provides
    fun provideAddWaterUseCase(repository: WaterRepository): AddWaterUseCase =
        AddWaterUseCase(repository)

    @Provides
    fun provideGetAllWaterIntakesUseCase(repository: WaterRepository): GetAllWaterIntakesUseCase =
        GetAllWaterIntakesUseCase(repository)

    @Provides
    fun provideGetDailyWaterIntakeUseCase(repository: WaterRepository): GetDailyWaterIntakeUseCase =
        GetDailyWaterIntakeUseCase(repository)
}