package com.ixigo.design.sdk.components.separator

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.ixigo.design.sdk.R


/**
 * Divider component.
 * Create background with provided height and width
 * Uses default background (R.color.n100) if no background is provided
**/
class IxiSeparator @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiSeparator)
        try {
            this.background = ContextCompat.getDrawable(context, typedArray.getResourceId(R.styleable.IxiSeparator_android_background, R.color.n100))
        } finally {
            typedArray.recycle()
        }
    }
}