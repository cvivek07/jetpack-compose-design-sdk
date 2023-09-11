package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState

class BottomSheetFeatureIconFragment : IxiBottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHeaderText("Main title sentence")
        setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
        setImage(R.drawable.sample_logo)
        setPrimaryButton("Button")
        setPrimaryButtonActionListener {
            dismiss()
            "Primary Button".toToast(requireContext())
        }
        setSecondaryButton("Button")
        setSecondaryButtonActionListener {
            dismiss()
            "Secondary Button".toToast(requireContext())
        }
    }

    companion object {
        fun newInstance(): BottomSheetFeatureIconFragment {
            return BottomSheetFeatureIconFragment()
        }
    }

}