package com.ixigo.design.sdk.fragments

import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment

class BottomSheetImplementation: IxiBottomSheetDialogFragment() {
    override fun onCloseActionListener() {
    }

    companion object {
        val TAG: String = BottomSheetImplementation::class.java.simpleName
        val TAG2: String? = BottomSheetImplementation::class.java.canonicalName
        @JvmStatic
        fun newInstance():IxiBottomSheetDialogFragment{
            return BottomSheetImplementation()
        }
    }
}