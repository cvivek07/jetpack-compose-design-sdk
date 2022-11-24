package com.ixigo.design_sdk.components.buttons.styles

import androidx.annotation.ColorRes
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.BaseComposition
import com.ixigo.design_sdk.components.BottomOutlineShape
import com.ixigo.design_sdk.components.LeadingOutlineShape
import com.ixigo.design_sdk.components.TrailingOutlineShape
import com.ixigo.design_sdk.components.styles.ComponentTextStyle
import com.ixigo.design_sdk.components.styles.IxiTextStyles.button
import com.ixigo.design_sdk.components.styles.IxiTextStyles.buttonLarge
import com.ixigo.design_sdk.components.styles.IxiTextStyles.outlinedButton

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
    val textStyle: ComponentTextStyle,
    val isEnabled: Boolean,
    val isOutLined: Boolean = false,
): BaseComposition()


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
            LeadingOutlineShape()
        )
    val normalTrailingShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.trailingShapeRadius,
            TrailingOutlineShape()
        )
    val normalBottomShape =
        ButtonShapes(
            ButtonPadding.normalPadding,
            ButtonRadius.bottomShapeRadius,
            BottomOutlineShape()
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
            LeadingOutlineShape()
        )
    val xxLargeTrailingShape =
        ButtonShapes(
            ButtonPadding.xxlPadding, ButtonRadius.trailingShapeRadius,
            TrailingOutlineShape()
        )
    val xxLargeBottomShape = ButtonShapes(
        ButtonPadding.xxlPadding, ButtonRadius.bottomShapeRadius,
        BottomOutlineShape()
    )
}


object ButtonStyles {
    private val defaultStyle = ComponentStyle(
        bgColor = R.color.b700,
        hoverColor = R.color.b600,
        disableColor = R.color.disabled_bg,
        strokeColor = android.R.color.transparent,
        disableTextColor = R.color.disabled_text,
        shape = IxiButtonShapes.normalRegularShape,
        textStyle = button,
        isEnabled = true,
        isOutLined = false
    )

    val defaultOutlinedStyle = defaultStyle.copy(
        bgColor = android.R.color.transparent,
        hoverColor = R.color.b400,
        strokeColor = R.color.b700,
        textStyle = outlinedButton.copy(
            textColor = R.color.b700,
            bgColor = android.R.color.transparent
        ),
        isOutLined = true
    )

    // Naming convention
    // colorName +
    // Size(Normal, XLarge, XXLarge ) +
    // Shape (RegularShapeRadius, LeadingShapeRadius, BottomShapeRadius, TrailingShapeRadius)
    val o700NormalRegularShapeRadius = defaultStyle.copy(
        bgColor = R.color.o700,
        hoverColor = R.color.o600,
        shape = IxiButtonShapes.normalTrailingShape,
    )
    val o700NormalTrailingShapeRadius = o700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalTrailingShape
    )


    val o700NormalBottomShapeRadius = o700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalBottomShape
    )

    val b700NormalRegularShapeRadius = defaultStyle.copy(
        shape = IxiButtonShapes.normalRegularShape
    )

    val b700NormalRegularShapeRadiusOutlined = defaultOutlinedStyle

    val b700NormalLeadingShapeRadius = b700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalLeadingShape
    )
    val b700NormalLeadingShapeRadiusOutlined = b700NormalRegularShapeRadiusOutlined.copy(
        shape = IxiButtonShapes.normalLeadingShape
    )

    val b700NormalTrailingShapeRadius = b700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalTrailingShape
    )
    val o700NormalLeadingShapeRadius = o700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalLeadingShape
    )


    val b700NormalTrailingShapeRadiusOutlined = defaultOutlinedStyle.copy(
        shape = IxiButtonShapes.normalTrailingShape
    )

    val b700NormalBottomShapeRadius = b700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.normalBottomShape
    )

    val b700NormalBottomShapeRadiusOutlined = defaultOutlinedStyle.copy(
        shape = IxiButtonShapes.normalBottomShape
    )

    val b700XXlargeRegularShapeRadius = b700NormalRegularShapeRadius.copy(
        shape = IxiButtonShapes.xxLargeRegularShape,
        textStyle = buttonLarge,
    )
    val b700XXlargeBottomShapeRadius = b700XXlargeRegularShapeRadius.copy(
        shape = IxiButtonShapes.xxLargeBottomShape,
    )
    val b700XXlargeBottomShapeRadiusDisabled = b700XXlargeBottomShapeRadius.copy(
        isEnabled = false
    )
}
