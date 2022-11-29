package com.ixigo.design_sdk.components.buttons.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ixigo.design_sdk.components.styles.IxiColor
import com.ixigo.design_sdk.components.buttons.styles.ButtonShape
import com.ixigo.design_sdk.components.buttons.styles.ButtonSize
import com.ixigo.design_sdk.components.styles.IxiFamily

@Composable
internal fun ComposableButton(
    text: String = "",
    colors: IxiColor,
    shapes: ButtonShape,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBgColor = if (isPressed) colors.pressedColor else colors.bgColor
    val bgColor = if (isEnabled) enabledBgColor else IxiColor.Disabled.bgColor


    val textColor = if (isEnabled) colors.textColor else IxiColor.Disabled.textColor

    Button(
        onClick = onClick,
        modifier = Modifier
            .height(size.height)
            .wrapContentWidth(),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = bgColor)
        ),
        contentPadding = size.horizontalPadding,
        interactionSource = interactionSource,
        shape = shapes.shape,
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        DrawComponents(text, textColor, size, startDrawable, endDrawable)
    }

}

@Composable
internal fun ComposableTextButton(
    text: String = "",
    colors: IxiColor,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {
    val textColor = if (isEnabled) colors.textColor else IxiColor.Disabled.textColor

    TextButton(
        onClick = onClick,
        modifier = Modifier
            .height(size.height)
            .wrapContentWidth(),
        enabled = isEnabled,
        contentPadding = size.horizontalPadding,
    ) {
        DrawComponents(text, textColor, size, startDrawable, endDrawable)
    }

}

@Composable
internal fun ComposableButtonOutlined(
    text: String = "",
    colors: IxiColor,
    shapes: ButtonShape,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBorderColor = if (isPressed) colors.pressedColor else colors.bgColor
    val borderColor = if (isEnabled) enabledBorderColor else IxiColor.Disabled.bgColor

    val textColor = if (isEnabled) colors.bgColor else IxiColor.Disabled.textColor

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .height(size.height)
            .wrapContentWidth(),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            disabledBackgroundColor = colorResource(id = android.R.color.transparent)
        ),

        interactionSource = interactionSource,
        contentPadding = size.horizontalPadding,
        shape = shapes.shape,
        border = BorderStroke(2.dp, colorResource(id = borderColor)),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        DrawComponents(text, textColor, size, startDrawable, endDrawable)
    }
}


@Composable
private fun DrawComponents(
    text: String,
    @ColorRes textColor: Int,
    size: ButtonSize,
    @DrawableRes startDrawableRes: Int = 0,
    @DrawableRes endDrawableRes: Int = 0,
    @ColorRes drawableTint: Int = 0,
) {
    ConstraintLayout {
        val (imageStart, textView, imageEnd) = createRefs()
        var startTextPadding = 0.dp
        var endTextPadding = 0.dp

        if ((startDrawableRes == 0 && endDrawableRes != 0) || startDrawableRes != 0) {
            // Adding Start Padding as 5dp either Only start drawable is present or
            // Start drawable is not present but End drawable is present
            startTextPadding = 5.dp
        }
        if ((endDrawableRes == 0 && startDrawableRes != 0) || endDrawableRes != 0) {
            // Adding End Padding as 5dp either Only End drawable is present or
            // End drawable is not present but Start drawable is present
            endTextPadding = 5.dp
        }
        if (startDrawableRes != 0) {
            Image(
                painter = painterResource(id = startDrawableRes),
                contentDescription = "Image",
                modifier = Modifier.constrainAs(imageStart) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
                colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
            )
        }
        Text(
            text = text,
            maxLines=1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(
                    start = startTextPadding,
                    end = endTextPadding,
                    top = 0.dp,
                    bottom = 0.dp
                )
                .constrainAs(textView) {
                    start.linkTo(imageStart.end)
                    end.linkTo(imageEnd.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },

            style = TextStyle(
                color = colorResource(id = textColor),
                fontSize = size.textSize,
                fontFamily = IxiFamily,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
            ),
        )
        if (endDrawableRes != 0) {
            Image(
                painter = painterResource(id = endDrawableRes),
                contentDescription = "Image",
                modifier = Modifier
                    .constrainAs(imageEnd) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposablePreview() {

}
