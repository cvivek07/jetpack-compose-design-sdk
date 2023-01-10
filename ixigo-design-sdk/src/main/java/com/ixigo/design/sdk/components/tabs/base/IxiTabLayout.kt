package com.ixigo.design.sdk.components.tabs.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ixigo.design.sdk.components.tabs.IxiPillTabItem

class IxiTabLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    @DrawableRes
    var startIcon: Int = 0

    @DrawableRes
    var endIcon: Int = 0
    var title: String = ""
    var tabType: TabType = TabType.PILL


    override fun setupWithViewPager(viewPager: ViewPager?) {
        super.setupWithViewPager(viewPager)

        if (tabType == TabType.PILL) {
            setSelectedTabIndicator(null)
            for (i in 0 until tabCount) {
                val tabItem = IxiPillTabItem(context)
                tabItem.setEndDrawable(startIcon)
                tabItem.setEndDrawable(endIcon)
                tabItem.setTitle(title)
                tabItem.isSelected = isSelected
                getTabAt(i)?.customView = tabItem;
            }
        }


    }
}

enum class TabType {
    PILL,
    LINED
}
