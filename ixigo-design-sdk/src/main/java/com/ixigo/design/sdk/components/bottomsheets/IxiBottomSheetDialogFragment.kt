package com.ixigo.design.sdk.components.bottomsheets

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Dp
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.databinding.IxiBottomSheetFragmentBinding


/**
 * A class representing a custom base Bottom Sheet view in Android.
 * This class extends [BottomSheetDialogFragment] and implements UI customization
 * functionality
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
            val bottomSheet: FrameLayout? =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            bottomSheet?.let {
                val behaviour = BottomSheetBehavior.from(bottomSheet)
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
        return _binding.root
    }

    fun setImage(@DrawableRes image: Int?) {
        _binding.ixiBottomSheet.setImage(image)
    }

    fun setHeaderText(headerText: String?) {
        _binding.ixiBottomSheet.setHeaderText(headerText)
    }

    fun setImageBackgroundColor(@ColorRes imageBackgroundColor: Int?) {
        _binding.ixiBottomSheet.setImageBackgroundColor(imageBackgroundColor)
    }

    fun setBodyText(bodyText: String?) {
        _binding.ixiBottomSheet.setBodyText(bodyText)
    }

    fun setToolbarTitle(toolbarText: String?) {
        _binding.ixiBottomSheet.setToolbarTitle(toolbarText)
    }

    fun setToolbarSubtitle(toolbarSubtitleText: String?) {
        _binding.ixiBottomSheet.setToolbarSubtitle(toolbarSubtitleText)
    }

    fun setPrimaryButton(ixiPrimaryButtonText: String, primaryButtonHelperText: String? = null) {
        _binding.ixiBottomSheet.setPrimaryButton(ixiPrimaryButtonText, primaryButtonHelperText)
    }

    fun setPrimaryButtonActionListener(primaryActionListener: (() -> Unit)?) {
        _binding.ixiBottomSheet.setPrimaryButtonActionListener(primaryActionListener)
    }

    fun setSecondaryButton(
        ixiSecondaryButtonText: String,
        secondaryButtonHelperText: String? = null
    ) {
        _binding.ixiBottomSheet.setSecondaryButton(
            ixiSecondaryButtonText,
            secondaryButtonHelperText
        )
    }

    fun setSecondaryButtonActionListener(secondaryActionListener: (() -> Unit)?) {
        _binding.ixiBottomSheet.setSecondaryButtonActionListener(secondaryActionListener)
    }

    fun setButtonMinWidth(minWidth: Dp) {
        _binding.ixiBottomSheet.setButtonMinWidth(minWidth)
    }

    fun setButtonMaxWidth(maxWidth: Dp) {
        _binding.ixiBottomSheet.setButtonMaxWidth(maxWidth)
    }

    fun setCloseActionListener(closeActionListener: (() -> Unit)?) {
        _binding.ixiBottomSheet.setCloseActionListener(closeActionListener)
    }

    fun setIconSize(size: Float?) {
        _binding.ixiBottomSheet.setIconSize(size)
    }

    fun disableDragging(enabled: Boolean) {
        _binding.ixiBottomSheet.disableDragging(enabled)
    }

    fun setView(view: View) {
        _binding.ixiBottomSheet.setView(view)
    }

    fun setContent(content: (@Composable () -> Unit)?) {
        _binding.ixiBottomSheet.setContent(content)
    }

    fun setInlineAlert(text: String, ixiColor: IxiColor? = null) {
        _binding.ixiBottomSheet.setInlineAlert(text, ixiColor)
    }

    fun setCloseActionAlignment(alignment: IxiBottomSheetView.ActionIconAlignment) {
        _binding.ixiBottomSheet.setCloseActionAlignment(alignment)
    }

    fun setToolbarCloseIcon(@DrawableRes icon: Int) {
        _binding.ixiBottomSheet.setToolbarCloseIcon(icon)
    }

    fun showBottomDivider(show: Boolean) {
        _binding.ixiBottomSheet.showBottomDivider(show)
    }

    fun showFullWidthButtons(enable: Boolean) {
        _binding.ixiBottomSheet.showFullWidthButtons(enable)
    }
}