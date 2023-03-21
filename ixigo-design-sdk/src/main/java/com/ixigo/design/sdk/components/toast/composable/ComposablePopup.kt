package com.ixigo.design.sdk.components.toast.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.toast.IxiToastType

private val iconDefaultSize = 20.dp

@Composable
fun ComposablePopup(
    heading: String,
    subHeading: String? = null,
    leftIcon: ImageData? = null,
    leftIconClickListener: (() -> Unit)? = null,
    rightIcon: ImageData? = null,
    rightIconClickListener: (() -> Unit)? = null,
    buttonText: String? = null,
    buttonClickListener: (() -> Unit)? = null,
    ixiToastType: IxiToastType = IxiToastType.WHITE,
    positionX: Int,
    positionY: Int,
    show: Boolean
) {
    val backgroundColor = when (ixiToastType) {
        IxiToastType.WHITE -> colorResource(id = R.color.n40)
        IxiToastType.BLACK -> colorResource(id = R.color.n900)
        IxiToastType.RED -> colorResource(id = R.color.r500)
        IxiToastType.GREEN -> colorResource(id = R.color.g500)
        IxiToastType.YELLOW -> colorResource(id = R.color.y600)
    }

    if (show) {
        Popup(
            alignment = Alignment.TopCenter,
            offset = IntOffset(positionX, positionY),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp)
                    .background(backgroundColor, RoundedCornerShape(10.dp))
                    .padding(horizontal = 18.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                leftIcon?.let {
                    Icon(
                        icon = leftIcon,
                        iconClickListener = leftIconClickListener
                    )
                }

                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .weight(1f)
                ) {

                    TypographyText(
                        text = heading,
                        textStyle = IxiTypography.Body.Medium.regular,
                        color = if (ixiToastType == IxiToastType.WHITE) colorResource(
                            R.color.n800
                        ) else colorResource(R.color.n0),
                    )

                    subHeading?.let {
                        TypographyText(
                            text = subHeading,
                            textStyle = IxiTypography.Body.Small.regular,
                            color = if (ixiToastType == IxiToastType.WHITE) colorResource(
                                R.color.n800
                            ) else colorResource(R.color.n0),
                        )
                    }
                }

                buttonText?.let {
                    TypographyText(
                        text = buttonText,
                        textStyle = IxiTypography.Body.Medium.regular,
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                            .makeClickableIfPossible(buttonClickListener),
                        color = colorResource(R.color.o800),
                        textAlign = TextAlign.Center
                    )
                }

                rightIcon?.let {
                    Icon(
                        icon = rightIcon,
                        iconClickListener = rightIconClickListener,
                    )
                }
            }
        }
    }
}

@Composable
fun Icon(icon: ImageData, iconClickListener: (() -> Unit)?, modifier: Modifier = Modifier) {
    icon.getPainterForImage()?.let {
        androidx.compose.material.Icon(
            modifier = modifier
                .width(
                    icon.width ?: iconDefaultSize
                )
                .height(icon.height ?: iconDefaultSize)
                .makeClickableIfPossible(iconClickListener),
            painter = it,
            contentDescription = ""
        )
    }
}

fun Modifier.makeClickableIfPossible(clickListener: (() -> Unit)?): Modifier {
    val modifier = if (clickListener != null) {
        this.clickable(onClick = clickListener)
    } else {
        this
    }
    return modifier
}