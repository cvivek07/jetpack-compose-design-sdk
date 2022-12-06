package com.ixigo.design_sdk.components.progress_step

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design_sdk.components.progress_step.base.BaseProgressStep
import com.ixigo.design_sdk.components.progress_step.base.ProgressStepMode
import com.ixigo.design_sdk.components.progress_step.composables.DrawHorizontalInlineSteps
import kotlinx.coroutines.launch

class HorizontalInlineProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseProgressStep(context, attrs, defStyleAttr) {

    public override var mode: ProgressStepMode = ProgressStepMode.Dark
    set(value) {
        field = value
        super.mode = value
    }

    @Composable
    override fun Content() {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnDetachedFromWindow)

        with(state.value) {
            DrawHorizontalInlineSteps(
                steps = steps,
                progressStepSize = stepSize,
                selectionIndicator = selectionIndicator,
                currentItem = currentIndex,
                currentProgressState = currentItemProgressState,
                mode = mode
            ) { state, scope ->
                scope.launch {
                    state.animateScrollToItem(currentIndex)
                }
            }
        }
    }
}