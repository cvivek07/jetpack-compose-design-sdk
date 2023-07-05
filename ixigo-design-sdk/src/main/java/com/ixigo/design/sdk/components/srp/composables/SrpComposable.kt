package com.ixigo.design.sdk.components.srp.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun SrpComposable(
    modifier: Modifier = Modifier,
    title: SrpTitle,
    subTitle: String? = null,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = R.color.n60),
                shape = RoundedCornerShape(percent = 50)
            )
            .clickable(interactionSource = interactionSource, indication = null) {
                onClick.invoke()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TypographyText(text = title.startText, textStyle = IxiTypography.Body.Small.medium)
            Icon(
                modifier = Modifier.padding(horizontal = 5.dp),
                painter = painterResource(id = title.icon),
                contentDescription = "",
                tint = Color.Black
            )
            TypographyText(text = title.endText, textStyle = IxiTypography.Body.Small.medium)
        }
        if (!subTitle.isNullOrBlank()) {
            TypographyText(
                text = subTitle,
                textStyle = IxiTypography.Body.XSmall.regular,
                textAlign = TextAlign.Center,
                modifier = Modifier.wrapContentHeight().padding(top = 2.dp),
                color = colorResource(id = R.color.n600),
            )
        }
    }
}

@Preview
@Composable
fun SegmentControlPreview() {
    SrpComposable(title = SrpTitle("DLI", R.drawable.right_arrow, "FBD 15 Dec 1 Traveller"))
}


data class SrpTitle(
    val startText: String,
    @DrawableRes val icon: Int,
    val endText: String
)