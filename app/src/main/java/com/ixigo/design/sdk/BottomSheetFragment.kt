package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentBottomSheetBinding

class BottomSheetFragment : Fragment() {

    private var _binding: FragmentBottomSheetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //variant 1
        binding.first.setClickListener {
            val fragment = BottomSheetImageFragment.newInstance()
            fragment.show(childFragmentManager, "Tag")
        }

        //variant 2
        binding.second.setClickListener {
            val fragment = BottomSheetFeatureIconFragment.newInstance()
            fragment.show(childFragmentManager, "Tag")

        }

        //variant 3
        binding.third.setClickListener {
            val fragment = BottomSheetNoIconFragment.newInstance()
            fragment.show(childFragmentManager, "Tag")
        }

        //variant 4
        binding.fourth.setClickListener {
            val myBottomSheetFragment = BottomSheetViewFragment.newInstance()
            myBottomSheetFragment.show(childFragmentManager, "BOTTOM_SHEET")
        }
    }
}