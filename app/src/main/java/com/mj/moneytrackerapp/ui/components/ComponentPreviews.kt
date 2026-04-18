package com.mj.moneytrackerapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.theme.Blue
import java.time.LocalDateTime

@Preview(
    name = "AppTopBar - Default",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun AppTopBarPreview() {
    AppTopBar(
        title = "Screen Title",
        onBackClick = {}
    )
}

@Preview(
    name = "AppTopBar - With Back Button",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun AppTopBarWithBackPreview() {
    AppTopBar(
        title = "Details",
        onBackClick = {}
    )
}

@Preview(
    name = "AppFilledButton",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun AppFilledButtonPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppFilledButton(
            title = "Save",
            onClick = {}
        )
        AppFilledButton(
            title = "Delete",
            onClick = {}
        )
    }
}

@Preview(
    name = "CategoryTypeIcon - All Sizes",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun CategoryTypeIconAllSizesPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
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

@Preview(
    name = "CategoryTypeIcon - Different Colors",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun CategoryTypeIconColorsPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryTypeIcon(
            iconRes = R.drawable.ic_food,
            backgroundColor = Blue
        )
        CategoryTypeIcon(
            iconRes = R.drawable.ic_car,
            backgroundColor = com.mj.moneytrackerapp.ui.theme.OceanBlue
        )
        CategoryTypeIcon(
            iconRes = R.drawable.ic_money,
            backgroundColor = com.mj.moneytrackerapp.ui.theme.DarkGreen
        )
    }
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
            iconBackgroundColor = Blue
        )
        ExpenseTile(
            title = "Salary",
            date = LocalDateTime.now(),
            amount = 3000.00,
            iconRes = R.drawable.ic_income,
            iconBackgroundColor = com.mj.moneytrackerapp.ui.theme.LightBlue
        )
    }
}

@Preview(
    name = "RoundedContentColumn",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun RoundedContentColumnPreview() {
    RoundedContentColumn(
        modifier = Modifier.padding(bottom = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(3) {
                AppFilledButton(
                    title = "Item ${it + 1}",
                    onClick = {}
                )
            }
        }
    }
}

@Preview(
    name = "ShortCashFlowSummary",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun ShortCashFlowSummaryPreview() {
    ShortCashFlowSummary(
        spendingPercent = 45f
    )
}

@Preview(
    name = "LabeledOutlinedField",
    showBackground = true,
    device = Devices.PIXEL_7
)
@Composable
fun LabeledOutlinedFieldPreview() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        LabeledOutlinedField(
            value = text,
            title = "Enter Name",
            placeholder = "John Doe",
            onValueChange = { text = it }
        )

        LabeledOutlinedField(
            value = "",
            title = "Enter Description",
            minLines = 3,
            placeholder = "Type your message here..."
        )
    }
}

