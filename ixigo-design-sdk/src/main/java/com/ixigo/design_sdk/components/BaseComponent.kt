package com.ixigo.design_sdk.components

import android.content.Context
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.Gravity
import android.view.WindowManager
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design_sdk.SdkInitializer
import com.ixigo.design_sdk.components.buttons.shapes.ButtonStyles
import com.ixigo.design_sdk.components.buttons.shapes.ComponentStyle

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {
    protected val project = SdkInitializer.projectName
}

abstract class BaseComposition()