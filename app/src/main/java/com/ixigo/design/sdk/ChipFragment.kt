package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.databinding.FragmentChipsBinding


class ChipFragment  : BaseFragment() {

    private var _binding: FragmentChipsBinding? = null
    var lastCheckedId = View.NO_ID

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChipsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMasterGroup()
        setNeutralGroup()
        setDisabledGroup()
        setBlueGroup()
        setGreenGroup()
        setRedGroup()
        setYellowGroup()
        setPurpleGroup()

    }
    private fun setMasterGroup() {
        binding.cgMaster.setOnCheckedStateChangeListener { group, checkedIds ->
            for (i in 0 until group.childCount){
                    val chip = group.getChildAt(i) as BaseChip
                    chip.isChecked = false
            }
            for (id in checkedIds) {
                lastCheckedId = id
                val chip: BaseChip = group.findViewById(id)
                chip.isChecked = true
            }
        }
        binding.masterChip1.setColor(IxiChipColor.YELLOW)
        binding.masterChip1.setOnChipCheckedChangeListener(R.drawable.baseline_remove_circle_24) { buttonView, isChecked -> {} }
        binding.masterChip2.setColor(IxiChipColor.BLUE)
        binding.masterChip2.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
        binding.masterChip3.setColor(IxiChipColor.GREEN)
        binding.masterChip3.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
    }

    private fun setPurpleGroup() {
        binding.pPrimaryChip1.setColor(IxiChipColor.PURPLE)
        binding.pPrimaryChip1.isChecked = true
        binding.pPrimaryChip2.setColor(IxiChipColor.PURPLE)
        binding.pPrimaryChip2.isChecked = false

        binding.pSecondaryChip1.setColor(IxiChipColor.PURPLE)
        binding.pSecondaryChip1.isChecked = true
        binding.pSecondaryChip2.setColor(IxiChipColor.PURPLE)
        binding.pSecondaryChip2.isChecked = false

        binding.pOutlinedChip1.setColor(IxiChipColor.PURPLE)
        binding.pOutlinedChip1.isChecked = true
        binding.pOutlinedChip2.setColor(IxiChipColor.PURPLE)
        binding.pOutlinedChip2.isChecked = false

        binding.pTextChip1.setColor(IxiChipColor.PURPLE)
        binding.pTextChip1.isChecked = true
        binding.pTextChip2.setColor(IxiChipColor.PURPLE)
        binding.pTextChip2.isChecked = false
    }

    private fun setYellowGroup() {
        binding.yPrimaryChip1.setColor(IxiChipColor.YELLOW)
        binding.yPrimaryChip1.isChecked = true
        binding.yPrimaryChip2.setColor(IxiChipColor.YELLOW)
        binding.yPrimaryChip2.isChecked = false

        binding.ySecondaryChip1.setColor(IxiChipColor.YELLOW)
        binding.ySecondaryChip1.isChecked = true
        binding.ySecondaryChip2.setColor(IxiChipColor.YELLOW)
        binding.ySecondaryChip2.isChecked = false

        binding.yOutlinedChip1.setColor(IxiChipColor.YELLOW)
        binding.yOutlinedChip1.isChecked = true
        binding.yOutlinedChip2.setColor(IxiChipColor.YELLOW)
        binding.yOutlinedChip2.isChecked = false

        binding.yTextChip1.setColor(IxiChipColor.YELLOW)
        binding.yTextChip1.isChecked = true
        binding.yTextChip2.setColor(IxiChipColor.YELLOW)
        binding.yTextChip2.isChecked = false
    }

    private fun setRedGroup() {
        binding.rPrimaryChip1.setColor(IxiChipColor.RED)
        binding.rPrimaryChip1.isChecked = true
        binding.rPrimaryChip2.setColor(IxiChipColor.RED)
        binding.rPrimaryChip2.isChecked = false

        binding.rSecondaryChip1.setColor(IxiChipColor.RED)
        binding.rSecondaryChip1.isChecked = true
        binding.rSecondaryChip2.setColor(IxiChipColor.RED)
        binding.rSecondaryChip2.isChecked = false

        binding.rOutlinedChip1.setColor(IxiChipColor.RED)
        binding.rOutlinedChip1.isChecked = true
        binding.rOutlinedChip2.setColor(IxiChipColor.RED)
        binding.rOutlinedChip2.isChecked = false

        binding.rTextChip1.setColor(IxiChipColor.RED)
        binding.rTextChip1.isChecked = true
        binding.rTextChip2.setColor(IxiChipColor.RED)
        binding.rTextChip2.isChecked = false
    }

    private fun setGreenGroup() {
        binding.gPrimaryChip1.setColor(IxiChipColor.GREEN)
        binding.gPrimaryChip1.isChecked = true
        binding.gPrimaryChip2.setColor(IxiChipColor.GREEN)
        binding.gPrimaryChip2.isChecked = false

        binding.gSecondaryChip1.setColor(IxiChipColor.GREEN)
        binding.gSecondaryChip1.isChecked = true
        binding.gSecondaryChip2.setColor(IxiChipColor.GREEN)
        binding.gSecondaryChip2.isChecked = false

        binding.gOutlinedChip1.setColor(IxiChipColor.GREEN)
        binding.gOutlinedChip1.isChecked = true
        binding.gOutlinedChip2.setColor(IxiChipColor.GREEN)
        binding.gOutlinedChip2.isChecked = false

        binding.gTextChip1.setColor(IxiChipColor.GREEN)
        binding.gTextChip1.isChecked = true
        binding.gTextChip2.setColor(IxiChipColor.GREEN)
        binding.gTextChip2.isChecked = false
    }

    private fun setBlueGroup() {
        binding.bPrimaryChip1.setColor(IxiChipColor.BLUE)
        binding.bPrimaryChip1.isChecked = true
        binding.bPrimaryChip2.setColor(IxiChipColor.BLUE)
        binding.bPrimaryChip2.isChecked = false

        binding.bSecondaryChip1.setColor(IxiChipColor.BLUE)
        binding.bSecondaryChip1.isChecked = true
        binding.bSecondaryChip2.setColor(IxiChipColor.BLUE)
        binding.bSecondaryChip2.isChecked = false

        binding.bOutlinedChip1.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip1.isChecked = true
        binding.bOutlinedChip2.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip2.isChecked = false

        binding.bTextChip1.setColor(IxiChipColor.BLUE)
        binding.bTextChip1.isChecked = true
        binding.bTextChip2.setColor(IxiChipColor.BLUE)
        binding.bTextChip2.isChecked = false
    }

    private fun setDisabledGroup() {
        binding.primaryChipDisabled.setColor(IxiChipColor.YELLOW)
        binding.primaryChipDisabled.isEnabled = false
        binding.secondaryChipDisabled.isEnabled = false
        binding.outlinedChipDisabled.isEnabled = false
        binding.textChipDisabled.isEnabled = false
    }

    private fun setNeutralGroup() {
        binding.primaryChip1.isChecked = true
        binding.primaryChip1.setColor(IxiChipColor.NEUTRAL)
        binding.primaryChip1.setOnCloseIconClickListener {
            binding.primaryChip1.isEnabled = false
        }
        binding.primaryChip2.isChecked = false
        binding.primaryChip2.setColor(IxiChipColor.NEUTRAL)
        binding.primaryChip2.setOnClickListener {
            binding.primaryChip1.isEnabled = true
        }

        binding.secondaryChip1.isChecked = true
        binding.secondaryChip1.setColor(IxiChipColor.NEUTRAL)
        binding.secondaryChip1.setOnCloseIconClickListener {
            binding.secondaryChip1.isEnabled = false
        }
        binding.secondaryChip2.isChecked = false
        binding.secondaryChip2.setColor(IxiChipColor.NEUTRAL)
        binding.secondaryChip2.setOnClickListener {
            binding.secondaryChip1.isEnabled = true
        }

        binding.outlinedChip1.isChecked = true
        binding.outlinedChip1.setColor(IxiChipColor.NEUTRAL)
        binding.outlinedChip1.setOnCloseIconClickListener {
            binding.outlinedChip1.isEnabled = false
        }

        binding.outlinedChip2.setColor(IxiChipColor.NEUTRAL)
        binding.outlinedChip2.setOnClickListener {
            binding.outlinedChip1.isEnabled = true
        }
        binding.textChip2.isChecked = false
        binding.textChip1.isChecked = true
        binding.textChip1.setColor(IxiChipColor.NEUTRAL)
        binding.textChip1.setOnCloseIconClickListener {
            binding.textChip1.isEnabled = false
        }
        binding.textChip2.isChecked = false
        binding.textChip2.setColor(IxiChipColor.NEUTRAL)
        binding.textChip2.setOnClickListener {
            binding.textChip1.isEnabled = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}