package com.ixigo.design_sdk.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design_sdk.components.buttons.shapes.ButtonStyles
import com.ixigo.design_sdk.components.buttons.shapes.ComponentStyle

@Composable
fun ComposableButton(
    text: String = "Compose  Button",
    style: ComponentStyle,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBgColor = if (isPressed) style.hoverColor else style.bgColor
    val bgColor = if (style.isEnabled) enabledBgColor else style.disableColor

    val paddingValues = PaddingValues(
        style.shape.padding.startPadding,
        style.shape.padding.topPadding,
        style.shape.padding.endPadding,
        style.shape.padding.bottomPadding
    )

    Button(
        onClick = onClick,
        modifier = Modifier,
        enabled = style.isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = bgColor)
        ),
        contentPadding = paddingValues,
        interactionSource = interactionSource,
        shape = style.shape.shape,
    ) {
        DrawComponents(style, text, isPressed, startDrawable, endDrawable)
    }

}

@Composable
fun ComposableButtonOutlined(
    text: String = "Compose  Button",
    style: ComponentStyle,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val bgColor = if (isPressed) style.hoverColor else style.bgColor
    val borderColor = if (style.isEnabled) style.strokeColor else style.disableColor

    val paddingValues = PaddingValues(
        style.shape.padding.startPadding,
        style.shape.padding.topPadding,
        style.shape.padding.endPadding,
        style.shape.padding.bottomPadding
    )

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier,
        enabled = style.isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = bgColor),
            disabledBackgroundColor = colorResource(id = android.R.color.transparent)
        ),

        interactionSource = interactionSource,
        contentPadding = paddingValues,
        shape = style.shape.shape,
        border = BorderStroke(2.dp, colorResource(id = borderColor))
    ) {
        DrawComponents(style, text, isPressed, startDrawable, endDrawable)
    }
}

@Composable
private fun DrawComponents(
    style: ComponentStyle,
    text: String,
    isPressed: Boolean = false,
    @DrawableRes startDrawableRes: Int = 0,
    @DrawableRes endDrawableRes: Int = 0,
) {
    val textStyle = if (!style.isEnabled) {
        style.textStyle.copy(textColor = style.disableTextColor)
    } else if (isPressed) {
        style.textStyle.copy(textColor = android.R.color.white)
    } else style.textStyle


    val textComposable = @Composable {
        Text(
            text = text,
            modifier = Modifier
                .padding(PaddingValues())
                .wrapContentWidth(),
            style = textStyle.toTextStyle(),
        )
    }

    val startDrawable = @Composable {
        Image(
            painter = painterResource(id = startDrawableRes),
            contentDescription = "Image",
            modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
        )
    }

    val endDrawable = @Composable {
        Image(
            painter = painterResource(id = endDrawableRes),
            contentDescription = "Image",
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)
        )
    }

    if (startDrawableRes != 0) {
        startDrawable()
    }
    textComposable()
    if (endDrawableRes != 0) {
        endDrawable()
    }
}

@Preview(showBackground = true)
@Composable
fun ComposablePreview() {
    ComposableButton("Button", ButtonStyles.b700NormalRegularShapeRadiusOutlined)
}
