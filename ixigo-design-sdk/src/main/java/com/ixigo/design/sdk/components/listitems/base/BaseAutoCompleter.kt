package com.ixigo.design.sdk.components.listitems.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent

abstract class BaseAutoCompleter @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state =
        mutableStateOf(AutoCompleterDataState(null, null, null, null, null, null, null, {}, {}, {}))


    fun setTitle(title: String) {
        val inState = state.value
        state.value = inState.copy(title = title)
    }

    fun setIconCode(title: String?) {
        val inState = state.value
        state.value = inState.copy(code = title)
    }

    fun setSubTitle(subTitle: String?) {
        val inState = state.value
        state.value = inState.copy(subTitle = subTitle)
    }

    fun setIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startIconRes = icon)
    }

    fun setEndIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(endIconRes = icon)
    }

    fun onEndIconClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onEndIconClick = onClick)
    }

    fun onStartIconClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onStartIconClick = onClick)
    }


    fun setFromValue(value: String) {
        val inState = state.value
        state.value = inState.copy(from = value)
    }

    fun setToValue(value: String) {
        val inState = state.value
        state.value = inState.copy(to = value)
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

data class AutoCompleterDataState(
    val startIconRes: Int?,
    val title: String?,
    val from: String?,
    val to: String?,
    val subTitle: String?,
    val code: String?,
    val endIconRes: Int?,
    val onItemClick: () -> Unit,
    val onEndIconClick: () -> Unit,
    val onStartIconClick: () -> Unit,
)