package com.ixigo.design.sdk.components.inlinealert

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.inlinealert.base.BaseInlineAlert
import com.ixigo.design.sdk.components.inlinealert.base.InlineAlertType
import com.ixigo.design.sdk.components.inlinealert.composable.ComposableInlineAlert
import com.ixigo.design.sdk.utils.Utils.mapLayoutAlignmentToComposeAlignment

class IxiInlineAlert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseInlineAlert(context, attrs, defStyleAttr)  {

    /**
     * Sets the color type of chip among [InlineAlertType]
     * can also be directly used from xml as app:inlineAlertType="neutral"
     */
    fun setType(type: InlineAlertType){
        super.setColor(mapTypeToColor(type))
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindow
        )
        with(state.value) {
            ComposableInlineAlert(
                logo = state.value.logo,
                heading = state.value.heading,
                text = state.value.text,
                rightIcon = state.value.rightIcon,
                leftButtonText = state.value.leftButtonText,
                leftButtonClickListener = leftButtonClickListener,
                rightButtonText = state.value.rightButtonText,
                rightButtonClickListener = rightButtonClickListener,
                onRightIconClickListener = state.value.onRightIconClickListener,
                ixiColor = state.value.ixiColor,
                textAlignment = mapLayoutAlignmentToComposeAlignment(state.value.textAlignment),
                headingAlignment = mapLayoutAlignmentToComposeAlignment(state.value.textAlignment)
            )
        }
    }


}