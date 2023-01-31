package com.ixigo.design.sdk.components.chip.base

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiChipColorState
import com.ixigo.design.sdk.utils.Utils

abstract class BaseChip @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Chip(context, attrs, defStyleAttr)  {
    protected var horizontalPadding:Float = 8f
    protected var ixiChipSize:IxiChipSize
    protected var onClickListener:((View)->Unit)? = null
    protected var drawableStart:Int? = null
    protected var drawableEnd:Int? = null
    protected  var ixiChipColor =  IxiChipColor()
    init {
        this.setTextAppearance(R.style.chipText)
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseChip)
        try {
            ixiChipSize = mapChipTypeToEnum(typedArray.getInt(R.styleable.BaseChip_chipType, 0))
            val text = typedArray.getString(R.styleable.BaseChip_android_text) ?: ""
            this.textSize = ixiChipSize.textSize
            this.chipMinHeight = Utils.convertDpToPixel(ixiChipSize.height, context)
            this.textAlignment = TEXT_ALIGNMENT_CENTER
            setText(text)
            horizontalPadding = if (ixiChipSize == IxiChipSize.SMALL) 4f else 8f
            val drawableEnd =
                typedArray.getResourceId(R.styleable.BaseChip_chipDrawableEnd, 0)
            val drawableStart =
                typedArray.getResourceId(R.styleable.BaseChip_chipDrawableStart, 0)
            setStartDrawable(if(drawableStart!=0) drawableStart else null)
            setEndDrawable(if(drawableEnd!=0) drawableEnd else null)
            val iconSize = typedArray.getDimensionPixelSize(R.styleable.BaseChip_size, -1)
            if (iconSize != -1) {
                setIconSize(iconSize.toFloat(), iconSize.toFloat())
            } else {
                val drawableStartSize =
                    typedArray.getDimensionPixelSize(R.styleable.BaseChip_drawableStartSize, 16)
                val drawableEndSize =
                    typedArray.getDimensionPixelSize(R.styleable.BaseChip_drawableEndSize, 16)
                setIconSize(drawableStartSize.toFloat(), drawableEndSize.toFloat())
            }
            this.isCheckable = true
            setCheckedDrawable(null)
        } finally {
            typedArray.recycle()
        }
    }

    abstract fun getColorState(color:IxiChipColor): IxiChipColorState
    abstract fun getDisabledColor(): IxiChipColor

    open fun setOnChipCheckedChangeListener(@DrawableRes checkedIcon:Int?=null, listener: OnCheckedChangeListener?){
        if(onClickListener==null) {
            this.setOnClickListener {}
        }
        this.setOnCheckedChangeListener { buttonView, isChecked ->
                listener?.onCheckedChanged(buttonView, isChecked)
                if (isChecked) {
                    checkedIcon?.let {
                        this.setCheckedDrawableToStart(it)
                    }
                } else {
                    if(checkedIcon!=null&&drawableStart==null) {
                        this.setStartDrawable(null)
                    }
                    drawableStart?.let {
                        this.setStartDrawable(drawableStart)
                    }
                }
        }
    }


    open fun setOnIxiChipClickListener(onClickListener:(View)->Unit){
        this.onClickListener = onClickListener
        this.setOnClickListener {
            onClickListener.invoke(it)
        }
    }

    override fun setChipIcon(chipIcon: Drawable?) {
        super.setChipIcon(chipIcon)
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
    }

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if(ixiChipColor==null){
            ixiChipColor = IxiChipColor()
        }
        this.chipIconTint =  getDrawableColorStateList(context, getColorState(ixiChipColor))
    }

    fun setStartDrawable(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            drawableStart = drawable
            if (drawable != null) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = ContextCompat.getDrawable(context, drawable)

            } else {
                this.chipStartPadding = 0f
                this.chipIcon = null
            }
            this.isChipIconVisible = drawable != null
        }
    }

    private fun setCheckedDrawableToStart(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            if (drawable != null) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = ContextCompat.getDrawable(context, drawable)
            } else {
                this.chipStartPadding = 0f
                this.chipIcon = null
            }
            this.isChipIconVisible = drawable != null
        }
    }

    override fun setCloseIconResource(id: Int) {
        if(isChipEligible()) {
            this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
        }
        super.setCloseIconResource(id)
    }

    private fun setEndDrawable(@DrawableRes drawable:Int?){
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

    fun setCheckedDrawable(@DrawableRes drawable:Int?){
        drawable?.let {
            this.checkedIcon = ContextCompat.getDrawable(context, drawable)
        }
        this.isCheckedIconVisible = drawable != null
        if(this.isChipIconVisible){
            this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
        } else{
            this.chipStartPadding = 0f
        }
    }

    fun setColor(color: IxiChipColor) {
        this.ixiChipColor = color
        setIxiChipColorState(getColorState(color))
    }

    internal open fun setIxiChipColorState(colorState: IxiChipColorState?) {
        colorState?.let {
            this.chipBackgroundColor = getBackgroundColorStateList(context, colorState)
            this.setTextColor(getTextColorStateList(context, it))
            this.chipIconTint = getDrawableColorStateList(context, colorState)
            this.closeIconTint = getDrawableColorStateList(context, colorState)
            this.chipStrokeColor = getStrokeColorStateList(context, colorState)
        }
    }

    private fun getBackgroundColorStateList(context: Context, colorState: IxiChipColorState): ColorStateList {
        val states:MutableList<IntArray> = mutableListOf()
        val colors:MutableList<Int> = mutableListOf()
        states.add(intArrayOf(-android.R.attr.state_enabled))
        colors.add(ContextCompat.getColor(context, getDisabledColor().backgroundColor))
        colorState.unselected?.backgroundColor?.let {
            states.add(intArrayOf(-android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context,it))
            states.add(intArrayOf(-android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        colorState.selected?.backgroundColor?.let {
            states.add(intArrayOf(android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context, it))
            states.add(intArrayOf(android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        return ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

    private fun getTextColorStateList(context: Context, colorState: IxiChipColorState): ColorStateList {
        val states:MutableList<IntArray> = mutableListOf()
        val colors:MutableList<Int> = mutableListOf()
        states.add(intArrayOf(-android.R.attr.state_enabled))
        colors.add(ContextCompat.getColor(context, getDisabledColor().textColor))
        colorState.unselected?.textColor?.let {
            states.add(intArrayOf(-android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context,it))
            states.add(intArrayOf(-android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        colorState.selected?.textColor?.let {
            states.add(intArrayOf(android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context, it))
            states.add(intArrayOf(android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        return ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

    private fun getDrawableColorStateList(context: Context, colorState: IxiChipColorState): ColorStateList {
        val states:MutableList<IntArray> = mutableListOf()
        val colors:MutableList<Int> = mutableListOf()
        getDisabledColor().drawableTintColor?.let {
            states.add(intArrayOf(-android.R.attr.state_enabled))
            colors.add(ContextCompat.getColor(context, it))
        }
        if(colorState.unselected?.drawableTintColor!=null) {
            states.add(intArrayOf(-android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context, colorState.unselected.drawableTintColor))
            states.add(intArrayOf(-android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, colorState.unselected.drawableTintColor))
        } else{
            colorState.unselected?.textColor?.let {
                states.add(intArrayOf(-android.R.attr.state_checked))
                colors.add(ContextCompat.getColor(context, colorState.unselected.textColor))
                states.add(intArrayOf(-android.R.attr.state_selected))
                colors.add(ContextCompat.getColor(context, colorState.unselected.textColor))
            }
        }
        if(colorState.selected?.drawableTintColor!=null) {
            states.add(intArrayOf(android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context, colorState.selected.drawableTintColor))
            states.add(intArrayOf(android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, colorState.selected.drawableTintColor))
        } else{
            colorState.selected?.textColor?.let {
                states.add(intArrayOf(android.R.attr.state_checked))
                colors.add(ContextCompat.getColor(context, colorState.selected.textColor))
                states.add(intArrayOf(android.R.attr.state_selected))
                colors.add(ContextCompat.getColor(context, colorState.selected.textColor))
            }
        }
        return ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

    private fun getStrokeColorStateList(context: Context, colorState: IxiChipColorState): ColorStateList {
        val states:MutableList<IntArray> = mutableListOf()
        val colors:MutableList<Int> = mutableListOf()
        getDisabledColor().strokeColor?.let {
            states.add(intArrayOf(-android.R.attr.state_enabled))
            colors.add(ContextCompat.getColor(context, it))
        }
        colorState.unselected?.strokeColor?.let {
            states.add(intArrayOf(-android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context,it))
            states.add(intArrayOf(-android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        colorState.selected?.strokeColor?.let {
            states.add(intArrayOf(android.R.attr.state_checked))
            colors.add(ContextCompat.getColor(context, it))
            states.add(intArrayOf(android.R.attr.state_selected))
            colors.add(ContextCompat.getColor(context, it))
        }
        return ColorStateList(states.toTypedArray(), colors.toIntArray())
    }

    private fun isChipEligible():Boolean{
        return ixiChipSize==IxiChipSize.LARGE || ixiChipSize==IxiChipSize.SMALL
    }

    fun setIconSize(startSize: Float = 16f, endSize: Float = 16f){
        this.chipIconSize = Utils.convertDpToPixel(startSize, context)
        this.closeIconSize = Utils.convertDpToPixel(endSize, context)
    }

    protected fun setText(text:String) {
        if(ixiChipSize!=IxiChipSize.NOTIFICATION) {
            this.text = text
        }
    }

    private fun mapChipTypeToEnum(int:Int):IxiChipSize{
        return when(int){
            0-> IxiChipSize.LARGE
            1-> IxiChipSize.SMALL
            2-> IxiChipSize.XSMALL
            3-> IxiChipSize.NOTIFICATION
            else-> IxiChipSize.LARGE
        }
    }

    enum class IxiChipSize(val textSize:Float,val height:Float) {
        LARGE(14f, 30f),
        SMALL(12f, 20f),
        XSMALL(10f, 15f),
        NOTIFICATION(0f, 2f);
    }
}

