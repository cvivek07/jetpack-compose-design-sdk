package com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.base.BaseBottomNavItem
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.ComposableBottomNavItem
import com.ixigo.design.sdk.components.imageutils.ImageData

/**
 * IxiBottomNavItem is a class that extends [BaseBottomNavItem].
 * It overrides the [Content] function to set the view composition strategy to [ViewCompositionStrategy.DisposeOnDetachedFromWindow]
 * and render the [ComposableBottomNavItem]
 *
 * @constructor Creates a new instance of IxiBottomNavItem
 * @param context The context of the application
 * @param attrs The attribute set for the view
 * @param defStyleAttr The default style attribute
 */
internal class IxiBottomNavItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseBottomNavItem(context, attrs, defStyleAttr) {

    /**
     * Overrides the [Content] function to set the view composition strategy to [ViewCompositionStrategy.DisposeOnDetachedFromWindow] and render the [ComposableBottomNavItem]
     */
    @Composable
    override fun Content() {
        ComposableBottomNavItem(
            icon = ImageData(
                drawableRes = state.value.icon,
                drawable = state.value.iconDrawable,
                drawableBitmap = null,
                url = null,
                height = null,
                width = null
            ),
            selectedIcon = ImageData(
                drawableRes = state.value.selectedIcon,
                drawable = state.value.selectedIconDrawable,
                drawableBitmap = null,
                url = null,
                height = null,
                width = null
            ),
            label = state.value.label,
            selected = state.value.selected,
            onClick = state.value.onClick,
            badgeType = state.value.badgeType,
            badgeContent = state.value.badgeContent,
            ixiColor = state.value.ixiColor
        )
    }
}