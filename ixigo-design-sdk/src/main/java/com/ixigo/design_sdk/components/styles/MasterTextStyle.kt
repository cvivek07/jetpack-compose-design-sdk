package com.ixigo.design_sdk.components.styles

import androidx.annotation.ColorRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.R

val IxiFamily = FontFamily(
    Font(R.font.ixitype_light, FontWeight.Light),
    Font(R.font.ixitype_regular, FontWeight.Normal),
    Font(R.font.ixitype_regular, FontWeight.SemiBold),
    Font(R.font.ixitype_bold, FontWeight.Bold),
    Font(R.font.ixitype_medium_italic, FontWeight.Medium, FontStyle.Italic)
)

data class ComponentTextStyle(
    @ColorRes val textColor: Int,
    val fontSize: TextUnit,
    val fontFamily: FontFamily,
    val fontWeight: FontWeight,
    val fontStyle: FontStyle,
    val letterSpacing: TextUnit,
    @ColorRes val bgColor: Int,
    val textDecoration: TextDecoration
) {
    @Composable
    fun toTextStyle(): TextStyle {
        return TextStyle(
            color = colorResource(id = textColor),
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing,
            background = colorResource(id = bgColor),
            textDecoration = textDecoration,
        )
    }
}

object IxiTextStyles {
    val h1 = ComponentTextStyle(
        textColor = R.color.white,
        fontSize = 16.sp,
        fontFamily = IxiFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        letterSpacing = 0.1.em,
        bgColor = android.R.color.transparent,
        textDecoration = TextDecoration.None
    )

    val h2 = h1.copy(
        fontSize = 14.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.5.em,
        textDecoration = TextDecoration.Underline
    )

    val button = ComponentTextStyle(
        textColor = R.color.white,
        fontSize = 18.sp,
        fontFamily = IxiFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        letterSpacing = 1.sp,
        bgColor = android.R.color.transparent,
        textDecoration = TextDecoration.None
    )

    val outlinedButton = button.copy(
        textColor = R.color.b700,
        bgColor = android.R.color.transparent
    )

    val outlinedButtonLarge = outlinedButton.copy(
        fontSize = 24.sp,
    )
    val buttonLarge = button.copy(
        fontSize = 24.sp,
        letterSpacing = 0.5.sp,
    )
}
