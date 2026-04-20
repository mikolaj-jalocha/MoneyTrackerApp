package com.mj.moneytrackerapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.components.AppTopBar
import com.mj.moneytrackerapp.ui.components.RoundedContentColumn
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen
import com.mj.moneytrackerapp.ui.theme.Blue
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightBlue
import com.mj.moneytrackerapp.ui.theme.MainGreen
import com.mj.moneytrackerapp.ui.theme.OceanBlue
import com.mj.moneytrackerapp.ui.utils.toCurrencyString
import java.time.LocalDateTime
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun TransactionScreen(modifier: Modifier = Modifier) {
    val isIncomeSelected by remember { mutableStateOf(false) }
    val isExpenseSelected by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        Column {
            AppTopBar(title = "Transaction")

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TransactionCard(
                    title = "Total Balance",
                    amount = 7787.0,
                    isWide = true,
                    modifier = Modifier.align(Start)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TransactionCard(
                        title = "Income",
                        isSelected = isIncomeSelected,
                        amount = 4287.0
                    )
                    TransactionCard(
                        title = "Expense",
                        iconRes = R.drawable.ic_expense,
                        isSelected = isExpenseSelected,
                        amount = 3506.0,
                        isExpense = true,
                    )
                }

            }
        }
        RoundedContentColumn(
            modifier = Modifier
                .align(BottomCenter)
                .fillMaxHeight(0.70f)
        ) {
            MonthlyExpensesSection(
                expenses = listOf(
                    ExpenseItem(
                        title = "Return",
                        date = LocalDateTime.now().minusDays(2),
                        amount = 26.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Groceries"
                    ),
                    ExpenseItem(
                        title = "Snacks",
                        date = LocalDateTime.now().minusDays(3),
                        amount = -7.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue,
                        description = "Food & Drink"
                    ),
                    ExpenseItem(
                        title = "Gas",
                        date = LocalDateTime.now().minusDays(5),
                        amount = -45.50,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Transportation"
                    ),
                    ExpenseItem(
                        title = "Restaurant",
                        date = LocalDateTime.now().minusDays(8),
                        amount = -32.99,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue,
                        description = "Food & Drink"
                    )
                ),
                monthName = LocalDateTime.now().month.getDisplayName(
                    TextStyle.FULL_STANDALONE,
                    Locale.getDefault()
                )
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                showCalendarIcon = true
            )

            MonthlyExpensesSection(
                expenses = listOf(
                    ExpenseItem(
                        title = "Salary",
                        date = LocalDateTime.now().minusDays(32),
                        amount = +5054.30,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Income"
                    ),
                    ExpenseItem(
                        title = "Pharmacy",
                        date = LocalDateTime.now().minusDays(35),
                        amount = -19.99,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue,
                        description = "Health & Care"
                    ),
                    ExpenseItem(
                        title = "Clothes",
                        date = LocalDateTime.now().minusDays(45),
                        amount = -67.50,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Shopping"
                    )
                ),
                monthName = LocalDateTime.now().minusMonths(1).month.getDisplayName(
                    TextStyle.FULL_STANDALONE,
                    Locale.getDefault()
                )
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                showCalendarIcon = false
            )

            MonthlyExpensesSection(
                expenses = listOf(
                    ExpenseItem(
                        title = "Grocery",
                        date = LocalDateTime.now().minusDays(62),
                        amount = -48.75,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Groceries"
                    ),
                    ExpenseItem(
                        title = "Utilities",
                        date = LocalDateTime.now().minusDays(65),
                        amount = -85.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue,
                        description = "Bills & Utilities"
                    ),
                    ExpenseItem(
                        title = "Gym",
                        date = LocalDateTime.now().minusDays(68),
                        amount = -35.00,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = Blue,
                        description = "Health & Fitness"
                    ),
                    ExpenseItem(
                        title = "Books",
                        date = LocalDateTime.now().minusDays(72),
                        amount = -42.99,
                        iconRes = R.drawable.ic_groceries,
                        iconBackgroundColor = LightBlue,
                        description = "Entertainment"
                    )
                ),
                monthName = LocalDateTime.now().minusMonths(2).month.getDisplayName(
                    TextStyle.FULL_STANDALONE,
                    Locale.getDefault()
                )
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                showCalendarIcon = false
            )

        }
    }
}

@Composable
private fun TransactionCard(
    modifier: Modifier = Modifier,
    title: String = "Income",
    amount: Double = 0.0,
    iconRes: Int = R.drawable.ic_income,
    isExpense: Boolean = false,
    isSelected: Boolean = false,
    isWide: Boolean = false
) {
    Surface(
        contentColor = if (isSelected) BackgroundGreen else LettersAndIcons,
        color = if (isSelected) OceanBlue else BackgroundGreen,
        shape = RoundedCornerShape(16.dp),
        onClick = {},
        modifier = modifier
    ) {
        Column(
            modifier = if (isWide) {
                Modifier
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .fillMaxWidth()
            } else {
                Modifier.padding(horizontal = 24.dp, vertical = 12.dp)
            },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (!isWide) {
                Icon(
                    painter = painterResource(iconRes),
                    tint = if (isSelected) BackgroundGreen else if (isExpense) OceanBlue else MainGreen,
                    contentDescription = null
                )
            }
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = amount.toCurrencyString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) BackgroundGreen else if (isExpense) OceanBlue else LettersAndIcons
            )
        }
    }
}


@Preview(
    device = Devices.PIXEL_7
)
@Composable
fun TransactionScreenPreview() {
    Scaffold { innerPadding ->
        TransactionScreen(modifier = Modifier.padding(innerPadding))
    }
}
