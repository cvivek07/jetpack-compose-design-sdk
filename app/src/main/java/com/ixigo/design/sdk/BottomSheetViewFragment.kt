package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.databinding.FragmentBlankBottomSheetBinding

class BottomSheetViewFragment : IxiBottomSheetDialogFragment() {

    private lateinit var binding: FragmentBlankBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBottomSheetBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle("Toolbar Title")
        setCloseActionAlignment(IxiBottomSheetView.ActionIconAlignment.START)
        disableDragging(true)
        setPrimaryButton("Yes", "helper text")
        setPrimaryButtonActionListener { dismiss() }
        setSecondaryButton("No", "helper")
        setSecondaryButtonActionListener {
            dismiss()
        }
        setCloseActionListener {
            dismiss()
        }
        setContent {
            AndroidView(factory = {binding.root},
                modifier = Modifier.fillMaxWidth())
        }
    }

    companion object {
        fun newInstance(): BottomSheetViewFragment {
            return BottomSheetViewFragment()
        }
    }

}