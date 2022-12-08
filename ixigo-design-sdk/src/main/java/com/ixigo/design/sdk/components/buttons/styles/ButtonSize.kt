package com.ixigo.design.sdk.components.buttons.styles

import androidx.compose.foundation.layout.PaddingValues
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

sealed class ButtonSize(
    val height: Dp,
    val textSize: TextUnit,
    val horizontalPadding: PaddingValues
) {

    object Small : ButtonSize(
        height = 30.dp, textSize = 14.sp, horizontalPadding = PaddingValues(horizontal = 10.dp)
    )

    object Medium : ButtonSize(
        height = 40.dp, textSize = 16.sp, horizontalPadding = PaddingValues(horizontal = 10.dp)
    )

    object Large : ButtonSize(
        height = 50.dp, textSize = 18.sp, horizontalPadding = PaddingValues(horizontal = 15.dp)
    )

    object XLarge : ButtonSize(
        height = 56.dp, textSize = 24.sp, horizontalPadding = PaddingValues(horizontal = 20.dp)
    )

    object XXLarge : ButtonSize(
        height = 90.dp, textSize = 24.sp, horizontalPadding = PaddingValues(horizontal = 30.dp)
    )
}