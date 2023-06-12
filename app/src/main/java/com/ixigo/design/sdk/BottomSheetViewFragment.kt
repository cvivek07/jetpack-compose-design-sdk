package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState
import com.ixigo.design.sdk.databinding.FragmentBottomSheetBinding

class BottomSheetViewFragment : IxiBottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun createBottomSheetView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: BottomSheetState
    ): View {
        binding = FragmentBottomSheetBinding.inflate(
            inflater,
            container,
            false
        )
        val state = BottomSheetState(
            toolbarText = "Toolbar Title",
            closeActionAlignment = IxiBottomSheetView.ActionIconAlignment.END,
            disableDragging = true,
            primaryButtonText = "Yes",
            primaryActionListener = {
                dismiss()
                "Primary Action".toToast(requireContext())
            },
            secondaryButtonText = "No",
            secondaryActionListener = {
                dismiss()
                "Secondary action".toToast(requireContext())
            },
            onClose = {
                dismiss()
                "Close Action".toToast(requireContext())
            },
            view = binding.root
        )
        return super.createBottomSheetView(inflater, container, state)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // perform operations
    }

    companion object {
        fun newInstance(): BottomSheetViewFragment {
            return BottomSheetViewFragment()
        }
    }

}