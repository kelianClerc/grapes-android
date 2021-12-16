package com.spendesk.grapes.compose.button

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun primaryButtonColors() = ButtonDefaults.buttonColors(
    backgroundColor = MaterialTheme.colors.primary,
    contentColor = MaterialTheme.colors.onPrimary,
)

@Composable
fun secondaryButtonColors() = ButtonDefaults.buttonColors(
    backgroundColor = MaterialTheme.colors.surface,
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun alertButtonColors() = ButtonDefaults.buttonColors(
    backgroundColor = MaterialTheme.colors.error,
    contentColor = MaterialTheme.colors.onError,
)

@Composable
fun warningButtonColors() = ButtonDefaults.buttonColors(
    backgroundColor = MaterialTheme.colors.secondary,
    contentColor = MaterialTheme.colors.onSecondary,
)
