package com.mj.moneytrackerapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.MainGreen

@Composable
fun AppFilledButton(
    title: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.Companion
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