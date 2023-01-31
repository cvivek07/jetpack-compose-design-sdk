package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.TabbedBar

class IxiTabbedToolBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    fun setData(data: List<TabDataItem>) {
        val initState = state.value
        state.value = initState.copy(tabbedData = data)
    }

    fun setTabType(tabType: TabType) {
        val initState = state.value
        state.value = initState.copy(tabType = tabType)
    }

    fun setupViewPager(viewPager: ViewPager2, adapter: FragmentStateAdapter) {
        val initState = state.value
        state.value = initState.copy(viewPager = viewPager, adapter = adapter)
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            state.value.tabbedData?.let {
                viewPager?.let { it1 ->
                    TabbedBar(
                        homeIcon = homeIcon,
                        elevation = elevation,
                        menuProvider = menuProvider,
                        data = it,
                        viewPager = it1,
                        adapter = adapter,
                        tabType = tabType
                    )
                }
            }
        }
    }
}

data class TabDataItem(val title: String?, val startIcon: Int, val endIcon: Int, val topIcon: Int, val topUrl: String?)