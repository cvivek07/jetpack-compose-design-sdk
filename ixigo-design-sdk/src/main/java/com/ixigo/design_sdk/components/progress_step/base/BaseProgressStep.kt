package com.ixigo.design_sdk.components.progress_step.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import com.ixigo.design_sdk.components.BaseComponent
import com.ixigo.design_sdk.components.styles.IxiColor

abstract class BaseProgressStep @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected val steps = listOf<ProgressStepData>()

    /**
     * The progress denote currently selected Item
     */
    var progress = 0
    var progressStepType = BarType.VERTICAL
    var color: IxiColor = IxiColor.Blue
    var selectedColor = IxiColor.Blue
    var onCompletionListener: SelectionCompletionListener? = null

    fun selectNext(progressState: ProgressState) {
        progress++
        if (progress == getMaxProgress() - 1) {
            onCompletionListener?.onCompletion(progressState)
        }
    }


    fun setProgress(position: Int, progressState: ProgressState){
//    fun setExtraView(position: Int, view: View) {
//
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
    @DrawableRes   icon: Int,
    @DrawableRes  check: Int,
    @DrawableRes number: Int
) {
//    object Active : ProgressState()
//    object Completed : ProgressState()
//    object Error : ProgressState()
//    object InActive : ProgressState()
//    object Delay : ProgressState()
}

sealed class ProgressStepSize {
    object Small : ProgressStepSize()
    object Large : ProgressStepSize()
}

data class ProgressStepData(val label: String, val subText: String?)

