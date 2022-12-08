package com.ixigo.design_sdk.components.progress_step

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.progress_step.base.BaseProgressStep
import com.ixigo.design_sdk.components.progress_step.composables.DrawVerticalSteps
import kotlinx.coroutines.launch

class VerticalProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseProgressStep(context, attrs, defStyleAttr) {
    @Composable
    override fun Content() {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow)

        with(state.value) {
            DrawVerticalSteps(
                steps = steps,
                progressStepSize = stepSize,
                selectionIndicator = selectionIndicator,
                currentItem = currentIndex,
                currentProgressState = currentItemProgressState,
            ){ state, scope ->
                scope.launch {
                    state.animateScrollToItem(currentIndex)
                }
            }
        }
    }
}