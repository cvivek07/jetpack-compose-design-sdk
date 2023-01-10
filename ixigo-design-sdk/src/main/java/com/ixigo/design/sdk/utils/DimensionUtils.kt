package com.ixigo.design.sdk.utils

import android.content.Context
import android.content.res.Resources

object DimensionUtils {
    fun Context.dpToPx(dp: Int): Float {
        return (this.resources.displayMetrics.density * dp)
    }

    fun Context.dpToPx(dp: Float): Float {
        return this.resources.displayMetrics.density * dp
    }


    val Float.toPx get() = this * Resources.getSystem().displayMetrics.density

    val Float.toDp get() = this / Resources.getSystem().displayMetrics.density



    val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()

    val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()

}