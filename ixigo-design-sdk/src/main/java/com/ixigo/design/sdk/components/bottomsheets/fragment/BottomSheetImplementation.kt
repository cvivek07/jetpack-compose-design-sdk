package com.ixigo.design.sdk.components.bottomsheets.fragment

import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment

class BottomSheetImplementation(private val onCloseActionListener:(()->Unit)? = null): IxiBottomSheetDialogFragment() {
    override fun onCloseActionListener() {
        this.onCloseActionListener?.invoke()
    }

    companion object {
        val TAG: String = BottomSheetImplementation::class.java.simpleName
        val TAG2: String? = BottomSheetImplementation::class.java.canonicalName
        @JvmStatic
        fun newInstance(onCloseActionListener:(()->Unit)?=null):IxiBottomSheetDialogFragment{
            return BottomSheetImplementation(onCloseActionListener)
        }
    }
}