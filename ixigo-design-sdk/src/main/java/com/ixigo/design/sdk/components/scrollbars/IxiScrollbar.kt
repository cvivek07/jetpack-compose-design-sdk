package com.ixigo.design.sdk.components.scrollbars

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.scrollbars.composables.ScrollBar

class IxiScrollbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    var state = mutableStateOf(ScrollBarState())

    fun scrollToPosition(position: Int){
        state.value = state.value.copy(scrollPosition = position)
    }

    fun setItemCount(itemCount: Int){
        state.value = state.value.copy(itemCount =  itemCount)
    }

    @Composable
    override fun Content() {
        with(state.value) {
            ScrollBar(itemCount = this.itemCount,  position = this.scrollPosition)
        }
    }
}

data class ScrollBarState(
    val scrollPosition: Int = 0,
    val itemCount: Int = 0
)