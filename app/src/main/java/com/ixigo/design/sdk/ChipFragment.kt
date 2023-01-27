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
        binding.masterChip1.setOnChipCheckedChangeListener(R.drawable.baseline_remove_circle_24) { buttonView, isChecked -> {} }
        binding.masterChip2.setIxiChipColorState(IxiChipColorState.Secondary.BLUE)
        binding.masterChip2.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
        binding.masterChip3.setIxiChipColorState(IxiChipColorState.Outlined.GREEN)
        binding.masterChip3.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
    }

    private fun setPurpleGroup() {
        binding.pPrimaryChip1.setColor(false, IxiChipColorState.Primary.PURPLE)
        binding.pPrimaryChip2.setColor(true, IxiChipColorState.Primary.PURPLE)

        binding.pSecondaryChip1.setColor(false, IxiChipColorState.Secondary.PURPLE)
        binding.pSecondaryChip2.setColor(true, IxiChipColorState.Secondary.PURPLE)

        binding.pOutlinedChip1.setColor(false, IxiChipColorState.Outlined.PURPLE)
        binding.pOutlinedChip2.setColor(true, IxiChipColorState.Outlined.PURPLE)

        binding.pTextChip1.setColor(false, IxiChipColorState.Text.PURPLE)
        binding.pTextChip2.setColor(true, IxiChipColorState.Text.PURPLE)
    }

    private fun setYellowGroup() {
        binding.yPrimaryChip1.setColor(false, IxiChipColorState.Primary.YELLOW)
        binding.yPrimaryChip2.setColor(true, IxiChipColorState.Primary.YELLOW)

        binding.ySecondaryChip1.setColor(false, IxiChipColorState.Secondary.YELLOW)
        binding.ySecondaryChip2.setColor(true, IxiChipColorState.Secondary.YELLOW)

        binding.yOutlinedChip1.setColor(false, IxiChipColorState.Outlined.YELLOW)
        binding.yOutlinedChip2.setColor(true, IxiChipColorState.Outlined.YELLOW)

        binding.yTextChip1.setColor(false, IxiChipColorState.Text.YELLOW)
        binding.yTextChip2.setColor(true, IxiChipColorState.Text.YELLOW)
    }

    private fun setRedGroup() {
        binding.rPrimaryChip1.setColor(false, IxiChipColorState.Primary.RED)
        binding.rPrimaryChip2.setColor(true, IxiChipColorState.Primary.RED)

        binding.rSecondaryChip1.setColor(false, IxiChipColorState.Secondary.RED)
        binding.rSecondaryChip2.setColor(true, IxiChipColorState.Secondary.RED)

        binding.rOutlinedChip1.setColor(false, IxiChipColorState.Outlined.RED)
        binding.rOutlinedChip2.setColor(true, IxiChipColorState.Outlined.RED)

        binding.rTextChip1.setColor(false, IxiChipColorState.Text.RED)
        binding.rTextChip2.setColor(true, IxiChipColorState.Text.RED)
    }

    private fun setGreenGroup() {
        binding.gPrimaryChip1.setColor(false, IxiChipColorState.Primary.GREEN)
        binding.gPrimaryChip2.setColor(true, IxiChipColorState.Primary.GREEN)

        binding.gSecondaryChip1.setColor(false, IxiChipColorState.Secondary.GREEN)
        binding.gSecondaryChip2.setColor(true, IxiChipColorState.Secondary.GREEN)

        binding.gOutlinedChip1.setColor(false, IxiChipColorState.Outlined.GREEN)
        binding.gOutlinedChip2.setColor(true, IxiChipColorState.Outlined.GREEN)

        binding.gTextChip1.setColor(false, IxiChipColorState.Text.GREEN)
        binding.gTextChip2.setColor(true, IxiChipColorState.Text.GREEN)
    }

    private fun setBlueGroup() {
        binding.bPrimaryChip1.setColor(false, IxiChipColorState.Primary.BLUE)
        binding.bPrimaryChip2.setColor(true, IxiChipColorState.Primary.BLUE)

        binding.bSecondaryChip1.setColor(false, IxiChipColorState.Secondary.BLUE)
        binding.bSecondaryChip2.setColor(true, IxiChipColorState.Secondary.BLUE)

        binding.bOutlinedChip1.setColor(false, IxiChipColorState.Outlined.BLUE)
        binding.bOutlinedChip2.setColor(true, IxiChipColorState.Outlined.BLUE)

        binding.bTextChip1.setColor(false, IxiChipColorState.Text.BLUE)
        binding.bTextChip2.setColor(true, IxiChipColorState.Text.BLUE)
    }

    private fun setDisabledGroup() {
        binding.primaryChipDisabled.isEnabled = false
        binding.secondaryChipDisabled.isEnabled = false
        binding.outlinedChipDisabled.isEnabled = false
        binding.textChipDisabled.isEnabled = false
    }

    private fun setNeutralGroup() {
        binding.primaryChip1.setColor(false, IxiChipColorState.Primary.NEUTRAL)
        binding.primaryChip1.onEndDrawableClickListener {
            binding.primaryChip1.isEnabled = false
        }
        binding.primaryChip2.setColor(true, IxiChipColorState.Primary.NEUTRAL)
        binding.primaryChip2.setOnClickListener {
            binding.primaryChip1.isEnabled = true
        }

        binding.secondaryChip1.setColor(false, IxiChipColorState.Secondary.NEUTRAL)
        binding.secondaryChip1.onEndDrawableClickListener {
            binding.secondaryChip1.isEnabled = false
        }
        binding.secondaryChip2.setColor(true, IxiChipColorState.Secondary.NEUTRAL)
        binding.secondaryChip2.setOnClickListener {
            binding.secondaryChip1.isEnabled = true
        }

        binding.outlinedChip1.setColor(false, IxiChipColorState.Outlined.NEUTRAL)
        binding.outlinedChip1.onEndDrawableClickListener {
            binding.outlinedChip1.isEnabled = false
        }
        binding.outlinedChip2.setColor(true, IxiChipColorState.Outlined.NEUTRAL)
        binding.outlinedChip2.setOnClickListener {
            binding.outlinedChip1.isEnabled = true
        }

        binding.textChip1.setColor(false, IxiChipColorState.Text.NEUTRAL)
        binding.textChip1.onEndDrawableClickListener {
            binding.textChip1.isEnabled = false
        }
        binding.textChip2.setColor(true, IxiChipColorState.Text.NEUTRAL)
        binding.textChip2.setOnClickListener {
            binding.textChip1.isEnabled = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}