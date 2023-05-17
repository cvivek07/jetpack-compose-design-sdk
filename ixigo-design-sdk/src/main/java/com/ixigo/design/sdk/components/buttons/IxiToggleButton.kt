package com.ixigo.design.sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.listitems.composables.DrawSwitch
import com.ixigo.design.sdk.components.styles.IxiColor

class IxiToggleButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    private val state = mutableStateOf(ToggleButtonState())

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiToggleButton)
        try {
            val colorEnum = typedArray.getInt(R.styleable.IxiToggleButton_ixiColor, -1)
            if (colorEnum != -1) {
                setIxiColor(mapTypeToColor(colorEnum))
            }
            val checked = typedArray.getBoolean(R.styleable.IxiToggleButton_android_checked, false)
            setChecked(checked)
            setToggleChangeListener { }
        } finally {
            typedArray.recycle()
        }
    }

    fun setIxiColor(color: IxiColor) {
        state.value = state.value.copy(color = color)
    }

    fun setChecked(checked: Boolean) {
        state.value = state.value.copy(switchValue = checked)
    }

    fun setToggleChangeListener(func: (Boolean) -> Unit) {
        state.value = state.value.copy(onToggleListener = {
            state.value = state.value.copy(switchValue = it)
            func.invoke(it)
        })
    }

    private fun mapTypeToColor(int: Int): IxiColor {
        return when (int) {
            0 -> IxiColor.Warning
            1 -> IxiColor.Extension
            2 -> IxiColor.Error
            3 -> IxiColor.Success
            4 -> IxiColor.Blue
            5 -> IxiColor.Neutral
            6 -> IxiColor.Orange
            else -> {
                IxiColor.Neutral
            }
        }
    }


    @Composable
    override fun Content() {
        DrawSwitch(
            color = state.value.color,
            switchValue = state.value.switchValue,
            switchChangeListener = state.value.onToggleListener
        )
    }
}

data class ToggleButtonState(
    val color: IxiColor = IxiColor.Blue,
    val switchValue: Boolean = false,
    val onToggleListener: (Boolean) -> Unit = {}
)