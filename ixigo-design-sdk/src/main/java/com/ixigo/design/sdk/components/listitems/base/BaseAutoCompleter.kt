package com.ixigo.design.sdk.components.listitems.base

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.imageutils.ImageData

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
     * @param title value to be set
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
     * @param imageData [ImageData] object to set resource to be set. If [ImageData] contains both
     * [ImageData.drawable] and [ImageData.drawableRes], [ImageData.drawable] will be used.
     */
    fun setIcon( imageData: ImageData) {
        val inState = state.value
        state.value = inState.copy(startIconData = imageData)
    }

    /**
     * Set the drawable resource at the right side of the item
     * @param imageData [ImageData] object to set resource to be set. If [ImageData] contains both
     * [ImageData.drawable] and [ImageData.drawableRes], [ImageData.drawable] will be used.
     */
    fun setEndIcon( imageData: ImageData) {
        val inState = state.value
        state.value = inState.copy(endIconData = imageData)
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
    val startIconData: ImageData?,
    val title: String?,
    val from: String?,
    val to: String?,
    val subTitle: String?,
    val code: String?,
    val endIconData: ImageData?,
    val onItemClick: () -> Unit,
    val onEndIconClick: () -> Unit,
    val onStartIconClick: () -> Unit,
)