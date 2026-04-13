package com.mj.moneytrackerapp.ui.logging

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.components.AppTopBar
import com.mj.moneytrackerapp.ui.components.CategoryTypeIcon
import com.mj.moneytrackerapp.ui.components.CategoryTypeIconSize
import com.mj.moneytrackerapp.ui.components.ShortCashFlowSummary
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen
import com.mj.moneytrackerapp.ui.theme.MainGreen

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        Column {
            AppTopBar(title = "Categories")
            ShortCashFlowSummary(
                spendingPercent = 30f
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(105.dp),
            contentPadding = PaddingValues(all = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.80f)
                .background(
                    color = BackgroundGreen,
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .padding(vertical = 24.dp)
                .align(BottomCenter),
        ) {
            items(8) {
                CategoryTypeIcon(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center),
                    iconRes = R.drawable.ic_groceries,
                    size = CategoryTypeIconSize.BIG
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    device = Devices.PIXEL_7
)
@Composable
fun CategoryScreenPreview() {
    Scaffold { innerPadding ->
        CategoryScreen(modifier = Modifier.padding(innerPadding))
    }
}