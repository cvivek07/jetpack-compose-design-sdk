package com.ixigo.design.sdk.components.progressstep

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.ixigo.design.sdk.components.progressstep.base.BaseProgressStep
import com.ixigo.design.sdk.components.progressstep.base.ProgressStepMode
import com.ixigo.design_sdk.components.progress_step.composables.DrawHorizontalInlineSteps
import kotlinx.coroutines.launch

/**
 * Special type of Horizontal Progress Step which has text inline with the icons
 *
 * https://www.figma.com/file/WYm8OYDqRTjzIYjgVRfS2E/Components?type=design&node-id=1028-171705&mode=design&t=UdbrnsPY7euxQxTu-0
 */
class HorizontalInlineProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseProgressStep(context, attrs, defStyleAttr) {

    /**
     * Field to set the mode of the [HorizontalInlineProgressStep].
     */
    public override var mode: ProgressStepMode = ProgressStepMode.Dark
    set(value) {
        field = value
        super.mode = value
    }

    @Composable
    override fun Content() {
        with(state.value) {
            DrawHorizontalInlineSteps(
                steps = steps,
                progressStepIconSize = stepSize,
                selectionIndicator = selectionIndicator,
                currentItem = currentIndex,
                currentProgressState = currentItemProgressState,
                mode = mode,
                indexingPattern = state.value.indexingPattern
            ) { state, scope ->
                scope.launch {
                    state.animateScrollToItem(currentIndex)
                }
            }
        }
    }
}