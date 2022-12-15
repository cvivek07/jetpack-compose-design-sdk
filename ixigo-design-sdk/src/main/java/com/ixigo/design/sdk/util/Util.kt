package com.ixigo.design.sdk.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times


object Util {
    @Composable
    @JvmStatic
    fun convertDimensionToDp(px: Float): Dp {
        return px * 1.dp
    }
}