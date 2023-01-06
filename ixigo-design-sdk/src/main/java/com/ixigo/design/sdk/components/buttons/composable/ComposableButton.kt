package com.ixigo.design.sdk.components.buttons.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design.sdk.components.buttons.*
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiFamily

/**
 * Composable API for Drawing [IxiPrimaryButton].
 *
 * A user interface element which has solid colored background and  user can tap or click to perform
 * an action.
 *
 * User can also set text on IxiPrimaryButton along with start and end drawables
 *
 * To use [IxiPrimaryButton] in composable code call the [ComposablePrimaryButton] function with asked arguments
 * ```
 * ComposablePrimaryButton(
 *      "Button",
 *      IxiColor.Blue,
 *      ButtonShape.RegularShape
 *      ButtonSize.XLarge,
 *      true,
 *      R.drawable.ic_start,
 *      R.drawable.ic_end,
 * ){
 *  // To perform action on Button press
 * }
 * ```
 * @param text text to be displayed on Button
 * @param color The color that will be used to resolve the background and text color for
 * this Button. Choose from :
 * [IxiColor.Orange],[IxiColor.Blue], [IxiColor.Error], [IxiColor.Warning],
 * [IxiColor.Success], [IxiColor.Extension].
 * @param shape Defines the Button's shape. Choose from :
 * [ButtonShape.RegularShape], [ButtonShape.LeadingShape], [ButtonShape.TrailingShape],
 * [ButtonShape.BottomShape].
 * @param size Set the size for the Button. Size defines the height of Button, Horizontal padding and
 * text size of Button. Choose from [ButtonSize.Large], [ButtonSize.XLarge]
 * [ButtonSize.XXLarge], [ButtonSize.Medium], [ButtonSize.Small].
 * @param isEnabled Controls the enabled state of the Button. When `false`, this Button will not
 * be clickable.
 * @param startDrawable drawable at the start of the Primary Button.
 * @param endDrawable drawable at the end of the Primary Button.
 * @param onClick Will be called when the user clicks the Button.
 *
 * @since 1.0
 */
@Composable
fun ComposablePrimaryButton(
    text: String = "",
    color: IxiColor,
    shape: ButtonShape,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabledBgColor = if (isPressed) color.pressedColor else color.bgColor
    val bgColor = if (isEnabled) enabledBgColor else IxiColor.Disabled.bgColor


    val textColor = if (isEnabled) color.textColor else IxiColor.Disabled.textColor

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
        shape = shape.shape,
        elevation = ButtonDefaults.elevation(0.dp)
    ) {
        DrawComponents(text, textColor, size, startDrawable, endDrawable)
    }

}


/**
 * Composable API for Drawing [IxiSecondaryButton].
 *
 * A user interface element which has translucent colored background and  user can tap or click to
 * perform an action.
 *
 * User can also set text on IxiPrimaryButton along with start and end drawables.
 *
 * To use [IxiSecondaryButton] in composable code call the [ComposableSecondaryButton] function
 * with asked arguments
 * ```
 * ComposableSecondaryButton(
 *      "Button",
 *      IxiColor.Blue,
 *      ButtonShape.RegularShape
 *      ButtonSize.XLarge,
 *      true,
 *      R.drawable.ic_start,
 *      R.drawable.ic_end,
 * ) {
 *  // To perform action on Button press
 * }
 * ```
 * @param text text to be displayed on Button.
 * @param color The color that will be used to resolve the background and text color for
 * this Button. Choose from :
 * [IxiColor.Orange],[IxiColor.Blue], [IxiColor.Error], [IxiColor.Warning],
 * [IxiColor.Success], [IxiColor.Extension].
 * @param shape Defines the Button's shape. Choose from :
 * [ButtonShape.RegularShape], [ButtonShape.LeadingShape], [ButtonShape.TrailingShape],
 * [ButtonShape.BottomShape].
 * @param size Set the size for the Button. Size defines the height of Button, Horizontal padding and
 * text size of Button. Choose from [ButtonSize.Large], [ButtonSize.XLarge]
 * [ButtonSize.XXLarge], [ButtonSize.Medium], [ButtonSize.Small].
 * @param isEnabled Controls the enabled state of the Button. When `false`, this Button will not
 * be clickable.
 * @param startDrawable drawable at the start of the Primary Button.
 * @param endDrawable drawable at the end of the Primary Button.
 * @param onClick Will be called when the user clicks the Button.
 *
 * @since 1.0
 */
@Composable
fun ComposableSecondaryButton(
    text: String = "",
    colors: IxiColor,
    shapes: ButtonShape,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {
    ComposablePrimaryButton(
        text = text,
        color = mapSecStyle(colors),
        shape = shapes,
        size = size,
        isEnabled = isEnabled,
        startDrawable = startDrawable,
        endDrawable = endDrawable,
        onClick = onClick
    )
}

/**
 * Composable API for Drawing [IxiTertiaryButton]
 * A user interface element which has only text and no background and  user can tap or click to perform
 * an action.
 * User can also set text on IxiPrimaryButton along with start and end drawables
 *
 * To use [IxiTertiaryButton] in composable code call the [ComposableSecondaryButton] function with asked arguments
 * ```
 * ComposableTextButton(
 *      "Button",
 *      IxiColor.Blue,
 *      ButtonSize.XLarge,
 *      true,
 *      R.drawable.ic_start,
 *      R.drawable.ic_end,
 * ) {
 * // To perform action on Button press
 * }
 * ```
 * @param text text to be displayed on Button
 * @param color The color that will be used to resolve the background and text color for
 * this Button. Choose from :
 * [IxiColor.Orange],[IxiColor.Blue], [IxiColor.Error], [IxiColor.Warning],
 * [IxiColor.Success], [IxiColor.Extension].
 * @param size Set the size for the Button. Size defines the height of Button, Horizontal padding and
 * text size of Button. Choose from [ButtonSize.Large], [ButtonSize.XLarge]
 * [ButtonSize.XXLarge], [ButtonSize.Medium], [ButtonSize.Small].
 * @param isEnabled Controls the enabled state of the Button. When `false`, this Button will not
 * be clickable.
 * @param startDrawable drawable at the start of the Primary Button and should be DrawableResource.
 * @param endDrawable drawable at the end of the Primary Button.
 * @param onClick Will be called when the user clicks the Button.
 *
 * @since 1.0
 */
@Composable
internal fun ComposableTextButton(
    text: String = "",
    color: IxiColor,
    size: ButtonSize,
    isEnabled: Boolean = true,
    @DrawableRes startDrawable: Int = 0,
    @DrawableRes endDrawable: Int = 0,
    onClick: () -> Unit = {}
) {
    val textColor = if (isEnabled) color.textColor else IxiColor.Disabled.textColor

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

/**
 * Composable API for Drawing [IxiOutlinedButton].
 *
 * A user interface element which has stroke and no background and  user can tap or click to perform
 *  an action.
 *
 * User can also set text on IxiPrimaryButton along with start and end drawables.
 *
 * To use [IxiTertiaryButton] in composable code call the [ComposableSecondaryButton] function with asked arguments
 * ```
 * ComposableOutlinedButton(
 *      "Button",
 *      IxiColor.Blue,
 *      ButtonSize.XLarge,
 *      true,
 *      R.drawable.ic_start,
 *      R.drawable.ic_end,
 * ) {
 * // To perform action on Button press
 * }
 * ```
 * @param text text to be displayed on Button.
 * @param color The color that will be used to resolve the border and text color for
 * this Button. Choose from :
 * [IxiColor.Orange],[IxiColor.Blue], [IxiColor.Error], [IxiColor.Warning],
 * [IxiColor.Success], [IxiColor.Extension].
 * @param size Set the size for the Button. Size defines the height of Button, Horizontal padding and
 * text size of Button. Choose from [ButtonSize.Large], [ButtonSize.XLarge]
 * [ButtonSize.XXLarge], [ButtonSize.Medium], [ButtonSize.Small].
 * @param isEnabled Controls the enabled state of the Button. When `false`, this Button will not
 * be clickable.
 * @param startDrawable drawable at the start of the Primary Button and should be DrawableResource.
 * @param endDrawable drawable at the end of the Primary Button.
 * @param onClick Will be called when the user clicks the Button.
 *
 * @since 1.0
 */
@Composable
internal fun ComposableOutlinedButton(
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
    ConstraintLayout() {
        val (imageStart, textView, imageEnd) = createRefs()
        var startTextPadding = 0.dp
        var endTextPadding = 0.dp

        if ((startDrawableRes == 0 && endDrawableRes != 0)) {
            // Adding Start Padding as 5dp either Only start drawable is present or
            // Start drawable is not present but End drawable is present
            startTextPadding = 5.dp
        }
        if ((endDrawableRes == 0 && startDrawableRes != 0)) {
            // Adding End Padding as 5dp either Only End drawable is present or
            // End drawable is not present but Start drawable is present
            endTextPadding = 5.dp
        }
        if (startDrawableRes != 0) {
            Image(
                painter = painterResource(id = startDrawableRes),
                contentDescription = "Image",
                modifier = Modifier
                    .padding(start = 5.dp, end = 5.dp)
                    .constrainAs(imageStart) {
                        start.linkTo(parent.start, margin = 5.dp, goneMargin = 5.dp)
                        end.linkTo(textView.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
            )
        }
        Text(
            text = text,
            maxLines = 1,
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
                    width = Dimension.preferredWrapContent
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
                    .padding(start = 5.dp, end = 5.dp)
                    .constrainAs(imageEnd) {
                        start.linkTo(textView.end)
                        end.linkTo(parent.end, 5.dp, 5.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                colorFilter = if (drawableTint != 0) ColorFilter.tint(Color.Black) else null
            )
        }


        createHorizontalChain(imageStart, textView, imageEnd, chainStyle = ChainStyle.Packed)

    }
}

private fun mapSecStyle(colors: IxiColor) = when (colors) {
    IxiColor.Blue -> IxiColor.BlueSecondary
    IxiColor.Disabled -> IxiColor.Disabled
    IxiColor.Error -> IxiColor.ErrorSecondary
    IxiColor.Extension -> IxiColor.ExtensionSecondary
    IxiColor.Orange -> IxiColor.OrangeSecondary
    IxiColor.Success -> IxiColor.SuccessSecondary
    IxiColor.Warning -> IxiColor.WarningSecondary
    else -> IxiColor.OrangeSecondary
}

@Preview(showBackground = true)
@Composable
private fun ComposablePreview() {

}
