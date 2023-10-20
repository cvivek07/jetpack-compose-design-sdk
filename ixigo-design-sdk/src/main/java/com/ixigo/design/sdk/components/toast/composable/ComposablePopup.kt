package com.ixigo.design.sdk.components.toast.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.toast.IxiToastType

private val ICON_DEFAULT_SIZE = 20.dp
private val ICON_PADDING_END = 12.dp
private val POPUP_PADDING_HORIZONTAL = 20.dp
private val CONTENT_PADDING = 18.dp
private val BUTTON_PADDING_HORIZONTAL = 12.dp
private val BUTTON_PADDING_VERTICAL = 10.dp
private val TOAST_RADIUS = 10.dp

@Composable
fun ComposablePopup(
    heading: String? = null,
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

    val popup = remember { mutableStateOf(show) }

    if (popup.value) {
        Popup(
            offset = IntOffset(positionX, positionY),
            onDismissRequest = { popup.value = false },
            properties = PopupProperties(dismissOnClickOutside = true),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = POPUP_PADDING_HORIZONTAL),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .background(backgroundColor, RoundedCornerShape(TOAST_RADIUS))
                        .padding(horizontal = CONTENT_PADDING, vertical = BUTTON_PADDING_VERTICAL),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    leftIcon?.let {
                        Icon(
                            icon = leftIcon,
                            iconClickListener = leftIconClickListener,
                            modifier = Modifier.padding(end = ICON_PADDING_END)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .weight(1f)
                    ) {

                        heading?.let {
                            TypographyText(
                                text = heading,
                                textStyle = IxiTypography.Body.Medium.regular,
                                color = if (ixiToastType == IxiToastType.WHITE) colorResource(R.color.n800)
                                else colorResource(R.color.n0),
                            )
                        }

                        subHeading?.let {
                            TypographyText(
                                text = subHeading,
                                textStyle = IxiTypography.Body.Small.regular,
                                color = if (ixiToastType == IxiToastType.WHITE) colorResource(R.color.n800)
                                else colorResource(R.color.n0),
                            )
                        }
                    }

                    buttonText?.let {
                        TypographyText(
                            text = buttonText,
                            textStyle = IxiTypography.Body.Medium.regular,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(
                                    horizontal = BUTTON_PADDING_HORIZONTAL,
                                    vertical = BUTTON_PADDING_VERTICAL
                                )
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
}

@Composable
fun Icon(icon: ImageData, iconClickListener: (() -> Unit)?, modifier: Modifier = Modifier) {
    icon.getPainterForImage()?.let {
        androidx.compose.material.Icon(
            modifier = modifier
                .width(icon.width ?: ICON_DEFAULT_SIZE)
                .height(icon.height ?: ICON_DEFAULT_SIZE)
                .makeClickableIfPossible(iconClickListener),
            painter = it,
            contentDescription = "",
            tint = Color.White
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