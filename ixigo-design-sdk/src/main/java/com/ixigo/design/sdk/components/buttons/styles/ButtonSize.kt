package com.ixigo.design.sdk.components.buttons.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.components.styles.IxiTypography

data class ComponentPadding(
    val startPadding: Dp,
    val topPadding: Dp,
    val endPadding: Dp,
    val bottomPadding: Dp
)

sealed class ButtonSize(
    val height: Dp,
    val horizontalPadding: PaddingValues,
    val typography: TextStyle
) {

    object Small : ButtonSize(
        height = 30.dp, typography = IxiTypography.Button.Small.regular, horizontalPadding = PaddingValues(horizontal = 10.dp)
    )

    object Medium : ButtonSize(
        height = 40.dp, typography = IxiTypography.Button.Medium.regular, horizontalPadding = PaddingValues(horizontal = 10.dp)
    )

    object Large : ButtonSize(
        height = 50.dp, typography = IxiTypography.Button.Large.regular, horizontalPadding = PaddingValues(horizontal = 15.dp)
    )

    object XLarge : ButtonSize(
        height = 56.dp, typography = IxiTypography.Button.XLarge.regular, horizontalPadding = PaddingValues(horizontal = 20.dp)
    )

    object XXLarge : ButtonSize(
        height = 90.dp, typography = IxiTypography.Button.XLarge.regular, horizontalPadding = PaddingValues(horizontal = 30.dp)
    )

    data class Extra(
        val extraHeight: Dp,
        val extraTextSize: TextStyle,
        val extraHorizontalPadding: Dp
    ) : ButtonSize(height = extraHeight, typography =  extraTextSize, horizontalPadding = PaddingValues(horizontal = extraHorizontalPadding))
}