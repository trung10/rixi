package com.ri.riix.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.ri.riix.R
import no.nordicsemi.android.common.theme.nordicTypography

@Composable
fun RiixTheme(content: @Composable () -> Unit) {
    val darkColorPalette = darkColorScheme(
        primary = colorResource(id = R.color.md_theme_primary),
        onPrimary = colorResource(id = R.color.md_theme_onPrimary),
        primaryContainer = colorResource(id = R.color.md_theme_primaryContainer),
        onPrimaryContainer = colorResource(id = R.color.md_theme_onPrimaryContainer),
        inversePrimary = colorResource(id = R.color.md_theme_primaryInverse),
        secondary = colorResource(id = R.color.md_theme_secondary),
        onSecondary = colorResource(id = R.color.md_theme_onSecondary),
        secondaryContainer = colorResource(id = R.color.md_theme_secondaryContainer),
        onSecondaryContainer = colorResource(id = R.color.md_theme_onSecondaryContainer),
        tertiary = colorResource(id = R.color.md_theme_tertiary),
        onTertiary = colorResource(id = R.color.md_theme_onTertiary),
        tertiaryContainer = colorResource(id = R.color.md_theme_tertiaryContainer),
        onTertiaryContainer = colorResource(id = R.color.md_theme_onTertiaryContainer),
        background = colorResource(id = R.color.background),
        onBackground = colorResource(id = R.color.md_theme_onBackground),
        surface = colorResource(id = R.color.md_theme_surface),
        onSurface = colorResource(id = R.color.md_theme_onSurface),
        surfaceVariant = colorResource(id = R.color.md_theme_surfaceVariant),
        onSurfaceVariant = colorResource(id = R.color.md_theme_onSurfaceVariant),
        inverseSurface = colorResource(id = R.color.md_theme_inverseSurface),
        inverseOnSurface = colorResource(id = R.color.md_theme_inverseOnSurface),
        error = colorResource(id = R.color.md_theme_error),
        onError = colorResource(id = R.color.md_theme_onError),
        errorContainer = colorResource(id = R.color.md_theme_errorContainer),
        onErrorContainer = colorResource(id = R.color.md_theme_onErrorContainer),
        outline = colorResource(id = R.color.md_theme_outline),
    )

    val lightColorPalette = lightColorScheme(
        primary = colorResource(id = R.color.md_theme_primary),
        onPrimary = colorResource(id = R.color.md_theme_onPrimary),
        primaryContainer = colorResource(id = R.color.md_theme_primaryContainer),
        onPrimaryContainer = colorResource(id = R.color.md_theme_onPrimaryContainer),
        inversePrimary = colorResource(id = R.color.md_theme_primaryInverse),
        secondary = colorResource(id = R.color.md_theme_secondary),
        onSecondary = colorResource(id = R.color.md_theme_onSecondary),
        secondaryContainer = colorResource(id = R.color.md_theme_secondaryContainer),
        onSecondaryContainer = colorResource(id = R.color.md_theme_onSecondaryContainer),
        tertiary = colorResource(id = R.color.md_theme_tertiary),
        onTertiary = colorResource(id = R.color.md_theme_onTertiary),
        tertiaryContainer = colorResource(id = R.color.md_theme_tertiaryContainer),
        onTertiaryContainer = colorResource(id = R.color.md_theme_onTertiaryContainer),
        background = colorResource(id = R.color.background),
        onBackground = colorResource(id = R.color.md_theme_onBackground),
        surface = colorResource(id = R.color.md_theme_surface),
        onSurface = colorResource(id = R.color.md_theme_onSurface),
        surfaceVariant = colorResource(id = R.color.md_theme_surfaceVariant),
        onSurfaceVariant = colorResource(id = R.color.md_theme_onSurfaceVariant),
        inverseSurface = colorResource(id = R.color.md_theme_inverseSurface),
        inverseOnSurface = colorResource(id = R.color.md_theme_inverseOnSurface),
        error = colorResource(id = R.color.md_theme_error),
        onError = colorResource(id = R.color.md_theme_onError),
        errorContainer = colorResource(id = R.color.md_theme_errorContainer),
        onErrorContainer = colorResource(id = R.color.md_theme_onErrorContainer),
        outline = colorResource(id = R.color.md_theme_outline),
    )

    val colorScheme = if (isSystemInDarkTheme()) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = nordicTypography,
    ) {
        val background = colorScheme.background

        CompositionLocalProvider(
            LocalContentColor provides contentColorFor(background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = background),
            ) {
                content()
            }
        }
    }
}
