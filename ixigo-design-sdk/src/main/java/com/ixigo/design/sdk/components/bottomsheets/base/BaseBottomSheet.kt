package com.ixigo.design.sdk.components.bottomsheets.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import com.ixigo.design.sdk.components.BaseComponent

/**
 * A base class for a custom bottom sheet view in Android.
 *
 * @property state The state of the bottom sheet view.
 *
 * @constructor Creates a new instance of the [BaseBottomSheet] class.
 *
 * @param context The context associated with the view.
 * @param attrs The attributes for the view.
 * @param defStyleAttr The default style for the view.
 */
abstract class BaseBottomSheet @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseComponent(context, attrs, defStyleAttr) {
    protected var state = mutableStateOf(BottomSheetState())

    /**
     * Sets the image to be displayed in the bottom sheet.
     *
     * @param image The image to be displayed, represented as a drawable resource ID.
     */
    fun setImage(@DrawableRes image:Int?){
        val inState = state.value
        state.value = inState.copy(image = image)
    }

    /**
     * Sets the header text to be displayed in the bottom sheet.
     *
     * @param headerText The header text to be displayed.
     */
    fun setHeaderText(headerText:String?){
        val inState = state.value
        state.value = inState.copy(headerText = headerText)
    }

    /**
     * Sets the background color of the image in the bottom sheet.
     *
     * @param imageBackgroundColor The background color of the image, represented as a color resource ID.
     */
    fun setImageBackgroundColor(@ColorRes imageBackgroundColor: Int?){
        val inState = state.value
        state.value = inState.copy(imageBackgroundColor = imageBackgroundColor)
    }

    /**
     * Sets the body text to be displayed in the bottom sheet.
     *
     * @param bodyText The body text to be displayed.
     */
    fun setBodyText(bodyText:String?){
        val inState = state.value
        state.value = inState.copy(bodyText = bodyText)
    }

    /**
     * Sets the text to be displayed in the toolbar of the bottom sheet.
     *
     * @param toolbarText The text to be displayed in the toolbar.
     */
    fun setToolbarText(toolbarText:String?){
        val inState = state.value
        state.value = inState.copy(toolbarText = toolbarText)
    }

    /**
     * Sets the primary button to be displayed in the bottom sheet.
     *
     * @param ixiPrimaryButtonText The text to be displayed on the primary button.
     * @param primaryActionListener The action to be performed when the primary button is clicked.
     */
    fun setPrimaryButton(ixiPrimaryButtonText: String, primaryActionListener: (() -> Unit)?){
        val inState = state.value
        state.value = inState.copy(primaryButtonText = ixiPrimaryButtonText, primaryActionListener = primaryActionListener)
    }

    /**
     * Set the text for the secondary button and its corresponding action listener.
     *
     * @param ixiSecondaryButtonText the text for the secondary button.
     * @param secondaryActionListener the action listener for the secondary button.
     */
    fun setSecondaryButton(ixiSecondaryButtonText: String, secondaryActionListener: (() -> Unit)){
        val inState = state.value
        state.value = inState.copy(secondaryButtonText = ixiSecondaryButtonText, secondaryActionListener = secondaryActionListener)
    }

    /**
     * Set the action listener for close button.
     *
     * @param closeActionListener the action listener for close button.
     */
    fun setCloseActionListener(closeActionListener: (() -> Unit)?){
        val inState = state.value
        state.value = inState.copy(onClose = closeActionListener)
    }

    /**
     * Set the size of the icon.
     *
     * @param size the size of the icon.
     */
    fun setIconSize(size: Float?){
        val inState = state.value
        state.value = inState.copy(iconSize = size)
    }

    /**
     * Enable or disable the pointer for the bottom sheet.
     *
     * @param enabled whether the pointer is enabled or disabled.
     */
    fun enablePointer(enabled: Boolean){
        val inState = state.value
        state.value = inState.copy(enablePointer = enabled)
    }

    /**
     * Set the custom view to be displayed in the bottom sheet.
     * The view ovverrides the default view in BottomSheet
     *
     * @param view the view to be displayed.
     */
    fun setView(view: View){
        val inState = state.value
        state.value = inState.copy(view = view)
    }
}

data class BottomSheetState(
    @DrawableRes val image:Int? = null,
    val headerText:String? = null,
    @ColorRes val imageBackgroundColor: Int? = null,
    val bodyText: String? = null,
    val toolbarText: String? = null,
    val primaryButtonText: String? = null,
    val secondaryButtonText: String? = null,
    val primaryActionListener: (()->Unit)? = null,
    val secondaryActionListener: (()->Unit)? = null,
    val onClose: (() -> Unit)? = null,
    val iconSize:Float? = null,
    val view: View? = null,
    val enablePointer:Boolean = false
    )