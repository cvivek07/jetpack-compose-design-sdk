package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentProgressStepBinding
import com.ixigo.design_sdk.components.progress_step.base.*

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