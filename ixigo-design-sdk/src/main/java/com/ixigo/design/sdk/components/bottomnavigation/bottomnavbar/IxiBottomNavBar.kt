package com.ixigo.design.sdk.components.bottomnavigation.bottomnavbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.Menu
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.IxiBottomNavItem
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType
import com.ixigo.design.sdk.utils.Utils

/**
 * Custom BottomNavigationView class that allows for custom items to be added
 *
 * @param context The context in which the view is running
 * @param attrs The attributes of the XML tag that is inflating the view
 */
class IxiBottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BottomNavigationView(context, attrs) {
    /**
     * A list of all [IxiBottomNavItem]s added to this view
     */
    private val bottomNavItemList: MutableList<IxiBottomNavItem> = mutableListOf()

    private var ixiBottomNavItemProvider:IxiBottomNavItemProvider? = null

    /**
     * Inflates the menu for the [IxiBottomNavBar] with the specified number of items
     *
     * @param items The number of items to inflate the menu with
     */
    private fun inflateIxiBottomNavBarMenu(items: Int) {
        this.menu.clear()
        for (i in 0 until items) {
            this.menu.add(Menu.NONE, i, Menu.NONE, "")
        }
    }

    /**
     * Set the [IxiBottomNavItemProvider] for [IxiBottomNavBar].
     *
     * @param ixiBottomNavItemProvider the provider for [IxiBottomNavItem]s
     */
    fun setIxiBottomNavItemProvider(ixiBottomNavItemProvider: IxiBottomNavItemProvider) {
        this.ixiBottomNavItemProvider = ixiBottomNavItemProvider
        setNavigationItems(ixiBottomNavItemProvider.provideMenu())
    }

    /**
     * Updates the selected state of the [IxiBottomNavItem] with the specified id
     *
     * @param id The id of the [IxiBottomNavItem] to update
     * @param selected The new selected state of the [IxiBottomNavItem]
     * @return `true` if the item was successfully updated, `false` otherwise
     */
    fun updatedSelectedIxiItem(id: Int, selected: Boolean): Boolean {
        if (bottomNavItemList.isEmpty()) {
            throw IllegalStateException(ERROR)
        }
        val item = bottomNavItemList.find { it.id == id } ?: return false
        clearAllPreviousSelectedItems()
        item.setItemSelected(selected)
        if (selected) {
            ixiBottomNavItemProvider?.onIxiNavItemSelected(item.id)
        }
        return true
    }

    /**
     * Sets the navigation items for the bottom navigation bar.
     *
     * @param list A list of [IxiBottomNavItem]s to be added to this view
     */
    private fun setNavigationItems(list: List<IxiBottomNavItem>) {
//        this.setPadding(
//            0,
//            Utils.convertPixelsToDp(4f, context = context).toInt(),
//            0,
//            Utils.convertPixelsToDp(14f, context = context).toInt()
//        )
        this.minimumHeight = Utils.convertPixelsToDp(78f, context = context).toInt()
        inflateIxiBottomNavBarMenu(list.size)
        val mbottomNavigationMenuView = this.getChildAt(0) as BottomNavigationMenuView
        list.forEachIndexed { index, bottomNavigationItemView ->
            this.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    bottomNavigationItemView.getIxiColor().bgColor
                )
            )
            val view = mbottomNavigationMenuView.getChildAt(index)
            val itemView = view as BottomNavigationItemView
            val defaultBottomNavigationItemView: IxiBottomNavItem = LayoutInflater.from(context)
                .inflate(
                    R.layout.item_default,
                    mbottomNavigationMenuView,
                    false
                ) as IxiBottomNavItem
            defaultBottomNavigationItemView.id = bottomNavigationItemView.id
            defaultBottomNavigationItemView.onClick {
                defaultBottomNavigationItemView.setItemSelected(!defaultBottomNavigationItemView.isItemSelected())
            }
            with(bottomNavigationItemView) {
                getLabel()?.let {
                    defaultBottomNavigationItemView.setLabel(it)
                }
                getIcon()?.let {
                    defaultBottomNavigationItemView.setIcon(it)
                }
                getSelectedIcon()?.let {
                    defaultBottomNavigationItemView.setSelectedIcon(it)
                }
                getBadgeType()?.let {
                    defaultBottomNavigationItemView.setBadgeType(it)
                }
                getBadgeContent()?.let {
                    defaultBottomNavigationItemView.setBadgeContent(it)
                }
                getIxiColor().let {
                    defaultBottomNavigationItemView.setIxiColor(it)
                }
                defaultBottomNavigationItemView.onClick {
                    clearAllPreviousSelectedItems()
                    defaultBottomNavigationItemView.setItemSelected(!defaultBottomNavigationItemView.isItemSelected())
                    bottomNavigationItemView.getOnCLick().invoke()
                    ixiBottomNavItemProvider?.onIxiNavItemSelected(defaultBottomNavigationItemView.id)
                }
                defaultBottomNavigationItemView.setItemSelected(isItemSelected())
            }
            bottomNavItemList.add(defaultBottomNavigationItemView)
            itemView.addView(defaultBottomNavigationItemView)
        }
    }

    /**
     * Clears the selection of all previous bottom navigation items.
     */
    private fun clearAllPreviousSelectedItems() {
        bottomNavItemList.forEach {
            it.setItemSelected(false)
        }
    }

    /**
     * Clears the badge of the bottom navigation item with the specified ID.
     *
     * @param id The ID of the bottom navigation item.
     * @return true if the badge is cleared successfully, false if the item with the specified ID is not found.
     * @throws IllegalStateException if there are no bottom navigation items set.
     */
    fun clearBadge(id: Int): Boolean {
        if (bottomNavItemList.isEmpty()) {
            throw IllegalStateException(ERROR)
        }
        val item = bottomNavItemList.find { it.id == id } ?: return false
        item.setBadgeType(null)
        return true
    }

    /**
     * Sets the badge for the bottom navigation item with the specified ID.
     *
     * @param id The ID of the bottom navigation item.
     * @param badgeType The type of badge to set.
     * @param badgeContent The content of the badge. Can be null.
     * @return true if the badge is set successfully, false if the item with the specified ID is not found.
     * @throws IllegalStateException if there are no bottom navigation items set.
     */
    fun setBadge(id: Int, badgeType: BadgeType, badgeContent: String? = null): Boolean {
        if (bottomNavItemList.isEmpty()) {
            throw IllegalStateException(ERROR)
        }
        val item = bottomNavItemList.find { it.id == id } ?: return false
        item.setBadgeType(badgeType)
        badgeContent?.let {
            item.setBadgeContent(badgeContent)
        }
        return true
    }

    companion object {
        /**
         * Error message thrown when no bottom navigation items are found.
         */
        const val ERROR =
            "No IxiBottomNavItem found, please set item using setIxiBottomNavItemProvider before calling this function"
    }

    /**
     * Interface for providing [IxiBottomNavItem]s for [IxiBottomNavBar]
     *
     * Implement this interface activity or fragment and pass it to [IxiBottomNavBar]
     * using [setIxiBottomNavItemProvider].
     */
    interface IxiBottomNavItemProvider {
        /**
         * Provide the list of [IxiBottomNavItem]s to be displayed in [IxiBottomNavBar].
         *
         * @return list of [IxiBottomNavItem]s to be displayed in [IxiBottomNavBar].
         */
        fun provideMenu(): List<IxiBottomNavItem>
        /**
         * Called when an item in the navigation menu is selected.
         *
         * @param id the selected item id
         */
        fun onIxiNavItemSelected(id: Int)
    }

}