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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.spendesk.grapes.compose.card.PlasticCard
import com.spendesk.grapes.compose.card.PlasticCardAlert
import com.spendesk.grapes.compose.card.PlasticCardWarning
import com.spendesk.grapes.compose.card.PurpleCard
import com.spendesk.grapes.samples.R
import com.spendesk.grapes.samples.home.composeui.GrapesTheme

class CardsComposeFragment : Fragment() {

    companion object {
        fun newInstance() = CardsComposeFragment()
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
                            text = stringResource(id = R.string.cardsCompose),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.primary.copy(alpha = 0.05f))
                                .padding(vertical = 48.dp, horizontal = 16.dp),
                            style = MaterialTheme.typography.h4,
                            color = MaterialTheme.colors.primary
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        PurpleCardShowcase()
                        PlasticCardShowcase()
                    }
                }
            }
        }
    }

    @Composable
    fun PurpleCardShowcase() {
        Text(text = stringResource(id = R.string.cardPurple), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        Card(
            shape = MaterialTheme.shapes.medium, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(id = R.string.cardOnTheWay), style = MaterialTheme.typography.body2)
                PurpleCard(
                    title = stringResource(id = R.string.homePushSectionOnTheWayDeepBlueBucketViewTitle),
                    body = stringResource(id = R.string.homePushSectionOnTheWayDeepBlueBucketViewDescription),
                    buttonContent = stringResource(id = R.string.homePushSectionOnTheWayDeepBlueBucketViewButtonText)
                )
                Text(text = stringResource(id = R.string.cardRecard), style = MaterialTheme.typography.body2)
                PurpleCard(
                    title = stringResource(id = R.string.homePushSectionRecardDeepBlueBucketViewTitle),
                    body = stringResource(id = R.string.homePushSectionRecardDeepBlueBucketViewDescription),
                    buttonContent = stringResource(id = R.string.homePushSectionRecardDeepBlueBucketViewButtonText)
                )
            }
        }
    }

    @Composable
    fun PlasticCardShowcase() {
        Text(text = stringResource(id = R.string.cardPlasticCard), modifier = Modifier.padding(horizontal = 16.dp), style = MaterialTheme.typography.h6)
        Card(
            shape = MaterialTheme.shapes.medium, modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = stringResource(id = R.string.cardNormal), style = MaterialTheme.typography.body2)
                PlasticCard(
                    availableAmount = stringResource(id = R.string.homePushSectionPlasticCardNormalInformativeActionBucketViewTitle),
                    descriptionText = stringResource(id = R.string.homePushSectionPlasticCardNormalInformativeActionBucketViewSubtitleText),
                    buttonText = stringResource(id = R.string.homePushSectionPlasticCardNormalInformativeActionBucketViewSmallButtonText)
                )
                Text(text = stringResource(id = R.string.cardWarning), style = MaterialTheme.typography.body2)
                PlasticCardWarning(
                    availableAmount = stringResource(id = R.string.homePushSectionPlasticCardWarningInformativeActionBucketViewTitle),
                    descriptionText = stringResource(id = R.string.homePushSectionPlasticCardWarningInformativeActionBucketViewSubtitleText),
                    buttonText = stringResource(id = R.string.homePushSectionPlasticCardWarningInformativeActionBucketViewSmallButtonText)
                )
                Text(text = stringResource(id = R.string.cardAlert), style = MaterialTheme.typography.body2)
                PlasticCardAlert(
                    availableAmount = stringResource(id = R.string.homePushSectionPlasticCardAlertInformativeActionBucketViewTitle),
                    descriptionText = stringResource(id = R.string.homePushSectionPlasticCardAlertInformativeActionBucketViewSubtitleText),
                    buttonText = stringResource(id = R.string.homePushSectionPlasticCardAlertInformativeActionBucketViewSmallButtonText)
                )
            }
        }
    }
}
