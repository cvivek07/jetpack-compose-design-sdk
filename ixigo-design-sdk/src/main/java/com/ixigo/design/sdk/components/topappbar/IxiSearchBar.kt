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


    /**
     * Set the hint text in search bar.
     *
     * @param hint value to be set as hint
     */
    fun setSearchBarHint(hint: String) {
        state.value = state.value.copy(hint = hint)
    }

    fun setSearchFocusChange(listener: ((Boolean)->Unit)?) {
        state.value = state.value.copy (onSearchFocusChange = listener ?:{})
    }

    override fun clearFocus() {
        state.value = state.value.copy (shouldFocus = false)
    }

     fun captureFocus() {
        state.value = state.value.copy (shouldFocus = true)
    }

    fun isFocussed() = state.value.shouldFocus

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            SearchBar(
                homeIcon = homeIcon,
                elevation = elevation,
                menuProvider = menuProvider,
                hint = hint,
                onQueryChange = {
                    text = it
                    textChangeListener?.onTextChange(it)
                },
                onFocusChange = onSearchFocusChange,
                shouldFocus = shouldFocus
            )
        }
    }
}