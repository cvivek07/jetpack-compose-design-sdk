package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import com.ixigo.design.sdk.R

class IxigoButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseButton(context, attrs, defStyleAttr) {
    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxigoButton);
        try {
            val text = typedArray.getString(R.styleable.IxigoButton_android_text) ?: ""
            setText(text)
            flag = typedArray.getInt(
                R.styleable.IxigoButton_ixi_button_style,
                o700NormalTrailingShapeRadius
            )

            setStyle(mapFlagsWithStyle(flag))
        } finally {
            typedArray.recycle()
        }
    }



    @Composable
    override fun Content() {
        with(state.value) {
            ComposableButton(text, style, onClick)
        }
    }
}
