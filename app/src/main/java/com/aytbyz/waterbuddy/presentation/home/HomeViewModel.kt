package com.aytbyz.waterbuddy.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aytbyz.waterbuddy.domain.model.WaterIntake
import com.aytbyz.waterbuddy.domain.usecase.AddWaterUseCase
import com.aytbyz.waterbuddy.domain.usecase.GetAllWaterIntakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import com.aytbyz.waterbuddy.domain.usecase.ClearAllWaterIntakesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val addWaterUseCase: AddWaterUseCase,
    private val getDailyWaterIntakeUseCase: GetAllWaterIntakesUseCase,
    private val clearAllUseCase: ClearAllWaterIntakesUseCase
) : ViewModel() {

    private val _intakeList = mutableStateOf<List<WaterIntake>>(emptyList())
    val intakeList: State<List<WaterIntake>> = _intakeList

    init {
        loadTodayIntakes()
    }

    fun addWater(amount: Double) {
        viewModelScope.launch {
            addWaterUseCase(amount = amount)
            loadTodayIntakes()
        }
    }

    private fun loadTodayIntakes() {
        viewModelScope.launch {
            _intakeList.value = getDailyWaterIntakeUseCase()
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            clearAllUseCase()
            loadTodayIntakes()
        }
    }
}