package com.ixigo.design.sdk.components.srp.composables

import androidx.compose.foundation.background
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
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun SrpComposable(
    modifier: Modifier = Modifier,
    data: SrpModel,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = colorResource(id = R.color.n60),
                shape = RoundedCornerShape(percent = 50)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TypographyText(text = data.srcId, textStyle = IxiTypography.Body.Small.medium)
        Icon(
            modifier = Modifier.padding(horizontal = 5.dp),
            painter = painterResource(id = R.drawable.right_arrow),
            contentDescription = ""
        )
        TypographyText(text = data.destId, textStyle = IxiTypography.Body.Small.medium)
        TypographyText(
            modifier = Modifier.padding(horizontal = 5.dp),
            text = "•",
            textStyle = IxiTypography.Body.Small.regular
        )
        TypographyText(text = data.date, textStyle = IxiTypography.Body.Small.regular)
        TypographyText(
            modifier = Modifier.padding(horizontal = 5.dp),
            text = "•",
            textStyle = IxiTypography.Body.Small.regular
        )
        TypographyText(text = data.travellerNumber, textStyle = IxiTypography.Body.Small.regular)
    }
}

@Preview
@Composable
fun SegmentControlPreview() {
    SrpComposable(data = SrpModel("DLI", "FBD", "15 Dec 2022", "188829920"))
}


data class SrpModel(
    val srcId: String,
    val destId: String,
    val date: String,
    val travellerNumber: String,
)