package com.ixigo.design.sdk.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design.sdk.DesignConfig
import com.ixigo.design.sdk.Project
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.utils.setupEditMode

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {
    protected val themeColor = SdkManager.getConfig().project.color
    protected var preferredHeight: Int = 0
    protected var preferredWidth: Int = 0

    override fun onAttachedToWindow() {
        if (isInEditMode) {
            SdkManager.initSdk(DesignConfig(Project.TRAIN))
            setupEditMode()
        }
        super.onAttachedToWindow()

        preferredWidth = layoutParams.width
        preferredHeight = layoutParams.height
    }
}