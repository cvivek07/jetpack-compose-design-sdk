package com.ixigo.design.sdk.components.chip

import android.content.Context
import android.util.AttributeSet
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiChipColorState

internal class IxiTextChip  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseChip(context, attrs, defStyleAttr)  {
//    init {
//        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiTextChip)
//        try {
//            val backgroundColorVal: Int =
//                typedArray.getResourceId(R.styleable.IxiTextChip_android_background, -1)
//            val backgroundColor = if (backgroundColorVal != -1) backgroundColorVal else android.R.color.transparent
//            val drawableTintColorVal: Int =
//                typedArray.getResourceId(R.styleable.IxiTextChip_android_drawableTint, -1)
//            val drawableTintColor = if (drawableTintColorVal != -1) drawableTintColorVal else android.R.color.transparent
//            val textColorVal: Int = typedArray.getResourceId(R.styleable.IxiTextChip_android_textColor, -1)
//            val textColor = if (textColorVal != -1) textColorVal else R.color.black
//            isEnabled = typedArray.getBoolean(R.styleable.IxiTextChip_android_enabled, true)
//            if (ixiChipColor == null) {
//                setColor(
//                    IxiChipColor(
//                        textColor = textColor,
//                        drawableTintColor = drawableTintColor,
//                        backgroundColor = backgroundColor
//                    )
//                )
//            }
//        } finally {
//            typedArray.recycle()
//        }
//    }

    override fun getColorState(color: IxiChipColor): IxiChipColorState {
        return when(color){
            IxiChipColor.NEUTRAL -> IxiChipColorState.Text.NEUTRAL
            IxiChipColor.BLUE -> IxiChipColorState.Text.BLUE
            IxiChipColor.GREEN -> IxiChipColorState.Text.GREEN
            IxiChipColor.PURPLE -> IxiChipColorState.Text.PURPLE
            IxiChipColor.RED -> IxiChipColorState.Text.RED
            IxiChipColor.YELLOW -> IxiChipColorState.Text.YELLOW
            else -> {
                IxiChipColorState(color,color)
            }
        }
    }

    override fun getDisabledColor(): IxiChipColor {
        return IxiChipColorState.TextDisabled
    }

}