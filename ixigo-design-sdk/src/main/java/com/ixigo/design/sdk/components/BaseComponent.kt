package com.ixigo.design.sdk.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design.sdk.SdkInitializer
import com.ixigo.design.sdk.utils.DimensionUtils.toDp

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {
    protected var preferredHeight: Int = 0
    protected var preferredWidth: Int = 0
    protected val project = SdkInitializer.projectName

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        preferredWidth = layoutParams.width
        preferredHeight = layoutParams.height
    }
}

abstract class BaseComposition()