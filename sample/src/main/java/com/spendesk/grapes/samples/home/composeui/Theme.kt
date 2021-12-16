package com.spendesk.grapes.samples.home.composeui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
internal fun GrapesTheme(
    darkTheme: Boolean? = null,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = grapesColors(darkTheme),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
