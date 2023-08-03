package com.ixigo.design.sdk.components.text

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.updateHeight
import com.ixigo.design.sdk.components.buttons.composable.updateWidth
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.Highlight
import com.ixigo.design.sdk.components.text.composable.ClickableTextComposable


class IxiClickableText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IxiText(context, attrs, defStyleAttr) {

    private var defaultTypography: IxiTypography.TypographyType = IxiTypography.Body.Small
    private var defaultTextStyle = defaultTypography.regular

    private val state = mutableStateOf(
        ClickableTextState(
            text = "",
            textStyle = defaultTextStyle,
            onClick = null,
            maxLines = Int.MAX_VALUE,
            vAlignment = Alignment.Top,
            hAlignment = Alignment.Start,
            textAlign = TextAlign.Left,
            overflow = TextOverflow.Visible,
            highlightTexts = listOf()
        )
    )

    fun setOriginalText(text: String){
        state.value = state.value.copy(text = text)
    }

    fun setOriginalTextColor(@ColorInt color: Int) {
        val style = state.value.textStyle.copy(color = Color(color))
        state.value = state.value.copy(textStyle = style)
    }

    fun setHighlightedText(list: List<Highlight>) {
        state.value = state.value.copy(highlightTexts = list)
    }

    fun setHighlightColor(@ColorRes color: Int) {
        state.value = state.value.copy(highlightColor = color)
    }

    @Composable
    override fun Content() {
        val stateValue = remember { state }
        val modifier = if (stateValue.value.onClick != null) {
            Modifier.clickable {
                stateValue.value.onClick!!.invoke()
            }
        } else {
            Modifier
        }
            .updateWidth(preferredWidth)
            .updateHeight(preferredHeight)
            .wrapContentHeight(align = stateValue.value.vAlignment)
            .wrapContentWidth(align = stateValue.value.hAlignment)

        if (stateValue.value.text != null) {
            ClickableTextComposable(
                text = stateValue.value.text!!,
                highlights = stateValue.value.highlightTexts,
                textStyle = stateValue.value.textStyle,
                modifier = modifier,
                maxLines = stateValue.value.maxLines,
                overflow = stateValue.value.overflow,
                textAlign = stateValue.value.textAlign,
                highlightColor = stateValue.value.highlightColor
            )
        }
    }
}

data class ClickableTextState(
    val text: String? = null,
    val textStyle: TextStyle,
    val maxLines: Int,
    val overflow: TextOverflow,
    val vAlignment: Alignment.Vertical,
    val hAlignment: Alignment.Horizontal,
    val textAlign: TextAlign,
    val onClick: (() -> Unit)?,
    val highlightTexts : List<Highlight>,
    @ColorRes val highlightColor: Int = R.color.b500,
)