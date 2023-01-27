package com.ixigo.design.sdk.components.listitems.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseListItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state =
        mutableStateOf(
            ListItemDataState(
                paddingValues = PaddingValues(
                    top = 10.dp,
                    bottom = 10.dp,
                    start = 4.dp,
                    end = 4.dp
                ),
                title = "",
                color = themeColor
            )
        )

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        val inState = state.value
        state.value = inState.copy(
            paddingValues = PaddingValues(
                top = top.dp,
                bottom = bottom.dp,
                start = left.dp,
                end = right.dp
            )
        )
    }

    /**
     * Sets the start icon for the ListItem.
     * @param icon The drawable resource ID of the start icon.
     */
    fun setStartIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startIcon = icon)
    }

    /**
     * Set the size of the start icon.
     * @param widthInDp The width of the start icon in dp.
     * @param heightInDp The height of the start icon in dp.
     */
    fun setStartIconSize(widthInDp: Int, heightInDp: Int) {
        val inState = state.value
        state.value = inState.copy(startIconWidth = widthInDp.dp, startIconHeight = heightInDp.dp)
    }

    /**
     * Set the end icon.
     * @param icon The drawable resource id of the end icon.
     */
    fun setEndIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(endIcon = icon)
    }

    /**
     * Set the size of the end icon.
     * @param widthInDp The width of the end icon in dp.
     * @param heightInDp The height of the end icon in dp.
     */
    fun setEndIconSize(widthInDp: Int, heightInDp: Int) {
        val inState = state.value
        state.value = inState.copy(endIconWidth = widthInDp.dp, endIconHeight = heightInDp.dp)
    }


    /**
     * Set the avatar URL.
     * @param avatar The URL of the avatar.
     */
    fun setAvatarUrl(avatar: String?) {
        val inState = state.value
        state.value = inState.copy(startAvatarUrl = avatar)
    }


    /**
     * Set the avatar place holder.
     * @param icon The drawable resource id of the avatar place holder.
     */
    fun setAvatarPlaceHolder(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startAvatarPlaceHolder = icon)
    }

    /**
     * Set the size of the avatar.
     * @param widthInDp The width of the avatar in dp.
     * @param heightInDp The height of the avatar in dp.
     */
    fun setAvatarSize(widthInDp: Int, heightInDp: Int) {
        val inState = state.value
        state.value =
            inState.copy(startAvatarWidth = widthInDp.dp, startAvatarHeight = heightInDp.dp)
    }

    /**
     * Set the start logo URL.
     * @param logoUrl The URL of the start logo.
     */
    fun setStartLogoUrl(logoUrl: String?) {
        val inState = state.value
        state.value = inState.copy(startLogoUrl = logoUrl)
    }

    /**
     * Set the start logo icon.
     * @param icon The drawable resource id of the start logo icon.
     */
    fun setStartLogoIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startLogo = icon)
    }

    /**
     * Set the size of the start logo.
     * @param widthInDp The width of the start logo in dp.
     * @param heightInDp The height of the start logo in dp.
     */
    fun setStartLogoSize(widthInDp: Int, heightInDp: Int) {
        val inState = state.value
        state.value = inState.copy(startLogoWidth = widthInDp.dp, startLogoHeight = heightInDp.dp)
    }


    /**
     * set the initial state of the start checkbox. Providing this will make the checkbox visible.
     * @param initialValue checkbox will be checked if true else unchecked
     */
    fun setStartCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(startCheckedValue = initialValue)
    }

    /**
     * set the check change listener for the start CheckBox.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setStartCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(startCheckChangeListener = checkChangeListener)
    }

    /**
     * Set the theme color for the list item. Setting this value will cause each item
     * like CheckBox, Switch and Action Text Color
     * @param color Color to be set
     */
    fun setThemeColor(color: IxiColor) {
        val inState = state.value
        state.value = inState.copy(color = color)
    }


    /**
     * Set the Title for this ListItem
     * @param title title to be set
     */
    fun setTitle(title: String) {
        val inState = state.value
        state.value = inState.copy(title = title)
    }

    /**
     * Set the SubTitle for this ListItem
     * @param subTitle subtitle to be set
     */
    fun setSubTitle(subTitle: String?) {
        val inState = state.value
        state.value = inState.copy(subTitle = subTitle)
    }

    /**
     * Set the Meta text value for this ListItem
     * @param metaText meta text value to be set
     */
    fun setMetaText(metaText: String?) {
        val inState = state.value
        state.value = inState.copy(metaText = metaText)
    }

    /**
     * Set the end logo URL.
     * @param logoUrl The URL of the end logo.
     */
    fun setEndLogoUrl(logoUrl: String?) {
        val inState = state.value
        state.value = inState.copy(endLogoUrl = logoUrl)
    }

    /**
     * Sets the end icon for the list item.
     * @param icon The drawable resource ID of the end icon.
     */
    fun setEndLogoIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(endLogo = icon)
    }

    /**
     * Set the size of the end icon.
     * @param widthInDp The width of the end icon in dp.
     * @param heightInDp The height of the end icon in dp.
     */
    fun setEndLogoSize(widthInDp: Int, heightInDp: Int) {
        val inState = state.value
        state.value = inState.copy(endLogoWidth = widthInDp.dp, endLogoHeight = heightInDp.dp)
    }

    /**
     * set the initial state of the end checkbox. Providing this will make the checkbox visible.
     * @param initialValue checkbox will be checked if true else unchecked
     */
    fun setEndCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(endCheckedValue = initialValue)
    }

    /**
     * set the check change listener for the end CheckBox.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setEndCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(endCheckChangeListener = checkChangeListener)
    }


    /**
     * set the initial state of the start Switch. Providing this will make the Switch visible.
     * @param initialValue checkbox will be checked if true else unchecked
     */
    fun setSwitchCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(endSwitchValue = initialValue)
    }


    /**
     * set the check change listener for the end Switch.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setSwitchCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(endSwitchChangeListener = checkChangeListener)
    }

    /**
     * Set the text value for text button
     * @param text text to be set
     */
    fun setActionText(text: String?) {
        val inState = state.value
        state.value = inState.copy(endActionText = text)
    }

    /**
     * Set the click listener for text button
     * @param clickAction click lambda
     */
    fun setActionTextClickListener(clickAction: (() -> Unit)?) {
        val inState = state.value
        state.value = inState.copy(endActionClick = clickAction)
    }

    private fun setItemClickListener(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onItemClick = onClick)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        setItemClickListener {
            l?.onClick(this)
        }
    }
}

data class ListItemDataState(
    val paddingValues: PaddingValues,
    @DrawableRes val startIcon: Int? = null,
    val startIconWidth: Dp? = 18.dp,
    val startIconHeight: Dp? = 18.dp,
    val startAvatarUrl: String? = null,
    @DrawableRes val startAvatarPlaceHolder: Int? = null,
    val startAvatarWidth: Dp? = 40.dp,
    val startAvatarHeight: Dp? = 40.dp,
    @DrawableRes val startLogo: Int? = null,
    val startLogoUrl: String? = null,
    val startLogoWidth: Dp? = 50.dp,
    val startLogoHeight: Dp? = 50.dp,
    val startCheckedValue: Boolean? = null,
    val startCheckChangeListener: (Boolean) -> Unit = {},
    val color: IxiColor,
    val title: String,
    val subTitle: String? = null,
    val metaText: String? = null,
    val endIcon: Int? = null,
    val endIconWidth: Dp? = 18.dp,
    val endIconHeight: Dp? = 18.dp,
    val endLogo: Int? = null,
    val endLogoUrl: String? = null,
    val endLogoWidth: Dp? = 50.dp,
    val endLogoHeight: Dp? = 50.dp,
    val endCheckedValue: Boolean? = null,
    val endCheckChangeListener: (Boolean) -> Unit = {},
    val endSwitchValue: Boolean? = null,
    val endSwitchChangeListener: (Boolean) -> Unit = {},
    val endActionText: String? = null,
    val endActionClick: (() -> Unit)? = null,
    val onItemClick: (() -> Unit) = {}
)