package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentBottomSheetBinding
import com.ixigo.design.sdk.fragments.BottomSheetImplementation

class BottomSheetFragment: Fragment() {

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
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setImageBackgroundColor(R.color.r50)
            fragment.setIconSize(127f)
            fragment.setImage(R.drawable.sample_image)
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.setSecondaryButton("Button"){
                "Secondary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 2
        binding.second.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setIconSize(80f)
            fragment.setImage(R.drawable.sample_logo)
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.setSecondaryButton("Button"){
                "Secondary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 3
        binding.third.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.setSecondaryButton("Button"){
                "Secondary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 4
        binding.fourth.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setImageBackgroundColor(R.color.r50)
            fragment.setImage(R.drawable.sample_image)
            fragment.setIconSize(127f)
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 5
        binding.fifth.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setImage(R.drawable.sample_logo)
            fragment.setIconSize(80f)
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 6
        binding.sixth.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }

        //variant 7
        binding.seventh.setClickListener {
            val fragment = BottomSheetImplementation.newInstance()
            fragment.setTitleText("Main title sentence")
            fragment.setBodyText("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
            fragment.setIsMasterTitleCentered(true)
            fragment.setMasterTitle("Test")
            fragment.setPrimaryButton("Button"){
                "Primary Button".toToast(requireContext())
            }
            fragment.show(childFragmentManager, BottomSheetImplementation.TAG)
        }
    }
}