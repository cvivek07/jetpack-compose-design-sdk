package com.ixigo.design.sdk.components.inlinealert

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.inlinealert.base.BaseInlineAlert
import com.ixigo.design.sdk.components.inlinealert.composable.ComposableInlineAlert
import com.ixigo.design.sdk.utils.Utils.mapLayoutAlignmentToComposeTextAlignment

/**
 * https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1172-214222&mode=design&t=UdbrnsPY7euxQxTu-0
 */

class IxiInlineAlert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseInlineAlert(context, attrs, defStyleAttr)  {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
             ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            ComposableInlineAlert(
                logo = state.value.logo,
                heading = state.value.heading,
                text = state.value.text,
                actionIcon = state.value.actionIcon,
                leftButtonText = state.value.leftButtonText,
                leftButtonClickListener = leftButtonClickListener,
                rightButtonText = state.value.rightButtonText,
                rightButtonClickListener = rightButtonClickListener,
                onRightIconClickListener = state.value.onActionIconClickListener,
                ixiColor = state.value.ixiColor.mapIxiColorToInlineAlertColor(state.value.ixiColor),
                textAlignment = mapLayoutAlignmentToComposeTextAlignment(state.value.textAlignment),
                headingAlignment = mapLayoutAlignmentToComposeTextAlignment(state.value.textAlignment),
                buttonColor = buttonColor
            )
        }
    }


}