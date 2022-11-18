package com.ixigo.design_sdk.components.input_fields

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.BaseComponent
import com.ixigo.design_sdk.components.buttons.ComposableButtonOutlined

class OutlinedInputField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseInputField(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )

        OutlinedIxiInputField(
            actionImage = state.value.actionImage,
            drawableEnd = state.value.drawableEnd,
            drawableStart = state.value.drawableStart,
            actionText = state.value.actionText,
            helperText = state.value.helperText,
            text = state.value.text,
            maxCharCount = state.value.maxCharCount,
            label = state.value.label
        )

    }
}