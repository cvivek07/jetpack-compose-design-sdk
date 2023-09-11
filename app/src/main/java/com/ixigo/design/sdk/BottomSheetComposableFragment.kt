package com.ixigo.design.sdk

import android.os.Bundle
import android.view.View
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

class BottomSheetComposableFragment : IxiBottomSheetDialogFragment() {

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
    }

    companion object {
        fun newInstance(): BottomSheetComposableFragment {
            return BottomSheetComposableFragment()
        }
    }
}