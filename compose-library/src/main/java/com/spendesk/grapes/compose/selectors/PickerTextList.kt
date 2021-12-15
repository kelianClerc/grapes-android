package com.spendesk.grapes.compose.selectors

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
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

private val ItemDividerWidth = 1.dp
private val ItemDividerHeight = 24.dp

@Composable
fun PickerTextList(
    modifier: Modifier = Modifier,
    itemLabels: List<PickerItemUiModel>,
    onItemSelected: (PickerItemUiModel) -> Unit
) {
    LazyRow(
        modifier = modifier.background(
            MaterialTheme.colors.surface,
            MaterialTheme.shapes.small
        )
    ) {
        itemsIndexed(
            items = itemLabels,
            key = { _, item -> item.id }
        ) { index, item ->
            val position = when {
                index == 0 && itemLabels.size > 1 -> PickerItemPosition.START
                index == 0 && itemLabels.size == 1 -> PickerItemPosition.START_AND_END
                index == itemLabels.size - 1 -> PickerItemPosition.END
                else -> PickerItemPosition.MIDDLE
            }
            val needADivider = position == PickerItemPosition.START ||
                position == PickerItemPosition.MIDDLE

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onItemSelected(item) }
            ) {
                PickerItem(itemUiModel = item, position = position)
                if (needADivider) {
                    Box(
                        modifier = Modifier
                            .width(ItemDividerWidth)
                            .height(ItemDividerHeight)
                            .background(MaterialTheme.colors.onSurface.copy(alpha = 0.12f))
                    )
                }
            }
        }
    }
}

enum class PickerItemPosition {
    START, START_AND_END, MIDDLE, END
}

data class PickerItemUiModel(
    val id: String,
    val label: String,
    val isSelected: Boolean
)

@Composable
fun PickerItem(
    itemUiModel: PickerItemUiModel,
    position: PickerItemPosition
) {
    val shape = when (position) {
        PickerItemPosition.START -> {
            RoundedCornerShape(
                topStart = MaterialTheme.shapes.small.topStart,
                topEnd = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp),
                bottomStart = MaterialTheme.shapes.small.bottomStart
            )
        }
        PickerItemPosition.START_AND_END -> {
            RoundedCornerShape(
                topStart = MaterialTheme.shapes.small.topStart,
                topEnd = MaterialTheme.shapes.small.topEnd,
                bottomEnd = MaterialTheme.shapes.small.bottomEnd,
                bottomStart = MaterialTheme.shapes.small.bottomStart
            )
        }
        PickerItemPosition.MIDDLE -> {
            RoundedCornerShape(
                topStart = CornerSize(0.dp),
                topEnd = CornerSize(0.dp),
                bottomEnd = CornerSize(0.dp),
                bottomStart = CornerSize(0.dp)
            )
        }
        PickerItemPosition.END -> {
            RoundedCornerShape(
                topStart = CornerSize(0.dp),
                topEnd = MaterialTheme.shapes.small.topEnd,
                bottomEnd = MaterialTheme.shapes.small.bottomEnd,
                bottomStart = CornerSize(0.dp)
            )
        }
    }

    val backgroundColor = animateColorAsState(
        if (itemUiModel.isSelected) {
            MaterialTheme.colors.primary.copy(alpha = 0.12f)
        } else {
            MaterialTheme.colors.surface
        }
    ).value

    val textColor = animateColorAsState(
        if (itemUiModel.isSelected) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.onSurface
        }
    ).value

    val borderColor = animateColorAsState(
        if (itemUiModel.isSelected) {
            MaterialTheme.colors.primary
        } else {
            MaterialTheme.colors.surface.copy(alpha = 0f)
        }
    ).value

    Text(
        text = itemUiModel.label,
        modifier = Modifier
            .background(backgroundColor, shape)
            .border(2.dp, borderColor, shape)
            .padding(12.dp),
        color = textColor
    )
}

@Preview(
    group = "Picker text list",
    name = "Picker text list small night",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    group = "Picker text list",
    name = "Picker text list small",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PickerTextListSmallPreview() {
    MaterialTheme {
        var items by remember {
            mutableStateOf(
                listOf(
                    PickerItemUiModel("1", "Level 1", false),
                    PickerItemUiModel("2", "Level 2", false),
                    PickerItemUiModel("3", "Level 3", false),
                    PickerItemUiModel("4", "Level 4", true),
                )
            )
        }
        Box(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.surface.copy(alpha = 0.20f))
                .padding(32.dp)
        ) {
            PickerTextList(
                itemLabels = items,
                onItemSelected = { selectedItem ->
                    items = items.map { it.copy(isSelected = it.id == selectedItem.id) }
                }
            )
        }
    }
}

@Preview(
    group = "Picker text list",
    name = "Picker text list long night",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    group = "Picker text list",
    name = "Picker text list long",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PickerTextListLongPreview() {
    MaterialTheme {
        var items by remember {
            mutableStateOf(
                listOf(
                    PickerItemUiModel("1", "Level 1", true),
                    PickerItemUiModel("2", "Level 2", false),
                    PickerItemUiModel("3", "Level 3", false),
                    PickerItemUiModel("4", "Level 4", false),
                    PickerItemUiModel("5", "Level 5", false),
                    PickerItemUiModel("6", "Level 6", false),
                    PickerItemUiModel("7", "Level 7", false),
                    PickerItemUiModel("8", "Level 8", false)
                )
            )
        }

        Box(
            modifier = Modifier
                .width(400.dp)
                .background(MaterialTheme.colors.surface.copy(alpha = 0.20f))
                .padding(32.dp)
        ) {
            PickerTextList(
                itemLabels = items,
                onItemSelected = { selectedItem ->
                    items = items.map { it.copy(isSelected = it.id == selectedItem.id) }
                }
            )
        }
    }
}
