package com.ixigo.design.sdk.components.topappbar.menu

import android.view.Menu
import android.view.MenuItem

data class MenuBuilder(
    val id: Int = 0,
    val text: CharSequence? = null,
    val icon: Int? = null,
    val groupId: Int = 0,
    val order: Int = Menu.NONE
)
data class IxiMenu(
    val id: Int = 0,
    val text: String? = null,
    val icon: Int? = null,
)

fun List<MenuBuilder>.addMenuItems(menu: Menu) {
    forEach {
        if (it.text != null) {
            menu.add(it.groupId, it.id, it.order, it.text)
        } else {
            it.icon?.let { iconId -> menu.add(it.groupId, it.id, it.order, "").setIcon(iconId) }
        }?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
    }
}

interface IxiMenuProvider {
    fun provideMenu(): List<IxiMenu>
    fun onMenuItemClick(id: Int)
}

