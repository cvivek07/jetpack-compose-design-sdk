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
import com.ixigo.design.sdk.components.tabs.base.TabType
import com.ixigo.design.sdk.components.topappbar.TabItem
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

//
//    fun setupActionIcon1(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
//        val initState = state.value
//        state.value = initState.copy(actionIcon1 = actionIcon, action1Click = actionIconClick)
//    }

    fun addMenuProvider(provider: IxiMenuProvider) {
        val initState = state.value
        state.value = initState.copy(menuProvider = provider)
    }

//    fun setupActionIcon2(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
//        val initState = state.value
//        state.value = initState.copy(actionIcon2 = actionIcon, action2Click = actionIconClick)
//    }

    fun setNavigationIcon(@DrawableRes actionIcon: Int) {
        val initState = state.value
        state.value = initState.copy(homeIcon = actionIcon)
    }

    fun setNavigationOnClickListener(navigationIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(homeIconClick = navigationIconClick)
    }

    fun setupHome(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(homeIcon = actionIcon, homeIconClick = actionIconClick)
    }

    fun setupElevation(elevation: Dp) {
        val initState = state.value
        state.value = initState.copy(elevation = elevation)
    }
}

data class AppBarState(
    @DrawableRes val homeIcon: Int = R.drawable.left_arrow,
    val homeIconClick: () -> Unit = {},
    val title: String? = null,
    val subTitle: String? = null,
    val elevation: Dp = 10.dp,
    val menuProvider: IxiMenuProvider? = null,
    val srpData: SrpModel? = null,
    val tabbedData: List<TabItem>? = null,
    val viewPager: ViewPager2? = null,
    val adapter: FragmentStateAdapter? = null,
    val tabType: TabType = TabType.LINED,
    val tabbedSelectionListener: (selectedItemIndex: Int) -> Unit = {}
)