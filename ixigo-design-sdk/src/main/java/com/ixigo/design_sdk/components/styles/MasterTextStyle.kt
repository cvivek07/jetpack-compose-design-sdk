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
    Font(R.font.ixi_sans_medium, FontWeight.Medium),
    Font(R.font.ixi_sans, FontWeight.Normal),
    Font(R.font.ixi_sans_black, FontWeight.SemiBold),
    Font(R.font.ixi_sans_bold, FontWeight.Bold),
    Font(R.font.ixi_sans_italic, FontWeight.Normal, FontStyle.Italic)
)