package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType
import com.ixigo.design.sdk.components.styles.IxiColor

/**
 * BaseBottomNavItem is an abstract class that serves as the base for creating bottom navigation items in our design system.
 * It extends the [BaseComponent] class and holds a mutable state of [BottomNavItemState].
 * @constructor Creates a new instance of [BaseBottomNavItem].
 * @param context: The context where the class is instantiated
 * @param attrs: The attribute set that can be used to set the properties of the class
 * @param defStyleAttr: The default style attribute for the class
 * The class provides several functions to set and get the properties of the bottom navigation item, such as icon, selected icon, label, and so on.
 * It also provides a function onClick to handle the click event of the item.
 */
abstract class BaseBottomNavItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(BottomNavItemState(ixiColor = mapColor(themeColor)))

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

    /**
     * Sets the view id for the [BaseBottomNavItem].
     *
     * @param id The id to be set for the [BaseBottomNavItem].
     */
    private fun setViewId(id: Int) {
        this.id = id
    }

    /**
     * setIcon sets the icon for the bottom navigation item.
     * @param icon: The resource id of the icon
     */
    fun setIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(icon = icon)
    }

    /**
     * getIcon gets the icon for the bottom navigation item.
     * @return Int? : The resource id of the icon
     */
    fun getIcon(): Int? {
        return state.value.icon
    }

    /**
     * setSelectedIcon sets the selected icon for the bottom navigation item.
     * @param icon: The resource id of the selected icon
     */
    fun setSelectedIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(selectedIcon = icon)
    }

    /**
     * getSelectedIcon gets the selected icon for the bottom navigation item.
     * @return Int? : The resource id of the selected icon
     */
    fun getSelectedIcon(): Int? {
        return state.value.selectedIcon
    }

    /**
     * setLabel sets the label for the bottom navigation item.
     * @param label: The string value of the label
     */
    fun setLabel(label: String) {
        val inState = state.value
        state.value = inState.copy(label = label)
    }

    /**
     * Returns the label of the current state.
     *
     * @return the label of the current state.
     */
    fun getLabel(): String? {
        return state.value.label
    }

    /**
     * Sets the selected state of the item.
     *
     * @param selected the selected state of the item.
     */
    fun setItemSelected(selected: Boolean) {
        val inState = state.value
        state.value = inState.copy(selected = selected)
    }

    /**
     * Returns the selected state of the item.
     *
     * @return the selected state of the item.
     */
    fun isItemSelected(): Boolean {
        return state.value.selected
    }

    /**
     * Sets the onClick function of the item.
     *
     * @param onClick the onClick function of the item.
     */
    fun onClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    /**
     * Returns the onClick function of the item.
     *
     * @return the onClick function of the item.
     */
    fun getOnCLick(): () -> Unit {
        return state.value.onClick
    }

    /**
     * Sets the badge type of the item.
     *
     * @param badgeType the badge type of the item.
     */
    fun setBadgeType(badgeType: BadgeType? = null) {
        val inState = state.value
        state.value = inState.copy(badgeType = badgeType)
    }

    /**
     * Returns the badge type of the item.
     *
     * @return the badge type of the item.
     */
    fun getBadgeType(): BadgeType? {
        return state.value.badgeType
    }

    /**
     * Sets the badge content of the item.
     *
     * @param badgeContent the badge content of the item. (if the badge type is set to large)
     */
    fun setBadgeContent(badgeContent: String) {
        val inState = state.value
        state.value = inState.copy(badgeContent = badgeContent)
    }

    /**
     * Returns the badge content of the item.
     *
     * @return the badge content of the item.
     */
    fun getBadgeContent(): String? {
        return state.value.badgeContent
    }

    /**
     * Sets the ixi color of the item.
     *
     * @param ixiColor the ixi color of the item.
     */
    fun setIxiColor(ixiColor: IxiColor) {
        val inState = state.value
        state.value = inState.copy(ixiColor = mapColor(ixiColor))
    }

    /**
     * Returns the ixi color of the item.
     *
     * @return the ixi color of the item.
     */
    fun getIxiColor(): IxiColor {
        return state.value.ixiColor
    }

    private fun mapColor(colors: IxiColor) = when (colors) {
        IxiColor.Blue -> IxiColor.BlueBottomNavbar
        IxiColor.Orange -> IxiColor.OrangeBottomNavbar
        else -> colors
    }


}

/**
 * Data class representing the state of a bottom navigation item.
 *
 * @property icon the resource ID of the icon to be displayed.
 * @property selectedIcon the resource ID of the selected icon to be displayed.
 * @property label the label of the item.
 * @property selected the selected state of the item.
 * @property onClick the onClick function of the item.
 * @property badgeType The type of badge to display.
 * @property badgeContent The content of the badge to display.
 * @property ixiColor The color of the item.
 */
data class BottomNavItemState(
    @DrawableRes val icon: Int? = null,
    @DrawableRes val selectedIcon: Int? = null,
    val label: String? = null,
    val selected: Boolean = false,
    val onClick: (() -> Unit) = {},
    val badgeType: BadgeType? = null,
    val badgeContent: String? = null,
    val ixiColor: IxiColor
)