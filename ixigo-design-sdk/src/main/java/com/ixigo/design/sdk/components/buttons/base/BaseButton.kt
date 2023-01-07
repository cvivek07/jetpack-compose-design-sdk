package com.ixigo.design.sdk.components.buttons.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor

/**
 * Base class for all the buttons. Extend this class to create a new type of button
 */
abstract class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected var startDrawableState = mutableStateOf(0)
    protected var state = mutableStateOf(ButtonState(colors = themeColor))
    protected var endDrawableState = mutableStateOf(0)

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseButton)
        try {
            val text = typedArray.getString(R.styleable.BaseButton_android_text) ?: ""
            setText(text)
            val drawableEnd =
                typedArray.getResourceId(R.styleable.BaseButton_android_drawableEnd, 0)
            val drawableStart =
                typedArray.getResourceId(R.styleable.BaseButton_android_drawableStart, 0)
            setHorizontalDrawables(drawableStart, drawableEnd)
        } finally {
            typedArray.recycle()
        }
    }

    /**
     * Sets the text to be displayed.
     * @param text: new text to be set
     */
    fun setText(text: String) {
        val inState = state.value
        state.value = inState.copy(text = text)
    }

    /**
     * Set the color for background of button. Calling this method will override the theme color.
     * Call this method only in case we need to provide a color explicitly and do not want to use
     * theme color.
     *
     * Don't use this method if we need to provide brand app button, as explicitly setting the color
     * on a button will render provided color and theme will have no effect on it. SO change in
     * theme after using this method will have no effect on button.
     *
     * @param color new color to be set. Please provide any color mentioned in [IxiColor.Orange],
     * [IxiColor.Blue], [IxiColor.Error], [IxiColor.Warning],[IxiColor.Success], [IxiColor.Extension]
     */
    protected open fun setColor(color: IxiColor) {
        val initState = state.value
        state.value = initState.copy(colors = color)
    }

    /**
     * Set the shape for the button.
     *
     * @param shape Shape to be set. Any shape can be provided from [IxiShape.RegularShape],
     * [IxiShape.BottomShape], [IxiShape.LeadingShape], [IxiShape.TrailingShape].
     * By default [IxiShape.RegularShape] is used.
     */
    protected open fun setShape(shape: IxiShape) {
        val initState = state.value
        state.value = initState.copy(shapes = shape)
    }

    /**
     * Set the size for the button. Size defines the height of button, Horizontal padding and
     * text size of button.
     *
     * @param size Size to be set. Size can be selected from [ButtonSize.Large], [ButtonSize.XLarge]
     * [ButtonSize.XXLarge], [ButtonSize.Medium], [ButtonSize.Small]
     * By default [ButtonSize.Large] is used.
     */
    protected open fun setSize(size: ButtonSize) {
        val initState = state.value
        state.value = initState.copy(sizes = size)
    }

    override fun setEnabled(enable: Boolean) {
        val initState = state.value
        state.value = initState.copy(isEnabled = enable)
    }

    override fun isEnabled(): Boolean {
        return state.value.isEnabled
    }


    /**
     * Set the start image.
     *
     * @param imageRes id for the drawable
     */
    fun setStartImageDrawable(@DrawableRes imageRes: Int) {
        startDrawableState.value = imageRes
    }

    /**
     * Set the end image.
     *
     * @param imageRes id for the drawable
     */
    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        endDrawableState.value = imageRes
    }

    fun setHorizontalDrawables(@DrawableRes imageResStart: Int, @DrawableRes imageResEnd: Int) {
        startDrawableState.value = imageResStart
        endDrawableState.value = imageResEnd
    }

    /**
     * remove both drawable
     */
    fun removeDrawables() {
        startDrawableState.value = 0
        endDrawableState.value = 0
    }

    /**
     * remove start drawable
     */
    fun removeStartDrawables() {
        startDrawableState.value = 0
    }


    /**
     * remove end drawable
     */
    fun removeEndDrawables() {
        endDrawableState.value = 0
    }


    /**
     * Register a λ to be invoked when this view is clicked.
     *
     * @param: onClick  λ that will be invoked
     */
    fun setClickListener(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(l)
        setClickListener {
            l?.onClick(this)
        }
    }
}


data class ButtonState(
    val text: String = "",
    val colors: IxiColor = IxiColor.Orange,
    val shapes: IxiShape = IxiShape.RegularShape,
    val sizes: ButtonSize = ButtonSize.Large,
    val isEnabled: Boolean = true,
    val onClick: () -> Unit = {}
)