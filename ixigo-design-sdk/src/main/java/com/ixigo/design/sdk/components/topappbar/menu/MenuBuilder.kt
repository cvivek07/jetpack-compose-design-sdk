package com.ixigo.design.sdk.components.topappbar.menu

import android.view.Menu
import android.view.MenuItem
import androidx.core.view.MenuItemCompat
import com.ixigo.design.sdk.R

data class MenuBuilder(
    val id: Int = 0,
    val text: CharSequence? = null,
    val icon: Int? = null,
    val groupId: Int = 0,
    val order: Int = Menu.NONE
) {

}

fun List<MenuBuilder>.addMenuItems(menu: Menu) {
    forEach {
        if (it.text != null) {
            menu.add(it.groupId, it.id, it.order, it.text)
        } else {
            it.icon?.let { iconId -> menu.add(it.groupId, it.id, it.order, "").setIcon(iconId) }
        }?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
    }
}

object MenuProvider {
    fun getSingleOptionMenuProvider() {

    }
}

