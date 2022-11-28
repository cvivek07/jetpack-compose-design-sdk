package com.ixigo.design_sdk.components.buttons.styles

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ComponentPadding(
    val startPadding: Dp,
    val topPadding: Dp,
    val endPadding: Dp,
    val bottomPadding: Dp
)
sealed class Sizes(val padding: ComponentPadding, val textSize: TextUnit) {

    object Small : Sizes(
        ComponentPadding(
            startPadding = 8.dp,
            endPadding = 8.dp,
            topPadding = 6.dp,
            bottomPadding = 6.dp
        ), 14.sp
    )

    object Medium : Sizes(
        ComponentPadding(
            startPadding = 12.dp,
            endPadding = 12.dp,
            topPadding = 9.dp,
            bottomPadding = 9.dp
        ), 16.sp
    )

    object Large : Sizes(
        ComponentPadding(
            startPadding = 16.dp,
            endPadding = 16.dp,
            topPadding = 14.dp,
            bottomPadding = 14.dp
        ), 18.sp
    )

    object XLarge : Sizes(
        ComponentPadding(
            startPadding = 20.dp,
            endPadding = 20.dp,
            topPadding = 16.dp,
            bottomPadding = 16.dp
        ), 24.sp
    )

    object XXLarge : Sizes(
        ComponentPadding(
            startPadding = 32.dp,
            endPadding = 32.dp,
            topPadding = 32.dp,
            bottomPadding = 32.dp
        ), 24.sp
    )
}