package com.ixigo.design_sdk.components.input_fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: (String) -> Unit
) {
    val trailingIcons = getTrailingActions(
        actionText,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        tintColor,
        actionImage,
        onActionIconClick
    )

    val leadingIcon = getLeadingAction(drawableStart, onDrawableStartClick, tintColor)

    val placeHolder = getPlaceHolder(hint)

    val labelComposable = getPlaceHolder(label)
    val textValue = remember { mutableStateOf(TextFieldValue(text = text)) }
    Column(Modifier.width(IntrinsicSize.Min)) {
        OutlinedTextField(
            value = textValue.value,
            onValueChange = {
                if (it.text.length <= maxCharCount)
                    textValue.value = it
                onTextChange(it.text)
            },
            label = labelComposable,
            placeholder = placeHolder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcons,
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start),
            modifier = Modifier.fillMaxWidth()
        )
        GetBottomText(helperText, maxCharCount, textValue)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LinedInputField(
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
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: (String) -> Unit
) {
    val trailingIcons = getTrailingActions(
        actionText,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        tintColor,
        actionImage,
        onActionIconClick
    )

    val leadingIcon = getLeadingAction(drawableStart, onDrawableStartClick, tintColor)

    val placeHolder = getPlaceHolder(hint)

    val labelComposable = getPlaceHolder(label)
    val textValue = remember { mutableStateOf(TextFieldValue(text = text)) }

    Column(Modifier.width(IntrinsicSize.Min)) {
        TextField(
            value = textValue.value,
            onValueChange = {
                if (it.text.length <= maxCharCount)
                    textValue.value = it
                onTextChange(it.text)
            },

            label = labelComposable,
            placeholder = placeHolder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcons,
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start),
            modifier = Modifier.padding(0.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
            ),

            )


        GetBottomText(helperText, maxCharCount, textValue)
    }
}


@Composable
private fun GetBottomText(
    helperText: String,
    maxCharCount: Int,
    textValue: MutableState<TextFieldValue>
) {
    Row {
        if (helperText.isNotEmpty()) {
            Text(
                text = helperText,
                textAlign = TextAlign.Start,
            )
        }
        val maxCharCountText = if (maxCharCount > 0) maxCharCount.toString() else ""
        if (helperText.isNotEmpty() || maxCharCountText.isNotEmpty()) {
            Spacer(modifier = Modifier.weight(1f))
        }
        if (maxCharCountText.isNotEmpty()) {
            Text(text = "${textValue.value.text.length} / $maxCharCountText")
        }
    }
}

@Composable
private fun getPlaceHolder(hint: String): @Composable () -> Unit {
    val placeHolder = @Composable {
        if (hint.isNotEmpty()) {
            Text(text = hint, modifier = Modifier.padding(0.dp))
        }
    }
    return placeHolder
}

@Composable
private fun getLeadingAction(
    drawableStart: Int,
    onDrawableStartClick: () -> Unit,
    tintColor: Int
): (@Composable () -> Unit)? {
    return if (drawableStart != 0) {
        @Composable {
            IconButton(onClick = onDrawableStartClick) {
                Image(
                    painter = painterResource(id = drawableStart),
                    contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                    colorFilter = ColorFilter.tint(colorResource(id = tintColor)),
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    } else {
        null
    }
}

@Composable
private fun getTrailingActions(
    actionText: String?,
    onActionTextClick: () -> Unit,
    drawableEnd: Int,
    onDrawableEndClick: () -> Unit,
    tintColor: Int,
    actionImage: Int,
    onActionIconClick: () -> Unit
): (@Composable () -> Unit) {
    val trailingIcons = @Composable {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (!actionText.isNullOrBlank()) {
                TextButton(onClick = onActionTextClick) {
                    Text(
                        text = actionText,
                        modifier = Modifier
                            .padding(2.dp)
                    )
                }
            }
            if (drawableEnd != 0) {
                IconButton(onClick = onDrawableEndClick) {
                    Image(
                        modifier = Modifier
                            .padding(2.dp),
                        painter = painterResource(id = drawableEnd),
                        contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                        colorFilter = ColorFilter.tint(colorResource(id = tintColor))
                    )
                }
            }
            if (actionImage != 0) {
                IconButton(onClick = onActionIconClick) {
                    Image(
                        painter = painterResource(id = drawableEnd),
                        contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                        colorFilter = ColorFilter.tint(colorResource(id = tintColor)),
                        modifier = Modifier
                            .padding(2.dp)
                    )
                }
            }
        }
    }
    return trailingIcons
}