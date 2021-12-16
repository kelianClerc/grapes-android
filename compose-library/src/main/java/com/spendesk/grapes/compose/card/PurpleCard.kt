package com.spendesk.grapes.compose.card

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spendesk.grapes.R
import com.spendesk.grapes.compose.SecondaryButton

private val CardPadding = 32.dp
private val TitleBodySpacing = 16.dp
private val BodyButtonSpacing = 32.dp

@Composable
fun PurpleCard(
    modifier: Modifier = Modifier,
    title: String,
    body: String,
    buttonContent: String,
    onButtonClickedListener: () -> Unit = {}
) {
    Card(
        modifier = modifier.height(IntrinsicSize.Max),
        shape = MaterialTheme.shapes.medium
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bg_bucket_deep_blue),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.padding(CardPadding).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle2,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(TitleBodySpacing))
            Text(
                text = body,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(BodyButtonSpacing))
            SecondaryButton(
                text = buttonContent,
                onClickListener = onButtonClickedListener,
                isSmall = true
            )
        }
    }
}

@Preview(group = "Purple card", name = "Purple card night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(group = "Purple card", name = "Purple card", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PurpleCardPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface)
                .padding(32.dp)
        ) {
            PurpleCard(
                title = "\uD83C\uDF81 Votre carte est en chemin !",
                body = "Vous devriez la recevoir d'ici le 14/06. Vous devriez la recevoir d'ici le 14/06. Vous devriez la recevoir d'ici le 14/06.",
                buttonContent = "J'ai reçu ma carte"
            )
        }
    }
}
