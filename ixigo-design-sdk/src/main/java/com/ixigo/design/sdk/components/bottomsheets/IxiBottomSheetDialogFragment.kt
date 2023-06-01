package com.ixigo.design.sdk.components.bottomsheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.compose.ui.unit.Dp
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.databinding.IxiBottomSheetFragmentBinding


/**
 * A class representing a custom base Bottom Sheet view in Android.
 * This class extends [BottomSheetDialogFragment] and implements UI customization
 * functionality
 *
 * @property uiState A data class [IxiBottomSheetDialogFragmentUiModel] containing all the properties required to build the bottom sheet dialog fragment.
 *
 * @version 1.0
 * @since 2023-01-27
 */
open class IxiBottomSheetDialogFragment(@LayoutRes val contentLayoutId: Int = 0, ixiBottomSheetDialogFragmentUiModel: IxiBottomSheetDialogFragmentUiModel = IxiBottomSheetDialogFragmentUiModel(), private val onCloseActionListener:(()->Unit)? = null) :BottomSheetDialogFragment() {
    private lateinit var _binding: IxiBottomSheetFragmentBinding
    private var uiState: IxiBottomSheetDialogFragmentUiModel = ixiBottomSheetDialogFragmentUiModel

    /**
     * Overrides [BottomSheetDialogFragment.onCreate] to set the style of the fragment
     * to [com.ixigo.design.sdk.R.style.TransparentBottomSheetDialogTheme].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, com.ixigo.design.sdk.R.style.TransparentBottomSheetDialogTheme)
    }

    /**
     * Overrides [BottomSheetDialogFragment.onCreateView] to create the view and
     * set up the UI.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = IxiBottomSheetFragmentBinding.inflate(inflater)
        setupUi()
        return _binding.root
    }

    /**
     * Sets up the UI using the [uiState] object.
     */
    private fun setupUi(){
        setView()
        _binding.ixiBottomSheet.setImage(uiState.image)
        _binding.ixiBottomSheet.setHeaderText(uiState.titleText)
        _binding.ixiBottomSheet.setImageBackgroundColor(uiState.imageBackgroundColor)
        _binding.ixiBottomSheet.setBodyText(uiState.bodyText)
        _binding.ixiBottomSheet.setToolbarTitle(uiState.toolbarTitle)
        uiState.closeActionAlignment?.let {
            _binding.ixiBottomSheet.setCloseActionAlignment(it)
        }
        uiState.toolbarCloseIcon?.let {
            _binding.ixiBottomSheet.setToolbarCloseIcon(it)
        }
        _binding.ixiBottomSheet.setToolbarSubtitle(uiState.toolbarSubtitle)
        _binding.ixiBottomSheet.setIconSize(uiState.iconSize)
        _binding.ixiBottomSheet.disableDragging(uiState.disableDragging)
        uiState.inlineAlertText?.let {
            _binding.ixiBottomSheet.setInlineAlert(it, uiState.inlineAlertIxiColor)
        }
        uiState.primaryButtonText?.let {
            _binding.ixiBottomSheet.setPrimaryButton(it, uiState.primaryButtonHelperText, uiState.primaryButtonAction?:{})
        }
        uiState.secondaryButtonText?.let {
            _binding.ixiBottomSheet.setSecondaryButton(it, uiState.secondaryButtonHelperText, uiState.secondaryButtonAction?:{})
        }
        _binding.ixiBottomSheet.setButtonMinWidth(uiState.buttonMinWidth)
        _binding.ixiBottomSheet.setButtonMaxWidth(uiState.buttonMaxWidth)
        _binding.ixiBottomSheet.setCloseActionListener{
            this.dismiss()
            onCloseActionListener()
        }
        _binding.ixiBottomSheet.showBottomDivider(uiState.showBottomDivider)
    }

    private fun setView() {
        if (contentLayoutId != 0) {
            val view = LayoutInflater.from(requireContext()).inflate(contentLayoutId, _binding.root, false)
            _binding.ixiBottomSheet.setView(view = view)
            return
        }
        uiState.view?.let {
            _binding.ixiBottomSheet.setView(it)
        }
    }

    /**
     * An abstract method to be implemented by subclasses to handle the close action.
     */
    fun onCloseActionListener(){
        this.onCloseActionListener?.invoke()
    }

    /**
     * Sets the image to be displayed in the Bottom Sheet.
     * @param image A drawable resource identifier for the image.
     */
    fun setImage(@DrawableRes image:Int?){
        uiState = uiState.copy(image = image)
    }

    /**
     * This function sets the title text to be displayed in the bottom sheet dialog fragment.
     *
     * @param headerText The title text to be displayed.
     */
    fun setTitleText(headerText:String?){
        uiState = uiState.copy(titleText = headerText)
    }

    /**
     * This function sets the background color for the image in the bottom sheet dialog fragment.
     *
     * @param imageBackgroundColor A color resource identifier.
     */
    fun setImageBackgroundColor(@ColorRes imageBackgroundColor: Int?){
        uiState = uiState.copy(imageBackgroundColor = imageBackgroundColor)
    }

    /**
     * This function sets the body text to be displayed in the bottom sheet dialog fragment.
     *
     * @param bodyText The body text to be displayed.
     */
    fun setBodyText(bodyText:String?){
        uiState = uiState.copy(bodyText = bodyText)
    }

    /**
     * Sets the subtitle to be displayed in the toolbar of the bottom sheet.
     *
     * @param toolbarSubtitleText The subtitle text to be displayed in the toolbar.
     */
    fun setMasterSubtitle(toolbarSubtitleText:String?){
        uiState = uiState.copy(toolbarSubtitle = toolbarSubtitleText)
    }

    /**
     * This function sets the master title to be displayed in the bottom sheet dialog fragment.
     *
     * @param masterTitle The master title to be displayed.
     */
    fun setMasterTitle(masterTitle:String?){
        uiState = uiState.copy(toolbarTitle = masterTitle)
    }

    /**
     * This function sets the primary button text and its corresponding action in the bottom sheet dialog fragment.
     *
     * @param primaryButtonText The text to be displayed on the primary button.
     * @param action The action to be performed when the primary button is clicked.
     */
    fun setPrimaryButton(primaryButtonText: String, primaryButtonHelperText: String? = null, action:(()->Unit)? = null){
        uiState = uiState.copy(primaryButtonText = primaryButtonText, primaryButtonAction = action, primaryButtonHelperText = primaryButtonHelperText)
    }

    /**
     * This function sets the primary button text and its corresponding action in the bottom sheet dialog fragment.
     *
     * @param secondaryButtonText The text to be displayed on the secondary button.
     * @param action The action to be performed when the secondary button is clicked.
     */
    fun setSecondaryButton(secondaryButtonText: String, secondaryButtonHelperText: String? = null, action:(()->Unit)? = null){
        uiState = uiState.copy(secondaryButtonText = secondaryButtonText, secondaryButtonAction = action, secondaryButtonHelperText = secondaryButtonHelperText)
    }

    fun setButtonMinWidth(minWidth: Dp){
        uiState= uiState.copy(buttonMinWidth = minWidth)
    }

    fun setButtonMaxWidth(maxWidth: Dp){
        uiState= uiState.copy(buttonMaxWidth = maxWidth)
    }

    /**
     * Set the size of the icon.
     *
     * @param size the size of the icon.
     */
    fun setIconSize(size: Float){
        uiState = uiState.copy(iconSize = size)
    }

    /**
     * Set the custom view to be displayed in the bottom sheet.
     * The view ovverrides the default view in BottomSheet
     *
     * @param view the view to be displayed.
     */
    fun setView(view: View){
        uiState = uiState.copy(view = view)
    }

    /**
     * Enable or disable the dragging for the bottom sheet.
     *
     * @param enabled whether the dragging is enabled or disabled.
     */
    fun disableDragging(enabled: Boolean){
        uiState = uiState.copy(disableDragging = enabled)
    }

    /**
     * Set the inline alert to be displayed below the content in the bottom sheet.
     *
     * @param text for the text of inlineAlert.
     * @param ixiColor for the color of inline alert by default it's [IxiColor.Neutral]
     */
    fun setInlineAlert(text: String, ixiColor: IxiColor? =null){
        uiState = uiState.copy(inlineAlertText = text, inlineAlertIxiColor = ixiColor)
    }

    /**
     * Set the close action icon alignment only ALIGN_NORMAL, ALIGN_OPPOSITE & ALIGN_CENTER is supported
     *
     * @param alignment alignment of close action icon
     */
    fun setCloseActionAlignment(alignment: IxiBottomSheetView.ActionIconAlignment){
        uiState = uiState.copy(closeActionAlignment = alignment)
    }

    /**
     * Sets the close icon drawable on Toolbar by default it's a Filled Cross Icon
     *
     * @param icon of close action icon
     */
    fun setToolbarCloseIcon(@DrawableRes icon: Int){
        uiState = uiState.copy(toolbarCloseIcon = icon)
    }

    fun showBottomDivider(show: Boolean) {
        uiState = uiState.copy(showBottomDivider = show)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet: FrameLayout? = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            bottomSheet?.let {
                val behaviour =  BottomSheetBehavior.from(bottomSheet)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
                behaviour.skipCollapsed = true
                if(uiState.disableDragging){
                    behaviour.isDraggable = false
                }
            }
        }
        return dialog
    }

    companion object {
        val TAG: String = IxiBottomSheetDialogFragment::class.java.simpleName
        val TAG2: String? = IxiBottomSheetDialogFragment::class.java.canonicalName
        @JvmStatic
        fun newInstance(onCloseActionListener:(()->Unit)?=null):IxiBottomSheetDialogFragment{
            return IxiBottomSheetDialogFragment(onCloseActionListener = onCloseActionListener)
        }
    }
}

data class IxiBottomSheetDialogFragmentUiModel(
    @DrawableRes val image:Int? = null,
    val titleText:String? = null,
    @ColorRes val imageBackgroundColor: Int? = null,
    val bodyText: String? = null,
    val toolbarTitle: String? = null,
    val toolbarSubtitle: String? = null,
    val primaryButtonText: String? = null,
    val primaryButtonHelperText: String? = null,
    val primaryButtonAction: (()->Unit)? = null,
    val primaryButtonColor:IxiColor? = null,
    val secondaryButtonText: String? = null,
    val secondaryButtonHelperText: String? = null,
    val secondaryButtonAction: (()->Unit)? = null,
    val secondaryButtonColor:IxiColor? = null,
    val buttonMinWidth: Dp = Dp.Unspecified,
    val buttonMaxWidth: Dp = Dp.Infinity,
    val onClose: (() -> Unit)? = null,
    val iconSize:Float? = null,
    val view:View? = null,
    val disableDragging:Boolean = false,
    val inlineAlertText: String? = null,
    val inlineAlertIxiColor: IxiColor? = null,
    val closeActionAlignment: IxiBottomSheetView.ActionIconAlignment? = null,
    val showBottomDivider: Boolean = false,
    @DrawableRes val toolbarCloseIcon: Int? = null,
)