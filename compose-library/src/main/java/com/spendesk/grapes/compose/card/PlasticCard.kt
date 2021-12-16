package com.spendesk.grapes.compose.card

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spendesk.grapes.compose.button.PrimaryButton
import com.spendesk.grapes.compose.tag.AlertTag
import com.spendesk.grapes.compose.tag.WarningTag

private val SpendeskCardPadding = 16.dp

@Composable
fun PlasticCard(
    availableAmount: String,
    descriptionText: String,
    buttonText: String,
    onLoadClicked: () -> Unit = {}
) {
    SpendeskPlasticCard(
        availableAmount = availableAmount,
        subtitle = {
            Text(
                descriptionText,
                style = MaterialTheme.typography.body2
            )
        },
        endSlot = {
            PrimaryButton(text = buttonText, onClickListener = onLoadClicked, isSmall = true)
        }
    )
}

@Composable
fun PlasticCardWarning(
    availableAmount: String,
    descriptionText: String,
    buttonText: String,
    onSeeCardClicked: () -> Unit = {}
) {
    SpendeskPlasticCard(
        availableAmount = availableAmount,
        subtitle = {
            WarningTag(content = descriptionText)
        },
        endSlot = {
            PrimaryButton(text = buttonText, onClickListener = onSeeCardClicked, isSmall = true)
        }
    )
}

@Composable
fun PlasticCardAlert(
    availableAmount: String,
    descriptionText: String,
    buttonText: String,
    onSeeCardClicked: () -> Unit = {}
) {
    SpendeskPlasticCard(
        availableAmount = availableAmount,
        subtitle = {
            AlertTag(content = descriptionText)
        },
        endSlot = {
            PrimaryButton(text = buttonText, onClickListener = onSeeCardClicked, isSmall = true)
        }
    )
}

@Composable
internal fun SpendeskPlasticCard(
    modifier: Modifier = Modifier,
    availableAmount: String,
    subtitle: @Composable() () -> Unit,
    endSlot: @Composable() () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.padding(SpendeskCardPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = availableAmount,
                    style = MaterialTheme.typography.h4
                )
                subtitle()
            }
            endSlot()
        }
    }
}

@Preview(group = "Plastic card", name = "Plastic card night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Plastic card", name = "Plastic card", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlasticCardPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.primary)
                .padding(32.dp)
        ) {
            PlasticCard(availableAmount = "$54,99", "Available on your card", "Top up") {}
        }
    }
}

@Preview(group = "Plastic card warning", name = "Plastic card warning night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Plastic card warning", name = "Plastic card warning", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlasticCardWarningPreview() {
    MaterialTheme {
        PlasticCardWarning(availableAmount = "$2 424,42", descriptionText = "Carte limitée", buttonText = "Voir ma carte") {}
    }
}

@Preview(group = "Plastic card alert", name = "Plastic card alert night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Plastic card alert", name = "Plastic card alert", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PlasticCardAlertPreview() {
    MaterialTheme {
        PlasticCardAlert(availableAmount = "$54,99", descriptionText = "Carte bloquée", buttonText = "Voir ma carte") {}
    }
}
