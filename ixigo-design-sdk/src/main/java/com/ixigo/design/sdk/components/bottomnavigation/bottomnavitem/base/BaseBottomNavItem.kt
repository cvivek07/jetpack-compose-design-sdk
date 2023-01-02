package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.ItemType
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseBottomNavItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(BottomNavItemState())

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseBottomNavItem)
        try {
            setIcon(typedArray.getResourceId(R.styleable.BaseBottomNavItem_android_icon, 0))
            setSelectedIcon(typedArray.getResourceId(R.styleable.BaseBottomNavItem_selectedIcon, 0))
            typedArray.getString(R.styleable.BaseBottomNavItem_itemLabel)?.let {
                setLabel(it)
            }
            setItemSelected(typedArray.getBoolean(R.styleable.BaseBottomNavItem_selected, false))
            setViewId(View.generateViewId())
        } finally {
            typedArray.recycle()
        }
    }

    private fun setViewId(id: Int) {
        this.id = id
    }

    fun setIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(icon = icon)
    }

    fun getIcon(): Int? {
        return state.value.icon
    }

    fun setSelectedIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(selectedIcon = icon)
    }

    fun getSelectedIcon(): Int? {
        return state.value.selectedIcon
    }

    fun setLabel(label: String) {
        val inState = state.value
        state.value = inState.copy(label = label)
    }

    fun getLabel(): String? {
        return state.value.label
    }

    fun setItemSelected(selected: Boolean) {
        val inState = state.value
        state.value = inState.copy(selected = selected)
    }

    fun isItemSelected(): Boolean {
        return state.value.selected
    }

    fun onClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    fun getOnCLick(): () -> Unit {
        return state.value.onClick
    }

    fun setBadgeType(badgeType: BadgeType? = null) {
        val inState = state.value
        state.value = inState.copy(badgeType = badgeType)
    }

    fun getBadgeType(): BadgeType? {
        return state.value.badgeType
    }

    fun setBadgeContent(badgeContent: String) {
        val inState = state.value
        state.value = inState.copy(badgeContent = badgeContent)
    }

    fun getBadgeContent(): String? {
        return state.value.badgeContent
    }

    fun setIxiColor(ixiColor: IxiColor) {
        val inState = state.value
        state.value = inState.copy(ixiColor = ixiColor)
    }

    fun getIxiColor(): IxiColor {
        return state.value.ixiColor
    }

    fun setItemType(itemType: ItemType) {
        val inState = state.value
        state.value = inState.copy(itemType = itemType)
    }

    fun getItemType(): ItemType {
        return state.value.itemType
    }


}

data class BottomNavItemState(
    @DrawableRes val icon: Int? = null,
    @DrawableRes val selectedIcon: Int? = null,
    val label: String? = null,
    val selected: Boolean = false,
    val onClick: (() -> Unit) = {},
    val badgeType: BadgeType? = null,
    val badgeContent: String? = null,
    val itemType: ItemType = ItemType.FILLED,
    val ixiColor: IxiColor = IxiColor.BlueBottomNavbarAndroid
)