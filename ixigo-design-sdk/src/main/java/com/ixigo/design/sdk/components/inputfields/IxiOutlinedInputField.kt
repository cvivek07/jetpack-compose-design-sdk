package com.ixigo.design.sdk.components.inputfields

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.inputfields.base.BaseInputField
import com.ixigo.design.sdk.components.inputfields.composables.OutlinedInputField

/**
 * https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1014-155849&mode=design&t=UdbrnsPY7euxQxTu-0
 */

class IxiOutlinedInputField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseInputField(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        OutlinedInputField(
            actionImage = state.value.actionImage,
            drawableEnd = state.value.drawableEnd,
            drawableStartText = state.value.drawableStartText,
            drawableStartTextStyle = state.value.drawableStartTextStyle,
            drawableStart = state.value.drawableStart,
            showLeadingDivider = state.value.showLeadingDivider,
            actionText = state.value.actionText,
            helperText = state.value.helperText,
            helperTextColor = state.value.helperTextColor,
            text = state.value.text,
            maxCharCount = state.value.maxCharCount,
            label = state.value.label,
            onDrawableStartClick = state.value.onClickDrawableStart,
            onDrawableEndClick = state.value.onClickDrawableEnd,
            onActionTextClick = state.value.onClickActionText,
            onActionIconClick = state.value.onClickActionIcon,
            onTextChange = state.value.onTextChange,
            onFocusChange= state.value.onFocusChange,
            colors = state.value.color,
            width = preferredWidth,
            readOnly = state.value.readOnly,
            isActiveAlways = state.value.isActiveAlways,
            enabled = state.value.enabled,
            keyboardType = state.value.keyboardType,
            capitalization = state.value.capitalization,
            showMaxCharCount = state.value.showMaxCharCount
        )

    }
}