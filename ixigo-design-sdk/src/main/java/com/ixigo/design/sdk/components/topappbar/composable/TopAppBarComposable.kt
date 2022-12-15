package com.ixigo.design.sdk.components.topappbar.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun MainToolBar(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    homeIconClick: () -> Unit = {},
    title: String? = null,
    subTitle: String? = null,
    actionText: String? = null,
    actionTextClick: () -> Unit = {},
    @DrawableRes actionIcon1: Int = 0,
    actionIcon1Click: () -> Unit = {},
    @DrawableRes actionIcon2: Int = 0,
    actionIcon2Click: () -> Unit = {},
    elevation: Dp = 0.dp,
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.n0),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(elevation),
        elevation = elevation,
        contentPadding = PaddingValues(0.dp)
    ) {
        if (homeIcon != 0) {
            IconButton(onClick = homeIconClick) {
                Image(
                    painter = painterResource(id = homeIcon),
                    contentDescription = "Image",
                )
            }
        }
        Column(Modifier.weight(1f)) {
            if (title != null) {
                TypographyText(
                    text = title,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textStyle = if (subTitle.isNullOrEmpty()) {
                        IxiTypography.Heading.H5.regular
                    } else {
                        IxiTypography.Heading.H6.regular
                    }
                )
            }
            if (!subTitle.isNullOrBlank()) {
                TypographyText(
                    text = subTitle,
                    textStyle = IxiTypography.Body.XSmall.regular,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
            }
        }

        if (actionIcon1 != 0) {
            IconButton(onClick = actionIcon1Click) {
                Image(
                    painter = painterResource(id = actionIcon1),
                    contentDescription = "Image",
                )
            }
        }
        if (actionIcon2 != 0) {
            IconButton(onClick = actionIcon2Click) {
                Image(
                    painter = painterResource(id = actionIcon2),
                    contentDescription = "Image",
                )
            }
        }
        if (!actionText.isNullOrEmpty()) {
            TextButton(onClick = actionTextClick) {
                Text(
                    text = actionText,
                )
            }
        }

    }
}

@Preview(showSystemUi = true, backgroundColor = 0xD9FF00FF)
@Composable
fun PreviewToolBar() {
    MainToolBar(
        title = "Title",
        subTitle = "Subtitle",
        actionIcon1 = R.drawable.ic_baseline_cancel_24,
        actionIcon2 = R.drawable.ic_baseline_cancel_24,
        actionText = "Send",
        elevation = 10.dp
    )
}