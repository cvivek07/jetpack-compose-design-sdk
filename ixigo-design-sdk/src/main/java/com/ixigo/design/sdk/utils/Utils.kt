package com.ixigo.design.sdk.utils

import android.content.Context
import android.content.res.Resources
import android.text.Layout
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign


object Utils {
    fun convertPixelsToDp(px: Float, context: Context): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            context.resources.displayMetrics
        )
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources: Resources = context.resources
        val metrics: DisplayMetrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }

    @Composable
    fun mapLayoutAlignmentToComposeTextAlignment(alignment: Layout.Alignment): TextAlign{
        return when(alignment){
            Layout.Alignment.ALIGN_NORMAL -> TextAlign.Start
            Layout.Alignment.ALIGN_OPPOSITE -> TextAlign.End
            Layout.Alignment.ALIGN_CENTER -> TextAlign.Center
        }
    }

    @Composable
    fun mapLayoutAlignmentToComposeAlignment(alignment: Layout.Alignment): Alignment{
        return when(alignment){
            Layout.Alignment.ALIGN_NORMAL -> Alignment.CenterStart
            Layout.Alignment.ALIGN_OPPOSITE -> Alignment.CenterEnd
            Layout.Alignment.ALIGN_CENTER -> Alignment.Center
        }
    }

}