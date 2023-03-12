package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.MainToolBar

class IxiAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseTopAppBar(context, attrs, defStyleAttr) {
    @Composable
    override fun Content() {
        with(state.value) {
            MainToolBar(
                homeIcon = homeIcon,
                title = title,
                subTitle = subTitle,
                elevation = elevation,
                menuProvider = menuProvider
            )
        }
    }
}