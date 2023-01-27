package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText


@Composable
fun ComposableBottomNavItem(
    @DrawableRes icon: Int?,
    @DrawableRes selectedIcon: Int? = null,
    label: String?,
    selected: Boolean = false,
    onClick: () -> Unit,
    badgeType: BadgeType? = null,
    badgeContent: String? = null,
    itemType: ItemType = ItemType.FILLED,
    ixiColor: IxiColor = IxiColor.BlueBottomNavbarAndroid
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick).fillMaxSize()
    ) {
        if (itemType == ItemType.LINED) {
            LinedItem(color = ixiColor.textColor, selected)
        } else {
            Spacer(modifier = Modifier.height(4.dp))
        }
        Spacer(modifier = Modifier.height(3.dp))
        IconWithBadge(
            icon = if (selected && selectedIcon != null) selectedIcon else icon,
            badgeType = badgeType,
            badgeContent = badgeContent,
            tint = if (itemType == ItemType.FILLED && selected) ixiColor.textColor
            else if (itemType == ItemType.LINED && selected) R.color.black
            else null,
            enableBackground = itemType == ItemType.FILLED && selected,
            ixiColor = ixiColor
        )
        Spacer(modifier = Modifier.height(2.dp))
        if (label != null) {
            if (selected && itemType == ItemType.FILLED) {
                TypographyText(text = label, textStyle = IxiTypography.Body.XSmall.medium.copy(
                    color = colorResource(
                        id = ixiColor.textColor
                    )
                ))

            } else {
                TypographyText(text = label, textStyle = IxiTypography.Body.XSmall.medium)
            }
        }
    }
}

@Composable
fun IconWithBadge(
    @DrawableRes icon: Int?,
    badgeType: BadgeType? = null,
    badgeContent: String? = null,
    @ColorRes tint: Int? = null,
    enableBackground: Boolean = true,
    ixiColor: IxiColor,
) {
    Box(
        modifier = Modifier
            .width(64.dp)
            .height(34.dp)
    ) {
        if (icon != null) {
            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(34.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .align(Alignment.Center)
                    .then(if (enableBackground) Modifier.background(colorResource(id = ixiColor.pressedColor)) else Modifier)
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = if (tint != null) colorResource(id = tint) else Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(24.dp)
                )
            }
        }
        badgeType?.let {
            NotificationBadge(
                badgeType = badgeType,
                content = badgeContent,
                borderColor = if (enableBackground) ixiColor.pressedColor else ixiColor.bgColor,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
        }
    }
}

@Composable
fun LinedItem(@ColorRes color: Int, enabled: Boolean) {
    Box(
        Modifier
            .width(50.dp)
            .height(4.dp)
            .clip(RoundedCornerShape(bottomEnd = 4.dp, bottomStart = 4.dp))
            .then(if (enabled) Modifier.background(colorResource(id = color)) else Modifier)
    )
}

@Composable
fun NotificationBadge(
    modifier: Modifier = Modifier,
    badgeType: BadgeType,
    content: String? = null,
    @ColorRes borderColor: Int? = R.color.white
) {
    if (badgeType == BadgeType.SMALL) {
        Box(
            modifier = modifier
                .offset(y = (-2).dp)
                .padding(top = 4.dp, end = 16.dp)
        ) {
            Box(
                modifier = modifier
                    .size(12.dp)
                    .background(
                        color = colorResource(id = R.color.r400), shape = CircleShape
                    )
                    .then(
                        if (borderColor != null) Modifier.border(
                            border = BorderStroke(
                                2.dp, color = colorResource(id = borderColor)
                            ),
                            shape = CircleShape
                        ) else Modifier
                    )

            )
        }
    } else if (badgeType == BadgeType.LARGE) {
        Box(modifier = modifier.offset(y = (-2).dp)) {
            Box(
                modifier = modifier
                    .clipToBounds()
                    .then(
                        if (borderColor != null) Modifier.border(
                            border = BorderStroke(
                                2.dp, color = colorResource(id = borderColor)
                            ),
                            shape = CircleShape
                        ) else Modifier
                    )
                    .background(
                        color = colorResource(id = R.color.r400),
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                content?.let {
                    Text(
                        text = content,
                        Modifier
                            .padding(horizontal = 10.dp, vertical = 2.dp)
                            .align(Alignment.Center),
                        style = IxiTypography.Body.XSmall.regular,
                        color = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}

enum class BadgeType {
    SMALL,
    LARGE
}

enum class ItemType {
    LINED,
    FILLED
}