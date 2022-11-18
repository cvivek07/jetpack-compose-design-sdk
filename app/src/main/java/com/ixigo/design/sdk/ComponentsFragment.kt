package com.ixigo.design.sdk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ixigo.design.sdk.databinding.FragmentComponentsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ComponentsFragment : Fragment() {

    private var _binding: FragmentComponentsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentComponentsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_ComponentFragment_to_ButtonsFragment)
        }
        binding.inputFields.setOnClickListener {
            findNavController().navigate(R.id.action_ComponentFragment_to_inputFieldFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}