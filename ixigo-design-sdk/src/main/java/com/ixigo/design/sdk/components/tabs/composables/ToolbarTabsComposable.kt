package com.ixigo.design.sdk.components.tabs.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ixigo.design.sdk.R
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

@Composable
fun LineTabComposable(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = 0,
    @DrawableRes endIcon: Int = 0,
    @DrawableRes topIcon: Int = 0,
    text: String?,
    isSelected: Boolean = false
) {
    val textColor =
        if (isSelected) colorResource(id = R.color.b500) else IxiTypography.Body.Medium.regular.color

    ConstraintLayout(modifier = modifier
        .wrapContentHeight()
        .wrapContentWidth()) {

        val (leftIcon, textView, rightIcon, topImage, line) = createRefs()

        if (topIcon != 0) {
            Icon(
                modifier = Modifier.constrainAs(topImage) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(textView.top)
                },
                painter = painterResource(id = topIcon),
                contentDescription = ""
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
                if (topIcon != 0) {
                    top.linkTo(topImage.bottom)
                }
                bottom.linkTo(line.top)

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
                .padding(top = 6.dp)
                .constrainAs(line) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
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