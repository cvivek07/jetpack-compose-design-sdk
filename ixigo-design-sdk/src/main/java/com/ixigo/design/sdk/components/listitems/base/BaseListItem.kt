package com.ixigo.design.sdk.components.listitems.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.imageutils.ImageData
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
                color = themeColor,
            )
        )

    override fun setPadding(left: Int, top: Int, right: Int, bottom: Int) {
        val currState = state.value
        state.value = currState.copy(
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
    fun setStartIcon(icon: ImageData?) {
        val currState = state.value
        state.value = currState.copy(startIcon = icon)
    }

    /**
     * Set the end icon.
     * @param icon The drawable resource id of the end icon.
     */
    fun setEndIcon(icon: ImageData?) {
        val currState = state.value
        state.value = currState.copy(endIcon = icon)
    }


    /**
     * Set the avatar URL.
     * @param avatar The URL of the avatar.
     */
    fun setAvatar(avatar: ImageData?) {
        val currState = state.value
        state.value = currState.copy(startAvatar = avatar)
    }

    /**
     * Set the start logo URL.
     * @param logoUrl The URL of the start logo.
     */
    fun setStartLogo(logoUrl: ImageData?) {
        val currState = state.value
        state.value = currState.copy(startLogo = logoUrl)
    }

    /**
     * set the initial state of the start checkbox. Providing this will make the checkbox visible.
     * @param value checkbox will be checked if true else unchecked
     */
    fun setStartCheckedValue(value: Boolean?) {
        val currState = state.value
        state.value = currState.copy(startCheckedValue = value)
    }

    /**
     * get the  checked state of the end CheckBox. Returns null if Checkbox is not drawn
     */
    fun getStartCheckedValue(): Boolean? {
        return state.value.startCheckedValue
    }


    /**
     * set the check change listener for the start CheckBox.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setStartCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val currState = state.value
        state.value = currState.copy(startCheckChangeListener = checkChangeListener)
    }

    /**
     * set the initial state of the start RadioButton. Providing this will make the RadioButton visible.
     * @param value radio button will be checked if true, unchecked if false and will not be drawn otherwise
     */
    fun setStartRadioValue(value: Boolean?) {
        val currState = state.value
        state.value = currState.copy(startRadioValue = value)
    }

    /**
     * get the checked state of the Start Radio Button.. Returns null if RadioButton is not drawn
     */
    fun getStartRadioValue(): Boolean? {
        return state.value.startRadioValue
    }

    /**
     * set the check change listener for the end Radio Button.
     * @param radioChangeListener checkChangeListener lambda
     */
    fun setStartRadioChangeListener(radioChangeListener: (Boolean) -> Unit) {
        val currState = state.value
        val internalListener: (Boolean) -> Unit = { bool ->
            state.value = state.value.copy(startRadioValue = bool)
            radioChangeListener(bool)
        }
        state.value = currState.copy(startRadioChangeListener = internalListener)
    }

    /**
     * Set the theme color for the list item. Setting this value will cause each item
     * like CheckBox, Switch and Action Text Color
     * @param color Color to be set
     */
    fun setThemeColor(color: IxiColor) {
        val currState = state.value
        state.value = currState.copy(color = color)
    }


    /**
     * Set the Title for this ListItem
     * @param title title to be set
     */
    fun setTitle(title: String) {
        val currState = state.value
        state.value = currState.copy(title = title)
    }

    /**
     * Set the SubTitle for this ListItem
     * @param subTitle subtitle to be set
     */
    fun setSubTitle(subTitle: String?) {
        val currState = state.value
        state.value = currState.copy(subTitle = subTitle)
    }

    /**
     * Set the Meta text value for this ListItem
     * @param metaText meta text value to be set
     */
    fun setMetaText(metaText: String?) {
        val currState = state.value
        state.value = currState.copy(metaText = metaText)
    }

    /**
     * Set the end logo URL.
     * @param logoUrl The URL of the end logo.
     */
    fun setEndLogoUrl(logoUrl: ImageData?) {
        val currState = state.value
        state.value = currState.copy(endLogo = logoUrl)
    }


    /**
     * set the initial state of the end checkbox. Providing this will make the checkbox visible.
     * @param value checkbox will be checked if true, unchecked if false and will not be drawn otherwise
     */
    fun setEndCheckedValue(value: Boolean?) {
        val currState = state.value
        state.value = currState.copy(endCheckedValue = value)
    }

    /**
     * get the  checked state of the end CheckBox. Returns null if Checkbox is not drawn
     */
    fun getEndCheckedValue(): Boolean? {
        return state.value.endCheckedValue
    }

    /**
     * set the initial state of the end RadioButton. Providing this will make the RadioButton visible.
     * @param value radio button will be checked if true, unchecked if false and will not be drawn otherwise
     */
    fun setEndRadioValue(value: Boolean?) {
        val currState = state.value
        state.value = currState.copy(endRadioValue = value)
    }

    /**
     * get the  checked state of the end End Radio Button.. Returns null if RadioButton is not drawn
     */
    fun getEndRadioValue(): Boolean? {
        return state.value.endRadioValue
    }

    /**
     * set the check change listener for the end Radio Button.
     * @param radioChangeListener checkChangeListener lambda
     */
    fun setEndRadioChangeListener(radioChangeListener: (Boolean) -> Unit) {
        val currState = state.value
        state.value = currState.copy(endRadioChangeListener = radioChangeListener)
    }


    /**
     * set the check change listener for the end CheckBox.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setEndCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val currState = state.value
        state.value = currState.copy(endCheckChangeListener = checkChangeListener)
    }


    /**
     * set the state of the end Switch. Providing this will make the Switch visible.
     * @param value switch will be checked if true, unchecked if false and will not be drawn otherwise
     */
    fun setSwitchCheckedValue(value: Boolean?) {
        val currState = state.value
        state.value = currState.copy(endSwitchValue = value)
    }

    /**
     * get the  checked state of the end Switch. Returns null if switch is not visible
     */
    fun getSwitchCheckedValue(): Boolean? {
        return state.value.endSwitchValue
    }

    /**
     * set the check change listener for the end Switch.
     * @param checkChangeListener checkChangeListener lambda
     */
    fun setSwitchCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val currState = state.value
        state.value = currState.copy(endSwitchChangeListener = checkChangeListener)
    }

    /**
     * Set the text value for text button
     * @param text text to be set
     */
    fun setActionText(text: String?) {
        val currState = state.value
        state.value = currState.copy(endActionText = text)
    }

    /**
     * Set the click listener for text button
     * @param clickAction click lambda
     */
    fun setActionTextClickListener(clickAction: (() -> Unit)?) {
        val currState = state.value
        state.value = currState.copy(endActionClick = clickAction)
    }


    private fun setItemClickListener(onClick: () -> Unit) {
        val currState = state.value
        state.value = currState.copy(onItemClick = onClick)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        setItemClickListener {
            l?.onClick(this)
        }
    }
}

data class ListItemDataState(
    val paddingValues: PaddingValues = PaddingValues(top = 10.dp, bottom = 10.dp, start = 4.dp, end = 4.dp),
    val startIcon: ImageData? = null,
    val startAvatar: ImageData? = null,
    val startLogo: ImageData? = null,
    val startRadioValue: Boolean? = null,
    val startRadioChangeListener: (Boolean) -> Unit = {},
    val startCheckedValue: Boolean? = null,
    val startCheckChangeListener: (Boolean) -> Unit = {},
    val color: IxiColor,
    val title: String,
    val subTitle: String? = null,
    val metaText: String? = null,
    val endIcon: ImageData? = null,
    val endLogo: ImageData? = null,
    @ColorRes val itemBackGroundColor: Int =  R.color.n0,
    val endCheckedValue: Boolean? = null,
    val endCheckChangeListener: (Boolean) -> Unit = {},
    val endSwitchValue: Boolean? = null,
    val endSwitchChangeListener: (Boolean) -> Unit = {},
    val endRadioValue: Boolean? = null,
    val endRadioChangeListener: (Boolean) -> Unit = {},
    val endActionText: String? = null,
    val endActionClick: (() -> Unit)? = null,
    val onItemClick: (() -> Unit) = {},
) {

}