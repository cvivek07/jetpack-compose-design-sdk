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
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            MainToolBar(
                homeIcon = homeIcon,
                homeIconClick = homeIconClick,
                title = title,
                subTitle = subTitle,
                actionText = actionText,
                actionTextClick = actionTextClick,
                actionIcon1 = actionIcon1,
                actionIcon1Click = action1Click,
                actionIcon2 = actionIcon2,
                actionIcon2Click = action2Click,
                elevation = elevation,
            )
        }
    }
}