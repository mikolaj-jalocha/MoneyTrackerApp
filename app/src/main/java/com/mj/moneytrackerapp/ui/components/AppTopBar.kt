package com.mj.moneytrackerapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.MainGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    modifier: Modifier = Modifier.Companion,
    onBackClick: () -> Unit = {},
    containerColor: Color = MainGreen,
    titleTextColor: Color = LettersAndIcons,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge.copy(
        fontWeight = FontWeight.Companion.SemiBold
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
                    tint = Color.Companion.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = containerColor
        )
    )
}