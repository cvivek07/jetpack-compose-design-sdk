package com.ixigo.design.sdk

import android.os.Bundle
import android.view.View
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment

class BottomSheetImageFragment : IxiBottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHeaderText("Main title sentence")
        setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
        setImageBackgroundColor(R.color.r50)
        setIconSize(127f)
        setImage(R.drawable.sample_image)
        setPrimaryButton("Button", "Hey!")
        setPrimaryButtonActionListener {
            dismiss()
            "Primary Button".toToast(requireContext())
        }
        setSecondaryButton("Button", "Hello")
        setSecondaryButtonActionListener{
            dismiss()
            "Secondary Button".toToast(requireContext())
        }
        setInlineAlert("This is a placeholder")
    }

    companion object {
        fun newInstance(): BottomSheetImageFragment {
            return BottomSheetImageFragment()
        }
    }

}