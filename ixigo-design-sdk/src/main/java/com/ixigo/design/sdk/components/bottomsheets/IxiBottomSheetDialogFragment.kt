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
import com.ixigo.design.sdk.components.buttons.IxiPrimaryButton
import com.ixigo.design.sdk.components.buttons.IxiSecondaryButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.databinding.IxiBottomSheetFragmentBinding


abstract class IxiBottomSheetDialogFragment :BottomSheetDialogFragment() {
    private lateinit var _binding: IxiBottomSheetFragmentBinding
    private var uiState: IxiBottomSheetDialogFragmentUiMode = IxiBottomSheetDialogFragmentUiMode()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, com.ixigo.design.sdk.R.style.TransparentBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = IxiBottomSheetFragmentBinding.inflate(inflater)
        setupUi()
        return _binding.root
    }


    private fun setupUi(){
        _binding.ixiBottomSheet.setImage(uiState.image)
        _binding.ixiBottomSheet.setHeaderText(uiState.titleText)
        _binding.ixiBottomSheet.setImageBackgroundColor(uiState.imageBackgroundColor)
        _binding.ixiBottomSheet.setBodyText(uiState.bodyText)
        _binding.ixiBottomSheet.setToolbarText(uiState.masterTitle)
        _binding.ixiBottomSheet.setIsToolbarCentered(uiState.isToolbarCentered?:false)
        _binding.ixiBottomSheet.setIconSize(uiState.iconSize)
        uiState.primaryButtonText?.let {
            val primaryButton = IxiPrimaryButton(context = requireContext())
            primaryButton.setText(it)
            primaryButton.setStyle(ButtonShape.RegularShape, uiState.primaryButtonColor?:IxiColor.Orange, ButtonSize.Large)
            primaryButton.setClickListener {
                uiState.primaryButtonAction?.invoke()
            }
            _binding.ixiBottomSheet.setPrimaryButton(primaryButton)
        }
        uiState.secondaryButtonText?.let {
            val secondaryButton = IxiSecondaryButton(context = requireContext())
            secondaryButton.setText(it)
            secondaryButton.setStyle(ButtonShape.RegularShape, uiState.secondaryButtonColor?:IxiColor.Orange, ButtonSize.Large)
            secondaryButton.setClickListener {
                uiState.secondaryButtonAction?.invoke()
            }
            _binding.ixiBottomSheet.setSecondaryButton(secondaryButton)
        }
        _binding.ixiBottomSheet.setCloseActionListener{
            this.dismiss()
            onCloseActionListener()
        }
    }
    abstract fun onCloseActionListener()

    fun setImage(@DrawableRes image:Int?){
        uiState = uiState.copy(image = image)
    }

    fun setTitleText(headerText:String?){
        uiState = uiState.copy(titleText = headerText)
    }

    fun setImageBackgroundColor(@ColorRes imageBackgroundColor: Int?){
        uiState = uiState.copy(imageBackgroundColor = imageBackgroundColor)
    }

    fun setBodyText(bodyText:String?){
        uiState = uiState.copy(bodyText = bodyText)
    }

    fun setMasterTitle(masterTitle:String?){
        uiState = uiState.copy(masterTitle = masterTitle)
    }

    fun setPrimaryButton(primaryButtonText: String, ixiColor: IxiColor? = null, action:(()->Unit)? = null){
        uiState = uiState.copy(primaryButtonText = primaryButtonText, primaryButtonAction = action, primaryButtonColor = ixiColor)
    }

    fun setSecondaryButton(secondaryButtonText: String, ixiColor: IxiColor?=null, action:(()->Unit)? = null){
        uiState = uiState.copy(secondaryButtonText = secondaryButtonText, secondaryButtonAction = action, secondaryButtonColor = ixiColor)
    }

    fun setIsToolbarCentered(boolean: Boolean){
        uiState = uiState.copy(isToolbarCentered = boolean)
    }

    fun setIconSize(size: Float){
        uiState = uiState.copy(iconSize = size)
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

data class IxiBottomSheetDialogFragmentUiMode(
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
    val isToolbarCentered: Boolean? = false,
    val iconSize:Float? = null
)