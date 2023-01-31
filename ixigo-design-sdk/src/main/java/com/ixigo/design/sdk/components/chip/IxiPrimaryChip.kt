package com.ixigo.design.sdk.components.chip

import android.content.Context
import android.util.AttributeSet
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiChipColorState


class IxiPrimaryChip @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseChip(context, attrs, defStyleAttr)  {
    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiPrimaryChip)
        try {
            val backgroundColorVal: Int =
                typedArray.getResourceId(R.styleable.IxiPrimaryChip_android_background, -1)
            val backgroundColor = if (backgroundColorVal != -1) backgroundColorVal else android.R.color.transparent
            val drawableTintColorVal: Int =
                typedArray.getResourceId(R.styleable.IxiPrimaryChip_android_drawableTint, -1)
            val drawableTintColor = if (drawableTintColorVal != -1) drawableTintColorVal else android.R.color.transparent
            val textColorVal: Int = typedArray.getResourceId(R.styleable.IxiPrimaryChip_android_textColor, -1)
            val textColor = if (textColorVal != -1) textColorVal else R.color.black
            isEnabled = typedArray.getBoolean(R.styleable.IxiPrimaryChip_android_enabled, true)
            setColor(IxiChipColor(backgroundColor = backgroundColor, textColor = textColor, drawableTintColor = drawableTintColor))
        } finally {
            typedArray.recycle()
        }
    }

    override fun getColorState(color:IxiChipColor): IxiChipColorState{
        return when(color){
            IxiChipColor.NEUTRAL -> IxiChipColorState.Primary.NEUTRAL
            IxiChipColor.BLUE -> IxiChipColorState.Primary.BLUE
            IxiChipColor.GREEN -> IxiChipColorState.Primary.GREEN
            IxiChipColor.PURPLE -> IxiChipColorState.Primary.PURPLE
            IxiChipColor.RED -> IxiChipColorState.Primary.RED
            IxiChipColor.YELLOW -> IxiChipColorState.Primary.YELLOW
            else -> {
                IxiChipColorState(color,color)
            }
        }
    }
    override fun getDisabledColor(): IxiChipColor {
        return IxiChipColorState.PrimaryDisabled
    }

}