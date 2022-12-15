package com.ixigo.design.sdk.components.topappbar.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.BaseComponent

abstract class BaseTopAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected var state = mutableStateOf(AppBarState())

    fun setTitle(title: String) {
        val initState = state.value
        state.value = initState.copy(title = title)
    }

    fun setSubTitle(subTitle: String) {
        val initState = state.value
        state.value = initState.copy(subTitle = subTitle)
    }

    fun setupActionText(text: String, actionTextClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(actionText = text, actionTextClick = actionTextClick)
    }

    fun setupActionIcon1(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(actionIcon1 = actionIcon, action1Click = actionIconClick)
    }

    fun setupActionIcon2(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(actionIcon2 = actionIcon, action2Click = actionIconClick)
    }

    fun setNavigationIcon(@DrawableRes actionIcon: Int) {
        val initState = state.value
        state.value = initState.copy(homeIcon = actionIcon)
    }

    fun setNavigationOnClickListener(navigationIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(homeIconClick = navigationIconClick)
    }

    fun setupHome(@DrawableRes actionIcon: Int, actionIconClick: () -> Unit) {
        val initState = state.value
        state.value = initState.copy(homeIcon = actionIcon, homeIconClick = actionIconClick)
    }

    fun setupElevation(elevation: Dp) {
        val initState = state.value
        state.value = initState.copy(elevation = elevation)
    }
}

data class AppBarState(
    @DrawableRes val homeIcon: Int = 0,
    val homeIconClick: () -> Unit = {},
    val title: String? = null,
    val subTitle: String? = null,
    val actionText: String? = null,
    val actionTextClick: () -> Unit = {},
    @DrawableRes val actionIcon1: Int = 0,
    val action1Click: () -> Unit = {},
    @DrawableRes val actionIcon2: Int = 0,
    val action2Click: () -> Unit = {},
    val elevation: Dp = 4.dp
)