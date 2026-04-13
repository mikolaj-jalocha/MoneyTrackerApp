package com.mj.moneytrackerapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen
import com.mj.moneytrackerapp.ui.theme.Blue
import com.mj.moneytrackerapp.ui.utils.applyIf
import com.mj.moneytrackerapp.ui.utils.applyIfNotNull

enum class CategoryTypeIconSize {
    SMALL,
    BIG
}

@Composable
fun CategoryTypeIcon(
    iconRes: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Blue,
    size: CategoryTypeIconSize = CategoryTypeIconSize.SMALL,
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(if (size == CategoryTypeIconSize.BIG) 30.dp else 22.dp))
            .applyIf(
                size == CategoryTypeIconSize.SMALL
            ) { Modifier.size(width = 57.dp, height = 53.dp) }
            .applyIf(
                size == CategoryTypeIconSize.BIG
            ) {
                Modifier.size(width = 105.dp, height = 98.dp)
            }
            .applyIfNotNull(onClick) {
                Modifier.clickable {
                    onClick?.invoke()
                }
            }
            .background(backgroundColor),
        contentAlignment = Alignment.Companion.Center
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = BackgroundGreen,
            modifier = Modifier.size(if (size == CategoryTypeIconSize.BIG) 53.dp else 32.dp)
        )
    }
}

@Preview(name = "CategoryTypeIcon - SMALL & BIG", showBackground = true, device = Devices.PIXEL_7)
@Composable
fun CategoryTypeIconPreview() {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CategoryTypeIcon(
            iconRes = R.drawable.ic_groceries,
            size = CategoryTypeIconSize.SMALL
        )
        CategoryTypeIcon(
            iconRes = R.drawable.ic_groceries,
            size = CategoryTypeIconSize.BIG
        )
    }
}