package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentButtonsBinding
import com.ixigo.design_sdk.components.buttons.shapes.ButtonStyles

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
        binding.buttonFirst.setText("Button 1")
        binding.buttonFirst.setClickListener{
                context?.let { it1 -> "Button1 Clicked Change".toToast(it1) }
        }

        binding.buttonSecond.setText("Button 2")
        binding.buttonSecond.setStyle(ButtonStyles.o700NormalLeadingShapeRadius)
        binding.buttonSecond.setClickListener{
            context?.let { it1 -> "Button2 Clicked Change".toToast(it1) }
        }

        binding.buttonThird.setText("Button 3")
        binding.buttonThird.setStyle(ButtonStyles.b700NormalLeadingShapeRadius)
        binding.buttonThird.setClickListener{
            context?.let { it1 -> "Button3 Clicked Change".toToast(it1) }
            binding.buttonFourth.isEnabled =  !binding.buttonFourth.isEnabled
        }

        binding.buttonFourth.setClickListener{
            context?.let { it1 -> "Button4 Clicked Change".toToast(it1) }
        }

        binding.buttonFifth.setClickListener{
            context?.let { it1 -> "Button5 Clicked Change".toToast(it1) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}