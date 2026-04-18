package com.mj.moneytrackerapp.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.R
import com.mj.moneytrackerapp.ui.components.AppTopBar
import com.mj.moneytrackerapp.ui.components.RoundedContentColumn
import com.mj.moneytrackerapp.ui.components.ShortCashFlowSummary
import com.mj.moneytrackerapp.ui.theme.BackgroundGreen
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightGreen
import com.mj.moneytrackerapp.ui.theme.MainGreen
import com.mj.moneytrackerapp.ui.theme.OceanBlue
import com.mj.moneytrackerapp.ui.utils.applyIf
import com.mj.moneytrackerapp.ui.utils.toCurrencyString

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MainGreen)
    ) {
        Column {
            AppTopBar(title = "Good Morning")
            ShortCashFlowSummary(
                spendingPercent = 30f
            )
        }
        RoundedContentColumn(
            modifier = Modifier.align(BottomCenter)
        ) {
            HomeScreenShortSummary()

            var selectedIndex by remember { mutableIntStateOf(1) }
            val options = listOf("Daily", "Weekly", "Monthly")

            DateFilterSegmentedButtonRow(
                options = options,
                selectedIndex = selectedIndex,
                onSelectionChange = { selectedIndex = it }
            )

        }
    }
}

@Composable
private fun HomeScreenShortSummary() {
    Surface(
        color = MainGreen,
        contentColor = LettersAndIcons,
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.size(width = 350.dp, height = 180.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.Center) {
            Surface(
                shape = CircleShape,
                tonalElevation = 6.dp,
                color = MainGreen.copy(alpha = 0.95f),
                modifier = Modifier.weight(1f)
            ) {
                HomeScreenGoalProgressCircularIndicator(
                    progress = 0.12f,
                    iconId = R.drawable.ic_car
                )
            }

            VerticalDivider(
                thickness = 2.dp,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxHeight(),
                color = BackgroundGreen
            )

            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                HomeScreenSummaryRowItem(
                    title = "Revenue last week",
                    value = 4000.0,
                    iconId = R.drawable.ic_money
                )

                HorizontalDivider(
                    thickness = 2.dp,
                    color = BackgroundGreen,
                    modifier = Modifier.padding(16.dp)
                )

                HomeScreenSummaryRowItem(
                    title = "Food last week",
                    value = -120.0,
                    iconId = R.drawable.ic_food
                )

            }

        }
    }
}

@Composable
private fun HomeScreenGoalProgressCircularIndicator(
    progress: Float,
    @DrawableRes
    iconId: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 32.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(contentAlignment = Center) {
            CircularProgressIndicator(
                modifier = Modifier.size(72.dp),
                progress = { progress },
                color = OceanBlue,
                trackColor = BackgroundGreen,
                gapSize = 0.dp
            )
            Image(
                painter = painterResource(iconId),
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                colorFilter = ColorFilter.tint(LettersAndIcons)
            )
        }

        Text(
            text = "Savings\n on goals",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun HomeScreenSummaryRowItem(
    title: String,
    value: Double,
    @DrawableRes
    iconId: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            16.dp,
            alignment = CenterHorizontally
        ),
        verticalAlignment = CenterVertically
    ) {

        Image(
            painter = painterResource(iconId),
            contentDescription = null,
            modifier = Modifier.size(35.dp),
            colorFilter = ColorFilter.tint(LettersAndIcons)
        )
        Column {

            Text(
                text = title,
                color = LettersAndIcons,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = value.toCurrencyString(),
                color = if (value < 0) OceanBlue else LettersAndIcons,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
private fun DateFilterSegmentedButtonRow(
    options: List<String>,
    selectedIndex: Int,
    onSelectionChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .background(LightGreen, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp)
    ) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                shape = RoundedCornerShape(32.dp),
                colors = SegmentedButtonDefaults.colors(
                    inactiveContainerColor = LightGreen,
                    activeContainerColor = MainGreen,
                    activeContentColor = LettersAndIcons,
                    inactiveContentColor = LettersAndIcons,
                    activeBorderColor = LightGreen,
                    inactiveBorderColor = LightGreen
                ),
                icon = {},
                onClick = { onSelectionChange(index) },
                selected = index == selectedIndex,
                label = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.applyIf(selectedIndex == index) {
                            Modifier.padding(all = 4.dp)
                        }
                    )
                }
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_7
)
@Composable
fun HomeScreenPreview() {
    Scaffold { innerPadding ->
        HomeScreen(modifier = Modifier.padding(innerPadding))
    }
}
