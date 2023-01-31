package com.ixigo.design.sdk.components.tabs.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.AsyncImageView
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun PillTabComposable(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = 0,
    @DrawableRes endIcon: Int = 0,
    text: String?,
    isSelected: Boolean = false
) {
    val borderColor = if (isSelected) R.color.b500 else R.color.n300
    val bgColor = if (isSelected) R.color.b50 else R.color.n0
    val textColor =
        if (isSelected) colorResource(id = R.color.b500) else IxiTypography.Body.Medium.regular.color
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .width(IntrinsicSize.Max)
            .height(40.dp)
            .border(
                border = BorderStroke(1.dp, colorResource(id = borderColor)),
                shape = IxiShape.PillShape.shape
            )
            .background(
                color = colorResource(id = bgColor), shape = IxiShape.PillShape.shape
            )
            .padding(8.dp)
    ) {
        if (startIcon != 0) {
            Icon(
                painter = painterResource(id = startIcon), contentDescription = "",
            )
        }
        if (!text.isNullOrBlank()) {
            TypographyText(
                text = text,
                textStyle = IxiTypography.Body.Medium.regular.copy(color = textColor),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        if (endIcon != 0) {
            Icon(
                painter = painterResource(id = endIcon), contentDescription = "",
            )
        }
    }
}

private object NoRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Color.Unspecified

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

@Composable
fun LineTabComposable(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = 0,
    @DrawableRes endIcon: Int = 0,
    @DrawableRes topIcon: Int = 0,
    topUrl: String? = null,
    topIconWidth: Dp = 40.dp,
    topIconHeight: Dp = 40.dp,
    text: String?,
    isSelected: Boolean = false
) {
    val interactionSource = MutableInteractionSource()
    val textColor =
        if (isSelected) colorResource(id = R.color.b500) else IxiTypography.Body.Medium.regular.color
    CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
        ConstraintLayout(
            modifier = modifier
                .wrapContentHeight()
                .wrapContentWidth()
        ) {

            val (leftIcon, textView, rightIcon, topImage, line) = createRefs()

            val topModifier = Modifier
                .constrainAs(topImage) {
                    top.linkTo(parent.top, margin = 6.dp, goneMargin = 2.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
//                bottom.linkTo(textView.top, margin = 4.dp)
                }
                .width(topIconWidth)
                .height(topIconHeight)
            if (topIcon != 0) {
                Icon(
                    modifier = topModifier,
                    painter = painterResource(id = topIcon),
                    contentDescription = ""
                )
            } else if (!topUrl.isNullOrBlank()) {
                AsyncImageView(
                    placeholder = R.drawable.ic_top_tab_pplace_holder,
                    url = topUrl,
                    modifier = topModifier,
                    contentDes = R.string.hello_world
                )
            }

            if (startIcon != 0) {
                Icon(
                    modifier = Modifier.constrainAs(leftIcon) {
                        end.linkTo(textView.start)
                        top.linkTo(textView.top)
                        bottom.linkTo(textView.bottom)
                    },
                    painter = painterResource(id = startIcon),
                    contentDescription = ""
                )
            }

            TypographyText(
                modifier = Modifier.constrainAs(textView) {
                    start.linkTo(leftIcon.end, margin = 8.dp)
                    if (topIcon != 0 || !topUrl.isNullOrBlank()) {
                        top.linkTo(topImage.bottom, margin = 6.dp)
                    }
                    bottom.linkTo(line.top, margin = 8.dp)
                },
                text = text ?: "",
                textStyle = IxiTypography.Body.Medium.regular.copy(color = textColor),
            )

            if (endIcon != 0) {
                Icon(
                    modifier = Modifier.constrainAs(rightIcon) {
                        start.linkTo(textView.end, margin = 8.dp)
                        top.linkTo(textView.top)
                        bottom.linkTo(textView.bottom)
                    },
                    painter = painterResource(id = endIcon),
                    contentDescription = ""
                )
            }

            Box(
                modifier = Modifier

                    .constrainAs(line) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(textView.bottom)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }
                    .width(0.dp)
                    .height(3.dp)
                    .background(
                        color = colorResource(
                            id = if (isSelected) {
                                R.color.b500
                            } else {
                                android.R.color.transparent
                            }
                        ),
                        shape = RoundedCornerShape(50)
                    ),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewData() {
    LineTabComposable(
        startIcon = R.drawable.ic_baseline_cancel_24,
        endIcon = R.drawable.ic_baseline_cancel_24,
        topIcon = R.drawable.ic_baseline_cancel_24,
        text = "title",
        isSelected = true
    )
}