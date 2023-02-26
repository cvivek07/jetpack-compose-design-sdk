package com.ixigo.design.sdk.components.topappbar.base

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenu
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider

abstract class BaseTopAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected var state = mutableStateOf(AppBarState())

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

    fun updateMenuItem(position: Int, data: IxiMenu) {
        val prevProvider = state.value.menuProvider
        val menuProviderList = prevProvider?.provideMenu()
        val list = menuProviderList?.toMutableList()
        list?.set(position, data)
        val p = object : IxiMenuProvider {
            override fun provideMenu(): List<IxiMenu> {
                return list ?: menuProviderList ?: listOf()
            }

            override fun onMenuItemClick(id: Int) {
                prevProvider?.onMenuItemClick(id)
            }

        }
        state.value = state.value.copy(menuProvider = p)
    }

    fun setNavigationIcon(@DrawableRes actionIcon: Int) {
        val initState = state.value
        state.value = initState.copy(
            homeIcon = ImageData.createFromRes(actionIcon)
        )
    }


    fun setNavigationIcon(actionIcon: Drawable) {
        val initState = state.value
        state.value = initState.copy(
            homeIcon = ImageData.createFromDrawable(actionIcon)
        )
    }

    fun setupElevation(elevation: Dp) {
        val initState = state.value
        state.value = initState.copy(elevation = elevation)
    }

    fun setItemEnable(id: Int, shouldEnable: Boolean) {
        val list = state.value.disabledIds.toMutableList()
        if (shouldEnable) {
            list.remove(id)
        } else {
            list.add(id)
        }
        state.value = state.value.copy(disabledIds = list)
    }
    fun getTitle() = state.value.title

    fun getSubTitle() = state.value.subTitle

}

data class AppBarState(
    val homeIcon: ImageData = ImageData(
        drawableRes = R.drawable.left_arrow,
        null,
        null,
        null,
        null,
        null
    ),
    val title: String? = null,
    val subTitle: String? = null,
    val elevation: Dp = 10.dp,
    val menuProvider: IxiMenuProvider? = null,
    val srpData: SrpModel? = null,
    val tabbedData: List<TabDataItem>? = null,
    val viewPager: ViewPager2? = null,
    val adapter: FragmentStateAdapter? = null,
    val tabType: TabType = TabType.LINE,
    val hint: String? = null,
    val tabbedSelectionListener: (selectedItemIndex: Int) -> Unit = {},
    val disabledIds: List<Int> = listOf(),
    val onSearchFocusChange: (Boolean) -> Unit = {},
    val shouldFocus: Boolean? = null
)