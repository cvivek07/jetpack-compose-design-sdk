package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState

class BottomSheetImageFragment : IxiBottomSheetDialogFragment() {

    override fun createBottomSheetView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        state: BottomSheetState
    ): View {
        val state = BottomSheetState(
            headerText = "Main title sentence",
            bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
            imageBackgroundColor = R.color.r50,
            iconSize = 127f,
            image = R.drawable.sample_image,
            primaryButtonText = "Button",
            primaryActionListener = {
                dismiss()
                "Primary Button".toToast(requireContext())
            },
            secondaryButtonText = "Button",
            secondaryActionListener = {
                dismiss()
                "Secondary Button".toToast(requireContext())
            },
            inlineAlertText = "This is a placeholder",
            secondaryButtonHelperText = "Hello",
            primaryButtonHelperText = "Hey!"
        )
        return super.createBottomSheetView(inflater, container, state)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // perform operations
    }

    companion object {
        fun newInstance(): BottomSheetImageFragment {
            return BottomSheetImageFragment()
        }
    }

}