package com.mj.moneytrackerapp.ui.logging

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen
import com.mj.moneytrackerapp.ui.theme.Blue
import com.mj.moneytrackerapp.ui.theme.DarkGreen
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightBlue
import com.mj.moneytrackerapp.ui.theme.LightGreen
import com.mj.moneytrackerapp.ui.theme.MainGreen
import com.mj.moneytrackerapp.ui.theme.OceanBlue
import com.mj.moneytrackerapp.ui.utils.toCurrencyString
import com.mj.moneytrackerapp.ui.utils.toExpenseDateString
import java.time.LocalDateTime

@Composable
fun SpendingSummaryScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        Column {
            AppTopBar(title = "Groceries")
            ShortSummary()
        }
        RoundedContentColumn(
            modifier = Modifier.align(BottomCenter)
        ) {

            MonthlyExpensesSection(
                monthName = "Kwiecień",
                expenses = listOf(
                    ExpenseItem(
                        title = "Grocery",
                        date = LocalDateTime.now().minusDays(2),
                        amount = 26.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue
                    ),
                    ExpenseItem(
                        title = "Snacks",
                        date = LocalDateTime.now().minusDays(3),
                        amount = 7.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue
                    )
                ),
                showCalendarIcon = true
            )

            MonthlyExpensesSection(
                monthName = "Marzec",
                expenses = listOf(
                    ExpenseItem(
                        title = "Grocery",
                        date = LocalDateTime.now().minusDays(2),
                        amount = 26.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue
                    ),
                    ExpenseItem(
                        title = "Snacks",
                        date = LocalDateTime.now().minusDays(3),
                        amount = 7.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue
                    )
                ),
                showCalendarIcon = false
            )

            AppFilledButton(
                title = "Add expenses",
                onClick = {}
            )

        }
    }
}

@Composable
private fun ExpenseTile(
    title: String,
    date: LocalDateTime,
    amount: Double,
    @DrawableRes
    iconRes: Int,
    iconBackgroundColor: Color = Blue
) {

    Row(
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(22.dp))
                .size(width = 57.dp, height = 53.dp)
                .background(iconBackgroundColor),
            contentAlignment = Center
        ) {
            Icon(
                painter = painterResource(iconRes),
                contentDescription = null,
                tint = BackgroundGreen,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            Text(
                text = title,
                color = DarkGreen,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = date.toExpenseDateString(),
                color = OceanBlue,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold
            )

        }

        Text(
            text = amount.toCurrencyString(),
            color = OceanBlue,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
        )

    }
}

@Composable
private fun ShortSummary() {
    Row(
        modifier = Modifier
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
            modifier = Modifier
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
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}

// New: model for an expense item
private data class ExpenseItem(
    val title: String,
    val date: LocalDateTime,
    val amount: Double,
    @DrawableRes val iconRes: Int,
    val iconBackgroundColor: Color = Blue
)

// New: optional calendar icon extracted as composable
@Composable
private fun CalendarIcon(onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.DateRange,
            contentDescription = null,
            tint = LettersAndIcons,
        )
    }
}

// Zmieniono: MonthlyExpensesSection używa LazyColumn i ma modifier jako pierwszy parametr
@Composable
private fun MonthlyExpensesSection(
    modifier: Modifier = Modifier,
    monthName: String,
    expenses: List<ExpenseItem>,
    showCalendarIcon: Boolean = true
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = monthName, style = MaterialTheme.typography.titleSmall)
                if (showCalendarIcon) {
                    CalendarIcon(onClick = {})
                }
            }
        }

        items(expenses) { item ->
            ExpenseTile(
                title = item.title,
                date = item.date,
                amount = item.amount,
                iconRes = item.iconRes,
                iconBackgroundColor = item.iconBackgroundColor
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    device = Devices.PIXEL_7
)
@Composable
fun SpendingSummaryScreenPreview() {
    Scaffold { innerPadding ->
        SpendingSummaryScreen(modifier = Modifier.padding(innerPadding))
    }
}