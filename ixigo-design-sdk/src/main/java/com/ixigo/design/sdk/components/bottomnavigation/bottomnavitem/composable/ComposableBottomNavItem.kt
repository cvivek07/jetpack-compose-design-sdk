package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable

import android.graphics.drawable.Drawable
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType.LARGE
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType.SMALL
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.utils.DrawablePainter


/**
 *A composable function that creates a bottom navigation item with an icon, a selected icon, a label, and a badge.
 *
 * @param icon The drawable resource ID for the icon to be displayed.
 * @param selectedIcon The drawable resource ID for the icon to be displayed when the item is selected. If not provided, the regular icon will be used.
 * @param label The label to be displayed beneath the icon.
 * @param selected A boolean value indicating whether the item is currently selected.
 * @param onClick A lambda function to be invoked when the item is clicked.
 * @param badgeType The type of badge to be displayed.
 * @param badgeContent The content of the badge.
 */
@Composable
fun ComposableBottomNavItem(
    icon: CompatImage?,
    selectedIcon: CompatImage? = null,
    label: String?,
    selected: Boolean = false,
    onClick: () -> Unit,
    badgeType: BadgeType? = null,
    badgeContent: String? = null,
    ixiColor: IxiColor = IxiColor.BlueBottomNavbar
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(11.dp))
        IconWithBadge(
            icon = if (selected && selectedIcon != null) selectedIcon else icon,
            badgeType = badgeType,
            badgeContent = badgeContent,
            tint = if (selected) ixiColor.textColor
            else null,
            enableBackground = selected,
            ixiColor = ixiColor
        )
        Spacer(modifier = Modifier.height(2.dp))
        if (label != null) {
            if (selected) {
                TypographyText(text = label, maxLines = 2, textAlign = TextAlign.Center, textStyle = IxiTypography.Body.XSmall.medium.copy(
                    color = colorResource(
                        id = ixiColor.textColor
                    ),
                    lineHeight = 16.8.sp
                ))
            } else {
                TypographyText(text = label, maxLines = 2, textAlign = TextAlign.Center, textStyle = IxiTypography.Body.XSmall.medium.copy(
                    lineHeight = 16.8.sp
                ))
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
    }
}

/**
 * A composable that displays an icon with a badge.
 *
 * @param icon The drawable resource ID for the icon.
 * @param badgeType The type of badge to display (small or large).
 * @param badgeContent The text content to display in the badge (if the badge type is set to large).
 * @param tint The color resource ID to tint the icon with.
 * @param enableBackground Whether to display a background behind the icon.
 * @param ixiColor The color theme to use for the background and border of the badge.
 */
@Composable
fun IconWithBadge(
    icon: CompatImage?,
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
                    painter = if(icon.drawable!=null) DrawablePainter(icon.drawable) else painterResource(id = icon.identifier),
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
/**
 * A composable that displays a notification badge.
 *
 * @param modifier The modifier to apply to the badge.
 * @param badgeType The type of badge to display (small or large).
 * @param content The text content to display in the badge (if the badge type is set to large).
 * @param borderColor The color resource ID for the border of the badge.
 */
@Composable
fun NotificationBadge(
    modifier: Modifier = Modifier,
    badgeType: BadgeType,
    content: String? = null,
    @ColorRes borderColor: Int = R.color.white
) {
    if (badgeType == SMALL) {
       SmallBadge(modifier=modifier, borderColor = borderColor)
    } else if (badgeType == LARGE) {
        LargeBadge(modifier = modifier.defaultMinSize(minWidth = 32.dp, minHeight = 20.dp), content = content, borderColor = borderColor)
    }
}

/**
 * A composable function that renders a large badge.
 *
 * @param modifier The modifier to apply to the root box.
 * @param content The text content of the badge.
 * @param borderColor The color of the border. Defaults to R.color.white.
**/
@Composable
fun LargeBadge(
    modifier: Modifier = Modifier,
    content: String? = null,
    @ColorRes borderColor: Int = R.color.white
){
    Box(modifier = modifier.offset(y = (-2).dp)) {
        Box(
            modifier = modifier
                .clipToBounds()
                .border(
                    border = BorderStroke(
                        2.dp, color = colorResource(id = borderColor)
                    ),
                    shape = IxiShape.PillShape.shape
                )
                .background(
                    color = colorResource(id = R.color.r400),
                    shape = IxiShape.PillShape.shape,
                )
        ) {
            content?.let {
                TypographyText(
                    text = content,
                    modifier = Modifier
                        .padding(horizontal = 11.dp, vertical = 4.dp)
                        .align(Alignment.Center),
                    textStyle = IxiTypography.Body.XSmall.regular.copy(
                        color = colorResource(id = R.color.white)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

/**
 * A composable function that renders a small badge.
 *
 * @param modifier The modifier to apply to the root box.
 * @param borderColor The color of the border. Defaults to R.color.white.
 */
@Composable
fun SmallBadge(
    modifier: Modifier = Modifier,
    @ColorRes borderColor: Int? = R.color.white
){
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
}

/**
 * An enum class for representing badge types.
 *
 * @property SMALL the small badge type
 * @property LARGE the large badge type
 */
enum class BadgeType {
    SMALL,
    LARGE
}

@Composable
@Preview(showSystemUi = true)
fun Badge(){
    Column() {
        Spacer(modifier = Modifier.height(100.dp))
        LargeBadge(content="2000k")
    }
}

data class CompatImage(@DrawableRes val identifier: Int = 0, val drawable: Drawable?)