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


class IxiBottomSheetDialogFragment:BottomSheetDialogFragment() {
    private lateinit var _binding: IxiBottomSheetFragmentBinding

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
        (arguments?.getSerializable(STATE) as? BottomSheetState)?.let {
            _binding.ixiBottomSheet.setImage(it.image)
            _binding.ixiBottomSheet.setHeaderText(it.headerText)
            _binding.ixiBottomSheet.setImageBackgroundColor(it.imageBackgroundColor)
            _binding.ixiBottomSheet.setBodyText(it.bodyText)
            _binding.ixiBottomSheet.setPrimaryButton(it.primaryButton)
            _binding.ixiBottomSheet.setSecondaryButton(it.secondaryButton)
            _binding.ixiBottomSheet.setCloseActionListener{
                this.dismiss()
                it.onClose?.invoke()
            }
            _binding.ixiBottomSheet.setToolbarText(it.toolbarText)
        }
        return _binding.root
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

    companion object {
        val TAG: String = IxiBottomSheetDialogFragment::class.java.simpleName
        val TAG2: String? = IxiBottomSheetDialogFragment::class.java.canonicalName
        const val STATE = "STATE"
        @JvmStatic
        fun newInstance(bottomSheetState: BottomSheetState):IxiBottomSheetDialogFragment{
            val bundle = Bundle()
            bundle.putSerializable(STATE, bottomSheetState)
            val fragment = IxiBottomSheetDialogFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}