package com.ixigo.design_sdk.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

object Typography {
    val n800 = Color(29, 38, 60)

    object Heading {
        val DisplayLarge500 = TextStyle(
            fontSize = 54.sp,
            lineHeight = 65.sp,
            letterSpacing = 4.sp,
            fontWeight = W500,
            color = n800
        )
        val DisplayLarge700 = TextStyle(
            fontSize = 54.sp,
            lineHeight = 65.sp,
            letterSpacing = 4.sp,
            fontWeight = W700,
            color = n800
        )
        val DisplayLarge900 = TextStyle(
            fontSize = 54.sp,
            lineHeight = 65.sp,
            letterSpacing = 4.sp,
            fontWeight = W900,
            color = n800
        )

        val h1_500 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 48.sp,
            letterSpacing = 3.sp,
            fontWeight = W500,
            color = n800
        )
        val h1_700 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 48.sp,
            letterSpacing = 3.sp,
            fontWeight = W700,
            color = n800
        )
        val h1_900 = TextStyle(
            fontSize = 40.sp,
            lineHeight = 48.sp,
            letterSpacing = 3.sp,
            fontWeight = W900,
            color = n800
        )

        val h2_500 = TextStyle(
            fontSize = 36.sp,
            lineHeight = 43.sp,
            letterSpacing = 3.sp,
            fontWeight = W500,
            color = n800
        )

        val h2_700 = TextStyle(
            fontSize = 36.sp,
            lineHeight = 43.sp,
            letterSpacing = 3.sp,
            fontWeight = W700,
            color = n800
        )

        val h2_900 = TextStyle(
            fontSize = 36.sp,
            lineHeight = 43.sp,
            letterSpacing = 3.sp,
            fontWeight = W900,
            color = n800
        )

        val h3_500 = TextStyle(
            fontSize = 30.sp,
            lineHeight = 36.sp,
            letterSpacing = 2.sp,
            fontWeight = W500,
            color = n800
        )
        val h3_700 = TextStyle(
            fontSize = 30.sp,
            lineHeight = 36.sp,
            letterSpacing = 2.sp,
            fontWeight = W700,
            color = n800
        )
        val h3_900 = TextStyle(
            fontSize = 30.sp,
            lineHeight = 36.sp,
            letterSpacing = 2.sp,
            fontWeight = W900,
            color = n800
        )

        val h4_500 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 29.sp,
            letterSpacing = 2.sp,
            fontWeight = W500,
            color = n800
        )
        val h4_700 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 29.sp,
            letterSpacing = 2.sp,
            fontWeight = W700,
            color = n800
        )
        val h4_900 = TextStyle(
            fontSize = 24.sp,
            lineHeight = 29.sp,
            letterSpacing = 2.sp,
            fontWeight = W900,
            color = n800
        )

        val h5_500 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 1.sp,
            fontWeight = W500,
            color = n800
        )
        val h5_700 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 1.sp,
            fontWeight = W700,
            color = n800
        )
        val h5_900 = TextStyle(
            fontSize = 20.sp,
            lineHeight = 24.sp,
            letterSpacing = 1.sp,
            fontWeight = W900,
            color = n800
        )

        val h6_500 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            letterSpacing = 1.sp,
            fontWeight = W500,
            color = n800
        )
        val h6_700 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            letterSpacing = 1.sp,
            fontWeight = W700,
            color = n800
        )
        val h6_900 = TextStyle(
            fontSize = 18.sp,
            lineHeight = 22.sp,
            letterSpacing = 1.sp,
            fontWeight = W900,
            color = n800
        )
    }

    object Body {
        object Large {
            val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
            )

            val medium = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W500,
                color = n800,
            )

            val bold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W700,
                color = n800,
            )

            val italics = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object Medium {
            val regular = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
            )

            val medium = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
            )

            val bold = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
            )

            val italics = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object Small {
            val regular = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
            )

            val medium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
            )

            val bold = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
            )

            val italics = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object XSmall {
            val regular = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
            )

            val medium = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
            )

            val bold = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
            )

            val italics = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}
