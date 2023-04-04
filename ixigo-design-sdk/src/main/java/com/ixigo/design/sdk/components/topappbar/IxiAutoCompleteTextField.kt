package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.search.composables.SearchViewComposable
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.AutoCompleteTextField

class IxiAutoCompleteTextField @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    var text: String? = null


    @Composable
    override fun Content() {
        with(state.value) {
            AutoCompleteTextField(
                content = {
                    SearchViewComposable(
                        query = query ?: "",
                        onQueryChange = onTextChange,
                        onSearchFocusChange = onSearchFocusChange,
                        requestFocus = requestFocus,
                        onClearQuery = onClearQuery,
                        hint = hint ?: "",
                        backgroundColor = backgroundColor,
                        borderColorFocused = borderColorFocused,
                        borderColorUnfocused = borderColorUnfocused,
                        modifier = Modifier
                            .background(
                                Color.White
                            )
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)
                    )
                }
            )
        }
    }
}