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

abstract class BaseProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected val state = mutableStateOf(ProgressStepState())

    val steps = mutableListOf<ProgressStepData>()

    /**
     * The progress denote currently selected Item
     */
    var progress = 0
    var progressStepType = BarType.VERTICAL
    var color: IxiColor = IxiColor.Blue
        set(value) {
            field = value
            val initState = state.value.copy(color = value)
            state.value = initState
        }
    var selectedColor: IxiColor = IxiColor.Blue
    var onCompletionListener: SelectionCompletionListener? = null

    var selectionIndicator: SelectionIndicator = SelectionIndicator.NUMBER
        set(value) {
            field = value
            val initState = state.value.copy(selectionIndicator = value)
            state.value = initState
        }


    protected var stepSize: ProgressStepSize = ProgressStepSize.Large
        set(value) {
            field = value
            val initState = state.value.copy(stepSize = value)
            state.value = initState
        }

    protected open var mode: ProgressStepMode = ProgressStepMode.Light
        set(value) {
            field = value
            val initState = state.value.copy(mode = value)
            state.value = initState
        }

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


        if ((progress == getMaxProgress() - 1) || progressState != ProgressState.Active) {
            onCompletionListener?.onCompletion(progressState)
        }
    }


    fun addSteps(list: List<ProgressStepData>) {
        steps.addAll(list)
        val initState = state.value.copy(steps = steps)
        state.value = initState
    }

    fun setProgress(position: Int, progressState: ProgressState) {
        progress = position
        val initState = state.value.copy(steps = steps)
        state.value = initState
    }

    fun getMaxProgress() = steps.size

    interface SelectionCompletionListener {
        fun onCompletion(progressState: ProgressState)
    }
}


enum class BarType {
    HORIZONTAL,
    HORIZONTAL_INLINE,
    VERTICAL
}

enum class SelectionIndicator {
    ICON,
    CHECK,
    NUMBER
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

sealed class ProgressStepSize(val size: Dp, val textStyle: TextStyle) {
    object Small : ProgressStepSize(
        20.dp,
        IxiTypography.Body.XSmall.regular
    )

    object Large : ProgressStepSize(
        30.dp,
        IxiTypography.Body.XSmall.regular
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
    val stepSize: ProgressStepSize = ProgressStepSize.Large,
    val steps: MutableList<ProgressStepData> = mutableListOf(),
    val currentItemProgressState: ProgressState? = null,
    val currentIndex: Int = 0,
    val mode: ProgressStepMode = ProgressStepMode.Dark,
    val scrollToPosition: ((LazyListState, CoroutineScope) -> Unit)? = null
)

