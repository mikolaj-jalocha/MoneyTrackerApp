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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.theme.Blue
import com.mj.moneytrackerapp.ui.theme.DarkGreen
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightBlue
import com.mj.moneytrackerapp.ui.theme.MainGreen
import com.mj.moneytrackerapp.ui.theme.OceanBlue
import com.mj.moneytrackerapp.ui.utils.toCurrencyString
import com.mj.moneytrackerapp.ui.utils.toExpenseDateString
import java.time.LocalDateTime

@Composable
fun ExpenseTile(
    title: String,
    date: LocalDateTime,
    amount: Double,
    description: String? = null,
    @DrawableRes
    iconRes: Int,
    iconBackgroundColor: Color = Blue
) {
    Row(
        modifier = Modifier.Companion
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Companion.CenterVertically,
    ) {
        CategoryTypeIcon(iconRes = iconRes, backgroundColor = iconBackgroundColor)

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp)
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

        if (description != null) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ExpenseTileDivider()
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                ExpenseTileDivider()
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }

        Text(
            text = amount.toCurrencyString(),
            color = if (amount < 0) OceanBlue else LettersAndIcons,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Companion.SemiBold,
        )

    }
}

@Composable
private fun ExpenseTileDivider() {
    VerticalDivider(
        thickness = 1.dp,
        color = MainGreen,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Preview(
    name = "ExpenseTile",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun ExpenseTilePreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ExpenseTile(
            title = "Groceries",
            date = LocalDateTime.now(),
            amount = -50.99,
            iconRes = R.drawable.ic_food,
            iconBackgroundColor = Blue,
        )
        ExpenseTile(
            title = "Salary",
            date = LocalDateTime.now(),
            amount = 3000.00,
            iconRes = R.drawable.ic_income,
            iconBackgroundColor = LightBlue
        )
        ExpenseTile(
            title = "Transport",
            date = LocalDateTime.now(),
            amount = -200.00,
            iconRes = R.drawable.ic_income,
            iconBackgroundColor = LightBlue,
            description = "Fuel"
        )
    }
}

