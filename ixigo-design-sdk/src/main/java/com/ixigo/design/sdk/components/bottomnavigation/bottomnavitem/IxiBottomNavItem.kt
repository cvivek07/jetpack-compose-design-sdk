package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.base.BaseBottomNavItem
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.ComposableBottomNavItem

class IxiBottomNavItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseBottomNavItem(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        ComposableBottomNavItem(
            icon = state.value.icon,
            selectedIcon = state.value.selectedIcon,
            label = state.value.label,
            selected = state.value.selected,
            onClick = state.value.onClick,
            badgeType = state.value.badgeType,
            badgeContent = state.value.badgeContent,
            itemType = state.value.itemType,
            ixiColor = state.value.ixiColor
        )
    }

}