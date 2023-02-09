package com.ixigo.design.sdk.components.tabs

import android.content.Context
import android.util.AttributeSet
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.tabs.base.BaseTabItem
import com.ixigo.design.sdk.components.tabs.composables.LineTabComposable

internal class IxiLineTabItems @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTabItem(context, attrs, defStyleAttr) {
    @Composable
    override fun Content() {
        setViewCompositionStrategy(
             ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            LineTabComposable(
                startIcon = startDrawable,
                endIcon = endDrawable,
                text = title,
                isSelected = isSelected,
            )
        }
    }

}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Transparent

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}