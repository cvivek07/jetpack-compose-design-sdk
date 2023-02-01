package com.ixigo.design.sdk.components.chip.base

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiChipColor
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
    protected var iconPadding:Float = 5f
    protected var horizontalPadding: Float = 8f
    protected var ixiChipSize: IxiChipSize
    protected var drawableStart: Int? = null
    protected var drawableEnd: Int? = null
    protected var ixiChipColor: IxiChipColor = IxiChipColor.BLUE

    init {
        this.setTextAppearance(R.style.chipText)
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseChip)
        try {
            setColor(setUserDefinedOrStandardColor(typedArray))
            ixiChipSize = mapChipTypeToEnum(typedArray.getInt(R.styleable.BaseChip_chipType, 0))
            val text = typedArray.getString(R.styleable.BaseChip_android_text) ?: ""
            this.textSize = ixiChipSize.textSize
            this.chipMinHeight = Utils.convertDpToPixel(ixiChipSize.height, context)
            this.textAlignment = TEXT_ALIGNMENT_CENTER
            setText(text)
            horizontalPadding = if (ixiChipSize == IxiChipSize.SMALL) 4f else 8f
            this.chipStartPadding = Utils.convertDpToPixel(horizontalPadding, context)
            this.chipEndPadding = Utils.convertDpToPixel(horizontalPadding, context)
            val drawableEnd =
                typedArray.getResourceId(R.styleable.BaseChip_closeIcon, 0)
            setCloseIconResource(drawableEnd)
            val drawableStart =
                typedArray.getResourceId(R.styleable.BaseChip_chipIcon, 0)
            setChipIconResource(drawableStart)
            this.chipStrokeWidth = Utils.convertDpToPixel(1f, context)
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
            this.isEnabled = typedArray.getBoolean(R.styleable.BaseChip_android_enabled, true)
            // adding this to make it selectable. Without onclickListener chip-group selection is not working
            this.setOnClickListener { }
        } finally {
            typedArray.recycle()
        }
    }

    private fun setUserDefinedOrStandardColor(typedArray: TypedArray): IxiChipColor {
        val drawableTintColorVal =
            typedArray.getResourceId(R.styleable.BaseChip_ixiChipDrawableTintColor, -1)
        val backgroundColorVal =
            typedArray.getResourceId(R.styleable.BaseChip_ixiChipBackgroundColor, -1)
        val unselectedBackgroundColorVal =
            typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnselectedBackgroundColor, -1)
        val textColorVal = typedArray.getResourceId(R.styleable.BaseChip_ixiChipTextColor, -1)
        val unSelectedTextColorVal =
            typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnSelectedTextColor, -1)
        val strokeColorVal = typedArray.getResourceId(R.styleable.BaseChip_ixiChipStrokeColor, -1)
        var drawableTintColor: Int? = null
        var backgroundColor: Int? = null
        var unselectedBackgroundColor: Int? = null
        var textColor: Int? = null
        var unSelectedTextColor: Int? = null
        var strokeColor: Int? = null
        if (drawableTintColorVal != -1) {
            drawableTintColor = drawableTintColorVal
        }
        if (backgroundColorVal != -1) {
            backgroundColor = backgroundColorVal
        }
        if (unselectedBackgroundColorVal != -1) {
            unselectedBackgroundColor = unselectedBackgroundColorVal
        }
        if (unSelectedTextColorVal != -1) {
            unSelectedTextColor = unSelectedTextColorVal
        }
        if (strokeColorVal != -1) {
            strokeColor = strokeColorVal
        }
        if (textColorVal != -1) {
            textColor = textColorVal
        }
        val attrIxiColor =
            getColorFromAttribute(typedArray.getInt(R.styleable.BaseChip_chipColor, -1))
        return IxiChipColor(
            backgroundColor ?: attrIxiColor.backgroundColor,
            unselectedBackgroundColor ?: attrIxiColor.unselectedBackgroundColor,
            strokeColor ?: attrIxiColor.strokeColor,
            textColor ?: attrIxiColor.textColor,
            unSelectedTextColor ?: attrIxiColor.unSelectedTextColor,
            drawableTintColor ?: attrIxiColor.drawableTintColor
        )

    }

    override fun setChecked(checked: Boolean) {
        super.setChecked(checked)
        if (ixiChipColor != null)
            setColor(ixiChipColor)
    }

    override fun setCheckedIcon(checkedIcon: Drawable?) {
        if (checkedIcon != null) {
            this.iconEndPadding = Utils.convertDpToPixel(-iconPadding, context)
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
            chipIconTint = iconTintSelector(ixiChipColor)
        }
        this.isChipIconVisible = chipIcon != null
        super.setChipIcon(chipIcon)
    }

    final override fun setChipIconResource(@DrawableRes id: Int) {
        val drawable = if (id == 0) null else AppCompatResources.getDrawable(context, id)
        chipIcon = drawable
        checkedIcon = drawable
    }


    final override fun setCloseIconResource(id: Int) {
        val drawable = if (id == 0) null else AppCompatResources.getDrawable(context, id)
        this.closeIconStartPadding = Utils.convertDpToPixel(-iconPadding+2f, context)
        closeIcon = drawable
    }

    override fun setCloseIcon(closeIcon: Drawable?) {
        if (closeIcon != null) {
            closeIconTint = iconTintSelector(ixiChipColor)
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
        chipIconTint = iconTintSelector(color)
        checkedIconTint = iconTintSelector(color)
        closeIconTint = iconTintSelector(color)
        chipBackgroundColor = backgroundSelector(color)
        setTextColor(textSelector(color))
        chipStrokeColor = strokeColorSelector(color)
    }


    private fun backgroundSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.backgroundColor),
            Color.TRANSPARENT,
            ContextCompat.getColor(context, IxiChipColor.DISABLED.backgroundColor)
        )
    }

    private fun textSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.textColor),
            ContextCompat.getColor(context, color.backgroundColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.textColor)
        )
    }

    private fun strokeColorSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.strokeColor),
            ContextCompat.getColor(context, color.strokeColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.strokeColor)
        )
    }

    private fun iconTintSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.drawableTintColor),
            ContextCompat.getColor(context, color.backgroundColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.drawableTintColor)
        )
    }

    open fun makeSelector(selectedColor: Int, unselectedColor: Int, disabledColor: Int): ColorStateList {
        val states = arrayOf(
            intArrayOf(
                -android.R.attr.state_enabled
            ),
            intArrayOf(
                -android.R.attr.state_checked,
                -android.R.attr.state_selected
            ),
            intArrayOf(
                android.R.attr.state_checked,
                android.R.attr.state_selected
            ),
        )
        val colors = intArrayOf(disabledColor, unselectedColor, selectedColor)

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

    private fun getColorFromAttribute(int: Int): IxiChipColor {
        return when (int) {
            0 -> IxiChipColor.NEUTRAL
            1 -> IxiChipColor.BLUE
            2 -> IxiChipColor.GREEN
            3 -> IxiChipColor.PURPLE
            4 -> IxiChipColor.RED
            5 -> IxiChipColor.YELLOW
            else -> {
                IxiChipColor()
            }
        }
    }

    // iconsize
    enum class IxiChipSize(val textSize: Float, val height: Float) {
        LARGE(14f, 30f),
        SMALL(12f, 20f),
        XSMALL(10f, 15f),
        NOTIFICATION(0f, 2f);
    }
}

