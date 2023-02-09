package com.ixigo.design.sdk.components.listitems.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.AsyncImageView
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun AutoCompleterRecentComposable(
    startIcon: ImageData? = null,
    endIcon: ImageData? = null,
    code: String? = null,
    from: String?,
    to: String?,
    subTitle: String? = null,
    onItemClick: () -> Unit,
    onEndIconClick: () -> Unit = {},
    onStartIconClick: () -> Unit = {},
) {
    DrawRow(onItemClick = onItemClick) {

        DrawStartIcon(startIcon, code, onStartIconClick)

        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            FromToTitleView(from = from ?: "", to = to ?: "")
            if (!subTitle.isNullOrBlank()) {
                TypographyText(text = subTitle, textStyle = IxiTypography.Body.XSmall.regular)
            }
        }

        DrawEndIcon(endIcon, onEndIconClick)
    }
}


@Composable
fun AutoCompleterDestinationComposable(
    startIcon: ImageData? = null,
    endIcon: ImageData? = null,
    title: String,
    code: String?,
    subTitle: String? = null,
    onItemClick: () -> Unit,
    onEndIconClick: () -> Unit = {},
    onStartIconClick: () -> Unit = {},
) {
    DrawRow(onItemClick = onItemClick) {

        DrawStartIcon(startIcon, code, onStartIconClick)

        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            TitleView(title = title)
            if (!subTitle.isNullOrBlank()) {
                TypographyText(text = subTitle, textStyle = IxiTypography.Body.XSmall.regular)
            }

        }

        DrawEndIcon(endIcon = endIcon, onEndIconClick = onEndIconClick)
    }
}

@Composable
fun AutoCompleterAirPortOrStationComposable(
    startIcon: ImageData? = null,
    endIcon: ImageData? = null,
    title: String,
    subTitle: String? = null,
    to: String? = null,
    from: String? = null,
    code: String?,
    onItemClick: () -> Unit,
    onEndIconClick: () -> Unit = {},
    onStartIconClick: () -> Unit = {},
) {
    DrawRow(onItemClick = onItemClick) {

        DrawStartIcon(startIcon = startIcon, iconText = code, onStartIconClick)

        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            TitleView(title = title)
            if (!subTitle.isNullOrBlank()) {
                TypographyText(text = subTitle, textStyle = IxiTypography.Body.XSmall.regular)
            } else if (from != null && to != null) {
                FromToTitleView(
                    from = from,
                    to = to,
                    IxiTypography.Body.XSmall.regular,
                    iconSize = 8.3.dp
                )
            }
        }

        DrawEndIcon(endIcon = endIcon, onEndIconClick = onEndIconClick)

    }
}

@Composable
private fun DrawRow(onItemClick: () -> Unit, content: @Composable RowScope.() -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val rowBgColor = if (isPressed) R.color.n400 else R.color.n0

    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.n0))
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(
                    color = colorResource(id = rowBgColor)
                ),
            ) {
                onItemClick()
            }
            .padding(start = 15.dp, top = 20.dp, bottom = 20.dp, end = 32.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {
        content()
    }
}

@Composable
private fun DrawStartIcon(startIcon: ImageData?, iconText: String?, onStartIconClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(startIcon?.width ?: 50.dp)
            .height(startIcon?.height ?: 50.dp)
            .clip(RoundedCornerShape(corner = CornerSize(10.dp)))
            .border(
                1.dp,
                colorResource(id = R.color.n100),
                shape = RoundedCornerShape(8.dp),
            )
            .background(colorResource(id = R.color.n40))
            .clickable { onStartIconClick() },
        contentAlignment = Alignment.Center

    ) {
        if (startIcon != null) {
            if (startIcon.url != null) {
                AsyncImageView(
                    modifier = Modifier
                        .width(startIcon.width ?: 30.dp)
                        .height(startIcon.width ?: 30.dp),
                    url = startIcon.url,
                    placeholder = startIcon.drawableRes,
                    contentDes = null
                )
            } else {
                startIcon.getPainterForImage()?.let {
                    Icon(
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .align(Alignment.Center),
                        painter = it,
                        contentDescription = ""
                    )
                }
            }
        } else if (iconText != null) {
            TypographyText(text = iconText, textStyle = IxiTypography.Body.Small.regular)
        }
    }
}


@Composable
private fun DrawEndIcon(endIcon: ImageData?, onEndIconClick: () -> Unit) {
    if (endIcon != null) {
        if (endIcon.url != null) {
            AsyncImageView(
                modifier = Modifier
                    .width(endIcon.width ?: 30.dp)
                    .height(endIcon.width ?: 30.dp),
                url = endIcon.url,
                placeholder = endIcon.drawableRes,
                contentDes = null
            )
        } else {
            endIcon.getPainterForImage()?.let {
                Icon(
                    modifier = Modifier
                        .width(endIcon.width ?: 30.dp)
                        .height(endIcon.height ?: 30.dp)
                        .clickable { onEndIconClick() },
                    painter = it,
                    contentDescription = "",
                )
            }
        }
    }
}

@Composable
fun TitleView(title: String) {
    TypographyText(text = title, textStyle = IxiTypography.Body.Medium.regular)
}

@Composable
fun FromToTitleView(
    from: String,
    to: String,
    textStyle: TextStyle = IxiTypography.Body.Medium.regular,
    iconSize: Dp = 12.5.dp
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TypographyText(text = from, textStyle = textStyle)
        Icon(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .size(iconSize),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = ""
        )
        TypographyText(text = to, textStyle = textStyle)
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowPreviewList() {
    Column(modifier = Modifier.fillMaxSize()) {
        AutoCompleterRecentComposable(
            startIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null,
                null
            ),
            endIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null, null
            ),
            subTitle = "State name",
            from = "Delhi",
            to = "Mumbai",
            code = "2556",
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {}
        )

        AutoCompleterDestinationComposable(
            startIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null,
                null
            ),
            endIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null,
                null
            ),
            title = "Nearest Railway Station",
            code = null,
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {}
        )

        AutoCompleterAirPortOrStationComposable(
            startIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null,
                null
            ),
            endIcon = ImageData(
                drawableRes = R.drawable.ic_baseline_cancel_24,
                null,
                null,
                null,
                null,
                null
            ),
            title = "Nearest Railway Station",
            to = "Delhi",
            from = "Mumbai",
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {},
            code = null
        )
    }

}