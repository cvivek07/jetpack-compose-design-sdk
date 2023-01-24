package com.ixigo.design.sdk.components.listitems.composables

import androidx.annotation.DrawableRes
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
import com.ixigo.design.sdk.components.progressstep.base.ProgressStepIconSize
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun AutoCompleterRecentComposable(
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
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

        if (endIcon != null) {
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onEndIconClick() },
                painter = painterResource(id = endIcon),
                contentDescription = "",
            )

        }
    }
}

@Composable
fun AutoCompleterDestinationComposable(
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
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

        if (endIcon != null) {
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onEndIconClick() },
                painter = painterResource(id = endIcon),
                contentDescription = "",
            )

        }
    }
}

@Composable
fun AutoCompleterAirPortOrStationComposable(
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
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

        if (endIcon != null) {
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { onEndIconClick() },
                painter = painterResource(id = endIcon),
                contentDescription = "",
            )

        }
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
private fun DrawStartIcon(startIcon: Int?, iconText: String?, onStartIconClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
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
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = startIcon),
                contentDescription = ""
            )
        } else if (iconText != null) {
            TypographyText(text = iconText, textStyle = IxiTypography.Body.Small.regular)
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
fun showPreviewList() {
    Column(modifier = Modifier.fillMaxSize()) {
        AutoCompleterRecentComposable(
            endIcon = R.drawable.ic_baseline_cancel_24,
            subTitle = "State name",
            from = "Delhi",
            to = "Mumbai",
            code = "2556",
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {}
        )

        AutoCompleterDestinationComposable(
            startIcon = R.drawable.ic_baseline_cancel_24,
            endIcon = R.drawable.ic_baseline_cancel_24,
            title = "Nearest Railway Station",
            code = null,
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {}
        )

        AutoCompleterAirPortOrStationComposable(
            startIcon = R.drawable.ic_baseline_cancel_24,
            endIcon = R.drawable.ic_baseline_cancel_24,
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