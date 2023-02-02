package com.ixigo.design.sdk.components.tabs.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent

abstract class BaseTabItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(TabItemState())

    fun setStartDrawable(@DrawableRes startDrawable: Int) {
        val initState = state.value
        state.value = initState.copy(startDrawable = startDrawable)
    }

    fun setEndDrawable(@DrawableRes endDrawable: Int) {
        val initState = state.value
        state.value = initState.copy(endDrawable = endDrawable)
    }

    fun setTitle(title: String) {
        val initState = state.value
        state.value = initState.copy(title = title)
    }

    override fun setSelected(isSelected: Boolean) {
        val initState = state.value
        state.value = initState.copy(isSelected = isSelected)
    }
}


data class TabItemState(
    @DrawableRes val startDrawable: Int = 0,
    @DrawableRes val endDrawable: Int = 0,
    val title: String? = null,
    val isSelected: Boolean = false
)