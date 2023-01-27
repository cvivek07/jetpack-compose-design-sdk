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
        super.setPadding(left, top, right, bottom)
    }

    fun setTitle(title: String) {
        val inState = state.value
        state.value = inState.copy(title = title)
    }

    fun setMetaText(title: String?) {
        val inState = state.value
        state.value = inState.copy(metaText = title)
    }

    fun setActionText(title: String?) {
        val inState = state.value
        state.value = inState.copy(endActionText = title)
    }

    fun setActionTextClickListener(clickAction: (() -> Unit)?) {
        val inState = state.value
        state.value = inState.copy(endActionClick = clickAction)
    }

    fun setStartCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(startCheckedValue = initialValue)
    }

    fun setStartCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(startCheckChangeListener = checkChangeListener)
    }

    fun setEndCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(endCheckedValue = initialValue)
    }

    fun setEndCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(endCheckChangeListener = checkChangeListener)
    }

    fun setSwitchCheckedValue(initialValue: Boolean) {
        val inState = state.value
        state.value = inState.copy(endSwitchValue = initialValue)
    }

    fun setSwitchCheckedChangeListener(checkChangeListener: (Boolean) -> Unit) {
        val inState = state.value
        state.value = inState.copy(endSwitchChangeListener = checkChangeListener)
    }

    fun setSubTitle(subTitle: String?) {
        val inState = state.value
        state.value = inState.copy(subTitle = subTitle)
    }

    fun setStartIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startIcon = icon)
    }

    fun setEndIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(endIcon = icon)
    }

    fun setAvatarUrl(avatar: String?) {
        val inState = state.value
        state.value = inState.copy(startAvatarUrl = avatar)
    }

    fun setThemeColor(color: IxiColor) {
        val inState = state.value

        state.value = inState.copy(color = color)
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