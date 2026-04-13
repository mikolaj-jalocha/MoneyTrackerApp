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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightGreen
import com.mj.moneytrackerapp.ui.utils.toCurrencyString

@Composable
fun ShortCashFlowSummary(
    spendingPercent: Float
) {
    Column(
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TotalBalance(
                amount = 1337.00,
                iconRes = R.drawable.ic_income,
                title = "Total balance"
            )

            VerticalDivider(
                thickness = 2.dp,
                modifier = Modifier.Companion
                    .padding(vertical = 2.dp)
                    .fillMaxHeight(),
                color = LightGreen
            )

            TotalBalance(
                amount = 1337.00,
                iconRes = R.drawable.ic_expense,
                title = "Total expenses"
            )
        }
        Spacer(Modifier.Companion.height(16.dp))
        Text(
            text = "Spendings cover $spendingPercent% of your income",
            style = MaterialTheme.typography.bodyMedium
        )

    }
}

@Composable
private fun TotalBalance(
    amount: Double,
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes iconRes: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Start
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = LettersAndIcons
            )
            Spacer(Modifier.width(4.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold
            )
        }

        Text(
            text = amount.toCurrencyString(),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold),
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}