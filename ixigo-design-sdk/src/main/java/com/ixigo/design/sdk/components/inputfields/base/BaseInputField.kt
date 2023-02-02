package com.ixigo.design.sdk.components.inputfields.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.styles.IxiColor

abstract class BaseInputField @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {

    private var textValue: String? = null
    lateinit var textChangeListener: TextChangeListener

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
            onClickDrawableStart = {},
            onTextChange = if (::textChangeListener.isInitialized) textChangeListener::onTextChange else null,
            color = IxiColor.Orange
        )
    )


    fun setText(text: String) {
        textValue = text
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

    fun setColor(color: IxiColor) {
        val initState = state.value.copy(color = color)
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
            setMaxCharCount(
                typedArray.getInt(
                    R.styleable.BaseInputField_maxCharCount,
                    Int.MAX_VALUE
                )
            )
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
        } finally {
            typedArray.recycle()
        }
    }
}

data class InputFieldState(
    val color: IxiColor,
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
    val onTextChange: ((String) -> Unit)?,
)


interface TextChangeListener {
    fun onTextChange(newText: String)
}