package com.spendesk.grapes.compose.card

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SwitchCard(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onSwitchChanged: (Boolean) -> Unit
) {
    Card(
        modifier = modifier
            .clickable { onSwitchChanged(!isSelected) },
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, modifier = Modifier.weight(1f))
            Switch(
                checked = isSelected,
                onCheckedChange = onSwitchChanged,
                colors = primarySwitch()
            )
        }
    }
}

@Preview(
    group = "Switch card",
    name = "Switch card night",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(group = "Switch card", name = "Switch card", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun CountItemPreview() {
    MaterialTheme {
        var isSelected by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.primary)
                .padding(32.dp)
        ) {
            SwitchCard(
                text = "I AM the subtitle",
                isSelected = isSelected,
                onSwitchChanged = { isSwitched -> isSelected = isSwitched }
            )
        }
    }
}
