package com.ixigo.design.sdk.components.inputfields.composables

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.composable.updateWidth
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import java.time.format.TextStyle

private val unFocusColor = R.color.n100

@Composable
fun OutlinedInputField(
    actionImage: Int = 0,
    drawableStartText: String = "",
    drawableStart: Int = 0,
    showLeadingDivider: Boolean = false,
    drawableEnd: Int = 0,
    maxCharCount: Int = Int.MAX_VALUE,
    actionText: String? = "",
    helperText: String = "",
    helperTextColor: Int,
    text: String = "",
    label: String = "",
    width: Int = -1,
    readOnly: Boolean,
    colors: IxiColor = IxiColor.Orange,
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: ((String) -> Unit)?,
    onFocusChange: ((Boolean) -> Unit)?,
    isActiveAlways: Boolean,
    enabled: Boolean,
    keyboardType: KeyboardType,
    capitalization: KeyboardCapitalization
) {

    val trailingIcons = getTrailingActions(
        actionText,
        colors.bgColor,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        actionImage,
        onActionIconClick,
    )

    val leadingIcon = getLeadingAction(drawableStartText, drawableStart, showLeadingDivider,  onDrawableStartClick)

    var textValue by remember(text) { mutableStateOf(text) }

    val isFocussed = remember {
        mutableStateOf(false)
    }

    val labelComposable =
        getPlaceHolder(label, colors, isFocussed.value, textValue)

    Column(Modifier.updateWidth(width)) {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                if (it.length <= maxCharCount) {
                    if(keyboardType == KeyboardType.Number) {
                        if(it.all { c -> c.isDigit() }) {
                            textValue = it
                            onTextChange?.invoke(textValue)
                        }
                    } else {
                        textValue = it
                        onTextChange?.invoke(textValue)
                    }
                }
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
                    onFocusChange?.let { it1 -> it1(it.isFocused) }
                }
                .padding(PaddingValues(0.dp)),
            colors = getInputFieldColors(colors, isActiveAlways),
            readOnly = readOnly,
            shape = RoundedCornerShape(size = 10.dp),
            enabled = enabled,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, capitalization = capitalization),
        )
        GetBottomText(helperText, helperTextColor, maxCharCount, textValue)
    }
}

@Composable
private fun getInputFieldColors(colors: IxiColor, isActiveAlways: Boolean) =
    TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = colorResource(id = colors.bgColor),
        unfocusedBorderColor = colorResource(id = if (isActiveAlways) colors.bgColor else unFocusColor),
        textColor = colorResource(id = R.color.n800),
        cursorColor = colorResource(id = colors.bgColor),
        focusedLabelColor = colorResource(id = colors.bgColor),
        unfocusedLabelColor = colorResource(id = R.color.n800),
        placeholderColor = colorResource(id = colors.bgColor),
    )

@Composable
private fun GetBottomText(
    helperText: String,
    @ColorRes helperTextColor: Int,
    maxCharCount: Int,
    textValue: String
) {
    Row(modifier = Modifier.padding(top = 2.dp)) {
        Spacer(modifier = Modifier.width(15.dp).height(1.dp))
        if (helperText.isNotEmpty()) {
            TypographyText(
                text = helperText,
                textAlign = TextAlign.Start,
                textStyle = IxiTypography.Body.XSmall.regular.copy(color = colorResource(id = helperTextColor))
            )
        }
        val maxCharCountText = if (maxCharCount > 0) maxCharCount.toString() else ""
        if (helperText.isNotEmpty() || maxCharCountText.isNotEmpty()) {
            Spacer(modifier = Modifier.weight(1f))
        }
        if (maxCharCountText.isNotEmpty() && maxCharCount != Int.MAX_VALUE) {
            TypographyText(
                text = "${textValue.length} / $maxCharCountText",
                textStyle = IxiTypography.Body.XSmall.regular.copy(color = colorResource(id = R.color.n600))
            )
        }
        Spacer(modifier = Modifier.width(15.dp).height(1.dp))
    }
}

@Composable
private fun getPlaceHolder(
    hint: String,
    ixiColor: IxiColor,
    isFocussed: Boolean,
    inputFieldTextValue: String
): @Composable () -> Unit {

    val color = if (isFocussed) ixiColor.bgColor else R.color.n600
    val typography =
        if (isFocussed || inputFieldTextValue.isNotEmpty()) {
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
    drawableStartText: String,
    drawableStart: Int,
    showLeadingDivider: Boolean,
    onDrawableStartClick: () -> Unit,
): (@Composable () -> Unit)? {
    return if (drawableStart != 0) {
        @Composable {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                .height(IntrinsicSize.Min)
                .clickable(onClick = onDrawableStartClick)) {
                Text(
                    text = drawableStartText,
                    modifier = Modifier
                        .padding(start = 16.dp),
                    color = colorResource(id = R.color.n800),
                    style = LocalTextStyle.current.copy(textAlign = TextAlign.Start)
                )

                Image(
                    painter = painterResource(id = drawableStart),
                    contentDescription = stringResource(id = R.string.outlined_input_drawable_end_des),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                if(showLeadingDivider) {
                    Divider(
                        color = colorResource(id = R.color.n100),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .fillMaxHeight()
                            .width(1.dp)
                    )
                }
            }
        }
    } else {
        null
    }
}

@Composable
private fun getTrailingActions(
    actionText: String?,
    @ColorRes actionTextColor: Int,
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
                            .padding(end = 8.dp),
                        color = colorResource(id = actionTextColor)
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
    drawableStartText: String ="",
    showLeadingDivider: Boolean = false,
    drawableStart: Int = 0,
    drawableEnd: Int = 0,
    maxCharCount: Int = 0,
    actionText: String? = "",
    helperText: String = "",
    helperTextColor: Int,
    text: String = "",
    label: String = "",
    width: Int = -1,
    colors: IxiColor = IxiColor.Orange,
    readOnly: Boolean,
    keyboardType: KeyboardType,
    onDrawableStartClick: () -> Unit,
    onDrawableEndClick: () -> Unit,
    onActionTextClick: () -> Unit,
    onActionIconClick: () -> Unit,
    onTextChange: ((String) -> Unit)?,
    onFocusChange: ((Boolean) -> Unit)?,
    capitalization: KeyboardCapitalization
) {

    val trailingIcons = getTrailingActions(
        actionText,
        colors.bgColor,
        onActionTextClick,
        drawableEnd,
        onDrawableEndClick,
        actionImage,
        onActionIconClick,
    )

    val leadingIcon = getLeadingAction(drawableStartText, drawableStart, showLeadingDivider, onDrawableStartClick)

    var textValue by remember(text) { mutableStateOf(text) }


    val isFocussed = remember {
        mutableStateOf(false)
    }
    val dividerColor = if (isFocussed.value) colors.bgColor else unFocusColor

    val labelComposable =
        getPlaceHolder(label, colors, isFocussed.value, textValue)
    Column(Modifier.updateWidth(width)) {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                if (it.length <= maxCharCount) {
                    if(keyboardType == KeyboardType.Number) {
                        if(it.all { c -> c.isDigit() }) {
                            textValue = it
                            onTextChange?.invoke(textValue)
                        }
                    } else {
                        textValue = it
                        onTextChange?.invoke(textValue)
                    }
                }
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
                    onFocusChange?.let { it1 -> it1(it.isFocused) }
                }
                .padding(PaddingValues(0.dp)),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                textColor = colorResource(id = R.color.n800),
                cursorColor = colorResource(id = colors.bgColor),
                focusedLabelColor = colorResource(id = colors.bgColor),
                unfocusedLabelColor = colorResource(id = R.color.n800)
            ),
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, capitalization = capitalization)
        )
        Divider(color = colorResource(id = dividerColor), modifier = Modifier.padding(top = 0.dp))
        GetBottomText(helperText, helperTextColor, maxCharCount, textValue)
    }

}