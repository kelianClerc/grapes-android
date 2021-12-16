package com.spendesk.grapes.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Crop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val SurroundingSlotSize = 24.dp
private val ButtonHeight = 48.dp
private val SmallButtonHeight = 32.dp
private val ButtonTextSize = 16.sp
private val SmallButtonTextSize = 14.sp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    isSmall: Boolean = false,
    onClickListener: () -> Unit = {},
    startSlot: (@Composable() () -> Unit)? = null
) {
    val colors = primaryButtonColors()
    SpendeskButton(
        modifier = modifier,
        text = text,
        isEnabled = isEnabled,
        isSmall = isSmall,
        onClickListener = onClickListener,
        colors = colors,
        startSlot = startSlot
    )
}

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    isSmall: Boolean = false,
    onClickListener: () -> Unit = {},
    startSlot: (@Composable() () -> Unit)? = null
) {
    val colors = secondaryButtonColors()
    SpendeskButton(
        modifier = modifier,
        text = text,
        isEnabled = isEnabled,
        isSmall = isSmall,
        onClickListener = onClickListener,
        colors = colors,
        startSlot = startSlot
    )
}

@Composable
fun AlertButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    isSmall: Boolean = false,
    onClickListener: () -> Unit = {},
    startSlot: (@Composable() () -> Unit)? = null
) {
    val colors = alertButtonColors()
    SpendeskButton(
        modifier = modifier,
        text = text,
        isEnabled = isEnabled,
        isSmall = isSmall,
        onClickListener = onClickListener,
        colors = colors,
        startSlot = startSlot
    )
}

@Composable
fun WarningButton(
    modifier: Modifier = Modifier,
    text: String,
    isEnabled: Boolean = true,
    isSmall: Boolean = false,
    onClickListener: () -> Unit = {},
    startSlot: (@Composable() () -> Unit)? = null
) {
    val colors = warningButtonColors()
    SpendeskButton(
        modifier = modifier,
        text = text,
        isEnabled = isEnabled,
        isSmall = isSmall,
        onClickListener = onClickListener,
        colors = colors,
        startSlot = startSlot
    )
}

@Composable
internal fun SpendeskButton(
    modifier: Modifier,
    text: String,
    isEnabled: Boolean,
    isSmall: Boolean,
    onClickListener: () -> Unit,
    colors: ButtonColors,
    startSlot: (@Composable() () -> Unit)? = null,
) {
    val buttonHeight = if (isSmall) SmallButtonHeight else ButtonHeight
    val buttonTextSize = if (isSmall) SmallButtonTextSize else ButtonTextSize

    Button(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .height(buttonHeight),
        onClick = { onClickListener.invoke() },
        enabled = isEnabled,
        colors = colors,
        contentPadding = buttonContentPadding(),
        shape = MaterialTheme.shapes.small
    ) {
        if (startSlot != null) {
            Box(modifier = Modifier.size(SurroundingSlotSize)) {
                startSlot()
            }
        }
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.button,
            fontSize = buttonTextSize
        )
        if (startSlot != null) {
            Spacer(modifier = Modifier.size(SurroundingSlotSize))
        }
    }
}

@Preview(group = "Primary Button", name = "Primary button enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Primary Button", name = "Primary button enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PrimaryButtonPreview() {
    MaterialTheme {
        PrimaryButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true, isSmall = true)
    }
}

@Preview(group = "Primary Button", name = "Primary button disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Primary Button", name = "Primary button disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PrimaryButtonDisabledPreview() {
    MaterialTheme {
        PrimaryButton(text = "Click me", isEnabled = false)
    }
}

@Preview(group = "Primary Button with icon", name = "Primary button with icon enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Primary Button with icon", name = "Primary button with icon enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PrimaryButtonWithIconPreview() {
    MaterialTheme {
        PrimaryButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Primary Button with icon", name = "Primary button with icon disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Primary Button with icon", name = "Primary button with icon disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PrimaryButtonWithIconDisabledPreview() {
    MaterialTheme {
        PrimaryButton(text = "Click me", isEnabled = false) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Secondary Button", name = "Secondary button enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Secondary Button", name = "Secondary button enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SecondaryButtonPreview() {
    MaterialTheme {
        SecondaryButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true)
    }
}

@Preview(group = "Secondary Button", name = "Secondary button disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Secondary Button", name = "Secondary button disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SecondaryButtonDisabledPreview() {
    MaterialTheme {
        SecondaryButton(text = "Click me", isEnabled = false)
    }
}

@Preview(group = "Secondary Button with icon", name = "Secondary button with icon enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Secondary Button with icon", name = "Secondary button with icon enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SecondaryButtonWithIconPreview() {
    MaterialTheme {
        SecondaryButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Secondary Button with icon", name = "Secondary button with icon disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Secondary Button with icon", name = "Secondary button with icon disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SecondaryButtonWithIconDisabledPreview() {
    MaterialTheme {
        SecondaryButton(text = "Click me", isEnabled = false) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Alert Button", name = "Alert button enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Alert Button", name = "Alert button enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AlertButtonPreview() {
    MaterialTheme {
        AlertButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true)
    }
}

@Preview(group = "Alert Button", name = "Alert button disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Alert Button", name = "Alert button disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AlertButtonDisabledPreview() {
    MaterialTheme {
        AlertButton(text = "Click me", isEnabled = false)
    }
}

@Preview(group = "Alert Button with icon", name = "Alert button with icon enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Alert Button with icon", name = "Alert button with icon enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AlertButtonWithIconPreview() {
    MaterialTheme {
        AlertButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Alert Button with icon", name = "Alert button with icon disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Alert Button with icon", name = "Alert button with icon disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun AlertButtonWithIconDisabledPreview() {
    MaterialTheme {
        AlertButton(text = "Click me", isEnabled = false) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Warning Button", name = "Warning button enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Warning Button", name = "Warning button enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WarningButtonPreview() {
    MaterialTheme {
        WarningButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true)
    }
}

@Preview(group = "Warning Button", name = "Warning button disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Warning Button", name = "Warning button disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WarningButtonDisabledPreview() {
    MaterialTheme {
        WarningButton(text = "Click me", isEnabled = false)
    }
}

@Preview(group = "Warning Button with icon", name = "Warning button with icon enabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Warning Button with icon", name = "Warning button with icon enabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WarningButtonWithIconPreview() {
    MaterialTheme {
        WarningButton(modifier = Modifier.width(200.dp), text = "Click me", isEnabled = true) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}

@Preview(group = "Warning Button with icon", name = "Warning button with icon disabled night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Warning Button with icon", name = "Warning button with icon disabled", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun WarningButtonWithIconDisabledPreview() {
    MaterialTheme {
        WarningButton(text = "Click me", isEnabled = false) {
            Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
        }
    }
}
