package com.ixigo.design.sdk.components.tabs

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ixigo.design.sdk.components.tabs.base.BaseTabItem
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.utils.DimensionUtils.toPx

/**
 * IxiTabLayout provides a horizontal layout to display tabs.
 *
 * Two types of tabs are supported:
 * [TabType.PILL] and [TabType.LINE]
 *
 * Population of the tabs to display is done through [TabLayout.Tab] instances.
 * You pass [TabDataItem] instance list to draw tab items in setupWithViewPager2() along with
 * [ViewPager2] instance to make connection with [ViewPager2]
 *
 * Call setupWithViewPager2() after setting up the adapter to view pager else it will
 * throw [IllegalArgumentException]
 *
 * Moreover, If List<TabDataItem> provided mismatch the items in [ViewPager2] adapter items,
 * it will throw [IllegalStateException]
 *
 * You should add a listener via [addOnTabSelectedListener] to be
 * notified when any tab's selection state has been changed.
 *
 * You can  add [IxiTabLayout] in your layout file. An example usage is like so:
 *
 * ```
 * <com.ixigo.design.sdk.components.tabs.IxiTabLayout
 *  android:id="@+id/tabLayout"
 *  android:layout_width="match_parent"
 *  android:layout_height="wrap_content" />
 *```
 *
 * <h3>ViewPager integration</h3>
 *
 * You must use [IxiTabLayout]  together with [ViewPager2] only. You
 * can call ```setupWithViewPager(ViewPager2)``` to link the two together. This layout will be
 * automatically populated from the [PagerAdapter]'s page titles.
 *
 * ```
 * <LinearLayout
 *   android:layout_width="match_parent"
 *   android:layout_height="wrap_content"
 *   android:orientation="vertical">
 *
 *      <com.ixigo.design.sdk.components.tabs.IxiTabLayout
 *      android:id="@+id/tabLayout"
 *      android:layout_width="match_parent"
 *      android:layout_height="wrap_content" />
 *
 *      <androidx.viewpager2.widget.ViewPager2
 *      android:id="@+id/viewPager"
 *      android:layout_width="match_parent"
 *      android:layout_height="match_parent" />
 * </LinearLayout>
 *
 * @since 1.0
 */
class IxiTabLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {

    /**
     * specify the type of the tabs. Type can be any of [TabType.LINE] or [TabType.PILL]
     */
    var tabType: TabType = TabType.LINE

    /**
     * padding values to be set between two tabs items
     */
    var tabPaddingInDp: Int = 5

    /**
     * Set up the [IxiTabLayout] wit [ViewPager2]
     *
     * @param viewPager [ViewPager2] instance to connect with the [IxiTabLayout]
     * @param tabDataItems List of [TabDataItem]s which are used to create the [TabLayout.Tab]s
     */
    fun setupWithViewPager2(viewPager: ViewPager2, tabDataItems: List<TabDataItem>) {
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


    fun addTab(tabData: TabDataItem) {
        // Removing default TabIndicator
        setSelectedTabIndicator(null)
        val tab = newTab()
        val tabView = if (tabType == TabType.PILL) {
            IxiPillTabItem(context)
        } else {
            IxiLineTabItems(context)
        }
        drawTab(tab, tabView, tabData)
        addTab(tab)
    }


    fun addTab(tabData: TabDataItem, position: Int) {
        // Removing default TabIndicator
        setSelectedTabIndicator(null)
        val tab = newTab()
        val tabView = if (tabType == TabType.PILL) {
            IxiPillTabItem(context)
        } else {
            IxiLineTabItems(context)
        }
        drawTab(tab, tabView, tabData)
        addTab(tab, position)
    }
    private fun drawTab(tab: Tab, tabItem: BaseTabItem, dataItem: TabDataItem) {
        val tabPadding = (tabPaddingInDp.toPx)
        tabItem.setEndDrawable(dataItem.endIcon)
        tabItem.setStartDrawable(dataItem.startIcon)
        tabItem.setTopDrawable(dataItem.topIcon)
        tabItem.setTitle(dataItem.title ?: "")
        tab.view.setPadding(tabPadding, 0, 0, 0)
        tab.customView = tabItem
    }
}

enum class TabType {
    PILL, LINE
}
