package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState

class BottomSheetNoIconFragment : IxiBottomSheetDialogFragment() {

    override fun createBottomSheetView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: BottomSheetState
    ): View {
        val state = BottomSheetState(
            headerText = "Main title sentence",
            bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
            primaryButtonText = "No",
            primaryActionListener = {
                dismiss()
                "Primary Button".toToast(requireContext())
            },
            secondaryButtonText = "Yes, Delete",
            buttonMinWidth = 150.dp,
            buttonMaxWidth = 300.dp,
            secondaryActionListener = {
                dismiss()
                "Secondary Button".toToast(requireContext())
            },
            onClose = {
                dismiss()
                "Close Action".toToast(requireContext())
            }
        )
        return super.createBottomSheetView(inflater, container, state)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // perform operations
    }

    companion object {
        fun newInstance(): BottomSheetNoIconFragment {
            return BottomSheetNoIconFragment()
        }
    }

}