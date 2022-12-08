package com.ixigo.design.sdk.components.topappbar.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun MainToolBar(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    title: String? = null,
    subTitle: String? = null,
    actionText: String? = null,
    @DrawableRes actionIcon1: Int = 0,
    @DrawableRes actionIcon2: Int = 0,
    elevation: Dp = 10.dp,
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.n0),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = elevation
    ) {
        Image(
            painter = painterResource(id = homeIcon),
            contentDescription = "Image",
            modifier = Modifier.padding(start = 5.dp, end = 5.dp),
        )
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
                    textStyle = IxiTypography.Body.XSmall.regular
                )
            }
        }

        if (actionIcon1 != 0) {
            Image(
                painter = painterResource(id = actionIcon1),
                contentDescription = "Image",
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            )
        }
        if (actionIcon2 != 0) {
            Image(
                painter = painterResource(id = actionIcon2),
                contentDescription = "Image",
                modifier = Modifier.padding(start = 5.dp, end = 5.dp),
            )
        }
        if (!actionText.isNullOrEmpty()) {
            Text(text = actionText)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewToolBar() {
    MainToolBar(
        title = "Title",
        actionIcon1 = R.drawable.ic_baseline_cancel_24,
        actionIcon2 = R.drawable.ic_baseline_cancel_24,
        actionText = "Send", elevation = 0.dp
    )
}