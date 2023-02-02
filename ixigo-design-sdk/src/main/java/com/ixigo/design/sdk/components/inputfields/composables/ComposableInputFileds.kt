package com.ixigo.design.sdk.components.inputfields.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.updateWidth
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiFamily
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val unFocusColor = R.color.n100

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
    width: Int = -1,
    colors: IxiColor = IxiColor.Orange,
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: ((String) -> Unit)?
) {

    val trailingIcons = getTrailingActions(
        actionText,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        actionImage,
        onActionIconClick,
    )

    val leadingIcon = getLeadingAction(drawableStart, onDrawableStartClick)

    val textValue = remember { mutableStateOf(TextFieldValue(text = text)) }

    val isFocussed = remember {
        mutableStateOf(false)
    }

    val labelComposable = getPlaceHolder(label, colors, isFocussed.value || textValue.value.text.isNotBlank())

    Column(Modifier.updateWidth(width)) {
        OutlinedTextField(
            value = textValue.value,
            onValueChange = {
                if (it.text.length <= maxCharCount)
                    textValue.value = it
                onTextChange?.invoke(it.text)
            },
            label = labelComposable,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcons,
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    isFocussed.value = it.isFocused
                },
            colors = getInputFieldColors(colors),
        )
        GetBottomText(helperText, maxCharCount, textValue)
    }
}

@Composable
private fun getInputFieldColors(colors: IxiColor) =
    TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = colorResource(id = colors.bgColor),
        unfocusedBorderColor = colorResource(id = unFocusColor),
        textColor = colorResource(id = R.color.n800),
        cursorColor = colorResource(id = colors.bgColor),
        focusedLabelColor = colorResource(id = colors.bgColor),
        unfocusedLabelColor = colorResource(id = R.color.n800),
        placeholderColor = colorResource(id = colors.bgColor),
    )

@Composable
private fun GetBottomText(
    helperText: String,
    maxCharCount: Int,
    textValue: MutableState<TextFieldValue>
) {
    Row {
        if (helperText.isNotEmpty()) {
            TypographyText(
                text = helperText,
                textAlign = TextAlign.Start,
                textStyle = IxiTypography.Body.XSmall.regular.copy(color = colorResource(id = R.color.n600))
            )
        }
        val maxCharCountText = if (maxCharCount > 0) maxCharCount.toString() else ""
        if (helperText.isNotEmpty() || maxCharCountText.isNotEmpty()) {
            Spacer(modifier = Modifier.weight(1f))
        }
        if (maxCharCountText.isNotEmpty() && maxCharCount != Int.MAX_VALUE) {
            TypographyText(
                text = "${textValue.value.text.length} / $maxCharCountText",
                textStyle = IxiTypography.Body.XSmall.regular.copy(color = colorResource(id = R.color.n600))
            )
        }
    }
}

@Composable
private fun getPlaceHolder(
    hint: String,
    ixiColor: IxiColor,
    isFocussed: Boolean
): @Composable () -> Unit {

    val color = if (isFocussed) ixiColor.bgColor else R.color.n600
    val typography =
        if (isFocussed) {
            IxiTypography.Body.XSmall.regular.copy(color = colorResource(id = color))
        } else {
            IxiTypography.Body.Medium.regular.copy(
                color = colorResource(id = color)
            )
        }
    val placeHolder = @Composable {
        if (hint.isNotEmpty()) {
            TypographyText(
                text = hint,
                modifier = Modifier.padding(0.dp),
                textStyle = typography
            )
        }
    }
    return placeHolder
}

@Composable
private fun getLeadingAction(
    drawableStart: Int,
    onDrawableStartClick: () -> Unit,
): (@Composable () -> Unit)? {
    return if (drawableStart != 0) {
        @Composable {
            IconButton(onClick = onDrawableStartClick) {
                Image(
                    painter = painterResource(id = drawableStart),
                    contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
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
    actionImage: Int,
    onActionIconClick: () -> Unit,
): (@Composable () -> Unit)? {
    if (actionText.isNullOrBlank() && drawableEnd == 0 && actionImage == 0) {
        return null
    }

    val trailingIcons = @Composable {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.wrapContentWidth()
        ) {
            if (!actionText.isNullOrBlank()) {
                TextButton(onClick = onActionTextClick) {
                    Text(
                        text = actionText,
                        modifier = Modifier
                            .padding(2.dp),
                        color = colorResource(id = R.color.n600)
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
//                        colorFilter = ColorFilter.tint(colorResource(id = drawableTint)),
                    )
                }
            }
            if (actionImage != 0) {
                IconButton(onClick = onActionIconClick) {
                    Image(
                        painter = painterResource(id = drawableEnd),
                        contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                        modifier = Modifier.padding(2.dp),
//                        colorFilter = ColorFilter.tint(colorResource(id = drawableTint)),
                    )
                }
            }
        }
    }
    return trailingIcons
}


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
    width: Int = -1,
    colors: IxiColor = IxiColor.Orange,
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: ((String) -> Unit)?
) {

    val trailingIcons = getTrailingActions(
        actionText,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        actionImage,
        onActionIconClick,
    )

    val leadingIcon = getLeadingAction(drawableStart, onDrawableStartClick)

    val textValue = remember { mutableStateOf(TextFieldValue(text = text)) }


    val isFocussed = remember {
        mutableStateOf(false)
    }
    val dividerColor = if (isFocussed.value) colors.bgColor else unFocusColor
    val labelComposable = getPlaceHolder(label, colors, isFocussed.value || textValue.value.text.isNotBlank())
//    val labelComposable = getPlaceHolder(label, placeholderTextColor.value)
    Column(Modifier.updateWidth(width)) {
        OutlinedTextField(
            value = textValue.value,
            onValueChange = {
                if (it.text.length <= maxCharCount)
                    textValue.value = it
                onTextChange?.invoke(it.text)
            },
            label = labelComposable,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcons,
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Start),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { isFocussed.value = it.isFocused }.padding(PaddingValues(0.dp)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                textColor = colorResource(id = R.color.n800),
                cursorColor = colorResource(id = colors.bgColor),
                focusedLabelColor = colorResource(id = colors.bgColor),
                unfocusedLabelColor = colorResource(id = R.color.n800)
            ),
        )
        Divider(color = colorResource(id = dividerColor), modifier = Modifier.padding(top = 0.dp))
        GetBottomText(helperText, maxCharCount, textValue)
    }

}