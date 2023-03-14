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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun SrpComposable(
    modifier: Modifier = Modifier,
    data: SrpModel,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = colorResource(id = R.color.n60),
                shape = RoundedCornerShape(percent = 50)
            )
            .clickable(interactionSource = interactionSource, indication = null) {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TypographyText(text = data.startText, textStyle = IxiTypography.Body.Small.medium)
        Icon(
            modifier = Modifier.padding(horizontal = 5.dp),
            painter = painterResource(id = data.icon),
            contentDescription = ""
        )
        TypographyText(text = data.endText, textStyle = IxiTypography.Body.Small.medium)
    }
}

@Preview
@Composable
fun SegmentControlPreview() {
    SrpComposable(data = SrpModel("DLI" , R.drawable.right_arrow,"FBD 15 Dec 1 Traveller"))
}


data class SrpModel(
    val startText: String,
    @DrawableRes val icon: Int,
    val endText: String
)