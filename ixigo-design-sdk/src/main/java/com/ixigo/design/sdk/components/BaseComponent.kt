package com.ixigo.design.sdk.components

import android.content.Context
import android.util.AttributeSet
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design.sdk.Project
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {
    protected val project = SdkManager.getConfig().project

    protected val themeColor = when(project) {
        Project.TRAIN -> IxiColor.Blue
        Project.FLIGHT -> IxiColor.Orange
        // Change the color for below items according to theme
        Project.ABHIBUS -> IxiColor.Blue
        Project.CONFIRM_TICKET -> IxiColor.Blue
    }
}