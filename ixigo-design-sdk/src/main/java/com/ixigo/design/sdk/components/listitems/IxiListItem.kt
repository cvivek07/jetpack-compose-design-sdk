package com.ixigo.design.sdk.components.listitems

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.listitems.base.BaseListItem
import com.ixigo.design.sdk.components.listitems.composables.ListItemComposable

/**
 * https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=979-62929&mode=design&t=UdbrnsPY7euxQxTu-0
 */

class IxiListItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseListItem(context, attrs, defStyleAttr) {


    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )

        ListItemComposable(state)
    }
}