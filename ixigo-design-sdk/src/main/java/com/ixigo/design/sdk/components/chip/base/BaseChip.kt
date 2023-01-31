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

/**
 * Base class for creating IxiChips.
 *
 * @param context Context to inflate the Chip
 * @param attrs AttributeSet for the Chip
 * @param defStyleAttr The default style for the Chip
 */
abstract class BaseChip @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Chip(context, attrs, defStyleAttr)  {
    protected var horizontalPadding:Float = 8f
    protected var iconPadding:Float = 5f
    protected var ixiChipSize:IxiChipSize
    protected var onClickListener:((View)->Unit)? = null
    protected var drawableStart:Int? = null
    protected var drawableEnd:Int? = null
    protected var ixiChipColor:IxiChipColor? = null

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
            val startDrawable = if(drawableStart!=0) drawableStart else null
            val endDrawable = if(drawableEnd!=0) drawableEnd else null
            setStartDrawable(startDrawable)
            setEndDrawable(endDrawable)
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
            this.isCheckable = typedArray.getBoolean(R.styleable.BaseChip_android_checkable, true)
            setCheckedDrawable(null)
            val colorAttrVal = typedArray.getInt(R.styleable.BaseChip_chipColor, -1)
            val colorAttr = if (colorAttrVal != -1) getColorFromAttribute(colorAttrVal) else null
            colorAttr?.let {
                setColor(colorAttr)
            }
        } finally {
            typedArray.recycle()
        }
    }

    /**
     * Abstract method to get the state of the color of the chip.
     *
     * @param color the color of the chip.
     * @return the state of the color of the chip.
     */
    abstract fun getColorState(color:IxiChipColor): IxiChipColorState

    /**
     * Abstract method to get the disabled color of the chip.
     *
     * @return the disabled color of the chip.
     */
    abstract fun getDisabledColor(): IxiChipColor

    /**
     * Open method to set a listener for changes in the checked state of the chip.
     *
     * @param checkedIcon the drawable resource for the checked icon.
     * @param listener the listener for changes in the checked state of the chip.
     */
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

    /**
     * Overridden method to set the checked state of the chip.
     *
     * @param checked the checked state of the chip.
     */
    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if(ixiChipColor==null){
            ixiChipColor = IxiChipColor()
        }
        this.chipIconTint =  getDrawableColorStateList(context, getColorState(ixiChipColor!!))
    }

    /**
     * Method to set the start drawable for the chip.
     *
     * @param drawable the drawable resource for the start drawable.
     */
    fun setStartDrawable(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            drawableStart = drawable
            if (drawable != null) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = ContextCompat.getDrawable(context, drawable)
                this.iconEndPadding = Utils.convertDpToPixel(-iconPadding, context)
            } else {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = null
            }
            this.isChipIconVisible = drawable != null
        }
    }

    /**
     * Sets the checked drawable to the start of the chip.
     *
     * @param drawable The drawable to set at the start of the chip.
     */
    private fun setCheckedDrawableToStart(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            if (drawable != null) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = ContextCompat.getDrawable(context, drawable)
            } else {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.chipIcon = null
            }
            this.isChipIconVisible = drawable != null
        }
    }


    /**
     * Sets the close icon resource for the chip.
     *
     * @param id The id of the resource to set as the close icon.
     */
    override fun setCloseIconResource(id: Int) {
        if(isChipEligible()) {
            this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
        }
        super.setCloseIconResource(id)
    }

    /**
     * Sets the end drawable for the chip.
     *
     * @param drawable The drawable to set at the end of the chip.
     */
    private fun setEndDrawable(@DrawableRes drawable:Int?){
        if(isChipEligible()) {
            if (drawable != null) {
                this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.closeIcon = ContextCompat.getDrawable(context, drawable)
                this.closeIconStartPadding = Utils.convertDpToPixel(-iconPadding+2f, context)
            } else {
                this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
                this.closeIcon = null
            }
            this.isCloseIconVisible = drawable != null
        }
    }

    /**
     * Sets the drawable for the checked state of the Chip.
     * @param drawable The drawable resource to be set as the checked state drawable.
     */
    fun setCheckedDrawable(@DrawableRes drawable:Int?){
        drawable?.let {
            this.checkedIcon = ContextCompat.getDrawable(context, drawable)
        }
        this.isCheckedIconVisible = drawable != null
        if(isChipEligible()) {
            if (this.isChipIconVisible) {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
            } else {
                this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
            }
        }
    }

    /**
     * Sets the color of the Chip.
     * @param color The color to be set for the Chip.
     */
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

    private fun getColorFromAttribute(int: Int): IxiChipColor {
        return when(int){
            0-> IxiChipColor.NEUTRAL
            1-> IxiChipColor.BLUE
            2-> IxiChipColor.GREEN
            3-> IxiChipColor.PURPLE
            4-> IxiChipColor.RED
            5-> IxiChipColor.YELLOW
            else -> {
                IxiChipColor()
            }
        }
    }

    enum class IxiChipSize(val textSize:Float,val height:Float) {
        LARGE(14f, 30f),
        SMALL(12f, 20f),
        XSMALL(10f, 15f),
        NOTIFICATION(0f, 2f);
    }
}

