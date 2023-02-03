package com.ixigo.design.sdk.components.listitems

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.listitems.base.BaseAutoCompleter
import com.ixigo.design.sdk.components.listitems.composables.AutoCompleterAirPortOrStationComposable

/**
 *
 */
class IxiAirportOrStationAutoCompleter @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseAutoCompleter(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )

        AutoCompleterAirPortOrStationComposable(
            startIcon = state.value.startIconRes,
            endIcon = state.value.endIconRes,
            title = state.value.title ?: "",
            subTitle = state.value.subTitle,
            to = state.value.to,
            from = state.value.from,
            onEndIconClick = state.value.onEndIconClick,
            onStartIconClick = state.value.onStartIconClick,
            onItemClick = state.value.onItemClick,
            code = state.value.code
        )
    }
}