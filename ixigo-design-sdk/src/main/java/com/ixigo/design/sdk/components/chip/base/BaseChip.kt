package com.ixigo.design.sdk.components.chip.base

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
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
) : Chip(context, attrs, defStyleAttr) {
    protected var horizontalPadding: Float = 8f
    protected var ixiChipSize: IxiChipSize
    protected var onClickListener: ((View) -> Unit)? = null
    protected var drawableStart: Int? = null
    protected var drawableEnd: Int? = null
    protected var ixiChipColor: IxiChipColor = IxiChipColor.BLUE

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
            setCloseIconResource(drawableEnd)
            val drawableStart =
                typedArray.getResourceId(R.styleable.BaseChip_chipDrawableStart, 0)
            setChipIconResource(drawableStart)
//
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


    override fun setCheckedIcon(checkedIcon: Drawable?) {
        if (checkedIcon != null) {
            this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)

        } else {
            this.chipStartPadding = 0f
        }
        this.isChipIconVisible = chipIcon != null
        super.setCheckedIcon(checkedIcon)
    }

    override fun setCheckedIconResource(@DrawableRes id: Int) {
        val drawable = if (id == 0) null else AppCompatResources.getDrawable(context, id)
        checkedIconTint = iconTintSelector(ixiChipColor)
        chipIcon = drawable
        checkedIcon = drawable
    }

    override fun setChipIcon(chipIcon: Drawable?) {
        if (chipIcon != null) {
            this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)

        } else {
            this.chipStartPadding = 0f
        }
        this.isChipIconVisible = chipIcon != null
        super.setChipIcon(chipIcon)
    }

    final override fun setChipIconResource(@DrawableRes id: Int) {
        val drawable = if (id == 0) null else AppCompatResources.getDrawable(context, id)
        chipIconTint = iconTintSelector(ixiChipColor)
        chipIcon = drawable
        checkedIcon = drawable
    }


    final override fun setCloseIconResource(id: Int) {
        val drawable = if (id == 0) null else AppCompatResources.getDrawable(context, id)
        closeIconTint = iconTintSelector(ixiChipColor)
        closeIcon = drawable
    }

    override fun setCloseIcon(closeIcon: Drawable?) {
        if (closeIcon != null) {
            this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)

        } else {
            this.chipEndPadding = 0f
        }
        this.isCloseIconVisible = closeIcon != null
        super.setCloseIcon(closeIcon)
    }


    /**
     * Sets the color of the Chip.
     * @param color The color to be set for the Chip.
     */
    fun setColor(color: IxiChipColor) {
        this.ixiChipColor = color
        chipBackgroundColor = backgroundSelector(color)
        setTextColor(textSelector(color))
        chipStrokeColor = textSelector(color)
    }


    private fun backgroundSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.backgroundColor),
            Color.TRANSPARENT
        )
    }

    private fun textSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.textColor),
            ContextCompat.getColor(context, color.backgroundColor)
        )
    }

    private fun iconTintSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.drawableTintColor),
            ContextCompat.getColor(context, color.backgroundColor)
        )
    }

    open fun makeSelector(selectedColor: Int, unselectedColor: Int): ColorStateList {
        val states = arrayOf(
            intArrayOf(
                -android.R.attr.state_checked,
                -android.R.attr.state_selected
            ),
            intArrayOf(
                android.R.attr.state_checked,
                android.R.attr.state_selected
            )
        )
        val colors = intArrayOf(unselectedColor, selectedColor)

        return ColorStateList(states, colors)
    }


    fun setIconSize(startSize: Float = 16f, endSize: Float = 16f) {
        this.chipIconSize = Utils.convertDpToPixel(startSize, context)
        this.closeIconSize = Utils.convertDpToPixel(endSize, context)
    }

    private fun mapChipTypeToEnum(int: Int): IxiChipSize {
        return when (int) {
            0 -> IxiChipSize.LARGE
            1 -> IxiChipSize.SMALL
            2 -> IxiChipSize.XSMALL
            3 -> IxiChipSize.NOTIFICATION
            else -> IxiChipSize.LARGE
        }
    }

    enum class IxiChipSize(val textSize: Float, val height: Float) {
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

