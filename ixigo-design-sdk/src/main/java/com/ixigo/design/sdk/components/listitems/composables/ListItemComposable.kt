package com.ixigo.design.sdk.components.listitems.composables

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.TextButton
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.AsyncImageView
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val iconDefaultSize = 18.dp
private val logoDefaultSize = 50.dp
private val avatarDefaultSize = 40.dp

@Composable
fun ListItemComposable(
    padding: PaddingValues = PaddingValues(top = 10.dp, bottom = 10.dp, start = 4.dp, end = 4.dp),
    startIcon: ImageData?,
    startAvatar: ImageData?,
    startLogo: ImageData?,
    startCheckedValue: Boolean?,
    startCheckChangeListener: (Boolean) -> Unit,
    color: IxiColor = IxiColor.Blue,
    endIcon: ImageData?,
    title: String?,
    subTitle: String?,
    metaText: String?,
    endLogo: ImageData?,
    endCheckedValue: Boolean?,
    endCheckChangeListener: (Boolean) -> Unit,
    endSwitchValue: Boolean?,
    endSwitchChangeListener: (Boolean) -> Unit,
    endActionText: String?,
    endActionClick: (() -> Unit)? = null,
    onItemClick: (() -> Unit) = {},
    @ColorRes itemBackGroundColor: Int = R.color.n0
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onItemClick)
            .background(color = colorResource(id = itemBackGroundColor))
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftContent(
            icon = startIcon,
            avatar = startAvatar,
            logo = startLogo,
            checkedValue = startCheckedValue,
            checkChangeListener = startCheckChangeListener,
            color = color
        )

        MiddleContent(
            title = title, subTitle = subTitle, meta = metaText, modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )

        RightContent(
            icon = endIcon,
            logo = endLogo,
            checkedValue = endCheckedValue,
            checkChangeListener = endCheckChangeListener,
            switchValue = endSwitchValue,
            switchChangeListener = endSwitchChangeListener,
            actionText = endActionText,
            actionClick = endActionClick,
            color = color
        )
    }
}

@Composable
fun LeftContent(
    icon: ImageData?,
    avatar: ImageData?,
    logo: ImageData?,
    checkedValue: Boolean?,
    checkChangeListener: (Boolean) -> Unit,
    color: IxiColor
) {
    if (icon != null) {

        icon.getPainterForImage()?.let {
            Icon(
                modifier = Modifier
                    .width(icon.width ?: iconDefaultSize)
                    .height(icon.height ?: iconDefaultSize),
                painter = it,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }

    if (checkedValue != null) {
        DrawCheckBox(color, checkedValue, checkChangeListener)
    }

    if (avatar != null) {
        AsyncImageView(
            modifier = Modifier
                .width(avatar.width ?: avatarDefaultSize)
                .height(avatar.height ?: avatarDefaultSize),
            url = avatar.url ?: "",
            placeholder = avatar.drawableRes,
            contentDes = null,
            shape = CircleShape,
            scale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (logo != null) {
        AsyncImageView(
            modifier = Modifier
                .width(logo.width ?: logoDefaultSize)
                .height(logo.height ?: logoDefaultSize),
            url = logo.url ?: "",
            placeholder = logo.drawableRes,
            contentDes = null,
            shape = CircleShape,
            scale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}

@Composable
fun MiddleContent(title: String?, subTitle: String?, meta: String?, modifier: Modifier) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            if (!title.isNullOrBlank()) {
                TypographyText(
                    text = title,
                    Modifier.weight(1f),
                    textStyle = IxiTypography.Body.Medium.regular,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (!meta.isNullOrBlank()) {
                TypographyText(
                    text = meta,
                    textStyle = IxiTypography.Body.XSmall.regular
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
        if (!subTitle.isNullOrBlank()) {
            TypographyText(
                text = subTitle,
                textStyle = IxiTypography.Body.Small.regular
            )
        }
    }

}


@Composable
fun RightContent(
    icon: ImageData?,
    logo: ImageData?,
    checkedValue: Boolean?,
    checkChangeListener: (Boolean) -> Unit,
    switchValue: Boolean?,
    switchChangeListener: (Boolean) -> Unit,
    actionText: String?,
    actionClick: (() -> Unit)? = null,
    color: IxiColor = IxiColor.Blue
) {
    if (icon != null) {
        icon.getPainterForImage()?.let {
            Icon(
                modifier = Modifier
                    .width(icon.width ?: iconDefaultSize)
                    .height(icon.height ?: iconDefaultSize),
                painter = it,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (logo != null) {
        AsyncImageView(
            modifier = Modifier
                .width(logo.width ?: logoDefaultSize)
                .height(logo.height ?: logoDefaultSize),
            url = logo.url?:"",
            placeholder = logo.drawableRes,
            contentDes = null,
            shape = CircleShape,
            scale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
    }


    if (checkedValue != null) {
        DrawCheckBox(color, checkedValue, checkChangeListener)
    }

    if (switchValue != null) {
        val switchState = remember { mutableStateOf(switchValue) }

        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value = it
                switchChangeListener(it)
            },
            thumbContent = { DrawThumb(color = color, switchState.value) },
            colors = SwitchDefaults.colors(
                checkedTrackColor = colorResource(id = color.bgColor),
                uncheckedTrackColor = colorResource(id = R.color.n100),
                uncheckedThumbColor = colorResource(id = R.color.n0),
                uncheckedBorderColor = colorResource(id = R.color.n100)
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (!actionText.isNullOrBlank()) {
        TextButton(onClick = actionClick ?: {}) {
            TypographyText(
                text = actionText, textStyle = IxiTypography.Button.Small.regular.copy(
                    color = colorResource(
                        id = color.bgColor
                    )
                )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
    }


}

@Composable
fun DrawThumb(color: IxiColor, isChecked: Boolean) {

    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(colorResource(id = R.color.n0), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            Image(
                painter = painterResource(id = R.drawable.ic_switch_thumb_tick),
                contentDescription = "",
                colorFilter = ColorFilter.tint(color = colorResource(id = color.bgColor))
            )
        }
    }
}

@Composable
fun DrawCheckBox(color: IxiColor, checkedValue: Boolean, checkChangeListener: (Boolean) -> Unit) {
    val checkedState = remember {
        mutableStateOf(checkedValue)
    }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = {
            checkedState.value = it
            checkChangeListener(it)
        },
        colors = CheckboxDefaults.colors(
            checkedColor = colorResource(id = color.bgColor),
        )
    )
}