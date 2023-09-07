package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState
import com.ixigo.design.sdk.databinding.FragmentBottomSheetBinding

class BottomSheetComposableFragment : IxiBottomSheetDialogFragment() {

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
            content = {
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    val items = (1..50).map { "Item $it" }
                    items(items.size) { item ->
                        Text(text = item.toString(), modifier = Modifier.fillMaxWidth())
                        Divider(color = Color.Gray, thickness = 1.dp)
                    }
                }
            }
        )
        return super.createBottomSheetView(inflater, container, state)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // perform operations
    }

    companion object {
        fun newInstance(): BottomSheetComposableFragment {
            return BottomSheetComposableFragment()
        }
    }

}