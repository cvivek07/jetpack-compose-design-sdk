package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColorState
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
//            group.clearCheck()
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
        binding.masterChip1.setIxiChipColorState(IxiChipColorState.Primary.YELLOW)
        binding.masterChip1.setOnCheckedChangeListener(R.drawable.baseline_remove_circle_24){}
        binding.masterChip2.setIxiChipColorState(IxiChipColorState.Secondary.BLUE)
        binding.masterChip2.setOnCheckedChangeListener {}
        binding.masterChip3.setIxiChipColorState(IxiChipColorState.Outlined.GREEN)
        binding.masterChip3.setOnCheckedChangeListener {
        }
    }

    private fun setPurpleGroup() {
        binding.pPrimaryChip1.setIxiChipColor(IxiChipColorState.Primary.PURPLE.unselected)
        binding.pPrimaryChip2.setIxiChipColor(IxiChipColorState.Primary.PURPLE.selected)

        binding.pSecondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.PURPLE.unselected)
        binding.pSecondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.PURPLE.selected)

        binding.pOutlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.PURPLE.unselected)
        binding.pOutlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.PURPLE.selected)

        binding.pTextChip1.setIxiChipColor(IxiChipColorState.Text.PURPLE.unselected)
        binding.pTextChip2.setIxiChipColor(IxiChipColorState.Text.PURPLE.selected)
    }

    private fun setYellowGroup() {
        binding.yPrimaryChip1.setIxiChipColor(IxiChipColorState.Primary.YELLOW.unselected)
        binding.yPrimaryChip2.setIxiChipColor(IxiChipColorState.Primary.YELLOW.selected)

        binding.ySecondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.YELLOW.unselected)
        binding.ySecondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.YELLOW.selected)

        binding.yOutlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.YELLOW.unselected)
        binding.yOutlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.YELLOW.selected)

        binding.yTextChip1.setIxiChipColor(IxiChipColorState.Text.YELLOW.unselected)
        binding.yTextChip2.setIxiChipColor(IxiChipColorState.Text.YELLOW.selected)
    }

    private fun setRedGroup() {
        binding.rPrimaryChip1.setIxiChipColor(IxiChipColorState.Primary.RED.unselected)
        binding.rPrimaryChip2.setIxiChipColor(IxiChipColorState.Primary.RED.selected)

        binding.rSecondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.RED.unselected)
        binding.rSecondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.RED.selected)

        binding.rOutlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.RED.unselected)
        binding.rOutlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.RED.selected)

        binding.rTextChip1.setIxiChipColor(IxiChipColorState.Text.RED.unselected)
        binding.rTextChip2.setIxiChipColor(IxiChipColorState.Text.RED.selected)
    }

    private fun setGreenGroup() {
        binding.gPrimaryChip1.setIxiChipColor(IxiChipColorState.Primary.GREEN.unselected)
        binding.gPrimaryChip2.setIxiChipColor(IxiChipColorState.Primary.GREEN.selected)

        binding.gSecondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.GREEN.unselected)
        binding.gSecondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.GREEN.selected)

        binding.gOutlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.GREEN.unselected)
        binding.gOutlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.GREEN.selected)

        binding.gTextChip1.setIxiChipColor(IxiChipColorState.Text.GREEN.unselected)
        binding.gTextChip2.setIxiChipColor(IxiChipColorState.Text.GREEN.selected)
    }

    private fun setBlueGroup() {
        binding.bPrimaryChip1.setIxiChipColor(IxiChipColorState.Primary.BLUE.selected)
        binding.bPrimaryChip2.setIxiChipColor(IxiChipColorState.Primary.BLUE.unselected)

        binding.bSecondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.BLUE.unselected)
        binding.bSecondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.BLUE.selected)

        binding.bOutlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.BLUE.unselected)
        binding.bOutlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.BLUE.selected)

        binding.bTextChip1.setIxiChipColor(IxiChipColorState.Text.BLUE.unselected)
        binding.bTextChip2.setIxiChipColor(IxiChipColorState.Text.BLUE.selected)
    }

    private fun setDisabledGroup() {
        binding.primaryChipDisabled.isEnabled(false)
        binding.secondaryChipDisabled.isEnabled(false)
        binding.outlinedChipDisabled.isEnabled(false)
        binding.textChipDisabled.isEnabled(false)
    }

    private fun setNeutralGroup() {
        binding.primaryChip1.setIxiChipColor(IxiChipColorState.Primary.NEUTRAL.unselected)
        binding.primaryChip1.onEndDrawableClickListener {
            binding.primaryChip1.isEnabled(false)
        }
        binding.primaryChip2.setIxiChipColor(IxiChipColorState.Primary.NEUTRAL.selected)
        binding.primaryChip2.setOnClickListener {
            binding.primaryChip1.isEnabled(true)
        }

        binding.secondaryChip1.setIxiChipColor(IxiChipColorState.Secondary.NEUTRAL.unselected)
        binding.secondaryChip1.onEndDrawableClickListener {
            binding.secondaryChip1.isEnabled(false)
        }
        binding.secondaryChip2.setIxiChipColor(IxiChipColorState.Secondary.NEUTRAL.selected)
        binding.secondaryChip2.setOnClickListener {
            binding.secondaryChip1.isEnabled(true)
        }

        binding.outlinedChip1.setIxiChipColor(IxiChipColorState.Outlined.NEUTRAL.unselected)
        binding.outlinedChip1.onEndDrawableClickListener {
            binding.outlinedChip1.isEnabled(false)
        }
        binding.outlinedChip2.setIxiChipColor(IxiChipColorState.Outlined.NEUTRAL.selected)
        binding.outlinedChip2.setOnClickListener {
            binding.outlinedChip1.isEnabled(true)
        }

        binding.textChip1.setIxiChipColor(IxiChipColorState.Text.NEUTRAL.unselected)
        binding.textChip1.onEndDrawableClickListener {
            binding.textChip1.isEnabled(false)
        }
        binding.textChip2.setIxiChipColor(IxiChipColorState.Text.NEUTRAL.selected)
        binding.textChip2.setOnClickListener {
            binding.textChip1.isEnabled(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}