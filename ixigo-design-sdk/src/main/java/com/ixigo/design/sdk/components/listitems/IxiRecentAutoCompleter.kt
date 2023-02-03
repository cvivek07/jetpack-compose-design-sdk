package com.ixigo.design.sdk.components.listitems

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.listitems.base.BaseListItem
import com.ixigo.design.sdk.components.listitems.composables.AutoCompleterRecentComposable

class IxiRecentAutoCompleter @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseListItem(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        AutoCompleterRecentComposable(
            subTitle = state.value.subTitle,
            startIcon = state.value.startIconRes,
            code = state.value.code,
            endIcon = state.value.endIconRes,
            onEndIconClick = state.value.onEndIconClick,
            onStartIconClick = state.value.onStartIconClick,
            onItemClick = state.value.onItemClick,
            from = state.value.from,
            to = state.value.to
        )
    }
}