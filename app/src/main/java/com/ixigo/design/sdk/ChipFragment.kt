package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.databinding.FragmentChipsBinding

class ChipFragment  : BaseFragment() {

    private var _binding: FragmentChipsBinding? = null

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
        binding.masterChip1.setIxiChipColor(IxiChipColor.Primary.NEUTRAL.background900)
        binding.masterChip2.setIxiChipColor(IxiChipColor.Primary.NEUTRAL.background800)
        binding.masterChip3.setIxiChipColor(IxiChipColor.Primary.NEUTRAL.background800)
    }

    private fun setPurpleGroup() {
        binding.pPrimaryChip1.setIxiChipColor(IxiChipColor.Primary.PURPLE.background400)
        binding.pPrimaryChip2.setIxiChipColor(IxiChipColor.Primary.PURPLE.background500)

        binding.pSecondaryChip1.setIxiChipColor(IxiChipColor.Secondary.PURPLE.background50)
        binding.pSecondaryChip2.setIxiChipColor(IxiChipColor.Secondary.PURPLE.background100)

        binding.pOutlinedChip1.setIxiChipColor(IxiChipColor.Outlined.PURPLE.stroke300)
        binding.pOutlinedChip2.setIxiChipColor(IxiChipColor.Outlined.PURPLE.background50Stroke300)

        binding.pTextChip1.setIxiChipColor(IxiChipColor.Text.PURPLE.text500)
        binding.pTextChip2.setIxiChipColor(IxiChipColor.Text.PURPLE.background50Text500)
    }

    private fun setYellowGroup() {
        binding.yPrimaryChip1.setIxiChipColor(IxiChipColor.Primary.YELLOW.background400)
        binding.yPrimaryChip2.setIxiChipColor(IxiChipColor.Primary.YELLOW.background500)

        binding.ySecondaryChip1.setIxiChipColor(IxiChipColor.Secondary.YELLOW.background50)
        binding.ySecondaryChip2.setIxiChipColor(IxiChipColor.Secondary.YELLOW.background100)

        binding.yOutlinedChip1.setIxiChipColor(IxiChipColor.Outlined.YELLOW.stroke300)
        binding.yOutlinedChip2.setIxiChipColor(IxiChipColor.Outlined.YELLOW.background50Stroke300)

        binding.yTextChip1.setIxiChipColor(IxiChipColor.Text.YELLOW.text500)
        binding.yTextChip2.setIxiChipColor(IxiChipColor.Text.YELLOW.background50Text500)
    }

    private fun setRedGroup() {
        binding.rPrimaryChip1.setIxiChipColor(IxiChipColor.Primary.RED.background400)
        binding.rPrimaryChip2.setIxiChipColor(IxiChipColor.Primary.RED.background500)

        binding.rSecondaryChip1.setIxiChipColor(IxiChipColor.Secondary.RED.background50)
        binding.rSecondaryChip2.setIxiChipColor(IxiChipColor.Secondary.RED.background100)

        binding.rOutlinedChip1.setIxiChipColor(IxiChipColor.Outlined.RED.stroke300)
        binding.rOutlinedChip2.setIxiChipColor(IxiChipColor.Outlined.RED.background50Stroke300)

        binding.rTextChip1.setIxiChipColor(IxiChipColor.Text.RED.text500)
        binding.rTextChip2.setIxiChipColor(IxiChipColor.Text.RED.background50Text500)
    }

    private fun setGreenGroup() {
        binding.gPrimaryChip1.setIxiChipColor(IxiChipColor.Primary.GREEN.background400)
        binding.gPrimaryChip2.setIxiChipColor(IxiChipColor.Primary.GREEN.background500)

        binding.gSecondaryChip1.setIxiChipColor(IxiChipColor.Secondary.GREEN.background50)
        binding.gSecondaryChip2.setIxiChipColor(IxiChipColor.Secondary.GREEN.background100)

        binding.gOutlinedChip1.setIxiChipColor(IxiChipColor.Outlined.GREEN.stroke300)
        binding.gOutlinedChip2.setIxiChipColor(IxiChipColor.Outlined.GREEN.background50Stroke300)

        binding.gTextChip1.setIxiChipColor(IxiChipColor.Text.GREEN.text500)
        binding.gTextChip2.setIxiChipColor(IxiChipColor.Text.GREEN.background50Text500)
    }

    private fun setBlueGroup() {
        binding.bPrimaryChip1.setIxiChipColor(IxiChipColor.Primary.BLUE.background400)
        binding.bPrimaryChip2.setIxiChipColor(IxiChipColor.Primary.BLUE.background500)

        binding.bSecondaryChip1.setIxiChipColor(IxiChipColor.Secondary.BLUE.background50)
        binding.bSecondaryChip2.setIxiChipColor(IxiChipColor.Secondary.BLUE.background100)

        binding.bOutlinedChip1.setIxiChipColor(IxiChipColor.Outlined.BLUE.stroke300)
        binding.bOutlinedChip2.setIxiChipColor(IxiChipColor.Outlined.BLUE.background50Stroke300)

        binding.bTextChip1.setIxiChipColor(IxiChipColor.Text.BLUE.text500)
        binding.bTextChip2.setIxiChipColor(IxiChipColor.Text.BLUE.background50Text500)
    }

    private fun setDisabledGroup() {
        binding.primaryChipDisabled.isEnabled(false)
        binding.secondaryChipDisabled.isEnabled(false)
        binding.outlinedChipDisabled.isEnabled(false)
        binding.textChipDisabled.isEnabled(false)
    }

    private fun setNeutralGroup() {
        binding.primaryChip1.setIxiChipColor(IxiChipColor.Primary.NEUTRAL.background900)
        binding.primaryChip1.onEndDrawableClickListener {
            binding.primaryChip1.isEnabled(false)
        }
        binding.primaryChip2.setIxiChipColor(IxiChipColor.Primary.NEUTRAL.background800)
        binding.primaryChip2.setOnClickListener {
            binding.primaryChip1.isEnabled(true)
        }

        binding.secondaryChip1.setIxiChipColor(IxiChipColor.Secondary.NEUTRAL.background40)
        binding.secondaryChip1.onEndDrawableClickListener {
            binding.secondaryChip1.isEnabled(false)
        }
        binding.secondaryChip2.setIxiChipColor(IxiChipColor.Secondary.NEUTRAL.background80)
        binding.secondaryChip2.setOnClickListener {
            binding.secondaryChip1.isEnabled(true)
        }

        binding.outlinedChip1.setIxiChipColor(IxiChipColor.Outlined.NEUTRAL.stroke300)
        binding.outlinedChip1.onEndDrawableClickListener {
            binding.outlinedChip1.isEnabled(false)
        }
        binding.outlinedChip2.setIxiChipColor(IxiChipColor.Outlined.NEUTRAL.background40Stroke300)
        binding.outlinedChip2.setOnClickListener {
            binding.outlinedChip1.isEnabled(true)
        }

        binding.textChip1.setIxiChipColor(IxiChipColor.Text.NEUTRAL.text800)
        binding.textChip1.onEndDrawableClickListener {
            binding.textChip1.isEnabled(false)
        }
        binding.textChip2.setIxiChipColor(IxiChipColor.Text.NEUTRAL.background40Text800)
        binding.textChip2.setOnClickListener {
            binding.textChip1.isEnabled(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}