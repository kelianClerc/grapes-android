package com.spendesk.grapes.samples.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Crop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.spendesk.grapes.compose.button.AlertButton
import com.spendesk.grapes.compose.button.PrimaryButton
import com.spendesk.grapes.compose.button.SecondaryButton
import com.spendesk.grapes.compose.button.WarningButton
import com.spendesk.grapes.samples.R
import com.spendesk.grapes.samples.home.composeui.GrapesTheme

class ButtonsComposeFragment : Fragment() {

    companion object {
        fun newInstance() = ButtonsComposeFragment()
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
                            text = stringResource(id = R.string.buttonsCompose),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.primary.copy(alpha = 0.05f))
                                .padding(vertical = 48.dp, horizontal = 16.dp),
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.primary
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        PrimaryButtonShowcase()
                        SecondaryButtonShowcase()
                        AlertButtonShowcase()
                        WarningButtonShowcase()
                    }
                }
            }
        }
    }

    @Composable
    private fun PrimaryButtonShowcase() {
        Text(text = stringResource(id = R.string.buttonPrimary), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                PrimaryButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth())
            },
            disabledComposable = {
                PrimaryButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth())
            }
        )
        Text(text = stringResource(id = R.string.buttonPrimaryWithIcon), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                PrimaryButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
                }
            },
            disabledComposable = {
                PrimaryButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
                }
            }
        )
    }

    @Composable
    private fun SecondaryButtonShowcase() {
        Text(text = stringResource(id = R.string.buttonSecondary), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                SecondaryButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth())
            },
            disabledComposable = {
                SecondaryButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth())
            }
        )
        Text(text = stringResource(id = R.string.buttonSecondaryWithIcon), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                SecondaryButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
                }
            },
            disabledComposable = {
                SecondaryButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth()) {
                    Icon(imageVector = Icons.Default.Crop, contentDescription = "Crop")
                }
            }
        )
    }

    @Composable
    private fun AlertButtonShowcase() {
        Text(text = stringResource(id = R.string.buttonAlert), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                AlertButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth())
            },
            disabledComposable = {
                AlertButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth())
            }
        )
    }

    @Composable
    private fun WarningButtonShowcase() {
        Text(text = stringResource(id = R.string.buttonWarning), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        ButtonShowcase(
            enabledComposable = {
                WarningButton(text = stringResource(id = R.string.stubButton), isEnabled = true, modifier = Modifier.fillMaxWidth())
            },
            disabledComposable = {
                WarningButton(text = stringResource(id = R.string.stubButton), isEnabled = false, modifier = Modifier.fillMaxWidth())
            }
        )
    }


    @Composable
    private fun ButtonShowcase(enabledComposable: @Composable() () -> Unit, disabledComposable: @Composable() () -> Unit) {
        Card(
            shape = MaterialTheme.shapes.medium, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(id = R.string.buttonNormal), style = MaterialTheme.typography.body2)
                enabledComposable()
                Text(text = stringResource(id = R.string.buttonDisabled), style = MaterialTheme.typography.body2)
                disabledComposable()
            }
        }
    }
}
