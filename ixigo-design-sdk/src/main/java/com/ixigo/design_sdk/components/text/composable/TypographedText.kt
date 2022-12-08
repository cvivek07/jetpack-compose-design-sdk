package com.ixigo.design_sdk.components.text.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ixigo.design_sdk.components.styles.IxiFamily

@Composable
fun TypographyText(text: String,modifier: Modifier = Modifier, textStyle: TextStyle) {
    Text(
        text = text,
        fontSize = textStyle.fontSize,
        fontWeight = textStyle.fontWeight,
        fontFamily = IxiFamily,
        letterSpacing = 0.sp,
        color = textStyle.color,
        textDecoration = textStyle.textDecoration,
        fontStyle = textStyle.fontStyle,
        lineHeight = textStyle.lineHeight
    )
}