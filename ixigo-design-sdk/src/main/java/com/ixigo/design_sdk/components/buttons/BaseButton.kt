package com.ixigo.design_sdk.components.buttons

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
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
    protected val b700NormalLeadingShapeRadiusOutlined = 8
    protected val b700NormalTrailingShapeRadiusOutlined = 9
    protected val b700NormalBottomShapeRadiusOutlined = 10


    protected var state = mutableStateOf(IxiState())
    protected var flag: Int = o700NormalTrailingShapeRadius


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
        val initState = state.value
        state.value = initState.copy(style = initState.style.copy(startDrawable = imageRes))
    }

    fun setEndImageDrawable(@DrawableRes imageRes: Int) {
        val initState = state.value
        state.value = initState.copy(style = initState.style.copy(endDrawable = imageRes))
    }

    fun setHorizontalDrawables(@DrawableRes imageResStart: Int, @DrawableRes imageResEnd: Int) {
        val initState = state.value
        state.value = initState.copy(
            style = initState.style.copy(
                startDrawable = imageResStart,
                endDrawable = imageResEnd
            )
        )
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

//    companion object {
//
//        protected const val o700NormalTrailingShapeRadius = 0
//        protected const val o700NormalLeadingShapeRadius = 1
//        protected const val b700NormalLeadingShapeRadius = 2
//        protected const val b700XXlargeBottomShapeRadius = 3
//        protected const val b700XXlargeBottomShapeRadiusDisabled = 4
//        protected const val b700XXlargeRegularShapeRadius = 5
//        protected const val b700NormalRegularShapeRadius = 6
//
//        @IntDef(
//            flag = true, value = [
//                o700NormalTrailingShapeRadius,
//                o700NormalLeadingShapeRadius,
//                b700NormalLeadingShapeRadius,
//                b700XXlargeBottomShapeRadius,
//                b700XXlargeBottomShapeRadiusDisabled,
//                b700XXlargeRegularShapeRadius,
//                b700NormalRegularShapeRadius]
//        )
//        @Retention(AnnotationRetention.SOURCE)
//        annotation class ButtonStyleFlags
//    }
}