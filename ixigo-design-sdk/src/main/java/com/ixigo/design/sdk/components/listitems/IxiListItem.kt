package com.ixigo.design.sdk.components.listitems

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.listitems.base.BaseListItem
import com.ixigo.design.sdk.components.listitems.composables.ListItemComposable

class IxiListItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseListItem(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )

        ListItemComposable(
            padding = state.value.paddingValues,
            startIcon = state.value.startIcon,
            startAvatar = state.value.startAvatar,
            startLogo = state.value.startLogo,
            startCheckedValue = state.value.startCheckedValue,
            startCheckChangeListener = state.value.startCheckChangeListener,
            color = state.value.color,
            title = state.value.title,
            subTitle = state.value.subTitle,
            metaText = state.value.metaText,
            endIcon = state.value.endIcon,
            endLogo = state.value.endLogo,
            endCheckedValue = state.value.endCheckedValue,
            endCheckChangeListener = state.value.endCheckChangeListener,
            endSwitchValue = state.value.endSwitchValue,
            endSwitchChangeListener = state.value.endSwitchChangeListener,
            endActionText = state.value.endActionText,
            endActionClick = state.value.endActionClick,
            onItemClick = state.value.onItemClick
        )
    }
}