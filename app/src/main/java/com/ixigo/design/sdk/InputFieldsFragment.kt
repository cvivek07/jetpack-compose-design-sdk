package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentInputFieldsBinding

class InputFieldsFragment : Fragment() {

    private var _binding: FragmentInputFieldsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInputFieldsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.inputField1?.apply {
            setLabel("Label")
            setActionText("Add-On")
            setHelperText("This is helper Text")
            setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
            setStartImageDrawable(R.drawable.ic_call_24)
            setDrawableTint(R.color.b700)
            setMaxCharCount(10)
            setText("ViVel")
            setActionTextClickListener { "Action Text Click".toToast(this.context) }
            setDrawableStartClickListener { "DrawableStart Click".toToast(this.context) }
            setDrawableEndClickListener { "DrawableEnd Click".toToast(this.context) }
        }

    }
}