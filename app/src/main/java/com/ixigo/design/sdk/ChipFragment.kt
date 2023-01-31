package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.chip.base.BaseChip
import com.ixigo.design.sdk.components.styles.IxiChipColor
import com.ixigo.design.sdk.databinding.FragmentChipsBinding


class ChipFragment : BaseFragment() {

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
        binding.masterChip1.setColor(IxiChipColor.YELLOW)
        binding.masterChip1.setChipIconResource(R.drawable.baseline_remove_circle_24)
        binding.masterChip1.setCloseIconResource(R.drawable.baseline_remove_circle_24)

        binding.masterChip1.setOnClickListener {
            binding.masterChip1.isSelected = !binding.masterChip1.isSelected
        }
//        binding.masterChip1.setSe(R.drawable.baseline_remove_circle_24) { buttonView, isChecked -> {} }
//        binding.masterChip1.setOnChipCheckedChangeListener(R.drawable.baseline_remove_circle_24) { buttonView, isChecked -> {} }
        binding.masterChip2.setColor(IxiChipColor.BLUE)
        binding.masterChip2.setChipIconResource(R.drawable.baseline_remove_circle_24)
        binding.masterChip2.setCloseIconResource(R.drawable.baseline_remove_circle_24)
//        binding.masterChip2.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
        binding.masterChip3.setColor(IxiChipColor.GREEN)
        binding.masterChip3.setChipIconResource(R.drawable.baseline_remove_circle_24)
//        binding.masterChip3.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
    }

    private fun setPurpleGroup() {
        binding.pOutlinedChip1.setColor(IxiChipColor.PURPLE)
        binding.pOutlinedChip1.isChecked = true
        binding.pOutlinedChip1.setChipIconResource(R.drawable.baseline_remove_circle_24)
//        binding.pOutlinedChip1.setOnClickListener {
//            binding.pOutlinedChip1.text.toString().toToast(context!!)
//        }
        binding.pOutlinedChip2.setColor(IxiChipColor.PURPLE)
        binding.pOutlinedChip2.isChecked = false
        binding.pOutlinedChip2.setChipIconResource(R.drawable.baseline_remove_circle_24)

//        binding.pOutlinedChip2.setOnClickListener {
//            binding.pOutlinedChip1.text.toString().toToast(context!!)
//        }
    }

    private fun setYellowGroup() {
        binding.yOutlinedChip1.setColor(IxiChipColor.YELLOW)
        binding.yOutlinedChip1.isChecked = true
        binding.yOutlinedChip2.setColor(IxiChipColor.YELLOW)
        binding.yOutlinedChip2.isChecked = false
    }

    private fun setRedGroup() {
        binding.rOutlinedChip1.setColor(IxiChipColor.RED)
        binding.rOutlinedChip1.isChecked = true
        binding.rOutlinedChip2.setColor(IxiChipColor.RED)
        binding.rOutlinedChip2.isChecked = false
    }

    private fun setGreenGroup() {
        binding.gOutlinedChip1.setColor(IxiChipColor.GREEN)
        binding.gOutlinedChip1.isChecked = true
        binding.gOutlinedChip2.setColor(IxiChipColor.GREEN)
        binding.gOutlinedChip2.isChecked = false
    }

    private fun setBlueGroup() {

        binding.bOutlinedChip1.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip1.setCheckedIconResource( R.drawable.ic_baseline_cancel_24)
        binding.bOutlinedChip1.setOnClickListener {
            binding.bOutlinedChip1.isSelected = !binding.bOutlinedChip1.isSelected
        }

        binding.bOutlinedChip2.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip2.setCheckedIconResource( R.drawable.ic_baseline_cancel_24)
        binding.bOutlinedChip2.isChecked = false
    }

    private fun setDisabledGroup() {
        binding.outlinedChipDisabled.isEnabled = false
    }

    private fun setNeutralGroup() {

        binding.outlinedChip1.isChecked = true
        binding.outlinedChip1.setColor(IxiChipColor.NEUTRAL)
        binding.outlinedChip1.setOnCloseIconClickListener {
            binding.outlinedChip1.isEnabled = false
        }

        binding.outlinedChip2.setColor(IxiChipColor.NEUTRAL)
        binding.outlinedChip2.setChipIconResource(0)
        binding.outlinedChip2.setOnClickListener {
            binding.outlinedChip1.isEnabled = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}