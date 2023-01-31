package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ixigo.design.sdk.components.chip.base.BaseChip
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
        sampleGroup()
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
        binding.masterChip1.setOnChipCheckedChangeListener(R.drawable.baseline_remove_circle_24) { buttonView, isChecked -> {} }
        binding.masterChip2.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
        binding.masterChip3.setOnChipCheckedChangeListener { buttonView, isChecked -> {} }
    }

    private fun setPurpleGroup() {
        binding.pOutlinedChip1.isChecked = true
        binding.pOutlinedChip1.setOnClickListener {
            binding.pOutlinedChip1.text.toString().toToast(requireContext())
        }
        binding.pOutlinedChip2.isChecked = false
        binding.pOutlinedChip2.setOnClickListener {
            binding.pOutlinedChip1.text.toString().toToast(requireContext())
        }
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
        binding.bOutlinedChip2.isChecked = false
    }

    private fun setDisabledGroup() {
        binding.outlinedChipDisabled.isEnabled = false
    }

    private fun setNeutralGroup() {
        binding.outlinedChip1.isChecked = true
    }

    private fun sampleGroup(){
        context?.let {
            binding.sampleOutline1.isChecked = true
            binding.sampleOutline1.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline1.text.toString().toToast(it)
            }
            binding.sampleOutline2.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline2.text.toString().toToast(it)
            }
            binding.sampleOutline3.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline3.text.toString().toToast(it)
            }
            binding.sampleOutline4.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline4.text.toString().toToast(it)
            }
            binding.sampleOutline5.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline5.text.toString().toToast(it)
            }
            binding.sampleOutline6.setOnChipCheckedChangeListener{buttonView, isChecked ->
                binding.sampleOutline6.text.toString().toToast(it)
            }
            binding.sampleOutline7.setOnClickListener {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}