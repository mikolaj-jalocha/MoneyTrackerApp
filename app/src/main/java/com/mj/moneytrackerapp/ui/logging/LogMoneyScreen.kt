package com.mj.moneytrackerapp.ui.logging

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.theme.DarkModeGreenBar
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightGreen
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

@Composable
fun AppFilledButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MainGreen,
            contentColor = LettersAndIcons

        ),
        onClick = onClick
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    containerColor: Color = MainGreen,
    titleTextColor: Color = LettersAndIcons,
    titleStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.titleLarge.copy(
        fontWeight = FontWeight.SemiBold
    )
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                color = titleTextColor,
                style = titleStyle
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = containerColor
        )
    )
}

@Composable
fun LabeledOutlinedField(
    value: String,
    title: String,
    modifier: Modifier = Modifier,
    minLines: Int = 1,
    onValueChange: (String) -> Unit = {},
    placeholder: String? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClick: (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .align(Start)
                .padding(start = 6.dp)
        )

        OutlinedTextField(
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = LightGreen,
                unfocusedContainerColor = LightGreen,
                focusedLabelColor = LettersAndIcons,
                unfocusedLabelColor = LettersAndIcons,
                focusedTextColor = LettersAndIcons,
                unfocusedTextColor = LettersAndIcons,
                focusedBorderColor = LightGreen,
                unfocusedBorderColor = LightGreen
            ),
            textStyle = MaterialTheme.typography.titleSmall,
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(18.dp),
            placeholder = if (placeholder != null) {
                {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Normal),
                        color = DarkModeGreenBar
                    )
                }
            } else null,
            trailingIcon = if (trailingIcon != null) {
                {
                    IconButton(onClick = onTrailingIconClick ?: {}) {
                        Icon(
                            imageVector = trailingIcon,
                            contentDescription = null,
                            tint = LettersAndIcons
                        )
                    }
                }
            } else null,
            minLines = minLines
        )
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