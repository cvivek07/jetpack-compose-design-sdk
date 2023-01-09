package com.ixigo.design.sdk.components.progress_step.base

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiTypography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Base class for all the Progress Steps. Progress Step is a widget which is used to show steps for a
 * particular action.
 */
abstract class BaseProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected val state = mutableStateOf(ProgressStepState())

    private val steps = mutableListOf<ProgressStepData>()

    /**
     * The progress denote currently selected Item
     */
    var progress = 0

    /**
     * Set the listener. This listener is used to notify that all steps have been reached and not
     * further action is required.
     */
    var onCompletionListener: SelectionCompletionListener? = null

    /**
     * This field define the type of icon for each step. Icon can be any of :
     * [SelectionIndicator.ICON]. [SelectionIndicator.NUMBER] and [SelectionIndicator.CHECK]
     */
    var selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER
        set(value) {
            field = value
            val initState = state.value.copy(selectionIndicator = value)
            state.value = initState
        }


//    /**
//     * This field define the size of the icons and text style. Step Size can be ny of the [ProgressStepIconSize.Large] and [ProgressStepIconSize.Small]
//     */
//    protected var stepSize: ProgressStepIconSize = ProgressStepIconSize.Large
//        set(value) {
//            field = value
//            val initState = state.value.copy(stepSize = value)
//            state.value = initState
//        }

    protected open var mode: ProgressStepMode = ProgressStepMode.Light
        set(value) {
            field = value
            val initState = state.value.copy(mode = value)
            state.value = initState
        }

    /**
     * Move to next step of the widget. If the Next Step is the last step.
     * then [SelectionCompletionListener.onCompletion] callback is received. If the ProgressState
     * provided to this method is [ProgressState.Active] then it moves to the next Step else It
     * stays with the Same progress and Update the icon according to the [ProgressState] provided.
     *
     * @param progressState State of the current Step
     */
    fun selectNext(progressState: ProgressState = ProgressState.Active) {
        if (progressState == ProgressState.Active)
            progress++

        val initState = state.value.copy(
            currentIndex = progress,
            currentItemProgressState = progressState,
            scrollToPosition = { state, scope ->
                scope.launch {
                    // Animate scroll to the 10th item
                    state.animateScrollToItem(index = progress)
                }
            })
        state.value = initState


        if ((progress == getMaxSteps() - 1) || progressState != ProgressState.Active) {
            onCompletionListener?.onCompletion(progressState)
        }
    }


    /**
     * Provide the list of Steps to be drawn in this widget
     *
     * @param progressSteps List of  [ProgressStepData] to be set as the Steps of this widget.
     */
    fun addSteps(progressSteps: List<ProgressStepData>) {
        steps.addAll(progressSteps)
        val initState = state.value.copy(steps = steps)
        state.value = initState
    }

    private fun setProgress(position: Int, progressState: ProgressState) {
        progress = position
        val initState = state.value.copy(steps = steps)
        state.value = initState
    }

    /**
     * return the max count of steps provided to This widget
     */
    fun getMaxSteps() = steps.size

    interface SelectionCompletionListener {
        fun onCompletion(progressState: ProgressState)
    }
}

enum class SelectionIndicator {
    ICON, // Icons with concentric circles
    CHECK,// Check Icon in a circle
    NUMBER // Number in a circle
}

sealed class ProgressState(
    color: IxiColor
) {
    object Active : ProgressState(IxiColor.Success)
    object Completed : ProgressState(IxiColor.Success)
    object Error : ProgressState(IxiColor.Error)
    object InActive : ProgressState(IxiColor.Disabled)
    object Delay : ProgressState(IxiColor.Warning)
}

sealed class ProgressStepIconSize(val size: Dp, val textStyle: TextStyle) {
    object Small : ProgressStepIconSize(
        20.dp,
        IxiTypography.Body.XSmall.medium
    )

    object Large : ProgressStepIconSize(
        30.dp,
        IxiTypography.Body.XSmall.medium
    )
}

sealed class ProgressStepMode {
    object Dark : ProgressStepMode()

    object Light : ProgressStepMode()
}

data class ProgressStepData(val label: String, val subText: String?)

data class ProgressStepState(
    val color: IxiColor = IxiColor.Warning,
    val selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER,
    val stepSize: ProgressStepIconSize = ProgressStepIconSize.Large,
    val steps: MutableList<ProgressStepData> = mutableListOf(),
    val currentItemProgressState: ProgressState? = null,
    val currentIndex: Int = 0,
    val mode: ProgressStepMode = ProgressStepMode.Dark,
    val scrollToPosition: ((LazyListState, CoroutineScope) -> Unit)? = null
)

