package com.ixigo.design.sdk.components.bottomsheets

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.bottomsheets.base.BaseBottomSheet
import com.ixigo.design.sdk.components.bottomsheets.composable.BaseBottomSheetComposable

class IxiBottomSheetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseBottomSheet(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow )
        with(state.value) {
            BaseBottomSheetComposable(
                image = image,
                headerText = headerText,
                imageBackgroundColor = imageBackgroundColor,
                bodyText = bodyText,
                toolbarText = toolbarText,
                primaryButton = primaryButton,
                secondaryButton = secondaryButton,
                closeActionListener = onClose,
                isToolbarCentered = isToolbarCentered
            )
        }
    }
}