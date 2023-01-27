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
            startIconWidth = state.value.startIconWidth,
            startIconHeight = state.value.startIconHeight,
            startAvatarUrl = state.value.startAvatarUrl,
            startAvatarPlaceHolder = state.value.startAvatarPlaceHolder,
            startAvatarWidth = state.value.startAvatarWidth,
            startAvatarHeight = state.value.startAvatarHeight,
            startLogo = state.value.startLogo,
            startLogoUrl = state.value.startLogoUrl,
            startLogoWidth = state.value.startLogoWidth,
            startLogoHeight = state.value.startLogoHeight,
            startCheckedValue = state.value.startCheckedValue,
            startCheckChangeListener = state.value.startCheckChangeListener,
            color = state.value.color,
            title = state.value.title,
            subTitle = state.value.subTitle,
            metaText = state.value.metaText,
            endIcon = state.value.endIcon,
            endIconWidth = state.value.endIconWidth,
            endIconHeight = state.value.endIconHeight,
            endLogo = state.value.endLogo,
            endLogoUrl = state.value.endLogoUrl,
            endLogoWidth = state.value.endLogoWidth,
            endLogoHeight = state.value.endLogoHeight,
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