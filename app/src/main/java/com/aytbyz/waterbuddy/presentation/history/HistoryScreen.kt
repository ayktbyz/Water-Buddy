package com.aytbyz.waterbuddy.presentation.history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aytbyz.waterbuddy.R
import com.aytbyz.waterbuddy.utils.DateUtils

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = hiltViewModel()) {
    val historyList by viewModel.history

    LaunchedEffect(Unit) {
        viewModel.loadHistory()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.water_history_title),
            modifier = Modifier.padding(bottom = 12.dp)
        )

        if (historyList.isEmpty()) {
            Text(
                text = stringResource(id = R.string.no_water_history_message),
                modifier = Modifier.padding(top = 24.dp)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(historyList) { intake ->
                    Text(
                        text = stringResource(
                            id = R.string.water_amount_with_time,
                            intake.amount.toInt(),
                            DateUtils.formatTimestamp(intake.timestamp)
                        )
                    )
                }
            }
        }
    }
}