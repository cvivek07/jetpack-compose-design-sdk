package com.ixigo.design_sdk.components.buttons

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
import androidx.compose.ui.unit.dp
import com.ixigo.design_sdk.components.buttons.shapes.ComponentStyle

@Composable
fun ComposableButton(
    text: String = "Compose  Button",
    style: ComponentStyle,
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


    if (style.isOutLined) {
        OutlinedButton(
            onClick = onClick,
            modifier = Modifier,
            enabled = style.isEnabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = bgColor),
            ),
            interactionSource = interactionSource,
            contentPadding = paddingValues,
            shape = style.shape.shape,
            border = BorderStroke(2.dp, colorResource(id = style.strokeColor))
        ) {
            DrawComponents(style, text)
        }
    } else {

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
            DrawComponents(style, text)
        }
    }
}

@Composable
private fun DrawComponents(
    style: ComponentStyle,
    text: String,
) {
    val textStyle = if (!style.isEnabled) {
        style.textStyle.copy(textColor = style.disableTextColor)
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
            painter = painterResource(id = style.startDrawable),
            contentDescription = "Image",
            modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp)
        )
    }


    val endDrawable = @Composable {
        Image(
            painter = painterResource(id = style.endDrawable),
            contentDescription = "Image",
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp)
        )
    }

    if (style.startDrawable != 0) {
        startDrawable()
    }
    textComposable()
    if (style.endDrawable != 0) {
        endDrawable()
    }
}

fun ComposeView.setContent() {
//    setContent {
//        IxigoButton()
//    }
}

fun ComposeView.setTextContent() {
    setContent {
        Text(text = "This is the textview in Compose", color = Color.Blue)
    }
}

//@Composable
//fun buttonComposableUsingRow() {
//    Row(
//        modifier = Modifier
//            .wrapContentWidth()
//            .clip(
//                shape = RoundedCornerShape(
//                    topStart = CornerSize(style.shape.radius.topStartRadius),
//                    topEnd = CornerSize(style.shape.radius.topEndRadius),
//                    bottomEnd = CornerSize(style.shape.radius.bottomEndRadius),
//                    bottomStart = CornerSize(style.shape.radius.bottomStartRadius)
//                )
//            )
//            .background(color = colorResource(id = bgColor))
//            .border(BorderStroke(2.dp, SolidColor(Color.Black)))
//            .clickable(
//                interactionSource = interactionSource,
//                indication = rememberRipple(bounded = true),
//                enabled = style.isEnabled,
//                role = Role.Button,
//                onClick = onClick,
//            )
//            .padding(
//                style.shape.padding.startPadding,
//                style.shape.padding.topPadding,
//                style.shape.padding.endPadding,
//                style.shape.padding.bottomPadding
//            )
//
//    )
//    {
//        val textStyle = if (!style.isEnabled) {
//            style.textStyle.copy(textColor = style.disableTextColor)
//        } else style.textStyle
//        Text(
//            text = text,
//            modifier = Modifier.padding(),
//            style = textStyle.toTextStyle(),
//
//            )
//    }
//}