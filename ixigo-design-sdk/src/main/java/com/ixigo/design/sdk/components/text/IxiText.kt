package com.ixigo.design.sdk.components.text

import android.content.Context
import android.util.AttributeSet
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.components.styles.IxiFamily
import com.ixigo.design.sdk.components.styles.IxiTypography

class Text @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AbstractComposeView(context, attrs, defStyleAttr) {

    protected val state = mutableStateOf(
        TextState("", IxiTypography.Heading.DisplayLarge.regular)
    )

    fun setText(text: String) {
        state.value = state.value.copy(text = text)
    }

    fun setTypography(typo: TextStyle) {
        state.value = state.value.copy(textStyle = typo)
    }

    @Composable
    override fun Content() {
        Text(
            text = state.value.text,
            fontSize = state.value.textStyle.fontSize,
            fontWeight = state.value.textStyle.fontWeight,
            fontFamily = IxiFamily,
            letterSpacing = 0.sp,
            color = state.value.textStyle.color,
            textDecoration = state.value.textStyle.textDecoration,
            fontStyle = state.value.textStyle.fontStyle,
            lineHeight = state.value.textStyle.lineHeight
        )

    }

}

data class TextState(val text: String, val textStyle: TextStyle)