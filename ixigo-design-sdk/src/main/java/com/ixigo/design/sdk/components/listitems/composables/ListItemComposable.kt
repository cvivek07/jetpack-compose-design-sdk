package com.ixigo.design.sdk.components.listitems.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.ComposableTextButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.imageutils.AsyncImageView
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val iconDefaultSize = 18.dp
private val logoDefaultSize = 50.dp
private val avatarDefaultSize = 40.dp

@Composable
fun ListItemComposable(
    padding: PaddingValues = PaddingValues(top = 10.dp, bottom = 10.dp, start = 4.dp, end = 4.dp),
    @DrawableRes startIcon: Int?,
    startIconWidth: Dp?,
    startIconHeight: Dp?,
    startAvatarUrl: String?,
    @DrawableRes startAvatarPlaceHolder: Int?,
    startAvatarWidth: Dp?,
    startAvatarHeight: Dp?,
    @DrawableRes startLogo: Int?,
    startLogoUrl: String?,
    startLogoWidth: Dp?,
    startLogoHeight: Dp?,
    startCheckedValue: Boolean?,
    startCheckChangeListener: (Boolean) -> Unit,
    color: IxiColor = IxiColor.Blue,
    endIcon: Int?,
    endIconWidth: Dp?,
    endIconHeight: Dp?,
    title: String?,
    subTitle: String?,
    metaText: String?,
    endLogo: Int?,
    endLogoUrl: String?,
    endLogoWidth: Dp?,
    endLogoHeight: Dp?,
    endCheckedValue: Boolean?,
    endCheckChangeListener: (Boolean) -> Unit,
    endSwitchValue: Boolean?,
    endSwitchChangeListener: (Boolean) -> Unit,
    endActionText: String?,
    endActionClick: (() -> Unit)? = null,
    onItemClick: (() -> Unit) = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onItemClick)
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftContent(
            icon = startIcon,
            iconWidth = startIconWidth,
            iconHeight = startIconHeight,
            avatarUrl = startAvatarUrl,
            avatarPlaceHolder = startAvatarPlaceHolder,
            avatarWidth = startAvatarWidth,
            avatarHeight = startAvatarHeight,
            logo = startLogo,
            logoUrl = startLogoUrl,
            logoWidth = startLogoWidth,
            logoHeight = startLogoHeight,
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
            iconWidth = endIconWidth,
            iconHeight = endIconHeight,
            logo = endLogo,
            logoUrl = endLogoUrl,
            logoWidth = endLogoWidth,
            logoHeight = endLogoHeight,
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
    @DrawableRes icon: Int?,
    iconWidth: Dp?,
    iconHeight: Dp?,
    avatarUrl: String?,
    @DrawableRes avatarPlaceHolder: Int?,
    avatarWidth: Dp?,
    avatarHeight: Dp?,
    @DrawableRes logo: Int?,
    logoUrl: String?,
    logoWidth: Dp?,
    logoHeight: Dp?,
    checkedValue: Boolean?,
    checkChangeListener: (Boolean) -> Unit,
    color: IxiColor
) {
    if (icon != null) {
        Icon(
            modifier = Modifier
                .width(iconWidth ?: iconDefaultSize)
                .height(iconHeight ?: iconDefaultSize),
            painter = painterResource(id = icon),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (checkedValue != null) {
        DrawCheckBox(color, checkedValue, checkChangeListener)
    }

    if (avatarUrl != null) {
        AsyncImageView(
            modifier = Modifier
                .width(avatarWidth ?: avatarDefaultSize)
                .height(avatarHeight ?: avatarDefaultSize),
            url = avatarUrl,
            placeholder = avatarPlaceHolder,
            contentDes = null,
            shape = CircleShape,
            scale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (logoUrl != null) {
        AsyncImageView(
            modifier = Modifier
                .width(logoWidth ?: logoDefaultSize)
                .height(logoHeight ?: logoDefaultSize),
            url = logoUrl,
            placeholder = logo,
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
                    maxLines = 1
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
    @DrawableRes icon: Int?,
    iconWidth: Dp?,
    iconHeight: Dp?,
    @DrawableRes logo: Int?,
    logoUrl: String?,
    logoWidth: Dp?,
    logoHeight: Dp?,
    checkedValue: Boolean?,
    checkChangeListener: (Boolean) -> Unit,
    switchValue: Boolean?,
    switchChangeListener: (Boolean) -> Unit,
    actionText: String?,
    actionClick: (() -> Unit)? = null,
    color: IxiColor = IxiColor.Blue
) {
    if (icon != null) {
        Icon(
            modifier = Modifier
                .width(iconWidth ?: iconDefaultSize)
                .height(iconHeight ?: iconDefaultSize),
            painter = painterResource(id = icon),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.width(10.dp))
    }

    if (checkedValue != null) {
        DrawCheckBox(color, checkedValue, checkChangeListener)
    }

    if (logoUrl != null) {
        AsyncImageView(
            modifier = Modifier
                .width(logoWidth ?: logoDefaultSize)
                .height(logoHeight ?: logoDefaultSize),
            url = logoUrl,
            placeholder = logo,
            contentDes = null,
            shape = CircleShape,
            scale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(10.dp))
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
        ComposableTextButton(color = color, size = ButtonSize.Small)
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