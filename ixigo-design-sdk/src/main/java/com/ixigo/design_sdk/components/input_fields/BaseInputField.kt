package com.ixigo.design_sdk.components.input_fields

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import com.ixigo.design.sdk.R
import com.ixigo.design_sdk.components.BaseComponent

abstract class BaseInputField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    protected val state = mutableStateOf(
        InputFieldState(
            actionImage = 0,
            drawableStart = 0,
            drawableEnd = 0,
            actualCharCountText = "",
            maxCharCount = 0,
            actionText = "",
            helperText = "",
            text = "",
            label = "",
            iconTint = R.color.black,
            onClickActionIcon = {},
            onClickActionText = {},
            onClickDrawableEnd = {},
            onClickDrawableStart = {}
        )
    )

    fun setText(text: String) {
        val initState = state.value.copy(text = text)
        state.value = initState
    }

    fun setActionText(text: String) {
        val initState = state.value.copy(actionText = text)
        state.value = initState
    }

    fun setHelperText(text: String) {
        val initState = state.value.copy(helperText = text)
        state.value = initState
    }

    fun setLabel(text: String) {
        val initState = state.value.copy(label = text)
        state.value = initState
    }

    fun setMaxCharCount(count: Int) {
        val initState = state.value.copy(maxCharCount = count)
        state.value = initState
    }


    protected fun setActualCharCountText(text: String) {
        val initState = state.value.copy(actionText = text)
        state.value = initState
    }

    fun setStartImageDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(drawableStart = imageRes)
        state.value = initState
    }

    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(drawableEnd = imageRes)
        state.value = initState
    }

    fun setActionDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(actionImage = imageRes)
        state.value = initState
    }

    fun setDrawableTint(@ColorRes tintColor: Int) {
        val initState = state.value.copy(iconTint = tintColor)
        state.value = initState
    }

    fun setActionTextClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickActionText = onClick)
        state.value = initState
    }

    fun setActionIconClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickActionIcon = onClick)
        state.value = initState
    }

    fun setDrawableStartClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickDrawableStart = onClick)
        state.value = initState
    }

    fun setDrawableEndClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickDrawableEnd = onClick)
        state.value = initState
    }
    init {
        val typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.BaseInputField);
        try {
            setText(typedArray.getString(R.styleable.BaseInputField_android_text) ?: "")
            setHelperText(typedArray.getString(R.styleable.BaseInputField_helperText) ?: "")
            setActionText(typedArray.getString(R.styleable.BaseInputField_actionText) ?: "")
            setLabel(typedArray.getString(R.styleable.BaseInputField_label) ?: "")
            setMaxCharCount(typedArray.getInt(R.styleable.BaseInputField_maxCharCount, 0))
            setActualCharCountText(
                typedArray.getString(R.styleable.BaseInputField_actualCharCounter) ?: ""
            )

            setEndImageDrawable(
                typedArray.getResourceId(R.styleable.BaseInputField_android_drawableEnd, 0)
            )
            setStartImageDrawable(
                typedArray.getResourceId(R.styleable.BaseInputField_android_drawableStart, 0)
            )
            setActionDrawable(typedArray.getResourceId(R.styleable.BaseInputField_actionImage, 0))
            val defColor = ContextCompat.getColor(context, R.color.black)
            val color =
                typedArray.getResourceId(R.styleable.BaseInputField_drawableTintColor, defColor)
            setDrawableTint(color)
        } finally {
            typedArray.recycle()
        }
    }
}

data class InputFieldState(
    @DrawableRes val actionImage: Int,
    @DrawableRes val drawableStart: Int,
    @DrawableRes val drawableEnd: Int,
    val actualCharCountText: String,
    val maxCharCount: Int,
    val actionText: String,
    val helperText: String,
    val text: String,
    val label: String,
    @ColorRes val iconTint: Int,
    val onClickActionText: () -> Unit,
    val onClickActionIcon: () -> Unit,
    val onClickDrawableStart: () -> Unit,
    val onClickDrawableEnd: () -> Unit,
)