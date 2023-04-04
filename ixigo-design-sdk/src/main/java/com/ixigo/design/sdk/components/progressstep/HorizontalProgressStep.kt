package com.ixigo.design.sdk.components.progressstep

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.progressstep.base.BaseProgressStep
import com.ixigo.design_sdk.components.progress_step.composables.DrawHorizontalSteps
import kotlinx.coroutines.launch

/**
 * Simple Horizontal Progress Step where Icons are used below the Icons
 */
class HorizontalProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseProgressStep(context, attrs, defStyleAttr) {
    @Composable
    override fun Content() {
        with(state.value) {
            DrawHorizontalSteps(
                steps = steps,
                progressStepIconSize = stepSize,
                selectionIndicator = selectionIndicator,
                currentItem = currentIndex,
                currentProgressState = currentItemProgressState,
            ) { state, scope ->
                scope.launch {
                    state.animateScrollToItem(currentIndex)
                }
            }
        }
    }
}