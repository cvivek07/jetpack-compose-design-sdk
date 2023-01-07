package com.ixigo.design.sdk.components.tabs.base

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ixigo.design.sdk.components.tabs.IxiLineTabItems
import com.ixigo.design.sdk.components.tabs.IxiPillTabItem
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.utils.DimensionUtils.toPx


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
            throw  java.lang.IllegalArgumentException("Please set adapter to the ViewPager")
        }

        val items = viewPager.adapter!!.itemCount
        if (items != tabDataItems.size) {
            throw IllegalStateException("TabItems Count does not match with ViewPager fragment count")
        }

        tabMode = MODE_SCROLLABLE
        tabGravity = GRAVITY_FILL
        setSelectedTabIndicator(null)
        tabRippleColor = null


        TabLayoutMediator(
            this, viewPager
        ) { tab, position ->
            if (tabType == TabType.PILL) {
                drawTab(tab, IxiPillTabItem(context), tabDataItems[position])
            } else {
                drawTab(tab, IxiLineTabItems(context), tabDataItems[position])
            }
        }.attach()
    }

    private fun drawTab(tab: Tab, tabItem: BaseTabItem, dataItem: TabDataItem) {
        val tabPadding = (tabPaddingInDp.toPx)
        tabItem.setEndDrawable(dataItem.endIcon)
        tabItem.setStartDrawable(dataItem.startIcon)
        tabItem.setTitle(dataItem.title ?: "")
        tab.view.setPadding(tabPadding, 0, 0, 0)
        tab.customView = tabItem
    }
}

enum class TabType {
    PILL,
    LINE
}
