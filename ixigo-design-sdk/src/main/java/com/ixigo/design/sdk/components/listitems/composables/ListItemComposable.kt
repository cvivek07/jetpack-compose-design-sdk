package com.ixigo.design.sdk.components.listitems.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.listitems.base.ListItemDataState
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val iconDefaultSize = 18.dp
private val logoDefaultSize = 50.dp
private val avatarDefaultSize = 40.dp

@Composable
fun ListItemComposable(state: MutableState<ListItemDataState>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = state.value.onItemClick)
            .background(color = colorResource(id = state.value.itemBackGroundColor))
            .padding(state.value.paddingValues),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftContent(
            state = state,
        )

        MiddleContent(
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )

        RightContent(
            state = state,
        )
    }
}

@Composable
fun LeftContent(state: MutableState<ListItemDataState>) {
    with(state.value) {
        if (startIcon != null) {

            startIcon.getPainterForImage()?.let {
                Icon(
                    modifier = Modifier
                        .width(startIcon.width ?: iconDefaultSize)
                        .height(startIcon.height ?: iconDefaultSize),
                    painter = it,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        if (startCheckedValue != null) {
            DrawCheckBox(color, startCheckedValue) {
                startCheckChangeListener(it)
                state.value = state.value.copy(startCheckedValue = it)
            }
        }

        if (startRadioValue != null) {
            DrawRadioButton(color = color, checkedValue = startRadioValue) {
                startRadioChangeListener(it)
                state.value = state.value.copy(startRadioValue = it)
            }
        }
        if (startAvatar != null) {
            AsyncImageView(
                modifier = Modifier
                    .width(startAvatar.width ?: avatarDefaultSize)
                    .height(startAvatar.height ?: avatarDefaultSize),
                url = startAvatar.url ?: "",
                placeholder = startAvatar.drawableRes,
                contentDes = null,
                shape = CircleShape,
                scale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
        }

        if (startLogo != null) {
            AsyncImageView(
                modifier = Modifier
                    .width(startLogo.width ?: logoDefaultSize)
                    .height(startLogo.height ?: logoDefaultSize),
                url = startLogo.url ?: "",
                placeholder = startLogo.drawableRes,
                contentDes = null,
                shape = CircleShape,
                scale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun MiddleContent(
    modifier: Modifier,
    state: MutableState<ListItemDataState>
) {
    with(state.value) {
        Column(modifier = modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (!title.isNullOrBlank()) {
                    TypographyText(
                        text = title,
                        Modifier.weight(1f),
                        textStyle = state.value.titleTypography,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (!metaText.isNullOrBlank()) {
                    TypographyText(
                        text = metaText,
                        textStyle = state.value.metaTextTypography
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
            if (!subTitle.isNullOrBlank()) {
                TypographyText(
                    text = subTitle,
                    textStyle = state.value.subtitleTypography
                )
            }
        }
    }

}


@Composable
fun RightContent(state: MutableState<ListItemDataState>) {
    with(state.value) {
        if (endIcon != null) {
            endIcon.getPainterForImage()?.let {
                Icon(
                    modifier = Modifier
                        .width(endIcon.width ?: iconDefaultSize)
                        .height(endIcon.height ?: iconDefaultSize),
                    painter = it,
                    contentDescription = ""
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }

        if (endLogo != null) {
            AsyncImageView(
                modifier = Modifier
                    .width(endLogo.width ?: logoDefaultSize)
                    .height(endLogo.height ?: logoDefaultSize),
                url = endLogo.url ?: "",
                placeholder = endLogo.drawableRes,
                contentDes = null,
                shape = CircleShape,
                scale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
        }


        if (endCheckedValue != null) {
            DrawCheckBox(color, endCheckedValue) {
                endCheckChangeListener(it)
                state.value = state.value.copy(endCheckedValue = it)
            }
        }

        if (endRadioValue != null) {
            DrawRadioButton(color = color, checkedValue = endRadioValue) {
                endRadioChangeListener(it)
                state.value = state.value.copy(endRadioValue = it)
            }
        }

        if (endSwitchValue != null) {
            DrawSwitch(color = color, switchValue = endSwitchValue) {
                endSwitchChangeListener(it)
                state.value = state.value.copy(endSwitchValue = it)
            }
            Spacer(modifier = Modifier.width(10.dp))
        }

        if (!endActionText.isNullOrBlank()) {
            TextButton(onClick = endActionClick ?: {}) {
                TypographyText(
                    text = endActionText, textStyle = IxiTypography.Button.Small.regular.copy(
                        color = colorResource(
                            id = color.bgColor
                        )
                    )
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun DrawSwitch(
    color: IxiColor,
    switchValue: Boolean,
    switchChangeListener: (Boolean) -> Unit,
) {
    val switchState = remember { mutableStateOf(switchValue) }

    if (switchValue != switchState.value) {
        switchState.value = switchValue
    }

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
fun DrawCheckBox(
    color: IxiColor,
    checkedValue: Boolean,
    checkChangeListener: (Boolean) -> Unit
) {
    val checkedState = remember {
        mutableStateOf(checkedValue)
    }

    if (checkedValue != checkedState.value) {
        checkedState.value = checkedValue
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

@Composable
fun DrawRadioButton(
    color: IxiColor,
    checkedValue: Boolean,
    checkChangeListener: (Boolean) -> Unit
) {
    val checkedState = remember {
        mutableStateOf(checkedValue)
    }

    if (checkedValue != checkedState.value) {
        checkedState.value = checkedValue
    }
    RadioButton(
        selected = checkedState.value,
        onClick = {
            checkedState.value = checkedState.value.not()
            checkChangeListener(checkedState.value)
        },

        colors = RadioButtonDefaults.colors(
            selectedColor = colorResource(id = color.bgColor),
        )
    )
}