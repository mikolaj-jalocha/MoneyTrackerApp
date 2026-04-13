package com.mj.moneytrackerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen

@Composable
fun RoundedContentColumn(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.80f)
            .background(
                color = BackgroundGreen,
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
            )
            .padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.Companion.Top),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        content = content
    )
}