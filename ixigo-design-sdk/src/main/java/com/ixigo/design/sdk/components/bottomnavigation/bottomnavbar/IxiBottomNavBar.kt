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

class IxiBottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BottomNavigationView(context, attrs) {
    val bottomNavItemList: MutableList<IxiBottomNavItem> = mutableListOf()
    private var onIxiItemSelectedListener: OnIxiItemSelectedListener? = null

    private fun inflateIxiBottomNavBarMenu(items: Int) {
        this.menu.clear()
        for (i in 0 until items) {
            this.menu.add(Menu.NONE, i, Menu.NONE, "")
        }
    }

    fun setOnIxiItemSelectedListener(onIxiItemSelectedListener: OnIxiItemSelectedListener) {
        this.onIxiItemSelectedListener = onIxiItemSelectedListener
    }

    fun updatedSelectedIxiItem(id: Int, selected: Boolean): Boolean {
        if (bottomNavItemList.isEmpty()) {
            throw IllegalStateException(ERROR)
        }
        val item = bottomNavItemList.find { it.id == id } ?: return false
        clearAllPreviousSelectedItems()
        item.setItemSelected(selected)
        if (selected) {
            onIxiItemSelectedListener?.onNavigationItemSelected(item)
        }
        return true
    }

    fun setNavigationItems(list: List<IxiBottomNavItem>) {
        this.setPadding(
            0,
            Utils.convertPixelsToDp(4f, context = context).toInt(),
            0,
            Utils.convertPixelsToDp(14f, context = context).toInt()
        )
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
                defaultBottomNavigationItemView.setItemType(getItemType())
                defaultBottomNavigationItemView.onClick {
                    clearAllPreviousSelectedItems()
                    defaultBottomNavigationItemView.setItemSelected(!defaultBottomNavigationItemView.isItemSelected())
                    bottomNavigationItemView.getOnCLick().invoke()
                    onIxiItemSelectedListener?.onNavigationItemSelected(
                        defaultBottomNavigationItemView
                    )
                }
                defaultBottomNavigationItemView.setItemSelected(isItemSelected())
            }
            bottomNavItemList.add(defaultBottomNavigationItemView)
            itemView.addView(defaultBottomNavigationItemView)
        }
    }

    private fun clearAllPreviousSelectedItems() {
        bottomNavItemList.forEach {
            it.setItemSelected(false)
        }
    }

    fun clearBadge(id: Int): Boolean {
        if (bottomNavItemList.isEmpty()) {
            throw IllegalStateException(ERROR)
        }
        val item = bottomNavItemList.find { it.id == id } ?: return false
        item.setBadgeType(null)
        return true
    }

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

    interface OnIxiItemSelectedListener {
        /**
         * Called when an item in the navigation menu is selected.
         *
         * @param item The selected item
         * @return true to display the item as the selected item and false if the item should not be
         * selected. Consider setting non-selectable items as disabled preemptively to make them
         * appear non-interactive.
         */
        fun onNavigationItemSelected(item: IxiBottomNavItem): Boolean
    }

    companion object {
        const val ERROR =
            "No IxiBottomNavItem found, please set item using setNavigationItems(list: List<IxiBottomNavItem>) before calling this function"
    }

}