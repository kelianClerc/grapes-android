package com.spendesk.grapes.compose.card

import androidx.compose.material.MaterialTheme
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.compositeOver

@Composable
fun primarySwitch() = SwitchDefaults.colors(
    checkedThumbColor = MaterialTheme.colors.primary,
    checkedTrackColor = MaterialTheme.colors.primary,
    uncheckedThumbColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
        .compositeOver(MaterialTheme.colors.surface)
)
