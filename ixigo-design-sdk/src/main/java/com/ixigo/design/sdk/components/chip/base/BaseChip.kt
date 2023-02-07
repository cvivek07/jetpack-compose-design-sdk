package com.ixigo.design.sdk.components.chip.base

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.components.styles.IxiColor
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
    protected var iconPadding: Float = 5f
    protected var horizontalPadding: Float = 8f
    protected var ixiChipSize: IxiChipSize
    protected var drawableStart: Int? = null
    protected var drawableEnd: Int? = null
    protected var ixiChipColor: IxiChipColor = IxiChipColor.BLUE

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseChip)
        try {
            val appearanceAttr = typedArray.getInt(R.styleable.BaseChip_ixiChipTextAppearance, -1)
            if(appearanceAttr!=-1){
                this.setTextAppearance(mapChipTextAppearanceTypeToStyle(appearanceAttr))
            } else{
                this.setTextAppearance(R.style.ChipTextAppearance)
            }
            ixiChipColor = setUserDefinedOrStandardColor(typedArray)
            setColor(ixiChipColor)
            ixiChipSize = mapChipTypeToEnum(typedArray.getInt(R.styleable.BaseChip_chipType, 0))
            val text = typedArray.getString(R.styleable.BaseChip_android_text) ?: ""
            val textSizeAttr = typedArray.getDimensionPixelSize(R.styleable.BaseChip_android_textSize, -1)
            if(textSizeAttr!=-1){
                this.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizeAttr.toFloat())
            } else{
                this.textSize = ixiChipSize.textSize
            }
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
        val drawableTintColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipDrawableTintColor, -1).takeIf { it != -1 }
        val backgroundColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipBackgroundColor, -1).takeIf { it != -1 }
        val unselectedBackgroundColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnselectedBackgroundColor, -1).takeIf { it != -1 }
        val textColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipTextColor, -1).takeIf { it != -1 }
        val unSelectedTextColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnselectedTextColor, -1).takeIf { it != -1 }
        val strokeColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipStrokeColor, -1).takeIf { it != -1 }
        val unselectedStrokeColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnselectedStrokeColor, -1).takeIf { it != -1 }
        val unselectedDrawableTintColor = typedArray.getResourceId(R.styleable.BaseChip_ixiChipUnselectedDrawableTintColor, -1).takeIf { it != -1 }
        val chipColor =
            getColorFromAttribute(typedArray.getInt(R.styleable.BaseChip_chipColor, -1))
        val ixiColorAttr = typedArray.getInt(R.styleable.BaseChip_ixiColor, -1)
        val ixiColor = if (ixiColorAttr != -1) getColorFromAttribute(ixiColorAttr) else null
        return IxiChipColor.Extra(
            background = backgroundColor ?: ixiColor?.backgroundColor ?: chipColor.backgroundColor,
            unselectedBackground = unselectedBackgroundColor ?: ixiColor?.unselectedBackgroundColor
            ?: chipColor.unselectedBackgroundColor,
            stroke = strokeColor ?: ixiColor?.strokeColor ?: chipColor.strokeColor,
            unselectedStroke = unselectedStrokeColor?:ixiColor?.unselectedStrokeColor?:chipColor.unselectedStrokeColor,
            text = textColor ?: ixiColor?.textColor ?: chipColor.textColor,
            unselectedText =unSelectedTextColor ?: ixiColor?.unSelectedTextColor ?: chipColor.unSelectedTextColor,
            drawableTint = drawableTintColor ?: ixiColor?.drawableTintColor ?: chipColor.drawableTintColor,
            unselectedDrawableTint = unselectedDrawableTintColor?: ixiColor?.unselectedDrawableTintColor?: chipColor.unselectedDrawableTintColor
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
        this.closeIconStartPadding = Utils.convertDpToPixel(-iconPadding + 2f, context)
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
    @Deprecated(message = "For color consistency throughout the SDK. Support for this will be removed in 1.0.0")
    fun setColor(color: IxiChipColor) {
        this.ixiChipColor = color
        chipIconTint = iconTintSelector(color)
        checkedIconTint = iconTintSelector(color)
        closeIconTint = iconTintSelector(color)
        chipBackgroundColor = backgroundSelector(color)
        setTextColor(textSelector(color))
        chipStrokeColor = strokeColorSelector(color)
    }

    fun setColor(ixiColor: IxiColor) {
        val color = when (ixiColor) {
            IxiColor.Blue -> IxiChipColor.BLUE
            IxiColor.Error -> IxiChipColor.RED
            IxiColor.Extension -> IxiChipColor.PURPLE
            IxiColor.Orange -> IxiChipColor.ORANGE
            IxiColor.Success -> IxiChipColor.GREEN
            IxiColor.Warning -> IxiChipColor.YELLOW
            else -> {
                IxiChipColor()
            }
        }
        setColor(color)
    }

    fun setIxiChipTextAppearance(textAppearance: IxiChipTextAppearance){
        val originalTextSize = this.textSize
        this.setTextAppearance(mapChipTextAppearanceTypeToStyle(textAppearance.ordinal))
        this.textSize = Utils.pixelsToSp(context, originalTextSize)
        setTextColor(textSelector(ixiChipColor))
    }


    private fun backgroundSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.backgroundColor),
            ContextCompat.getColor(context, color.unselectedBackgroundColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.backgroundColor)
        )
    }

    private fun textSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.textColor),
            ContextCompat.getColor(context, color.unSelectedTextColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.textColor)
        )
    }

    private fun strokeColorSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.strokeColor),
            ContextCompat.getColor(context, color.unselectedStrokeColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.strokeColor)
        )
    }

    private fun iconTintSelector(color: IxiChipColor): ColorStateList {
        return makeSelector(
            ContextCompat.getColor(context, color.drawableTintColor),
            ContextCompat.getColor(context, color.unselectedDrawableTintColor),
            ContextCompat.getColor(context, IxiChipColor.DISABLED.drawableTintColor)
        )
    }

    open fun makeSelector(
        selectedColor: Int,
        unselectedColor: Int,
        disabledColor: Int
    ): ColorStateList {
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

    private fun mapChipTextAppearanceTypeToStyle(enum: Int): Int {
        return when (enum) {
            0 -> R.style.ChipTextAppearance
            1 -> R.style.ChipTextAppearance_Bold
            2 -> R.style.ChipTextAppearance_Italic
            3 -> R.style.ChipTextAppearance_Bold_Italic
            else -> R.style.ChipTextAppearance
        }
    }

    private fun getColorFromAttribute(int: Int): IxiChipColor {
        return when (int) {
            0 -> IxiChipColor.YELLOW
            1 -> IxiChipColor.PURPLE
            2 -> IxiChipColor.RED
            3 -> IxiChipColor.GREEN
            4 -> IxiChipColor.BLUE
            5 -> IxiChipColor.NEUTRAL
            6 -> IxiChipColor.ORANGE
            else -> {
                IxiChipColor()
            }
        }
    }

    enum class IxiChipSize(val textSize: Float, val height: Float) {
        LARGE(14f, 30f),
        SMALL(12f, 20f),
        XSMALL(10f, 15f),
        NOTIFICATION(0f, 2f);
    }

    enum class IxiChipTextAppearance {
        NORMAL,
        BOLD,
        ITALIC,
        BOLD_ITALIC,
    }
}

