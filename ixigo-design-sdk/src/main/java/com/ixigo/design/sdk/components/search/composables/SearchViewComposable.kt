package com.ixigo.design.sdk.components.search.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun SearchViewComposable(
    query: TextFieldValue,
    onQueryChange: (TextFieldValue) -> Unit,
    onSearchFocusChange: (Boolean) -> Unit,
    onClearQuery: () -> Unit,
    hint: String,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    TextField(
        value = query,
        onValueChange = onQueryChange,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.n500),
            disabledTextColor = colorResource(id = R.color.n700),
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(
                color = colorResource(id = R.color.n60),
                shape = RoundedCornerShape(percent = 50)
            )
            .onFocusChanged {
                onSearchFocusChange(it.isFocused)
            }
            .focusRequester(focusRequester)

            .padding(top = 9.dp, bottom = 8.dp, start = 24.dp, end = 8.dp),
        singleLine = true,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        },
        label = {
            TypographyText(
                text = hint,
                textStyle = IxiTypography.Body.Medium.regular.copy(color = colorResource(id = R.color.n700))
            )
        }
    )
}

@Preview
@Composable
fun SearchPreview() {
    SearchViewComposable(
        query = TextFieldValue(),
        onQueryChange = {},
        onSearchFocusChange = {},
        onClearQuery = { },
        hint = "Search"
    )
}