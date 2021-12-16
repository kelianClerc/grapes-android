package com.spendesk.grapes.samples.home.composeui

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val white = Color(0xFFFFFFFF)

private val purpleHeart = Color(0xFF5D21D2)
private val daisyBush = Color(0xFF421896)

private val grenadier = Color(0xFFD12D00)
private val totemPole = Color(0xFF9E2208)

private val gunPowder = Color(0xFF48465E)

// TODO figure out a better way for this. Create a custom theme ?
private val warningColorLight = Color(0xFFA85D00)
private val warningColorDark = Color(0xFF7F4608)
private val onWarningColorLight = white
private val onWarningColorDark = white

@SuppressLint("ConflictingOnColor")
internal val grapesLightColors = lightColors(
    primary = purpleHeart,
    onPrimary = white,
    primaryVariant = purpleHeart,
    secondary = white,
    secondaryVariant = white,
    onSecondary = gunPowder,
    surface = white,
    onSurface = gunPowder,
    background = white,
    onBackground = gunPowder,
    error = grenadier,
    onError = white
)

internal val grapesDarkColors = darkColors(
    primary = daisyBush,
    onPrimary = white,
    primaryVariant = daisyBush,
    secondary = gunPowder,
    secondaryVariant = gunPowder,
    onSecondary = white,
    surface = gunPowder,
    onSurface = white,
    background = gunPowder,
    onBackground = white,
    error = totemPole,
    onError = white
)

internal val Colors.warning: Color
    get() = if (isLight) warningColorLight else warningColorDark

internal val Colors.onWarning: Color
    get() = if (isLight) onWarningColorLight else onWarningColorDark

@Composable
internal fun grapesColors(darkModeOverride: Boolean? = null): Colors =
    getGrapesColors(darkModeOverride ?: isSystemInDarkTheme())

internal fun getGrapesColors(darkMode: Boolean = false): Colors =
    if (darkMode) grapesDarkColors else grapesLightColors
