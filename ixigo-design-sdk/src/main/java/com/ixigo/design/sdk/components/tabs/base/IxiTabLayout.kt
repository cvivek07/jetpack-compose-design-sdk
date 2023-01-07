package com.ixigo.design.sdk.components.tabs.base

import android.content.Context
import android.util.AttributeSet
import androidx.compose.ui.unit.dp
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ixigo.design.sdk.components.tabs.IxiLineTabItems
import com.ixigo.design.sdk.components.tabs.IxiPillTabItem
import com.ixigo.design.sdk.components.topappbar.TabItem
import com.ixigo.design.sdk.utils.DimensionUtils.toPx
import kotlin.math.roundToInt


class IxiTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    var tabType: TabType = TabType.LINED

    /**
     * padding values to be set between two tabs items
     */
    var tabPaddingInDp: Int = 5

    fun setupWithViewPager2(viewPager: ViewPager2, tabItems: List<TabItem>) {
        if (viewPager.adapter == null) {
            throw  java.lang.RuntimeException("Please set adapter to the ViewPager")
        }

        val items = viewPager.adapter!!.itemCount
        if (items != tabItems.size) {
            throw java.lang.RuntimeException("TabItems Count does not match with ViewPager fragment count")
        }

        tabMode = MODE_SCROLLABLE
        tabGravity = GRAVITY_FILL
        setSelectedTabIndicator(null)
        tabRippleColor = null

        val tabPadding = (tabPaddingInDp.toPx)
        TabLayoutMediator(
            this, viewPager
        ) { tab, position ->

            if (tabType == TabType.PILL) {
                val tabItem = IxiPillTabItem(context)
                tabItem.setEndDrawable(tabItems[position].endIcon)
                tabItem.setStartDrawable(tabItems[position].startIcon)
                tabItem.setTitle(tabItems[position].title ?: "")
                tab.view.setPadding(tabPadding,0,0,0)
                tab.customView = tabItem
            } else {
                val tabItem = IxiLineTabItems(context)
                tabItem.setEndDrawable(tabItems[position].endIcon)
                tabItem.setStartDrawable(tabItems[position].startIcon)
                tabItem.setTitle(tabItems[position].title ?: "")
                tab.view.setPadding(tabPadding,0,0,0)
                tab.customView = tabItem
            }
        }.attach()
    }
}

enum class TabType {
    PILL,
    LINED
}
