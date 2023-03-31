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
            onTextChange = {},
            onFocusChange = null,
            color = IxiColor.Orange,
            readOnly = false
        )
    )


    /**
     *  Sets the text for this [InputField].
     *
     *  @param text The text to be set to the [InputField].
     */
    fun setText(text: String) {
        textValue = text
        val initState = state.value.copy(text = text)
        state.value = initState
    }

    /**
     *  @return  The text set on [InputField].
     */
    fun getText() = state.value.text

    /**
     * Sets the action text for this [InputField].
     *
     * @param text The action text to be set to the [InputField].
     */
    fun setActionText(text: String) {
        val initState = state.value.copy(actionText = text)
        state.value = initState
    }

    /**
     * Sets the helper text for this [InputField].
     *
     * @param text The helper text to be set to the [InputField].
     */
    fun setHelperText(text: String) {
        val initState = state.value.copy(helperText = text)
        state.value = initState
    }

    /**
     * Sets the label for this [InputField].
     *
     * @param text The label to be set to
     */
    fun setLabel(text: String) {
        val initState = state.value.copy(label = text)
        state.value = initState
    }

    /**
     * Sets the maximum character allowed for the text input.
     *
     * @param count the maximum character count
     */
    fun setMaxCharCount(count: Int) {
        val initState = state.value.copy(maxCharCount = count)
        state.value = initState
    }

    /**
     * Sets the color of the text input.
     *
     * @param color the color to be set
     */
    fun setColor(color: IxiColor) {
        val initState = state.value.copy(color = color)
        state.value = initState
    }


    /**
     * Sets the actual character count text to be displayed.
     *
     * @param text the text to be displayed
     */
    fun setActualCharCountText(text: String) {
        val initState = state.value.copy(actionText = text)
        state.value = initState
    }

    /**
     * Sets the drawable to be displayed at the start of the text input.
     *
     * @param imageRes the drawable resource id
     */
    fun setStartImageDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(drawableStart = imageRes)
        state.value = initState
    }

    /**
     * Sets the drawable to be displayed at the end of the text input.
     *
     * @param imageRes the drawable resource id
     */
    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(drawableEnd = imageRes)
        state.value = initState
    }

    /**
     * Sets the drawable to be displayed action icon.
     *
     * @param imageRes the drawable resource id
     */
    fun setActionDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value.copy(actionImage = imageRes)
        state.value = initState
    }

    /**
     * Sets the click listener for the action text.
     *
     * @param onClick the click listener
     */
    fun setActionTextClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickActionText = onClick)
        state.value = initState
    }

    /**
     * Sets the click listener for the action icon.
     *
     * @param onClick the click listener
     */
    fun setActionIconClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickActionIcon = onClick)
        state.value = initState
    }

    /**
     * Sets the click listener for the drawable at start.
     *
     * @param onClick the click listener
     */
    fun setDrawableStartClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickDrawableStart = onClick)
        state.value = initState
    }

    /**
     * Sets the click listener for the drawable at end.
     *
     * @param onClick the click listener
     */
    fun setDrawableEndClickListener(onClick: () -> Unit) {
        val initState = state.value.copy(onClickDrawableEnd = onClick)
        state.value = initState
    }

    /**
     * Sets the text change listener.
     *
     * @param listener the text change listener
     */
    fun setTextChangeListener(onTextChange: ((String) -> Unit)) {
        state.value = state.value.copy(onTextChange = {
            state.value = state.value.copy(text = it)
            onTextChange.invoke(it)
        })
    }

    /**
     * Sets the focus change listener.
     *
     * @param listener the focus change listener
     */
    fun setFocusChangeListener(listener: ((Boolean) -> Unit)?) {
        val initState = state.value
        state.value = initState.copy(onFocusChange = listener)
    }

    /**
     * Sets the text input to read only.
     *
     * @param value true to set the text input to read only, false otherwise
     */
    fun setReadOnly(value: Boolean) {
        val initState = state.value
        state.value = initState.copy(readOnly = value)
    }

    /**
     * Sets the text input to read only.
     *
     * @param value true to set the text input to read only, false otherwise
     */
    fun isReadOnly() = state.value.readOnly

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
    val onTextChange: ((String) -> Unit) = {},
    val onFocusChange: ((Boolean) -> Unit)?,
    val readOnly: Boolean
)


interface TextChangeListener {
    fun onTextChange(newText: String)
}