package com.ixigo.design.sdk.components.tabs

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.tabs.base.BaseTabItem
import com.ixigo.design.sdk.components.topappbar.TabDataItem

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
 * You can add tab item using
 * ```
 * tabLayout.addTab(TabDataItem("Typography",R.drawable.start_drawable,R.drawable.end_drawable))
 * ```
 *
 * <h3>ViewPager integration</h3>
 *
 * You should use [IxiTabLayout]  together with [ViewPager2]. You
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
 * ```
 * In case you want to use it with [ViewPager], You can call you can call
 * ```setupWithViewPager(ViewPager)``` to link the two together.
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

    private val defaultPadding = resources.getDimensionPixelSize(R.dimen.dp_8)

    /**
     * Start padding value of each TabItem
     */
    var tabPaddingStart: Int? = defaultPadding

    /**
     * End padding value of each TabItem
     */
    var tabPaddingEnd: Int? = defaultPadding


    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiTabLayout)
        try {

            tabPaddingStart = typedArray.getDimensionPixelSize(
                R.styleable.IxiTabLayout_tabPaddingStart,
                defaultPadding
            )
            tabPaddingEnd = typedArray.getDimensionPixelSize(
                R.styleable.IxiTabLayout_tabPaddingEnd,
                defaultPadding
            )
            tabType = TabType.values()[typedArray.getInt(R.styleable.IxiTabLayout_tabType, 1)]
        } finally {
            typedArray.recycle()
        }
    }

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


    /**
     *  Add tab Item in Lined or Pill Shape. In case no tab type is provided it will create Lined
     *  tab .
     *
     *  If this is the first tab to be added it will become the selected tab.
     *
     *  @param tabData Details rewuired to create the Tab
     */
    fun addTab(tabData: TabDataItem) {
        addTabInternal(tabData)
    }

    /**
     *  Add tab Item in Lined or Pill Shape at particular position. In case no tab type is
     *  provided it will create Lined tab.
     *
     *  In case position is not valid, tab will be added at end.
     *  Fore Example if negative position is provided or position overflows the existing tab count,
     *  it will add tab item in last.
     *
     *  If this is the first tab to be added it will become the selected tab.
     *
     *  @param tabData Details rewuired to create the Tab
     */
    fun addTab(tabData: TabDataItem, position: Int) {
        addTabInternal(tabData, position)
    }

    private fun addTabInternal(tabData: TabDataItem, position: Int = -1) {
        // Removing default TabIndicator
        setSelectedTabIndicator(null)

        val tab = newTab()
        val tabView = if (tabType == TabType.PILL) {
            IxiPillTabItem(context)
        } else {
            IxiLineTabItems(context)
        }
        drawTab(tab, tabView, tabData)


        if (position in 0 until tabCount) {
            addTab(tab, position)
        } else {
            addTab(tab)
        }
    }

    private fun drawTab(tab: Tab, tabItem: BaseTabItem, dataItem: TabDataItem) {
        tabItem.setEndDrawable(dataItem.endIcon)
        tabItem.setStartDrawable(dataItem.startIcon)
        tabItem.setTitle(dataItem.title ?: "")
        tab.view.setPadding(tabPaddingStart ?: 0, 0, tabPaddingEnd ?: 0, 0)
        tab.customView = tabItem
    }
}

enum class TabType {
    PILL,
    LINE
}
