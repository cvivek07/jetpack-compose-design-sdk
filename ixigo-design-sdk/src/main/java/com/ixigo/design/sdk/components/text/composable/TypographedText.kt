package com.ixigo.design.sdk.components.text.composable

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.components.styles.IxiFamily

@Composable
fun TypographyText(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        letterSpacing = 0.sp,
        style = textStyle,
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines
    )
}


@Composable
fun TypographyText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        letterSpacing = 0.sp,
        style = textStyle,
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines
    )
}