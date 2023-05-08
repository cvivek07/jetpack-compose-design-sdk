package com.ixigo.design.sdk.components.search.composables

import androidx.annotation.ColorRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import kotlinx.coroutines.launch

@Composable
fun SearchViewComposable(
    query: String,
    onQueryChange: ((String) -> Unit),
    onSearchFocusChange: ((Boolean) -> Unit),
    requestFocus: Boolean,
    onClearQuery: (() -> Unit),
    hint: String,
    @ColorRes backgroundColor: Int,
    @ColorRes borderColorFocused: Int,
    @ColorRes borderColorUnfocused: Int,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember {
        FocusRequester()
    }
    var queryText by remember(query) { mutableStateOf(query) }

    val scope = rememberCoroutineScope()
    val windowInfo = LocalWindowInfo.current

    LaunchedEffect(requestFocus) {
        snapshotFlow { windowInfo.isWindowFocused }.collect { isWindowFocused ->
            if (isWindowFocused && requestFocus) {
                focusRequester.requestFocus()
            }
        }
    }

    val trailingIconView = @Composable {
        IconButton(
            onClick = {
                queryText = ""
                focusRequester.requestFocus()
                onClearQuery.invoke()
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
            )
        }
    }
    OutlinedTextField(
        value = queryText,
        onValueChange = {
            queryText = it
            onQueryChange.invoke(it)
        },
        shape = RoundedCornerShape(50.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.n900),
            disabledTextColor = colorResource(id = R.color.n700),
            backgroundColor = colorResource(id = backgroundColor),
            focusedBorderColor = colorResource(id = borderColorFocused),
            unfocusedBorderColor = colorResource(id = borderColorUnfocused),
            cursorColor = colorResource(id = borderColorFocused),
        ),
        modifier = modifier(modifier, onSearchFocusChange, focusRequester),
        singleLine = true,
        trailingIcon = if (queryText.isNotBlank()) trailingIconView else null,
        placeholder = placeholder(hint)
    )
}

@Composable
private fun modifier(
    modifier: Modifier,
    onSearchFocusChange: ((Boolean) -> Unit),
    focusRequester: FocusRequester
): Modifier {
    return modifier
        .fillMaxWidth()
        .height(50.dp)
        .onFocusChanged {
            onSearchFocusChange.invoke(it.isFocused)
        }
        .focusRequester(focusRequester)
}

@Composable
private fun placeholder(hint: String) = (@Composable {
    TypographyText(
        modifier = Modifier.padding(0.dp),
        text = hint,
        textStyle = IxiTypography.Body.Medium.regular.copy(color = colorResource(id = R.color.n300))
    )
})

@Preview
@Composable
fun SearchPreview() {
    SearchViewComposable(
        query = "",
        onQueryChange = {},
        onSearchFocusChange = {},
        requestFocus = false,
        onClearQuery = { },
        hint = "Search",
        backgroundColor = R.color.n0,
        borderColorFocused = R.color.n0,
        borderColorUnfocused = R.color.n300
    )
}