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
        setBlueGroup()
        setGreenGroup()
        setRedGroup()
        setYellowGroup()
        setPurpleGroup()
        sampleGroup()
    }

    private fun setMasterGroup() {
        binding.masterChip1.setOnCloseIconClickListener{
            binding.masterChip1.text.toString().toToast(requireContext())
        }
        binding.masterChip2.setColor(IxiChipColor.BLUE)
        binding.masterChip2.setChipIconResource(R.drawable.baseline_remove_circle_24)
        binding.masterChip3.setColor(IxiChipColor.GREEN)
    }

    private fun setPurpleGroup() {
        binding.pOutlinedChip1.isChecked = true
        binding.pOutlinedChip1.setChipIconResource(R.drawable.ic_call_24)
        binding.pOutlinedChip2.isChecked = false
        binding.pOutlinedChip2.setChipIconResource(R.drawable.ic_call_24)
    }

    private fun setYellowGroup() {
        binding.yOutlinedChip1.isChecked = true
        binding.yOutlinedChip2.isChecked = false
    }

    private fun setRedGroup() {
        binding.rOutlinedChip1.isChecked = true
        binding.rOutlinedChip2.isChecked = false
    }

    private fun setGreenGroup() {
        binding.gOutlinedChip1.isChecked = true
        binding.gOutlinedChip2.isChecked = false
    }

    private fun setBlueGroup() {
        binding.bOutlinedChip1.isChecked = true
        binding.bOutlinedChip1.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip1.setCheckedIconResource(R.drawable.ic_baseline_cancel_24)
        binding.bOutlinedChip2.setColor(IxiChipColor.BLUE)
        binding.bOutlinedChip2.setCheckedIconResource(R.drawable.ic_baseline_cancel_24)
        binding.bOutlinedChip2.isChecked = false
    }

    private fun setNeutralGroup() {
        binding.outlinedChip1.isChecked = true
    }

    private fun sampleGroup() {
        context?.let {
            binding.sampleChipGroup.isSingleSelection = true
            binding.sampleChipGroup.setOnCheckedStateChangeListener() { group, checkedIds ->
                if (checkedIds.contains(lastCheckedId)) {
                    for (i in 0 until group.childCount){
                    val chip = group.getChildAt(i) as BaseChip
                    chip.isChecked = false
                    }
                }
                for (id in checkedIds) {
                    lastCheckedId = id
                    val chip: BaseChip = group.findViewById(id)
                    chip.isChecked = true
                    chip.text.toString().toToast(requireContext())
                }
            }
            binding.sampleOutline7.setColor(IxiChipColor.NEUTRAL)
            binding.sampleOutline7.setChipIconResource(0)
            binding.sampleOutline7.setOnClickListener {
                "Chip Clicked".toToast(requireContext())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

