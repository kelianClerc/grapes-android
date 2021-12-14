package com.spendesk.grapes.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val TagBorderWidth = 0.5.dp
private val TagHorizontalPadding = 12.dp
private val TagVerticalPadding = 4.dp
private const val TagBackgroundAlpha = 0.12f

@Composable
fun WarningTag(
    modifier: Modifier = Modifier,
    content: String
) {
    SpendeskTag(modifier = modifier, content = content, color = MaterialTheme.colors.secondary)
}

@Composable
fun AlertTag(
    modifier: Modifier = Modifier,
    content: String
) {
    SpendeskTag(modifier = modifier, content = content, color = MaterialTheme.colors.error)
}

@Composable
internal fun SpendeskTag(
    modifier: Modifier = Modifier,
    content: String,
    color: Color
) {
    Text(
        text = content,
        color = color,
        modifier = modifier
            .background(color.copy(alpha = TagBackgroundAlpha), MaterialTheme.shapes.small)
            .border(TagBorderWidth, color, MaterialTheme.shapes.small)
            .padding(horizontal = TagHorizontalPadding, vertical = TagVerticalPadding)
    )
}

@Preview
@Composable
fun WarningTagPreview() {
    MaterialTheme {
        WarningTag(content = "Carte limitée")
    }
}

@Preview
@Composable
fun AlertTagPreview() {
    MaterialTheme {
        AlertTag(content = "Carte bloquée")
    }
}
