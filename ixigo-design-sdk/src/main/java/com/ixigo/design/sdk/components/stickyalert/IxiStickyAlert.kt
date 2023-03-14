package com.ixigo.design.sdk.components.stickyalert

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.stickyalert.base.BaseStickyAlert
import com.ixigo.design.sdk.components.stickyalert.composable.ComposableStickyAlert

class IxiStickyAlert @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseStickyAlert(context, attrs, defStyleAttr)  {

    @Composable
    override fun Content() {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnDetachedFromWindowOrReleasedFromPool
        )
        with(state.value) {
            ComposableStickyAlert(
                leftIcon = state.value.leftIcon,
                rightIcon = state.value.rightIcon,
                text = state.value.text,
                leftButtonText = state.value.leftButtonText,
                leftButtonClickListener = leftButtonClickListener,
                rightButtonText = state.value.rightButtonText,
                rightButtonClickListener = rightButtonClickListener,
                ixiColor = state.value.ixiColor.mapIxiColorToStickyAlertColor(state.value.ixiColor),
                buttonColor = buttonColor,
                spaced = state.value.spaced,
                elevation = state.value.elevation
            )
        }
    }


}