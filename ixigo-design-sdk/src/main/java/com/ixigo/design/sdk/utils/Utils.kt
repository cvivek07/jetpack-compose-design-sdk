package com.ixigo.design.sdk.utils

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics




object Utils {

    fun convertDpToPixel(dp: Float, context: Context): Float {
        val resources: Resources = context.resources
        val metrics: DisplayMetrics = resources.displayMetrics
        return dp * (metrics.densityDpi / 160f)
    }
}