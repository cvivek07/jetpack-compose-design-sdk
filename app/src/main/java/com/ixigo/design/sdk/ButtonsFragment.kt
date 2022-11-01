package com.ixigo.design.sdk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ixigo.design.sdk.databinding.FragmentButtonsBinding
import com.ixigo.design_sdk.buttons.IxiButton
import com.ixigo.design_sdk.buttons.IxiState

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ButtonsFragment : Fragment() {

    private var _binding: FragmentButtonsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonFirst.setText("Button 2")
        binding.buttonFirst.setClickListener{
                context?.let { it1 -> "Button Clicked Change".toToast(it1) }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}