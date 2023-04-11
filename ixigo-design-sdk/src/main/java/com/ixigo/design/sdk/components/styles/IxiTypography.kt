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
    sealed interface TypographyType {
        val regular: TextStyle
        val medium: TextStyle
        val bold: TextStyle
        val italics: TextStyle
        val underline: TextStyle
        val strikeThrough: TextStyle

        fun TextStyle.applyItalics(): TextStyle {
            return this.copy(fontStyle = FontStyle.Italic)
        }

        fun TextStyle.applyUnderLine(): TextStyle {
            val prevDecoration = this.textDecoration
            val currentDecoration =
                if (prevDecoration != null && prevDecoration != TextDecoration.Underline) {
                    TextDecoration.combine(listOf(prevDecoration, TextDecoration.Underline))
                } else {
                    TextDecoration.Underline
                }
            return this.copy(textDecoration = currentDecoration)
        }

        fun TextStyle.applyStrikeThrough(): TextStyle {
            val prevDecoration = this.textDecoration
            val currentDecoration =
                if (prevDecoration != null && prevDecoration != TextDecoration.LineThrough) {
                    TextDecoration.combine(listOf(prevDecoration, TextDecoration.LineThrough))
                } else {
                    TextDecoration.LineThrough
                }
            return this.copy(textDecoration = currentDecoration)
        }

        fun TextStyle.applyFontStyle(
            underline: Boolean,
            italics: Boolean,
            strikeThrough: Boolean
        ): TextStyle {
            var textStyle = this
            if (underline) textStyle = textStyle.applyUnderLine()
            if (strikeThrough) textStyle = textStyle.applyStrikeThrough()
            if (italics) textStyle = textStyle.applyItalics()
            return textStyle
        }
    }

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
        object DisplayLarge : TypographyType {
            override val regular = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use DisplayLarge.medium instead")
            val semiBold = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 54.sp,
                lineHeight = 65.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )


        }

        object H1 : TypographyType {
            override val regular = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H1.medium instead")
            val semiBold = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 40.sp,
                lineHeight = 48.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object H2 : TypographyType {
            override val regular = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H2.medium instead")
            val semiBold = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val bold = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object H3 : TypographyType {
            override val regular = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H3.medium instead")
            val semiBold = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 30.sp,
                lineHeight = 36.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object H4 : TypographyType {
            override val regular = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H4.medium instead")
            val semiBold = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object H5 : TypographyType {
            override val regular = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H5.medium instead")
            val semiBold = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object H6 : TypographyType {
            override val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily
            )

            @Deprecated("Use H6.medium instead")
            val semiBold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )

            override val medium = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily
            )
            override val bold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W900,
                color = n800,
                fontFamily = IxiFamily
            )
            override val italics = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )
            override val underline = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )
            override val strikeThrough = TextStyle(
                fontSize = 18.sp,
                lineHeight = 22.sp,
                letterSpacing = 1.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }

    object Body {
        object Large : TypographyType {
            override val regular = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val medium = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val bold = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val italics = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
            )

            override val underline = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            override val strikeThrough = TextStyle(
                fontSize = 18.sp,
                lineHeight = 29.sp,
                letterSpacing = 5.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object Medium : TypographyType {
            override val regular = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 0.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val medium = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val bold = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val italics = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            override val underline = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            override val strikeThrough = TextStyle(
                fontSize = 16.sp,
                lineHeight = 26.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object Small : TypographyType {
            override val regular = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val medium = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val bold = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val italics = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            override val underline = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            override val strikeThrough = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.sp,
                letterSpacing = 4.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object XSmall : TypographyType {
            override val regular = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val medium = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val bold = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val italics = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            override val underline = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            override val strikeThrough = TextStyle(
                fontSize = 12.sp,
                lineHeight = 19.sp,
                letterSpacing = 3.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }

        object XXSmall : TypographyType {
            override val regular = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val medium = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W500,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val bold = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W700,
                color = n800,
                fontFamily = IxiFamily,
            )

            override val italics = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                fontStyle = FontStyle.Italic,
            )

            override val underline = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.Underline
            )

            override val strikeThrough = TextStyle(
                fontSize = 10.sp,
                lineHeight = 11.sp,
                letterSpacing = 2.sp,
                fontWeight = W400,
                color = n800,
                fontFamily = IxiFamily,
                textDecoration = TextDecoration.LineThrough
            )
        }
    }
}
