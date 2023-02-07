package com.ixigo.design.sdk.components.bottomsheets

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.bottomsheets.base.BaseBottomSheet
import com.ixigo.design.sdk.components.bottomsheets.composable.BaseBottomSheetComposable
import com.ixigo.design.sdk.util.Util

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
                titleText = headerText,
                imageBackgroundColor = imageBackgroundColor,
                bodyText = bodyText,
                masterTitleText = toolbarText,
                primaryButtonText = primaryButtonText,
                secondaryButtonText = secondaryButtonText,
                primaryActionListener = primaryActionListener,
                secondaryActionListener = secondaryActionListener,
                closeActionListener = onClose,
                iconSize = Util.convertDimensionToDp(px = iconSize?:80f),
                view = view,
                enablePointer = !disableDragging,
                inlineAlertText = inlineAlertText,
                inlineAlertIxiColor = inlineAlertIxiColor,
                masterSubtitleText = toolbarSubtitleText,
                closeActionAlignment = mapLayoutAlignmentToComposeAlignment(closeActionAlignment),
                closeIcon = toolbarCloseIcon
            )
        }
    }

    @Composable
    fun mapLayoutAlignmentToComposeAlignment(alignment: ActionIconAlignment): Alignment {
        return when(alignment){
            ActionIconAlignment.START -> Alignment.CenterStart
            ActionIconAlignment.END  -> Alignment.CenterEnd
        }
    }

    enum class ActionIconAlignment{
        START, END
    }

}