package com.ixigo.design.sdk.components.bottomsheets

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.ixigo.design.sdk.components.bottomsheets.base.BaseBottomSheet
import com.ixigo.design.sdk.components.bottomsheets.composable.BaseBottomSheetComposable

class IxiBottomSheetView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseBottomSheet(context, attrs, defStyleAttr) {

    @Composable
    override fun Content() {
        with(state.value) {
            BaseBottomSheetComposable(
                image = image,
                titleText = headerText,
                imageBackgroundColor = imageBackgroundColor,
                bodyText = bodyText,
                masterTitleText = toolbarText,
                primaryButtonText = primaryButtonText,
                secondaryButtonText = secondaryButtonText,
                buttonMinWidth = buttonMinWidth,
                buttonMaxWidth = buttonMaxWidth,
                primaryActionListener = primaryActionListener,
                secondaryActionListener = secondaryActionListener,
                primaryButtonHelperText = primaryButtonHelperText,
                secondaryButtonHelperText = secondaryButtonHelperText,
                closeActionListener = onClose,
                iconSize = iconSize?.toInt()?:80,
                view = view,
                enablePointer = !disableDragging,
                inlineAlertText = inlineAlertText,
                inlineAlertIxiColor = inlineAlertIxiColor,
                masterSubtitleText = toolbarSubtitleText,
                closeActionAlignment = mapLayoutAlignmentToComposeAlignment(closeActionAlignment),
                closeIcon = toolbarCloseIcon,
                showBottomDivider = showBottomDivider,
                showFullWidthButtons = showFullWidthButtons
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