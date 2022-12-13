package com.ixigo.design.sdk.components.bottomsheets.base

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.buttons.IxiPrimaryButton
import com.ixigo.design.sdk.components.buttons.IxiSecondaryButton

abstract class BaseBottomSheet @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(BottomSheetState())

    fun setImage(@DrawableRes image:Int?){
        val inState = state.value
        state.value = inState.copy(image = image)
    }

    fun setHeaderText(headerText:String?){
        val inState = state.value
        state.value = inState.copy(headerText = headerText)
    }

    fun setImageBackgroundColor(@ColorRes imageBackgroundColor: Int?){
        val inState = state.value
        state.value = inState.copy(imageBackgroundColor = imageBackgroundColor)
    }

    fun setBodyText(bodyText:String?){
        val inState = state.value
        state.value = inState.copy(bodyText = bodyText)
    }

    fun setToolbarText(toolbarText:String?){
        val inState = state.value
        state.value = inState.copy(toolbarText = toolbarText)
    }

    fun setPrimaryButton(ixiPrimaryButton: IxiPrimaryButton?){
        val inState = state.value
        state.value = inState.copy(primaryButton = ixiPrimaryButton)
    }

    fun setSecondaryButton(ixiSecondaryButton: IxiSecondaryButton?){
        val inState = state.value
        state.value = inState.copy(secondaryButton = ixiSecondaryButton)
    }

    fun setCloseActionListener(closeActionListener: (() -> Unit)?){
        val inState = state.value
        state.value = inState.copy(onClose = closeActionListener)
    }
}

data class BottomSheetState(
    @DrawableRes val image:Int? = null,
    val headerText:String? = null,
    @ColorRes val imageBackgroundColor: Int? = null,
    val bodyText: String? = null,
    val toolbarText: String? = null,
    val primaryButton: IxiPrimaryButton? = null,
    val secondaryButton: IxiSecondaryButton? = null,
    val onClose: (() -> Unit)? = null,
    val isToolbarCentered: Boolean? = false
    ):java.io.Serializable