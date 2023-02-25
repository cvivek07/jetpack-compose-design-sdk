package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.SegmentedControlBar

class IxiSegmentedControlBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    var segments: List<String> = listOf()
    var onSegmentChangeListener: ((selectedItemIndex: Int) -> Unit)? = null

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
             ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            SegmentedControlBar(
                homeIcon = homeIcon,
                elevation = elevation,
                menuProvider = menuProvider,
                items = segments,
                onItemSelection = onSegmentChangeListener ?: {}
            )
        }
    }
}