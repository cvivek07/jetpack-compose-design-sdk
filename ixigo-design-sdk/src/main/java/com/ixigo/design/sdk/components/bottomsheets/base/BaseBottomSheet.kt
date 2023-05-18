package com.ixigo.design.sdk.components.bottomsheets.base

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import com.ixigo.design.sdk.components.BaseComponent
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.components.styles.IxiColor

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
    fun setToolbarTitle(toolbarText:String?){
        val inState = state.value
        state.value = inState.copy(toolbarText = toolbarText)
    }

    /**
     * Sets the subtitle to be displayed in the toolbar of the bottom sheet.
     *
     * @param toolbarSubtitleText The subtitle text to be displayed in the toolbar.
     */
    fun setToolbarSubtitle(toolbarSubtitleText:String?){
        val inState = state.value
        state.value = inState.copy(toolbarSubtitleText = toolbarSubtitleText)
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

    fun setButtonMinWidth(minWidth: Dp){
        state.value = state.value.copy(buttonMinWidth = minWidth)
    }

    fun setButtonMaxWidth(maxWidth: Dp){
        state.value = state.value.copy(buttonMaxWidth = maxWidth)
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
    fun disableDragging(enabled: Boolean){
        val inState = state.value
        state.value = inState.copy(disableDragging = enabled)
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

    /**
     * Set the inline alert to be displayed below the content in the bottom sheet.
     *
     * @param text for the text of inlineAlert.
     * @param ixiColor for the color of inline alert by default it's [IxiColor.Neutral]
     */
    fun setInlineAlert(text: String, ixiColor: IxiColor? =null){
        val inState = state.value
        state.value = inState.copy(inlineAlertText = text, inlineAlertIxiColor = ixiColor)
    }

    /**
     * Set the close action icon alignment only START & END is supported
     *
     * @param alignment alignment of close action icon
     */
    fun setCloseActionAlignment(alignment: IxiBottomSheetView.ActionIconAlignment){
        val inState = state.value
        state.value = inState.copy(closeActionAlignment = alignment)
    }

    /**
     * Sets the close icon drawable on Toolbar by default it's a Filled Cross Icon
     *
     * @param icon of close action icon
     */
    fun setToolbarCloseIcon(@DrawableRes icon: Int){
        val inState = state.value
        state.value = inState.copy(toolbarCloseIcon = icon)
    }

    fun showBottomDivider(show: Boolean) {
        state.value = state.value.copy(showBottomDivider = show)
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
    val buttonMinWidth: Dp = Dp.Unspecified,
    val buttonMaxWidth: Dp = Dp.Infinity,
    val primaryActionListener: (()->Unit)? = null,
    val secondaryActionListener: (()->Unit)? = null,
    val onClose: (() -> Unit)? = null,
    val iconSize:Float? = null,
    val view: View? = null,
    val disableDragging:Boolean = false,
    val inlineAlertText: String? = null,
    val inlineAlertIxiColor: IxiColor? = null,
    val toolbarSubtitleText: String? = null,
    val closeActionAlignment: IxiBottomSheetView.ActionIconAlignment = IxiBottomSheetView.ActionIconAlignment.END,
    val showBottomDivider: Boolean = false,
    @DrawableRes val toolbarCloseIcon: Int? = null,
    )