package com.ixigo.design.sdk.components.chip.base

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.utils.Utils

abstract class BaseChip @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Chip(context, attrs, defStyleAttr)  {
    protected var color:IxiChipColor? = null
    protected var horizontalPadding:Float = 8f
    protected var chipType:ChipType
    init {
        this.setTextAppearance(R.style.chipText)
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseChip)
        try {
            chipType = mapChipTypeToEnum(typedArray.getInt(R.styleable.BaseChip_chipType, 0))
            val text = typedArray.getString(R.styleable.BaseChip_android_text) ?: ""
            when(chipType){
                ChipType.LARGE -> {
                    this.textSize = 14f
                    this.chipMinHeight = Utils.convertDpToPixel(30f, context)
                }
                ChipType.SMALL -> {
                    this.textSize = 12f
                    this.chipMinHeight = Utils.convertDpToPixel(20f, context)
                }
                ChipType.XSMALL -> {
                    this.textSize = 10f
                    this.chipMinHeight = Utils.convertDpToPixel(15f, context)
                }
                ChipType.NOTIFICATION -> {
                    //TODO: Doubt
                }
            }
            this.textAlignment = TEXT_ALIGNMENT_CENTER
            setText(text)
            if(isChipEligible()) {
                horizontalPadding = if(chipType==ChipType.SMALL) 4f else 8f
                val drawableEnd =
                    typedArray.getResourceId(R.styleable.BaseChip_chipDrawableEnd, 0)
                val drawableStart =
                    typedArray.getResourceId(R.styleable.BaseChip_chipDrawableStart, 0)
                if (drawableStart != 0) {
                    setStartDrawable(drawableStart)
                }
                if (drawableEnd != 0) {
                    setEndDrawable(drawableEnd)
                }
                val iconSize =typedArray.getDimensionPixelSize(R.styleable.BaseChip_size, -1)
                if(iconSize!=-1){
                    setIconSize(iconSize.toFloat(), iconSize.toFloat())
                } else{
                    val drawableStartSize = typedArray.getDimensionPixelSize(R.styleable.BaseChip_drawableStartSize, 16)
                    val drawableEndSize = typedArray.getDimensionPixelSize(R.styleable.BaseChip_drawableEndSize, 16)
                    setIconSize(drawableStartSize.toFloat(), drawableEndSize.toFloat())
                }
            }
//            this.background = ContextCompat.getDrawable(context, R.drawable.bg_chip_thin)
        } finally {
            typedArray.recycle()
        }
    }
    open fun isEnabled(boolean: Boolean){
        this.isEnabled = boolean
    }

    fun setStartDrawable(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            if (drawable != null) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = ContextCompat.getDrawable(context, drawable)
                this.chipIconTint = null
            } else {
                this.chipStartPadding = 0f
                this.chipIcon = null
            }
            this.isChipIconVisible = drawable != null
        }
    }

    fun setEndDrawable(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            if (drawable != null) {
                this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.closeIcon = ContextCompat.getDrawable(context, drawable)
            } else {
                this.chipEndPadding = 0f
                this.closeIcon = null
            }
            this.isCloseIconVisible = drawable != null
        }
    }

    protected open fun setIxiChipColor(color: IxiChipColor?) {
        this.chipIconTint = null
        this.closeIconTint = null
        color?.let {
            this.chipBackgroundColor = getColorStateList(it)
            it.drawableTintColor?.let{tintColor->
                this.setChipIconTintResource(tintColor)
                this.setCloseIconTintResource(tintColor)
            }
            this.setTextColor(ContextCompat.getColor(context,color.textColor))
            color.strokeColor?.let {strokeColor->
                this.setChipStrokeColorResource(strokeColor)
                this.chipStrokeWidth = Utils.convertDpToPixel(1f, context)
            }
        }
    }

    protected fun getColorStateList(ixiChipColor: IxiChipColor):ColorStateList{
        val states:MutableList<IntArray> = mutableListOf()
        val colors:MutableList<Int> = mutableListOf()
        states.add(intArrayOf(android.R.attr.state_enabled))
        colors.add(ContextCompat.getColor(context, ixiChipColor.backgroundColor))
        states.add(intArrayOf(-android.R.attr.state_checked))
        colors.add(ContextCompat.getColor(context, ixiChipColor.backgroundColor))
        states.add(intArrayOf(-android.R.attr.state_enabled))
        colors.add(ContextCompat.getColor(context, IxiColor.Disabled.bgColor))
        return ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

    open fun onEndDrawableClickListener( onClick:(()->Unit)? ){
        if(onClick!=null){
            this.setOnCloseIconClickListener {
                onClick.invoke()
            }
        } else{
            this.setOnCloseIconClickListener(null)
        }

    }

    private fun isChipEligible():Boolean{
        return chipType==ChipType.LARGE || chipType==ChipType.SMALL
    }

    fun setIconSize(startSize: Float = 16f, endSize: Float = 16f){
        this.chipIconSize = Utils.convertDpToPixel(startSize, context)
        this.closeIconSize = Utils.convertDpToPixel(endSize, context)
    }

    protected fun setText(text:String) {
        if(chipType!=ChipType.NOTIFICATION) {
            this.text = text
        }
    }

    private fun mapChipTypeToEnum(int:Int):ChipType{
        return when(int){
            0-> ChipType.LARGE
            1-> ChipType.SMALL
            2-> ChipType.XSMALL
            3-> ChipType.NOTIFICATION
            else-> ChipType.LARGE
        }
    }

    enum class ChipType {
        LARGE,
        SMALL,
        XSMALL,
        NOTIFICATION
    }
}

