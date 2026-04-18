package com.mj.moneytrackerapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    device = Devices.PIXEL_7,
    name = "HomeScreen - Pixel 7"
)
@Composable
fun HomeScreenPreview2() {
    Scaffold { innerPadding ->
        HomeScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(
    device = Devices.PIXEL_7,
    name = "CategoryScreen - Pixel 7"
)
@Composable
fun CategoryScreenPreview2() {
    Scaffold { innerPadding ->
        CategoryScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(
    device = Devices.PIXEL_7,
    name = "LogMoneyScreen - Pixel 7"
)
@Composable
fun LogMoneyScreenPreview2() {
    Scaffold { innerPadding ->
        LogMoneyScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Preview(
    device = Devices.PIXEL_7,
    name = "SpendingSummaryScreen - Pixel 7"
)
@Composable
fun SpendingSummaryScreenPreview2() {
    Scaffold { innerPadding ->
        SpendingSummaryScreen(modifier = Modifier.padding(innerPadding))
    }
}

