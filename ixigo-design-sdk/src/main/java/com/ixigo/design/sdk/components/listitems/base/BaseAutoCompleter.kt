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

    /**
     * Set the title for the auto completer item
     * @param title title to be set
     */
    fun setTitle(title: String) {
        val inState = state.value
        state.value = inState.copy(title = title)
    }

    /**
     * Set the code inside the bordered box
     * @param code value to be set
     */
    fun setIconCode(title: String?) {
        val inState = state.value
        state.value = inState.copy(code = title)
    }

    /**
     * Set the sub title for the item
     * @param subTitle value to be set
     */
    fun setSubTitle(subTitle: String?) {
        val inState = state.value
        state.value = inState.copy(subTitle = subTitle)
    }

    /**
     * Set the drawable resource inside the bordered box
     * @param icon drawable resource to be set
     */
    fun setIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(startIconRes = icon)
    }

    /**
     * Set the drawable resource at the right side of the item
     * @param icon drawable resource to be set
     */
    fun setEndIcon(@DrawableRes icon: Int) {
        val inState = state.value
        state.value = inState.copy(endIconRes = icon)
    }

    /**
     * Set the click event on the icon at right side of item
     * @param onClick event to be set
     */
    fun onEndIconClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onEndIconClick = onClick)
    }

    /**
     * Set the click event on the icon at left side of item
     * @param onClick event to be set
     */
    fun onStartIconClick(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onStartIconClick = onClick)
    }

    /**
     * Set the from value for the item
     * @param value value to be set
     */
    fun setFromValue(value: String) {
        val inState = state.value
        state.value = inState.copy(from = value)
    }

    /**
     * Set the to value for the item
     * @param value value to be set
     */
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