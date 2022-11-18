package com.ixigo.design_sdk.components.input_fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R

@Composable
fun OutlinedInputField(
    actionImage: Int = 0,
    drawableStart: Int = 0,
    drawableEnd: Int = 0,
    maxCharCount: Int = 0,
    actionText: String? = "",
    helperText: String = "",
    text: String = "",
    label: String = "",
    hint: String = "",
    tintColor: Int = R.color.black,
    onDrawableStartClick: () -> Unit = {},
    onDrawableEndClick: () -> Unit = {},
    onActionTextClick: () -> Unit = {},
    onActionIconClick: () -> Unit = {},
) {
    val trailingIcons = @Composable {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (!actionText.isNullOrBlank()) {
                Text(
                    text = actionText,
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onActionTextClick() })
            }
            if (drawableEnd != 0) {
                Image(
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onDrawableEndClick() },
                    painter = painterResource(id = drawableEnd),
                    contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                    colorFilter = ColorFilter.tint(colorResource(id = tintColor))
                )
            }
            if (actionImage != 0) {
                Image(
                    painter = painterResource(id = drawableEnd),
                    contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                    colorFilter = ColorFilter.tint(colorResource(id = tintColor)),
                    modifier = Modifier
                        .padding(4.dp)
                        .clickable { onActionIconClick() }
                )
            }
        }
    }

    val leadingIcon = @Composable {
        if (drawableStart != 0) {
            Image(
                painter = painterResource(id = drawableEnd),
                contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                colorFilter = ColorFilter.tint(colorResource(id = tintColor)),
                modifier = Modifier.clickable { onDrawableStartClick() }
            )
        }
    }

    val placeHolder = @Composable {
        if (hint.isNotEmpty()) {
            Text(text = hint)
        }
    }

    val labelComposable = @Composable {
        if (label.isNotEmpty()) {
            Text(text = label)
        }
    }
    val textValue = remember { mutableStateOf(TextFieldValue(text = text)) }
    Column() {
        OutlinedTextField(
            value = textValue.value,
            onValueChange = {
                if (it.text.length <= maxCharCount)
                    textValue.value = it
            },
            label = labelComposable,
            placeholder = placeHolder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcons,
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
        Row {
            if (helperText.isNotEmpty()) {
                Text(
                    text = helperText,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1F)
                )
            }
            val maxCharCountText = if (maxCharCount > 0) maxCharCount.toString() else ""
            if (maxCharCountText.isNotEmpty()) {
                Text(text = "${textValue.value.text.length} / $maxCharCountText")
            }
        }
    }

}