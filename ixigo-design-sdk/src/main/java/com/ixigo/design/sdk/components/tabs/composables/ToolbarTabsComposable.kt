package com.ixigo.design.sdk.components.tabs.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.ComposableButtonOutlined
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider


@Composable
fun ToolbarTabsComposable(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    modifier: Modifier = Modifier,
    data: List<String>,
    onItemSelection: (selectedItemIndex: Int) -> Unit
) {

    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = colorResource(id = R.color.n60),
                shape = RoundedCornerShape(percent = 50)
            )
    ) {
        items(data.size) { index ->
            ComposableButtonOutlined(
                text = data[index],
                colors = IxiColor.Blue,
                size = ButtonSize.Medium,
                shapes = ButtonShape.PillShape,
                onClick = { onItemSelection(index) },
            )
        }
    }
}

@Composable
fun PillTabComposable(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = 0,
    @DrawableRes endIcon: Int = 0,
    text: String?,
    isSelected: Boolean = false
) {
    val borderColor = if (isSelected) R.color.b500 else R.color.n300
    val bgColor = if (isSelected) R.color.b50 else R.color.n0
    val textColor =
        if (isSelected) colorResource(id = R.color.b500) else IxiTypography.Body.Medium.regular.color
    Row(
        verticalAlignment = Alignment.CenterVertically,

        modifier = modifier
            .wrapContentWidth()
            .height(40.dp)
            .border(
                border = BorderStroke(1.dp, colorResource(id = borderColor)),
                shape = ButtonShape.PillShape.shape
            )
            .background(
                color = colorResource(id = bgColor),
                shape = ButtonShape.PillShape.shape
            )
            .padding(8.dp),
    ) {
        if (startIcon != 0) {
            Icon(painter = painterResource(id = startIcon), contentDescription = "")
        }
        if (!text.isNullOrBlank()) {
            TypographyText(
                text = text,
                textStyle = IxiTypography.Body.Medium.regular.copy(color = textColor),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        if (endIcon != 0) {
            Icon(painter = painterResource(id = endIcon), contentDescription = "")
        }
    }
}

@Composable
fun LineTabComposable(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = 0,
    @DrawableRes endIcon: Int = 0,
    text: String?,
    isSelected: Boolean = false
) {
    val textColor =
        if (isSelected) colorResource(id = R.color.b500) else IxiTypography.Body.Medium.regular.color
    Column(modifier = Modifier.width(IntrinsicSize.Max)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .wrapContentWidth()
                .height(40.dp)
                .padding(8.dp),
        ) {
            if (startIcon != 0) {
                Icon(painter = painterResource(id = startIcon), contentDescription = "")
            }
            if (!text.isNullOrBlank()) {
                TypographyText(
                    text = text,
                    textStyle = IxiTypography.Body.Medium.regular.copy(color = textColor),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            if (endIcon != 0) {
                Icon(painter = painterResource(id = endIcon), contentDescription = "")
            }
        }
        if(isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(color = colorResource(id = R.color.b500))
            )
        }
    }

}
