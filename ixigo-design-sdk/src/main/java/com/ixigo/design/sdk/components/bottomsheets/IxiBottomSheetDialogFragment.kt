package com.ixigo.design.sdk.components.bottomsheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.databinding.IxiBottomSheetFragmentBinding


/**
 * An abstract class representing a custom base Bottom Sheet view in Android.
 * This class extends [BottomSheetDialogFragment] and implements UI customization
 * functionality
 *
 * @property uiState A data class [IxiBottomSheetDialogFragmentUiModel] containing all the properties required to build the bottom sheet dialog fragment.
 *
 * @version 1.0
 * @since 2023-01-27
 */
abstract class IxiBottomSheetDialogFragment :BottomSheetDialogFragment() {
    private lateinit var _binding: IxiBottomSheetFragmentBinding
    private var uiState: IxiBottomSheetDialogFragmentUiModel = IxiBottomSheetDialogFragmentUiModel()

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
        _binding.ixiBottomSheet.setImage(uiState.image)
        _binding.ixiBottomSheet.setHeaderText(uiState.titleText)
        _binding.ixiBottomSheet.setImageBackgroundColor(uiState.imageBackgroundColor)
        _binding.ixiBottomSheet.setBodyText(uiState.bodyText)
        _binding.ixiBottomSheet.setToolbarText(uiState.masterTitle)
        _binding.ixiBottomSheet.setIconSize(uiState.iconSize)
        _binding.ixiBottomSheet.enablePointer(uiState.enablePointer)
        uiState.view?.let {
            _binding.ixiBottomSheet.setView(it)
        }
        uiState.primaryButtonText?.let {
            _binding.ixiBottomSheet.setPrimaryButton(it, uiState.primaryButtonAction?:{})
        }
        uiState.secondaryButtonText?.let {
            _binding.ixiBottomSheet.setSecondaryButton(it, uiState.secondaryButtonAction?:{})
        }
        _binding.ixiBottomSheet.setCloseActionListener{
            this.dismiss()
            onCloseActionListener()
        }
    }

    /**
     * An abstract method to be implemented by subclasses to handle the close action.
     */
    abstract fun onCloseActionListener()

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
     * This function sets the master title to be displayed in the bottom sheet dialog fragment.
     *
     * @param masterTitle The master title to be displayed.
     */
    fun setMasterTitle(masterTitle:String?){
        uiState = uiState.copy(masterTitle = masterTitle)
    }

    /**
     * This function sets the primary button text and its corresponding action in the bottom sheet dialog fragment.
     *
     * @param primaryButtonText The text to be displayed on the primary button.
     * @param action The action to be performed when the primary button is clicked.
     */
    fun setPrimaryButton(primaryButtonText: String, action:(()->Unit)? = null){
        uiState = uiState.copy(primaryButtonText = primaryButtonText, primaryButtonAction = action)
    }

    /**
     * This function sets the primary button text and its corresponding action in the bottom sheet dialog fragment.
     *
     * @param secondaryButtonText The text to be displayed on the secondary button.
     * @param action The action to be performed when the secondary button is clicked.
     */
    fun setSecondaryButton(secondaryButtonText: String, action:(()->Unit)? = null){
        uiState = uiState.copy(secondaryButtonText = secondaryButtonText, secondaryButtonAction = action)
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
     * Enable or disable the pointer for the bottom sheet.
     *
     * @param enabled whether the pointer is enabled or disabled.
     */
    fun enablePointer(enabled: Boolean){
        uiState = uiState.copy(enablePointer = enabled)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet: FrameLayout? = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            bottomSheet?.let {
                val behaviour =  BottomSheetBehavior.from(bottomSheet)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
                behaviour.skipCollapsed = true
            }
        }
        return dialog
    }
}

data class IxiBottomSheetDialogFragmentUiModel(
    @DrawableRes val image:Int? = null,
    val titleText:String? = null,
    @ColorRes val imageBackgroundColor: Int? = null,
    val bodyText: String? = null,
    val masterTitle: String? = null,
    val primaryButtonText: String? = null,
    val primaryButtonAction: (()->Unit)? = null,
    val primaryButtonColor:IxiColor? = null,
    val secondaryButtonText: String? = null,
    val secondaryButtonAction: (()->Unit)? = null,
    val secondaryButtonColor:IxiColor? = null,
    val onClose: (() -> Unit)? = null,
    val iconSize:Float? = null,
    val view:View? = null,
    val enablePointer:Boolean = false,
)