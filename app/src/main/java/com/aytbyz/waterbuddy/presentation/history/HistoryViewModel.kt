package com.aytbyz.waterbuddy.presentation.history

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aytbyz.waterbuddy.domain.model.WaterIntake
import com.aytbyz.waterbuddy.domain.usecase.GetAllWaterIntakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getAllWaterIntakesUseCase: GetAllWaterIntakesUseCase
) : ViewModel() {

    private val _history = mutableStateOf<List<WaterIntake>>(emptyList())
    val history: State<List<WaterIntake>> = _history

    fun loadHistory() {
        viewModelScope.launch {
            _history.value = getAllWaterIntakesUseCase()
        }
    }
}