package com.ixigo.design_sdk.components.buttons.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design_sdk.components.styles.IxiColor
import com.ixigo.design_sdk.components.buttons.styles.Shapes
import com.ixigo.design_sdk.components.buttons.styles.Sizes
import com.ixigo.design_sdk.components.styles.IxiFamily

@Composable
internal fun ComposableButton(
    text: String = "",
    colors: IxiColor,
    shapes: Shapes,
    sizes: Sizes,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBgColor = if (isPressed) colors.pressedColor else colors.bgColor
    val bgColor = if (isEnabled) enabledBgColor else IxiColor.Disabled.bgColor


    val paddingValues = createPaddingValues(sizes)
    val textColor = if (isEnabled) colors.textColor else IxiColor.Disabled.textColor

    Button(
        onClick = onClick,
        modifier = Modifier,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = bgColor)
        ),
        contentPadding = paddingValues,
        interactionSource = interactionSource,
        shape = shapes.shape,
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        DrawComponents(text, textColor, sizes, startDrawable, endDrawable)
    }

}

@Composable
internal fun ComposableTextButton(
    text: String = "",
    colors: IxiColor,
    sizes: Sizes,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {


    val paddingValues = createPaddingValues(sizes)
    val textColor = if (isEnabled) colors.textColor else IxiColor.Disabled.textColor

    TextButton(
        onClick = onClick,
        modifier = Modifier,
        enabled = isEnabled,
        contentPadding = paddingValues,
    ) {
        DrawComponents(text, textColor, sizes, startDrawable, endDrawable)
    }

}

@Composable
internal fun ComposableButtonOutlined(
    text: String = "",
    colors: IxiColor,
    shapes: Shapes,
    sizes: Sizes,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBorderColor = if (isPressed) colors.pressedColor else colors.bgColor
    val borderColor = if (isEnabled) enabledBorderColor else IxiColor.Disabled.bgColor

    val paddingValues = createPaddingValues(sizes)
    val textColor = if (isEnabled) colors.bgColor else IxiColor.Disabled.textColor

    OutlinedButton(
        onClick = onClick,
        modifier = Modifier,
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            disabledBackgroundColor = colorResource(id = android.R.color.transparent)
        ),

        interactionSource = interactionSource,
        contentPadding = paddingValues,
        shape = shapes.shape,
        border = BorderStroke(2.dp, colorResource(id = borderColor)),
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        DrawComponents(text, textColor, sizes, startDrawable, endDrawable)
    }
}

@Composable
private fun createPaddingValues(sizes: Sizes) =
    PaddingValues(
        sizes.padding.startPadding,
        sizes.padding.topPadding,
        sizes.padding.endPadding,
        sizes.padding.bottomPadding
    )


@Composable
private fun DrawComponents(
    text: String,
    @ColorRes textColor: Int,
    sizes: Sizes,
    @DrawableRes startDrawableRes: Int = 0,
    @DrawableRes endDrawableRes: Int = 0,
    @ColorRes drawableTint: Int = 0,
) {
    val textStyle = TextStyle(
        color = colorResource(id = textColor),
        fontSize = sizes.textSize,
        fontFamily = IxiFamily,
        fontWeight = FontWeight.Medium,
        fontStyle = FontStyle.Normal,
    )

    val textComposable = @Composable {
        Text(
            text = text,
            modifier = Modifier
                .padding(PaddingValues())
                .wrapContentWidth(),
            style = textStyle,
        )
    }

    val startDrawable = @Composable {
        Image(
            painter = painterResource(id = startDrawableRes),
            contentDescription = "Image",
            modifier = Modifier.padding(0.dp, 0.dp, 8.dp, 0.dp),
            colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
        )
    }

    val endDrawable = @Composable {
        Image(
            painter = painterResource(id = endDrawableRes),
            contentDescription = "Image",
            modifier = Modifier.padding(8.dp, 0.dp, 0.dp, 0.dp),
            colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
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
private fun ComposablePreview() {

}
