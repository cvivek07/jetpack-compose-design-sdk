package com.ixigo.design_sdk.components.text

import android.content.Context
import android.util.AttributeSet
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ixigo.design_sdk.components.styles.IxiFamily
import com.ixigo.design_sdk.components.text.composable.TypographyText

class Text @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    protected val state = mutableStateOf(
        TextState("", com.ixigo.design_sdk.components.styles.Typography.Heading.DisplayLarge500)
    )

    fun setText(text: String) {
        state.value = state.value.copy(text = text)
    }

    fun setTypography(typo: TextStyle) {
        state.value = state.value.copy(textStyle = typo)
    }

    @Composable
    override fun Content() {
        TypographyText(text=state.value.text, textStyle = state.value.textStyle)
    }
}

data class TextState(val text: String, val textStyle: TextStyle)