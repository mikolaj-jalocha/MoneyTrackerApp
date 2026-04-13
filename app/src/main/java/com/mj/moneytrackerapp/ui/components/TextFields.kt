package com.mj.moneytrackerapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mj.moneytrackerapp.ui.theme.DarkModeGreenBar
import com.mj.moneytrackerapp.ui.theme.LettersAndIcons
import com.mj.moneytrackerapp.ui.theme.LightGreen

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
            modifier = Modifier.Companion
                .align(Alignment.Companion.Start)
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
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Companion.Normal),
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