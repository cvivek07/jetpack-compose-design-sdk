package com.ixigo.design.sdk.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.font.FontWeight.Companion.W900
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

object IxiTypography {
    private val n800 = Color(29, 38, 60)

    object Button {
        object XLarge {
            val regular = TextStyle(
                fontSize = 24.sp,
                lineHeight = 27.07.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object Large {
            val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 23.4.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object Medium {
            val regular = TextStyle(
                fontSize = 16.sp,
                lineHeight = 20.8.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
        }
        object Small {
            val regular = TextStyle(
                fontSize = 14.sp,
                lineHeight = 18.2.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
        }
    }

    object Heading {
        object DisplayLarge {
            val regular = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H1 {
            val regular = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H2 {
            val regular = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            val semiBold = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            val bold = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H3 {
            val regular = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H4 {
            val regular = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H5 {
            val regular = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }

        object H6 {
            val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )
            val semiBold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            val bold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
        }
    }

    object Body {
        object Large {
            val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            val medium = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            val bold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            val italics = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
            )

            val underline = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object Medium {
            val regular = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            val medium = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            val bold = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            val italics = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
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
                fontFamily = IxiFamily,
            )

            val medium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            val bold = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            val italics = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
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
                fontFamily = IxiFamily,
            )

            val medium = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            val bold = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            val italics = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            val underline = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            val strikeThrough = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}
