package com.ixigo.design.sdk.utils

import android.content.Context

object DimensionUtils {
    fun Context.dpToPx(dp: Int): Float {
        return (this.resources.displayMetrics.density * dp)
    }

    fun Context.dpToPx(dp: Float): Float {
        return this.resources.displayMetrics.density * dp
    }
}