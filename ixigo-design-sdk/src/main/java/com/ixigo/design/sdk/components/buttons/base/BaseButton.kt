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

abstract class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected var startDrawableState = mutableStateOf(0)
    protected var state = mutableStateOf(ButtonState())
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

    fun setText(text: String) {
        val inState = state.value
        state.value = inState.copy(text = text)
    }

    protected open fun setStyle(shapes: IxiShape, colors: IxiColor, sizes: ButtonSize) {
        val initState = state.value
        state.value = initState.copy(shapes = shapes, colors = colors, sizes = sizes)
    }

    override fun setEnabled(enable: Boolean) {
        val initState = state.value
        state.value = initState.copy(isEnabled = enable)
    }

    override fun isEnabled(): Boolean {
        return state.value.isEnabled
    }


    fun setStartImageDrawable(@DrawableRes imageRes: Int) {
        startDrawableState.value = imageRes
    }

    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        endDrawableState.value = imageRes
    }

    fun setHorizontalDrawables(@DrawableRes imageResStart: Int, @DrawableRes imageResEnd: Int) {
        startDrawableState.value = imageResStart
        endDrawableState.value = imageResEnd
    }

    fun removeDrawables() {
        startDrawableState.value = 0
        endDrawableState.value = 0
    }

    fun removeStartDrawables() {
        startDrawableState.value = 0
    }

    fun removeEndDrawables() {
        endDrawableState.value = 0
    }


    fun setClickListener(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
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