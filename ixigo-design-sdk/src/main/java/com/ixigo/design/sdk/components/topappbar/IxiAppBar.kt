package com.ixigo.design.sdk.components.topappbar

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.topappbar.base.BaseTopAppBar
import com.ixigo.design.sdk.components.topappbar.composable.MainToolBar

/**
 * https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=926-105703&mode=design&t=UdbrnsPY7euxQxTu-0
 */

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