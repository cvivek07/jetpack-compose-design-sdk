package com.ixigo.design.sdk.components.inputfields

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.inputfields.base.BaseInputField
import com.ixigo.design.sdk.components.inputfields.composables.LinedInputField

class IxiLinedInputField  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseInputField(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )

        LinedInputField(
            actionImage = state.value.actionImage,
            drawableEnd = state.value.drawableEnd,
            drawableStart = state.value.drawableStart,
            actionText = state.value.actionText,
            helperText = state.value.helperText,
            text = state.value.text,
            maxCharCount = state.value.maxCharCount,
            label = state.value.label,
            onDrawableStartClick = state.value.onClickDrawableStart,
            onDrawableEndClick = state.value.onClickDrawableEnd,
            onActionTextClick = state.value.onClickActionText,
            onActionIconClick = state.value.onClickActionIcon,
            onTextChange = state.value.onTextChange,
            colors = state.value.color
        )

    }
}