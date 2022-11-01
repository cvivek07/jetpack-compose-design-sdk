package com.ixigo.design_sdk

import android.content.Context
import androidx.annotation.ColorRes
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.ixigo.design.sdk.R

class ThemeModifier {
    fun getColor(context: Context) {
        ContextCompat.getColor(context, R.color.o700)
    }

    val color: Int = android.R.color.background_dark


}

val IxiFamily = FontFamily(
    Font(R.font.ixitype_light, FontWeight.Light),
    Font(R.font.ixitype_regular, FontWeight.Normal),
    Font(R.font.ixitype_regular, FontWeight.SemiBold),
    Font(R.font.ixitype_bold, FontWeight.Bold),
    Font(R.font.ixitype_medium_italic, FontWeight.Medium, FontStyle.Italic)
)

data class IxiStyle(
    @ColorRes val textColor : Int,
    val fontSize : TextUnit,
    val fontFamily :FontFamily,
    val fontWeight : FontWeight,
    val fontStyle :FontStyle,
    val letterSpacing : TextUnit,
    @ColorRes val bgColor : Int,
    val textDecoration : TextDecoration
) {
    @Composable
    fun toTextStyle() : TextStyle {
        return TextStyle(
            color = colorResource(id = textColor),
            fontSize = fontSize,
            fontFamily = fontFamily,
            fontWeight = fontWeight,
            fontStyle = fontStyle,
            letterSpacing = letterSpacing,
            background = colorResource(id = bgColor),
            textDecoration = textDecoration
        )
    }
}
object IxiTypography {
    val h1 = IxiStyle(
        textColor =  R.color.white,
        fontSize = 16.sp,
        fontFamily = IxiFamily,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
        letterSpacing = 0.1.em,
        bgColor = android.R.color.transparent,
        textDecoration = TextDecoration.None
    )

    val h2 = IxiStyle(
        textColor = R.color.white,
        fontSize = 14.sp,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.5.em,
        bgColor = android.R.color.transparent,
        textDecoration = TextDecoration.Underline
    )
}

object IxiShapes {
    val rectSmall = RectangleShape
    val roundRectSmall = RoundedCornerShape(4.dp)
    val topRoundRectSmall = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
    val startRoundRectSmall = RoundedCornerShape(4.dp, 0.dp, 0.dp, 4.dp)
    val endRoundRectSmall =
        RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 4.dp, topEnd = 4.dp, topStart = 0.dp)
}

class a {
    fun b() {
        IxiShapes.endRoundRectSmall.copy(bottomEnd = CornerSize(8), topEnd = CornerSize(8))
    }
}