package com.ixigo.design.sdk.components.topappbar.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider

abstract class BaseTopAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected var state = mutableStateOf(AppBarState())
    protected var menuProvider: IxiMenuProvider? = null

    fun setTitle(title: String) {
        val initState = state.value
        state.value = initState.copy(title = title)
    }

    fun setSubTitle(subTitle: String) {
        val initState = state.value
        state.value = initState.copy(subTitle = subTitle)
    }

    fun addMenuProvider(provider: IxiMenuProvider) {
        val initState = state.value
        state.value = initState.copy(menuProvider = provider)
    }

    fun setNavigationIcon(@DrawableRes actionIcon: Int) {
        val initState = state.value
        state.value = initState.copy(homeIcon = actionIcon)
    }

    fun setupElevation(elevation: Dp) {
        val initState = state.value
        state.value = initState.copy(elevation = elevation)
    }

    fun getTitle() = state.value.title

    fun getSubTitle() = state.value.subTitle

}

data class AppBarState(
    @DrawableRes val homeIcon: Int = R.drawable.left_arrow,
    val title: String? = null,
    val subTitle: String? = null,
    val elevation: Dp = 10.dp,
    val menuProvider: IxiMenuProvider? = null,
    val srpData: SrpModel? = null,
    val tabbedData: List<TabDataItem>? = null,
    val viewPager: ViewPager2? = null,
    val adapter: FragmentStateAdapter? = null,
    val tabType: TabType = TabType.LINE,
    val tabbedSelectionListener: (selectedItemIndex: Int) -> Unit = {}
)