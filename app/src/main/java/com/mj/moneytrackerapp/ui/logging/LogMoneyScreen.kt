package com.mj.moneytrackerapp.ui.logging

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.components.AppFilledButton
import com.mj.moneytrackerapp.ui.components.AppTopBar
import com.mj.moneytrackerapp.ui.components.LabeledOutlinedField
import com.mj.moneytrackerapp.ui.components.RoundedContentColumn
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.MainGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogMoneyScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {

        AppTopBar(
            title = "Add Expense",
            modifier = Modifier.padding(top = 8.dp),
            onBackClick = {},
            containerColor = MainGreen,
            titleTextColor = LettersAndIcons,
            titleStyle = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold)
        )

        RoundedContentColumn(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            LabeledOutlinedField(
                title = "Date",
                value = "26.04.2026",
                onValueChange = {},
                placeholder = null,
                trailingIcon = Icons.Default.DateRange,
                onTrailingIconClick = {}
            )

            LabeledOutlinedField(
                value = "",
                title = "Category",
                placeholder = "Select the category",
                trailingIcon = Icons.Default.KeyboardArrowDown,
                onTrailingIconClick = {}
            )

            LabeledOutlinedField(
                value = "30,00",
                title = "Amount",
                onTrailingIconClick = {}
            )

            LabeledOutlinedField(
                value = "Cinema",
                title = "Expense Title",
                onTrailingIconClick = {}
            )

            LabeledOutlinedField(
                value = "",
                title = "Description",
                placeholder = "Enter message",
                minLines = 5,
                onTrailingIconClick = {}
            )

            AppFilledButton(
                title = "Save",
                onClick = {}
            )

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(
    device = Devices.PIXEL_7
)
@Composable
fun LogMoneyScreenPreview() {
    Scaffold { innerPadding ->
        LogMoneyScreen(modifier = Modifier.padding(innerPadding))
    }
}