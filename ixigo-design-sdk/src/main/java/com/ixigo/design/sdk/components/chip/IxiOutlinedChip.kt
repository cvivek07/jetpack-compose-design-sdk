package com.ixigo.design.sdk.components.chip

import android.content.Context
import android.util.AttributeSet
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiChipColorState
import com.ixigo.design.sdk.utils.Utils

class IxiOutlinedChip @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseChip(context, attrs, defStyleAttr)  {
//    init {
//        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.IxiOutlinedChip)
//        try {
//            val backgroundColorVal: Int =
//                typedArray.getResourceId(R.styleable.IxiOutlinedChip_android_background, -1)
//            val backgroundColor = if (backgroundColorVal != -1) backgroundColorVal else android.R.color.transparent
//            val strokeColorVal: Int =
//                typedArray.getResourceId(R.styleable.IxiOutlinedChip_android_strokeColor, -1)
//            val strokeColor = if (strokeColorVal != -1) strokeColorVal else backgroundColor
//            val drawableTintColorVal: Int =
//                typedArray.getResourceId(R.styleable.IxiOutlinedChip_android_drawableTint, -1)
//            val drawableTintColor = if (drawableTintColorVal != -1) drawableTintColorVal else R.color.n0
//            val textColorVal: Int = typedArray.getResourceId(R.styleable.IxiOutlinedChip_android_textColor, -1)
//            val textColor = if (textColorVal != -1) textColorVal else R.color.black
//            isEnabled = typedArray.getBoolean(R.styleable.IxiOutlinedChip_android_enabled, true)
//            if(ixiChipColor==null) {
//                setColor(
//                    IxiChipColor(
//                        textColor = textColor,
//                        drawableTintColor = drawableTintColor,
//                        strokeColor = strokeColor,
//                        backgroundColor = backgroundColor
//                    )
//                )
//            }
//            this.chipStrokeWidth = Utils.convertDpToPixel(1f, context)
//        } finally {
//            typedArray.recycle()
//        }
//    }

    override fun getColorState(color: IxiChipColor): IxiChipColorState {
        return when(color){
            IxiChipColor.NEUTRAL -> IxiChipColorState.Outlined.NEUTRAL
            IxiChipColor.BLUE -> IxiChipColorState.Outlined.BLUE
//            IxiChipColor.GREEN -> IxiChipColorState.Outlined.GREEN
            IxiChipColor.PURPLE -> IxiChipColorState.Outlined.PURPLE
            IxiChipColor.RED -> IxiChipColorState.Outlined.RED
            IxiChipColor.YELLOW -> IxiChipColorState.Outlined.YELLOW
            else -> {
                IxiChipColorState(color,color)
            }
        }
    }

    override fun getDisabledColor(): IxiChipColor {
        return IxiChipColorState.OutlinedDisabled
    }
}