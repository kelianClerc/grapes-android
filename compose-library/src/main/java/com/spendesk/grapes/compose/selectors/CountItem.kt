package com.spendesk.grapes.compose.selectors

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountItem(
    modifier: Modifier = Modifier,
    amount: Int,
    maxAmount: Int,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        repeat(maxAmount) { index ->
            Item(isSelected = index < amount)
        }
    }
}

@Composable
private fun RowScope.Item(
    isSelected: Boolean
) {
    val animatedColor = animateColorAsState(
        if (isSelected) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.primary.copy(alpha = 0.12f)
        }
    ).value

    Box(
        modifier = Modifier
            .height(16.dp)
            .weight(1f)
            .background(animatedColor)
    )
}

@Preview(group = "Count item", name = "Count item night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Count item", name = "Count item", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun CountItemPreview() {
    MaterialTheme {
        var selectItem by remember { mutableStateOf(1) }
        val maxAmount = 5
        Box(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.surface)
                .clickable { selectItem = (selectItem % maxAmount) + 1 }
                .padding(32.dp)
        ) {
            CountItem(amount = selectItem, maxAmount = maxAmount)
        }
    }
}
