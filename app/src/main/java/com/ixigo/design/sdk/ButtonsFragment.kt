package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.databinding.FragmentButtonsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ButtonsFragment : BaseFragment() {

    private var _binding: FragmentButtonsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setShape(IxiShape.RegularShape)
        binding.buttonFirst.setSize( ButtonSize.Large)
        binding.buttonFirst.setOnClickListener{
            context?.let { it1 -> "Button1 Clicked Change".toToast(it1) }
        }

        binding.buttonSecond.setText("XLarge Blue Bottom ")
        binding.buttonSecond.setShape(IxiShape.BottomShape)
        binding.buttonSecond.setSize( ButtonSize.XLarge)
        binding.buttonSecond.setClickListener {
            context?.let { it1 -> "Button2 Clicked Change".toToast(it1) }
        }

        binding.buttonThird.setText("Leading Primary ")
        binding.buttonThird.setShape(IxiShape.LeadingShape)
        binding.buttonThird.setSize( ButtonSize.XLarge)
        binding.buttonThird.setClickListener {
            context?.let { it1 -> "Button3 Clicked Change".toToast(it1) }
            binding.buttonFourth.isEnabled = !binding.buttonFourth.isEnabled
        }

        binding.buttonFourth.setShape(IxiShape.TrailingShape)
        binding.buttonFourth.setSize( ButtonSize.XLarge)
        binding.buttonFourth.setText("Trailing Xlarge Success")
        binding.buttonFourth.setClickListener {
            context?.let { it1 -> "Trailing Xlarge Success".toToast(it1) }
        }

        binding.buttonFifth.setShape(IxiShape.TrailingShape)
        binding.buttonFifth.setSize( ButtonSize.Small)
        binding.buttonFifth.setStartImageDrawable(R.drawable.ic_call_24)
        binding.buttonFifth.setEndImageDrawable(R.drawable.ic_call_24)
        binding.buttonFifth.setText("Leading Small")
        binding.buttonFifth.setClickListener {
            context?.let { it1 -> "Button5 Clicked Change".toToast(it1) }
        }

        binding.buttonSixth.setShape(IxiShape.RegularShape)
        binding.buttonSixth.setSize( ButtonSize.Medium)
        binding.buttonSixth.setText("Outlined Medium")
        binding.buttonSixth.setClickListener {
            context?.let { it1 -> "Button6 Clicked Change".toToast(it1) }
        }

        var isButtonSelected = false
        binding.buttonAddRemove.setSize(ButtonSize.Medium)
        binding.buttonAddRemove.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonAddRemove.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonAddRemove.setClickListener {
            val buttonText = if (isButtonSelected) "Add" else "Remove"
            binding.buttonAddRemove.setText(buttonText)
            isButtonSelected = !isButtonSelected
        }

        binding.buttonSeven.isEnabled = false
        binding.buttonSeven.setText("Outlined Small Disabled")
        binding.buttonSeven.setShape(IxiShape.RegularShape)
        binding.buttonSeven.setSize( ButtonSize.Small)
        binding.buttonFifth.setClickListener {
            context?.let { it1 -> "Button5 Clicked Change".toToast(it1) }
            binding.buttonSeven.isEnabled = !binding.buttonSeven.isEnabled
        }

        binding.buttonEight.setText("Outlined Bottom Small Error")
        binding.buttonTen.setText("Secondary Button")

        binding.buttonEleven.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonEleven.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)

        binding.buttonEleven.setSize( ButtonSize.Large)

        binding.buttonEleven.setClickListener {
            context?.let { it1 -> "Button11 Clicked Change".toToast(it1) }
            binding.buttonTen.isEnabled = !binding.buttonTen.isEnabled
        }

        binding.buttonFifteen.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonFifteen.setSize( ButtonSize.Medium)
        binding.buttonFifteen.setClickListener {
            context?.let { it1 -> "Button15 Clicked Change".toToast(it1) }
            binding.buttonThirteen.isEnabled = !binding.buttonThirteen.isEnabled
        }


        binding.buttonSixteen.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonSixteen.setSize( ButtonSize.Medium)
        binding.buttonSixteen.setClickListener {
            context?.let { it1 -> "Button16 Clicked Change".toToast(it1) }
            binding.buttonFifteen.isEnabled = !binding.buttonFifteen.isEnabled
        }

        binding.buttonTwelve.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonTwelve.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonTwelve.setShape(IxiShape.BottomShape)
        binding.buttonTwelve.setSize( ButtonSize.Large)
        binding.buttonTwelve.setClickListener {
            context?.let { it1 -> "Button12 Clicked Change".toToast(it1) }
        }

        binding.buttonThirteen.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonFourth.setShape(IxiShape.LeadingShape)
        binding.buttonFourth.setSize( ButtonSize.Medium)
        binding.buttonThirteen.setClickListener {
            context?.let { it1 -> "Button13 Clicked Change".toToast(it1) }
        }

        binding.buttonFourteen.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonFourteen.setShape(IxiShape.TrailingShape)
        binding.buttonFourteen.setSize( ButtonSize.Small)
        binding.buttonFourteen.setClickListener {
            context?.let { it1 -> "Button14 Clicked Change".toToast(it1) }
        }

        binding.buttonEight.setShape(IxiShape.BottomShape)
        binding.buttonEight.setSize( ButtonSize.Large)
        binding.buttonTen.setClickListener {
            context?.let { it1 -> "Button10 Clicked Change".toToast(it1) }
        }
        binding.radioButton.setScale(0.5f)
        binding.radioButton.setToggleChangeListener {
            Toast.makeText(requireContext(), if(it) "Checked" else "Un-Checked", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}