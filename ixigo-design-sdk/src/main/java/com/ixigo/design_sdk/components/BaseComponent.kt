package com.ixigo.design_sdk.components

import android.content.Context
import android.graphics.PixelFormat
import android.util.AttributeSet
import android.view.Gravity
import android.view.WindowManager
import androidx.compose.ui.platform.AbstractComposeView
import com.ixigo.design_sdk.components.buttons.shapes.ButtonStyles
import com.ixigo.design_sdk.components.buttons.shapes.ComponentStyle

abstract class BaseComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    private var params: WindowManager.LayoutParams =
        WindowManager.LayoutParams().apply {
            gravity = Gravity.TOP
            type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL
            token = applicationWindowToken
            width = WindowManager.LayoutParams.WRAP_CONTENT
            height = WindowManager.LayoutParams.WRAP_CONTENT
            format = PixelFormat.TRANSLUCENT
            flags = flags or
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        }
}

data class IxiState(
    val text: String = "",
    val style: ComponentStyle = ButtonStyles.o700NormalTrailingShapeRadius,
    val onClick: () -> Unit = {}
)