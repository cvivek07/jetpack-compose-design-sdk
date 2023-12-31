package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentStickyAlertBinding

class StickyAlertFragment:Fragment() {
    private var _binding: FragmentStickyAlertBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStickyAlertBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.let {
            binding.neutralAlert.setRightButtonClickListener {
                "Right Button".toToast(it)
            }
            binding.neutralAlert.setLeftButtonClickListener {
                "Left Button".toToast(it)
            }
        }
    }
}