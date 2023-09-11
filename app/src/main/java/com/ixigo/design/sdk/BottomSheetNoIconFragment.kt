package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState

class BottomSheetNoIconFragment : IxiBottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHeaderText("Main title sentence")
        setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
        setPrimaryButton("No")
        setPrimaryButtonActionListener{
            dismiss()
            "Primary Button".toToast(requireContext())
        }
        setSecondaryButton("Yes, Delete")
        setButtonMinWidth(150.dp)
        setButtonMaxWidth(300.dp)
        setSecondaryButtonActionListener{
            dismiss()
            "Secondary Button".toToast(requireContext())
        }
        setCloseActionListener{
            dismiss()
            "Close Action".toToast(requireContext())
        }
    }

    companion object {
        fun newInstance(): BottomSheetNoIconFragment {
            return BottomSheetNoIconFragment()
        }
    }

}