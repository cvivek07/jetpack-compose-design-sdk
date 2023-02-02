package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.inputfields.base.TextChangeListener
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.SearchBar

class IxiSearchBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {

    var text: String? = null
    var textChangeListener: TextChangeListener? = null


    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            SearchBar(
                homeIcon = homeIcon,
                elevation = elevation,
                menuProvider = menuProvider,
                onQueryChange = {
                    text = it
                    textChangeListener?.onTextChange(it)
                }
            )
        }
    }
}