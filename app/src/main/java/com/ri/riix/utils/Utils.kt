package com.ri.riix.utils

import android.content.res.Resources
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.ri.riix.model.COMMAND
import com.ri.riix.model.DEVICE_STATE
import java.util.UUID

fun String.toUUID(): UUID = UUID.fromString(this)

fun Int.toTime(): String {
    val minutes = this / 60
    val seconds = this - minutes * 60
    return if (minutes > 0)
    "${if (minutes.toString().length < 2) "0$minutes" else minutes}:${if (seconds.toString().length < 2) "0$seconds" else seconds}"
    else "$seconds"
}

fun COMMAND.toCommand() = "*${this}#"

fun DEVICE_STATE.toState() = "*${this}#"

/**
 * This extension method converts a double value set as percentage of device width to Dp object
 * @example (0.1.dw) 10% of the device width
 */
inline val Double.dw: Dp
    get() = Resources.getSystem().displayMetrics.let {
        Dp(value = ((this * it.widthPixels) / it.density).toFloat())
    }

inline val Int.dw: Dp get() = this.toDouble().dw
inline val Float.dw: Dp get() = this.toDouble().dw

/**
 * This extension method converts a double value set as percentage of device height to Dp object
 * @example (0.1.dh) 10% of the device height
 */
inline val Double.dh: Dp
    get() = Resources.getSystem().displayMetrics.let {
        Dp(value = ((this * it.heightPixels) / it.density).toFloat())
    }
inline val Int.dh: Dp get() = this.toDouble().dh
inline val Float.dh: Dp get() = this.toDouble().dh

/**
 * This extension method converts a double value set as percentage of device width to TextUnit object
 * @example (0.1.sw) 10% of the device width
 */
@OptIn(ExperimentalUnitApi::class)
inline val Double.sw: TextUnit
    get() = Resources.getSystem().displayMetrics.let {
        TextUnit(((this * it.widthPixels) / it.scaledDensity).toFloat(), TextUnitType.Sp)
    }
inline val Int.sw: TextUnit get() = this.toDouble().sw
inline val Float.sw: TextUnit get() = this.toDouble().sw

/**
 * This extension method converts a double value set as percentage of device width to TextUnit object
 * @example (0.1.sh) 10% of the device height
 */
@OptIn(ExperimentalUnitApi::class)
inline val Double.sh: TextUnit
    get() = Resources.getSystem().displayMetrics.let {
        TextUnit(((this * it.heightPixels) / it.scaledDensity).toFloat(), TextUnitType.Sp)
    }
inline val Int.sh: TextUnit get() = this.toDouble().sh
inline val Float.sh: TextUnit get() = this.toDouble().sh

/**
 * Method that converts HEX string to Color object
 * @param hex string in format "#RRGGBB" or "#AARRGGBB"
 */
fun Color(hex: String = "#000000"): Color {
    val colorInt = android.graphics.Color.parseColor(hex)
    return Color(colorInt)
}