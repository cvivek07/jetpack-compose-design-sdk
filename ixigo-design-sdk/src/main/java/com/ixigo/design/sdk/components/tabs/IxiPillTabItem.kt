package com.ixigo.design.sdk.components.tabs

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.tabs.base.BaseTabItem
import com.ixigo.design.sdk.components.tabs.composables.PillTabComposable

internal class IxiPillTabItem @JvmOverloads constructor(
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
            PillTabComposable(
                startIcon = startDrawable,
                endIcon = endDrawable,
                text = title,
                isSelected = isSelected
            )
        }
    }

}