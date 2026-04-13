package com.mj.moneytrackerapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.theme.Blue
import com.mj.moneytrackerapp.ui.theme.DarkGreen
import com.mj.moneytrackerapp.ui.theme.OceanBlue
import com.mj.moneytrackerapp.ui.utils.toCurrencyString
import com.mj.moneytrackerapp.ui.utils.toExpenseDateString
import java.time.LocalDateTime

@Composable
fun ExpenseTile(
    title: String,
    date: LocalDateTime,
    amount: Double,
    @DrawableRes
    iconRes: Int,
    iconBackgroundColor: Color = Blue
) {

    Row(
        modifier = Modifier.Companion
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Companion.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CategoryTypeIcon(iconRes = iconRes, backgroundColor = iconBackgroundColor)

        Spacer(
            modifier = Modifier.Companion.width(16.dp)
        )

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.Companion
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = title,
                color = DarkGreen,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Companion.SemiBold
            )

            Text(
                text = date.toExpenseDateString(),
                color = OceanBlue,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Companion.Bold
            )
        }

        Text(
            text = amount.toCurrencyString(),
            color = OceanBlue,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Companion.SemiBold,
        )

    }
}

