package com.ixigo.design_sdk.components.buttons.shapes

import androidx.annotation.ColorRes
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.*
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.IxiStyle
import com.ixigo.design_sdk.IxiTypography.button
import com.ixigo.design_sdk.IxiTypography.buttonLarge
import com.ixigo.design_sdk.IxiTypography.outlinedButton
import com.ixigo.design_sdk.components.buttons.shapes.IxiButtonShapes.normalBottomOutlineShape
import com.ixigo.design_sdk.components.buttons.shapes.IxiButtonShapes.normalLeadingOutlinedShape
import com.ixigo.design_sdk.components.buttons.shapes.IxiButtonShapes.normalTrailingOutlineShape

data class ComponentPadding(
    val startPadding: Dp,
    val topPadding: Dp,
    val endPadding: Dp,
    val bottomPadding: Dp
)

data class ComponentRadius(
    val topStartRadius: Dp,
    val topEndRadius: Dp,
    val bottomEndRadius: Dp,
    val bottomStartRadius: Dp
)

data class ComponentStyle(
    @ColorRes val bgColor: Int,
    @ColorRes val hoverColor: Int,
    @ColorRes val disableColor: Int = R.color.disabled_bg,
    @ColorRes val strokeColor: Int = android.R.color.transparent,
    @ColorRes val disableTextColor: Int = R.color.disabled_text,
    val shape: ButtonShapes,
    val textStyle: IxiStyle,
    val isEnabled: Boolean,
    val isOutLined: Boolean = false
)


object ButtonPadding {
    val normalPadding = ComponentPadding(13.dp, 15.dp, 13.dp, 15.dp)
    val xlPadding = ComponentPadding(13.dp, 20.dp, 13.dp, 20.dp)
    val xxlPadding = ComponentPadding(13.dp, 30.dp, 13.dp, 30.dp)
}

object ButtonRadius {
    val regularShapeRadius = ComponentRadius(10.dp, 10.dp, 10.dp, 10.dp)
    val leadingShapeRadius = ComponentRadius(20.dp, 0.dp, 0.dp, 20.dp)
    val trailingShapeRadius = ComponentRadius(0.dp, 20.dp, 20.dp, 0.dp)
    val bottomShapeRadius = ComponentRadius(0.dp, 0.dp, 10.dp, 10.dp)
}

data class ButtonShapes(
    val padding: ComponentPadding,
    val radius: ComponentRadius,
    val shape: Shape
)

object IxiButtonShapes {
    val normalRegularShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.regularShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.regularShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.regularShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.regularShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.regularShapeRadius.bottomStartRadius)
            )
        )
    val normalLeadingShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.leadingShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.leadingShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.leadingShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.leadingShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.leadingShapeRadius.bottomStartRadius)
            )
        )
    val normalTrailingShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.trailingShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.trailingShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.trailingShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.trailingShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.trailingShapeRadius.bottomStartRadius)
            )
        )
    val normalBottomShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.bottomShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.bottomShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.bottomShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.bottomShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.bottomShapeRadius.bottomStartRadius)
            )
        )


    val xLargeRegularShape = ButtonShapes(
        ButtonPadding.xlPadding, ButtonRadius.regularShapeRadius,
        RoundedCornerShape(
            topStart = CornerSize(ButtonRadius.regularShapeRadius.topStartRadius),
            topEnd = CornerSize(ButtonRadius.regularShapeRadius.topEndRadius),
            bottomEnd = CornerSize(ButtonRadius.regularShapeRadius.bottomEndRadius),
            bottomStart = CornerSize(ButtonRadius.regularShapeRadius.bottomStartRadius)
        )
    )
    val xLargeLeadingShape = ButtonShapes(
        ButtonPadding.xlPadding, ButtonRadius.leadingShapeRadius,
        RoundedCornerShape(
            topStart = CornerSize(ButtonRadius.leadingShapeRadius.topStartRadius),
            topEnd = CornerSize(ButtonRadius.leadingShapeRadius.topEndRadius),
            bottomEnd = CornerSize(ButtonRadius.leadingShapeRadius.bottomEndRadius),
            bottomStart = CornerSize(ButtonRadius.leadingShapeRadius.bottomStartRadius)
        )
    )
    val xLargeTrailingShape =
        ButtonShapes(
            ButtonPadding.xlPadding, ButtonRadius.trailingShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.trailingShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.trailingShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.trailingShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.trailingShapeRadius.bottomStartRadius)
            )
        )
    val xLargeBottomShape = ButtonShapes(
        ButtonPadding.xlPadding, ButtonRadius.bottomShapeRadius,
        RoundedCornerShape(
            topStart = CornerSize(ButtonRadius.bottomShapeRadius.topStartRadius),
            topEnd = CornerSize(ButtonRadius.bottomShapeRadius.topEndRadius),
            bottomEnd = CornerSize(ButtonRadius.bottomShapeRadius.bottomEndRadius),
            bottomStart = CornerSize(ButtonRadius.bottomShapeRadius.bottomStartRadius)
        )
    )


    val xxLargeRegularShape =
        ButtonShapes(
            ButtonPadding.xxlPadding, ButtonRadius.regularShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.regularShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.regularShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.regularShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.regularShapeRadius.bottomStartRadius)
            )
        )
    val xxLargeLeadingShape =
        ButtonShapes(
            ButtonPadding.xxlPadding, ButtonRadius.leadingShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.leadingShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.leadingShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.leadingShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.leadingShapeRadius.bottomStartRadius)
            )
        )
    val xxLargeTrailingShape =
        ButtonShapes(
            ButtonPadding.xxlPadding, ButtonRadius.trailingShapeRadius,
            RoundedCornerShape(
                topStart = CornerSize(ButtonRadius.trailingShapeRadius.topStartRadius),
                topEnd = CornerSize(ButtonRadius.trailingShapeRadius.topEndRadius),
                bottomEnd = CornerSize(ButtonRadius.trailingShapeRadius.bottomEndRadius),
                bottomStart = CornerSize(ButtonRadius.trailingShapeRadius.bottomStartRadius)
            )
        )
    val xxLargeBottomShape = ButtonShapes(
        ButtonPadding.xxlPadding, ButtonRadius.bottomShapeRadius,
        RoundedCornerShape(
            topStart = CornerSize(ButtonRadius.bottomShapeRadius.topStartRadius),
            topEnd = CornerSize(ButtonRadius.bottomShapeRadius.topEndRadius),
            bottomEnd = CornerSize(ButtonRadius.bottomShapeRadius.bottomEndRadius),
            bottomStart = CornerSize(ButtonRadius.bottomShapeRadius.bottomStartRadius)
        )
    )


    val normalLeadingOutlinedShape = ButtonShapes(
        ButtonPadding.normalPadding,
        ButtonRadius.regularShapeRadius,
        LeadingOutlineShape()
    )

    val normalTrailingOutlineShape = ButtonShapes(
        ButtonPadding.normalPadding,
        ButtonRadius.regularShapeRadius,
        TrailingOutlineShape()
    )
    val normalBottomOutlineShape = ButtonShapes(
        ButtonPadding.normalPadding,
        ButtonRadius.regularShapeRadius,
        BottomOutlineShape()
    )

}


object ButtonStyles {
    val o700NormalTrailingShapeRadius = ComponentStyle(
        bgColor = R.color.o700,
        hoverColor = R.color.o600,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = normalTrailingOutlineShape,
        textStyle = button,
        isEnabled = true,
        isOutLined = false
    )
    val o700NormalLeadingShapeRadius = ComponentStyle(
        bgColor = R.color.o700,
        hoverColor = R.color.o600,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = normalLeadingOutlinedShape,
        textStyle = button,
        isEnabled = true,
        isOutLined = false
    )
    val b700NormalLeadingShapeRadius = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.normalLeadingShape,
        textStyle = button,
        isEnabled = true,
        isOutLined = false
    )
    val b700XXlargeBottomShapeRadius = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.xxLargeBottomShape,
        textStyle = buttonLarge,
        isEnabled = true,
        isOutLined = false
    )
    val b700XXlargeBottomShapeRadiusDisabled = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.xxLargeBottomShape,
        textStyle = buttonLarge,
        isEnabled = false,
        isOutLined = false
    )
    val b700XXlargeRegularShapeRadius = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.xxLargeRegularShape,
        textStyle = buttonLarge,
        isEnabled = true,
        isOutLined = false
    )

    val b700NormalRegularShapeRadius = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = R.color.disabled_text,
        disableTextColor = android.R.color.transparent,
        shape = IxiButtonShapes.normalRegularShape,
        textStyle = button,
        isEnabled = true,
        isOutLined = false
    )
    val b700NormalRegularShapeRadiusOutlined = ComponentStyle(
        bgColor = android.R.color.transparent,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = R.color.b700,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.normalRegularShape,
        textStyle = outlinedButton.copy(
            textColor = R.color.b700,
            bgColor = android.R.color.transparent
        ),
        isEnabled = true,
        isOutLined = true
    )
    val b700NormalLeadingShapeRadiusOutlined = ComponentStyle(
        bgColor = android.R.color.transparent,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = R.color.b700,
        disableTextColor = R.color.disabled_text,
        shape = normalLeadingOutlinedShape,
        textStyle = outlinedButton.copy(
            textColor = R.color.b700,
            bgColor = android.R.color.transparent
        ),
        isEnabled = true,
        isOutLined = true
    )

    val b700NormalTrailingShapeRadiusOutlined = ComponentStyle(
        bgColor = android.R.color.transparent,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = R.color.b700,
        disableTextColor = R.color.disabled_text,
        shape = normalTrailingOutlineShape,
        textStyle = outlinedButton.copy(
            textColor = R.color.b700,
            bgColor = android.R.color.transparent
        ),
        isEnabled = true,
        isOutLined = true
    )
    val b700NormalBottomShapeRadiusOutlined = ComponentStyle(
        bgColor = android.R.color.transparent,
        hoverColor = R.color.b400,
        disableColor = R.color.disabled_bg,
        strokeColor = R.color.b700,
        disableTextColor = R.color.disabled_text,
        shape = normalBottomOutlineShape,
        textStyle = outlinedButton.copy(
            textColor = R.color.b700,
            bgColor = android.R.color.transparent
        ),
        isEnabled = true,
        isOutLined = true
    )
}

class TrailingOutlineShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
        val shapeHeight = size.height
        val shapeWidth = size.width - radius

        val rect = Rect(
            left = size.width - size.height,
            top = 0f,
            right = size.width,
            bottom = shapeHeight
        )
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(shapeWidth, 0f)
            arcTo(
                rect = rect,
                startAngleDegrees = -90.0f,
                sweepAngleDegrees = 180.0f,
                forceMoveTo = false
            )
            lineTo(0f, shapeHeight)
        }
        return Outline.Generic(path)
    }
}

class LeadingOutlineShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
        val shapeHeight = size.height
        val shapeWidth = size.width - radius

        val rect = Rect(
            left = 0f,
            top = 0f,
            right = shapeHeight,
            bottom = shapeHeight
        )
        val path = Path().apply {
            moveTo(size.width, 0f)
            lineTo(shapeWidth, 0f)
            arcTo(
                rect = rect,
                startAngleDegrees = -90.0f,
                sweepAngleDegrees = -180.0f,
                forceMoveTo = false
            )
            lineTo(size.width, shapeHeight)
        }
        return Outline.Generic(path)
    }
}

class BottomOutlineShape(private val radius: Dp = Dp(40F)) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
//        val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
        val shapeHeight = size.height -  radius.value
        val shapeWidth = size.width - radius.value

        val bottomStartRect = Rect(
            left = 0f,
            top = shapeHeight,
            right = radius.value,
            bottom = size.height
        )
        val bottomEndRect = Rect(
            left = shapeWidth,
            top = shapeHeight,
            right = size.width,
            bottom = size.height
        )
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(0f, shapeHeight)
            arcTo(
                rect = bottomStartRect,
                startAngleDegrees = -180.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = false
            )
            lineTo(shapeWidth, size.height)
            arcTo(
                rect = bottomEndRect,
                startAngleDegrees = -270.0f,
                sweepAngleDegrees = -90.0f,
                forceMoveTo = false
            )
            lineTo(size.width, 0F)
        }

        return Outline.Generic(path)
    }
}