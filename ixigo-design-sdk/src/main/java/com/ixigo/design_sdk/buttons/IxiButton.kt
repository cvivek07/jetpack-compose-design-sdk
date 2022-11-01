package com.ixigo.design_sdk.buttons

import android.content.Context
import android.opengl.Visibility
import android.util.AttributeSet
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView

class IxiButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    private var state = mutableStateOf(IxiState())

    fun setText(text: String) {
        val inState = state.value
        state.value = inState.copy(text = text)
    }


    fun setClickListener(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    @Composable
    override fun Content() {
        IxigoButton(state.value.text, state.value.onClick)
    }
}

data class IxiState(val text: String = "", val onClick: () -> Unit = {})