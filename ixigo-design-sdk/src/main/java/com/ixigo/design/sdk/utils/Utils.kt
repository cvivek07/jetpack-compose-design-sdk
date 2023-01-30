package com.ixigo.design.sdk.utils

import android.content.Context
import android.util.TypedValue


object Utils {
    fun convertPixelsToDp(px: Float, context: Context): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            px,
            context.resources.displayMetrics
        )
    }
}