package com.spendesk.grapes.samples.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.spendesk.grapes.compose.card.SwitchCard
import com.spendesk.grapes.compose.selectors.CountItem
import com.spendesk.grapes.compose.selectors.PickerItemUiModel
import com.spendesk.grapes.compose.selectors.PickerTextList
import com.spendesk.grapes.samples.R
import com.spendesk.grapes.samples.home.composeui.GrapesTheme

class SelectorComposeFragment : Fragment() {

    companion object {
        fun newInstance() = SelectorComposeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                GrapesTheme {
                    val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colors.onSurface.copy(alpha = 0.02f))
                            .fillMaxHeight()
                            .verticalScroll(scrollState)
                    ) {
                        Text(
                            text = stringResource(id = R.string.selectorsCompose),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.primary.copy(alpha = 0.05f))
                                .padding(vertical = 48.dp, horizontal = 16.dp),
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.primary
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        PickerCardsListShowcase()
                        PickerTextListsShowcase()
                        SwitchCardShowcase()
                    }
                }
            }
        }
    }

    @Composable
    private fun PickerCardsListShowcase() {
        var additionalAmount by remember { mutableStateOf(0) }
        val maxAmount = 5
        val firstAmount = (1 + additionalAmount) % (maxAmount + 1)
        val secondAmount = (3 + additionalAmount) % (maxAmount + 1)
        val thirdAmount = (5 + additionalAmount) % (maxAmount + 1)
        Text(text = stringResource(id = R.string.selectorsPickerCardsListView), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        Card(
            shape = MaterialTheme.shapes.medium, modifier = Modifier
                .padding(16.dp)
                .clip(MaterialTheme.shapes.medium)
                .clickable { additionalAmount++ }
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(id = R.string.selectorsHeaderStatusIndicatorFirst), style = MaterialTheme.typography.body2)
                CountItem(amount = firstAmount, maxAmount = maxAmount)
                Text(text = stringResource(id = R.string.selectorsHeaderStatusIndicatorSecond), style = MaterialTheme.typography.body2)
                CountItem(amount = secondAmount, maxAmount = maxAmount)
                Text(text = stringResource(id = R.string.selectorsHeaderStatusIndicatorThird), style = MaterialTheme.typography.body2)
                CountItem(amount = thirdAmount, maxAmount = maxAmount)
            }
        }
    }

    @Composable
    private fun PickerTextListsShowcase() {
        var items by remember {
            mutableStateOf(
                listOf(
                    PickerItemUiModel("1", "Level 1", false),
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

        Text(text = stringResource(id = R.string.selectorsPickerTextListView), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        PickerTextList(
            modifier = Modifier.padding(16.dp),
            itemLabels = items,
            onItemSelected = { selectedItem ->
                items = items.map { it.copy(isSelected = it.id == selectedItem.id) }
            }
        )
    }

    @Composable
    private fun SwitchCardShowcase() {
        var isSelected by remember { mutableStateOf(false) }
        Text(text = stringResource(id = R.string.selectorsSwitchCardView), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        SwitchCard(
            modifier = Modifier.padding(16.dp),
            text = "I AM the subtitle",
            isSelected = isSelected,
            onSwitchChanged = { isSwitched -> isSelected = isSwitched }
        )
    }
}
