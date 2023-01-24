package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.progress_step.base.ProgressStepData

import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.databinding.FragmentProgressStepBinding

class ProgressStepFragment : Fragment() {

    private var _binding: FragmentProgressStepBinding? = null

    private val data = listOf(
        ProgressStepData(
            "Label 1",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 2",
            "A lot of sub text with some "
        ),

        ProgressStepData(
            "Label 3",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us jucy content and some cowboy shit with some of the other snacks today for all of us jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 4",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),
        ProgressStepData(
            "Label 5",
            "A lot of sub text with some jucy content and some cowboy shit with some of the other snacks today for all of us"
        ),

        ProgressStepData(
            "Label 6",
            "A lot of sub text with some jucy "
        ),
    )

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProgressStepBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.h1.setText("Vertical Progress Steps Using Icons")
        binding.h2.setText("Vertical Progress Steps Using Numbers")
        binding.h3.setText("Horizontal Progress Steps Using Icons")
        binding.h4.setText("Horizontal Progress Steps Using Numbers")
        binding.h5.setText("Horizontal Inline Progress Steps Using Dark Mode")
        binding.h6.setText("Horizontal Progress Steps Using Light Mode")

        binding.h1.setTypography(IxiTypography.Body.Large.bold)
        binding.h2.setTypography(IxiTypography.Body.Large.bold)
        binding.h3.setTypography(IxiTypography.Body.Large.bold)
        binding.h4.setTypography(IxiTypography.Body.Large.bold)
        binding.h5.setTypography(IxiTypography.Body.Large.bold)
        binding.h6.setTypography(IxiTypography.Body.Large.bold)

        binding.vProgressStep.apply {
            addSteps(data)
            selectionIndicator = SelectionIndicator.ICON

        }
        binding.next.setClickListener {
            binding.vProgressStep.selectNext()
        }
        binding.nextError.setClickListener {
            binding.vProgressStep.selectNext(ProgressState.Error)
        }


        binding.vProgressStep2.apply {
            addSteps(data)
//            progressState = ProgressState.Error
            selectionIndicator = SelectionIndicator.NUMBER

        }
        binding.next2.setClickListener { binding.vProgressStep2.selectNext() }
        binding.next2Error.setClickListener { binding.vProgressStep2.selectNext(ProgressState.Delay) }



        binding.hProgressStep.apply {
            addSteps(data)
            selectionIndicator = SelectionIndicator.ICON

        }
        binding.nextH.setClickListener {
            binding.hProgressStep.selectNext()
        }
        binding.nextHError.setClickListener {
            binding.hProgressStep.selectNext(ProgressState.Error)
        }

        binding.hProgressStepNumber.apply {
            addSteps(data)
            selectionIndicator = SelectionIndicator.NUMBER

        }
        binding.nextHNumber.setClickListener {
            binding.hProgressStepNumber.selectNext()
        }
        binding.nextHErrorNumber.setClickListener {
            binding.hProgressStepNumber.selectNext(ProgressState.Delay)
        }





        binding.hProgressInlineStep.apply {
            addSteps(data)
            selectionIndicator = SelectionIndicator.NUMBER
            mode = ProgressStepMode.Dark

        }
        binding.nextInlineLight.setClickListener {
            binding.hProgressInlineStep.selectNext()
        }


        binding.hProgressInlineStepDark.apply {
            addSteps(data)
            selectionIndicator = SelectionIndicator.CHECK
            mode = ProgressStepMode.Light

        }
        binding.nextInlineDark.setClickListener {
            binding.hProgressInlineStepDark.selectNext()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}