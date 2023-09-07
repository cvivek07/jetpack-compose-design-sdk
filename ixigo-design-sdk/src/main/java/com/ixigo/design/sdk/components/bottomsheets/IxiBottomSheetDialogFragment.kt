package com.ixigo.design.sdk.components.bottomsheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState
import com.ixigo.design.sdk.databinding.IxiBottomSheetFragmentBinding


/**
 * A class representing a custom base Bottom Sheet view in Android.
 * This class extends [BottomSheetDialogFragment] and implements UI customization
 * functionality
 *
 * @property state A data class [BottomSheetState] containing all the properties required to build the bottom sheet dialog fragment.
 *
 * @version 1.0
 * @since 2023-01-27
 */
open class IxiBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var _binding: IxiBottomSheetFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, com.ixigo.design.sdk.R.style.TransparentBottomSheetDialogTheme)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet: FrameLayout? = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            bottomSheet?.let {
                val behaviour =  BottomSheetBehavior.from(bottomSheet)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
                behaviour.skipCollapsed = true
                behaviour.isDraggable = false
            }
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = IxiBottomSheetFragmentBinding.inflate(inflater)
        return createBottomSheetView(inflater, container, BottomSheetState())
    }

    open fun createBottomSheetView(inflater: LayoutInflater, container: ViewGroup?, state: BottomSheetState) : View {
        state.view?.let { _binding.ixiBottomSheet.setView(view = it) }
        state.content?.let { _binding.ixiBottomSheet.setContent(content = it) }
        _binding.ixiBottomSheet.setImage(state.image)
        _binding.ixiBottomSheet.setHeaderText(state.headerText)
        _binding.ixiBottomSheet.setImageBackgroundColor(state.imageBackgroundColor)
        _binding.ixiBottomSheet.setBodyText(state.bodyText)
        _binding.ixiBottomSheet.setToolbarTitle(state.toolbarText)
        state.closeActionAlignment.let {
            _binding.ixiBottomSheet.setCloseActionAlignment(it)
        }
        state.toolbarCloseIcon?.let {
            _binding.ixiBottomSheet.setToolbarCloseIcon(it)
        }
        _binding.ixiBottomSheet.setToolbarSubtitle(state.toolbarSubtitleText)
        _binding.ixiBottomSheet.setIconSize(state.iconSize)
        _binding.ixiBottomSheet.disableDragging(state.disableDragging)
        state.inlineAlertText?.let {
            _binding.ixiBottomSheet.setInlineAlert(it, state.inlineAlertIxiColor)
        }
        state.primaryButtonText?.let {
            _binding.ixiBottomSheet.setPrimaryButton(it, state.primaryButtonHelperText)
        }
        _binding.ixiBottomSheet.setPrimaryButtonActionListener {
            state.primaryActionListener?.invoke()
        }
        state.secondaryButtonText?.let {
            _binding.ixiBottomSheet.setSecondaryButton(it, state.secondaryButtonHelperText)
        }
        _binding.ixiBottomSheet.setSecondaryButtonActionListener {
            state.secondaryActionListener?.invoke()
        }
        _binding.ixiBottomSheet.setButtonMinWidth(state.buttonMinWidth)
        _binding.ixiBottomSheet.setButtonMaxWidth(state.buttonMaxWidth)
        _binding.ixiBottomSheet.setCloseActionListener{
            state.onClose?.invoke()
        }
        _binding.ixiBottomSheet.showBottomDivider(state.showBottomDivider)
        _binding.ixiBottomSheet.showFullWidthButtons(state.showFullWidthButtons)
        return _binding.ixiBottomSheet
    }
}