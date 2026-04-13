package com.mj.moneytrackerapp.ui.utils

import androidx.compose.ui.Modifier

inline fun Modifier.applyIf(
    condition: Boolean,
    builder: Modifier.() -> Modifier
): Modifier =
    if (condition) {
        then(builder(Modifier))
    } else {
        this
    }

inline fun <T> Modifier.applyIfNotNull(
    condition: T?,
    builder: Modifier.(T) -> Modifier
): Modifier =
    if (condition != null) {
        then(builder(Modifier, condition))
    } else {
        this
    }
