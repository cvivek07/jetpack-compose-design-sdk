package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragmentUiModel

class BottomSheet(ixiBottomSheetDialogFragmentUiModel: IxiBottomSheetDialogFragmentUiModel) : IxiBottomSheetDialogFragment(R.layout.fragment_buttons, ixiBottomSheetDialogFragmentUiModel) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Make sure this is called every time", Toast.LENGTH_SHORT).show()
    }

}