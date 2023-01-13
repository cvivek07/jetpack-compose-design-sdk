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
            isEnabled(typedArray.getBoolean(R.styleable.IxiPrimaryChip_android_enabled, true))
            setIxiChipColor(IxiChipColor(backgroundColor = backgroundColor, textColor = textColor, drawableTintColor = drawableTintColor))
        } finally {
            typedArray.recycle()
        }
    }

    override fun isEnabled(boolean: Boolean) {
        if(!boolean) {
            setIxiChipColor(null)
        } else{
            setIxiChipColor(color)
        }
        super.isEnabled(boolean)
    }

    public override fun setIxiChipColor(color: IxiChipColor?) {
        if(color!=null) {
            this.color = color
           super.setIxiChipColor(IxiChipColor(
               backgroundColor = color.backgroundColor,
               textColor = color.textColor,
               drawableTintColor = color.drawableTintColor,
           ))
        } else{
            super.setIxiChipColor(IxiChipColorState.PrimaryDisabled)
        }
    }
}