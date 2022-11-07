package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.BaseComponent
import com.ixigo.design_sdk.components.IxiState
import com.ixigo.design_sdk.components.buttons.shapes.ButtonStyles
import com.ixigo.design_sdk.components.buttons.shapes.ComponentStyle

abstract class BaseButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {


    protected val o700NormalTrailingShapeRadius = 0
    protected val o700NormalLeadingShapeRadius = 1
    protected val b700NormalLeadingShapeRadius = 2
    protected val b700XXlargeBottomShapeRadius = 3
    protected val b700XXlargeBottomShapeRadiusDisabled = 4
    protected val b700XXlargeRegularShapeRadius = 5
    protected val b700NormalRegularShapeRadius = 6
    protected val b700NormalRegularShapeRadiusOutlined = 7
    protected val b700NormalTrailingShapeRadiusOutlined = 8
    protected val b700NormalLeadingShapeRadiusOutlined = 9
    protected val b700NormalBottomShapeRadiusOutlined = 10


    protected var startDrawableState = mutableStateOf(0)
    protected var state = mutableStateOf(IxiState())
    protected var endDrawableState = mutableStateOf(0)
    protected var flag: Int = o700NormalTrailingShapeRadius

    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseButton);
        try {
            val text = typedArray.getString(R.styleable.BaseButton_android_text) ?: ""
            setText(text)

            flag = typedArray.getInt(
                R.styleable.BaseButton_ixi_button_style,
                o700NormalTrailingShapeRadius
            )
            setStyle(mapFlagsWithStyle(flag))

            val drawableEnd = typedArray.getResourceId(R.styleable.BaseButton_android_drawableEnd ,0)
            val drawableStart = typedArray.getResourceId(R.styleable.BaseButton_android_drawableStart, 0)
            setHorizontalDrawables(drawableStart, drawableEnd)
        } finally {
            typedArray.recycle()
        }
    }

    fun setText(text: String) {
        val inState = state.value
        state.value = inState.copy(text = text)
    }

    fun setStyle(style: ComponentStyle) {
        val inState = state.value
        state.value = inState.copy(style = style)
    }

    override fun setEnabled(enable: Boolean) {
        val initState = state.value
        state.value = initState.copy(style = initState.style.copy(isEnabled = enable))
    }

    override fun isEnabled(): Boolean {
        return state.value.style.isEnabled
    }

    fun setStartImageDrawable(@DrawableRes imageRes: Int) {
        startDrawableState.value = imageRes
    }

    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        endDrawableState.value = imageRes
    }

    fun setHorizontalDrawables(@DrawableRes imageResStart: Int, @DrawableRes imageResEnd: Int) {
        startDrawableState.value  = imageResStart
        endDrawableState.value = imageResEnd
    }

    fun removeDrawables() {
        startDrawableState.value  = 0
        endDrawableState.value = 0
    }

    fun removeStartDrawables() {
        startDrawableState.value  = 0
    }

    fun removeEndDrawables() {
        endDrawableState.value = 0
    }


    fun setClickListener(onClick: () -> Unit) {
        val inState = state.value
        state.value = inState.copy(onClick = onClick)
    }

    protected fun mapFlagsWithStyle(flag: Int) = when (flag) {
        o700NormalLeadingShapeRadius -> ButtonStyles.o700NormalLeadingShapeRadius
        o700NormalTrailingShapeRadius -> ButtonStyles.o700NormalTrailingShapeRadius
        b700NormalLeadingShapeRadius -> ButtonStyles.b700NormalLeadingShapeRadius
        b700XXlargeBottomShapeRadius -> ButtonStyles.b700XXlargeBottomShapeRadius
        b700XXlargeBottomShapeRadiusDisabled -> ButtonStyles.b700XXlargeBottomShapeRadiusDisabled
        b700XXlargeRegularShapeRadius -> ButtonStyles.b700XXlargeRegularShapeRadius
        b700NormalRegularShapeRadius -> ButtonStyles.b700NormalRegularShapeRadius
        b700NormalRegularShapeRadiusOutlined -> ButtonStyles.b700NormalRegularShapeRadiusOutlined
        b700NormalLeadingShapeRadiusOutlined -> ButtonStyles.b700NormalLeadingShapeRadiusOutlined
        b700NormalTrailingShapeRadiusOutlined -> ButtonStyles.b700NormalTrailingShapeRadiusOutlined
        b700NormalBottomShapeRadiusOutlined -> ButtonStyles.b700NormalBottomShapeRadiusOutlined
        else -> ButtonStyles.b700NormalRegularShapeRadius
    }
}