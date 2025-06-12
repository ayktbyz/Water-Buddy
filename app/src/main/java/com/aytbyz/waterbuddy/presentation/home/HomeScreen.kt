package com.aytbyz.waterbuddy.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aytbyz.waterbuddy.R

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val intakeList by viewModel.intakeList
    val totalAmount = intakeList.sumOf { it.amount }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        // Ekranın başı: Su miktarı
        Text(
            text = stringResource(R.string.water_amount_today, totalAmount.toInt()),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

        // Ortada: Su içme butonları
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { viewModel.addWater(250.00) }) {
                Text(stringResource(R.string.drink_250ml))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { viewModel.addWater(500.00) }) {
                Text(stringResource(R.string.drink_500ml))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { viewModel.addWater(750.00) }) {
                Text(stringResource(R.string.drink_750ml))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { viewModel.addWater(1000.00) }) {
                Text(stringResource(R.string.drink_1lt))
            }
        }

        Button(
            onClick = { viewModel.clearAll() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        ) {
            Text(stringResource(R.string.clear_data), color = Color.White)
        }
    }
}