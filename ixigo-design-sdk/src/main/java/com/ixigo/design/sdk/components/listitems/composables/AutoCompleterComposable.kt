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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun AutoCompleterComposable(
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    title: String?,
    from: String?,
    to: String?,
    subTitle: String? = null,
    onItemClick: () -> Unit,
    onEndIconClick: () -> Unit,
    onStartIconClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val rowBgColor = if (isPressed) R.color.n40 else R.color.n0
    Row(
        modifier = Modifier
            .background(color = colorResource(id = R.color.n0))
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 15.dp, top = 20.dp, bottom = 20.dp, end = 32.dp)
            .safeContentPadding()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = colorResource(id = R.color.n40)
                ),
            ) {
                onItemClick()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

        ) {

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
//                .clickable { onStartIconClick() },

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
            }
        }

        Spacer(modifier = Modifier.width(15.dp))
        Column(
            modifier = Modifier.weight(1F)
        ) {
            if (title != null) {
                TypographyText(text = title, textStyle = IxiTypography.Body.Medium.regular)
            } else {
                FromToTitleView(from = from ?: "", to = to ?: "")
            }

            if (!subTitle.isNullOrBlank()) {
                TypographyText(text = subTitle, textStyle = IxiTypography.Body.XSmall.regular)
            }

        }

        if (endIcon != null) {
            Icon(
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
//                    .clickable { onEndIconClick() },
                painter = painterResource(id = endIcon),
                contentDescription = "",
            )

        }
    }
}

@Composable
fun FromToTitleView(from: String, to: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TypographyText(text = from, textStyle = IxiTypography.Body.Medium.regular)
        Icon(
            modifier = Modifier.padding(horizontal = 5.dp),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = ""
        )
        TypographyText(text = to, textStyle = IxiTypography.Body.Medium.regular)
    }
}

@Preview(showSystemUi = true)
@Composable
fun showPreviewList() {
    Column(modifier = Modifier.fillMaxSize()) {
        AutoCompleterComposable(
            startIcon = R.drawable.ic_baseline_cancel_24,
            endIcon = R.drawable.ic_baseline_cancel_24,
            title = null,
            subTitle = "State name",
            from = "Delhi",
            to = "Mumbai",
            onItemClick = {},
            onEndIconClick = {},
            onStartIconClick = {}
        )
    }

}