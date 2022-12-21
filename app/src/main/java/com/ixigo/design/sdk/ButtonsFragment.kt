package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentButtonsBinding
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize

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
        binding.buttonFirst.setText("Primary Button ")
        binding.buttonFirst.setStartImageDrawable(R.drawable.ic_call_24)
        binding.buttonFirst.setEndImageDrawable(R.drawable.ic_call_24)
        binding.buttonFirst.setStyle(ButtonShape.RegularShape, IxiColor.Orange, ButtonSize.Large)
        binding.buttonFirst.setClickListener {
            context?.let { it1 -> "Button1 Clicked Change".toToast(it1) }
        }

        binding.buttonSecond.setText("XLarge Blue Bottom ")
        binding.buttonSecond.setStyle(ButtonShape.BottomShape, IxiColor.Blue, ButtonSize.XLarge)
        binding.buttonSecond.setClickListener {
            context?.let { it1 -> "Button2 Clicked Change".toToast(it1) }
        }

        binding.buttonThird.setText("Leading Primary ")
        binding.buttonThird.setStyle(ButtonShape.LeadingShape, IxiColor.Error, ButtonSize.XXLarge)
        binding.buttonThird.setClickListener {
            context?.let { it1 -> "Button3 Clicked Change".toToast(it1) }
            binding.buttonFourth.isEnabled = !binding.buttonFourth.isEnabled
        }

        binding.buttonFourth.setStyle(ButtonShape.TrailingShape, IxiColor.Success, ButtonSize.XLarge)
        binding.buttonFourth.setText("Trailing Xlarge Success")
        binding.buttonFourth.setClickListener {
            context?.let { it1 -> "Trailing Xlarge Success".toToast(it1) }
        }

        binding.buttonFifth.setStyle(ButtonShape.TrailingShape, IxiColor.Warning, ButtonSize.Small)
        binding.buttonFifth.setStartImageDrawable(R.drawable.ic_call_24)
        binding.buttonFifth.setEndImageDrawable(R.drawable.ic_call_24)
        binding.buttonFifth.setText("Leading Small")
        binding.buttonFifth.setClickListener {
            context?.let { it1 -> "Button5 Clicked Change".toToast(it1) }
        }

        binding.buttonSixth.setStyle(ButtonShape.RegularShape, IxiColor.Extension, ButtonSize.Medium)
        binding.buttonSixth.setText("Outlined Medium")
        binding.buttonSixth.setClickListener {
            context?.let { it1 -> "Button6 Clicked Change".toToast(it1) }
        }

        binding.buttonSeven.isEnabled = false
        binding.buttonSeven.setText("Outlined Small Disabled")
        binding.buttonSeven.setStyle(ButtonShape.RegularShape, IxiColor.Extension, ButtonSize.Small)
        binding.buttonFifth.setClickListener {
            context?.let { it1 -> "Button5 Clicked Change".toToast(it1) }
            binding.buttonSeven.isEnabled = !binding.buttonSeven.isEnabled
        }

        binding.buttonEight.setText("Outlined Bottom Small Error")
        binding.buttonTen.setText("Secondary Button")

        binding.buttonEleven.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonEleven.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonEleven.setStyle(IxiColor.Extension, ButtonSize.Large)
        binding.buttonEleven.setClickListener {
            context?.let { it1 -> "Button11 Clicked Change".toToast(it1) }
            binding.buttonTen.isEnabled = !binding.buttonTen.isEnabled
        }

        binding.buttonFifteen.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonFifteen.setStyle(IxiColor.Success, ButtonSize.Medium)
        binding.buttonFifteen.setClickListener {
            context?.let { it1 -> "Button15 Clicked Change".toToast(it1) }
            binding.buttonThirteen.isEnabled = !binding.buttonThirteen.isEnabled
        }


        binding.buttonSixteen.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonSixteen.setStyle(IxiColor.Warning, ButtonSize.XXLarge)
        binding.buttonSixteen.setClickListener {
            context?.let { it1 -> "Button16 Clicked Change".toToast(it1) }
            binding.buttonFifteen.isEnabled = !binding.buttonFifteen.isEnabled
        }

        binding.buttonTwelve.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonTwelve.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonTwelve.setStyle(ButtonShape.BottomShape, IxiColor.Error, ButtonSize.Large)
        binding.buttonTwelve.setClickListener {
            context?.let { it1 -> "Button12 Clicked Change".toToast(it1) }
        }

        binding.buttonThirteen.setEndImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonThirteen.setStyle(ButtonShape.LeadingShape, IxiColor.Success, ButtonSize.Medium)
        binding.buttonThirteen.setClickListener {
            context?.let { it1 -> "Button13 Clicked Change".toToast(it1) }
        }

        binding.buttonFourteen.setStartImageDrawable(R.drawable.ic_baseline_cancel_24)
        binding.buttonFourteen.setStyle(ButtonShape.TrailingShape, IxiColor.Warning, ButtonSize.Small)
        binding.buttonFourteen.setClickListener {
            context?.let { it1 -> "Button14 Clicked Change".toToast(it1) }
        }

        binding.buttonEight.setStyle(ButtonShape.BottomShape, IxiColor.Error, ButtonSize.Large)
        binding.buttonTen.setClickListener {
            context?.let { it1 -> "Button10 Clicked Change".toToast(it1) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}