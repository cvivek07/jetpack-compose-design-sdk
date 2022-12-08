package com.ixigo.design_sdk.components.styles

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.ixigo.design.sdk.R

val IxiFamily = FontFamily(
    Font(R.font.ixi_sans_medium, FontWeight.Medium),
    Font(R.font.ixi_sans, FontWeight.Normal),
    Font(R.font.ixi_sans_black, FontWeight.SemiBold),
    Font(R.font.ixi_sans_bold, FontWeight.Bold),
    Font(R.font.ixi_sans_italic, FontWeight.Normal, FontStyle.Italic)
)