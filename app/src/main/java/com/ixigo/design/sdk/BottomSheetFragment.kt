package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetView
import com.ixigo.design.sdk.components.bottomsheets.helper.IxiBottomSheetHelper
import com.ixigo.design.sdk.databinding.FragmentBottomSheetBinding

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
            IxiBottomSheetHelper.showImageBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    titleText = "Main title sentence",
                    bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    imageBackgroundColor = R.color.r50,
                    iconSize = 127f,
                    image = R.drawable.sample_image,
                    primaryButtonText = "Button",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Button",
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                    inlineAlertText = "This is a placeholder"
                    ), childFragmentManager
            )
        }

//        //variant 2
        binding.second.setClickListener {
            IxiBottomSheetHelper.showFeatureIconBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    titleText = "Main title sentence",
                    bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    image = R.drawable.sample_logo,
                    primaryButtonText = "Button",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Button",
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                ), childFragmentManager
            )
        }

        //variant 3
        binding.third.setClickListener {
            IxiBottomSheetHelper.showNoIconBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    titleText = "Main title sentence",
                    bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    primaryButtonText = "Button",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Button",
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                ), childFragmentManager
            )
        }

        val fragment = ButtonsFragment()
        childFragmentManager.beginTransaction().add(fragment, "Test").commit()
        binding.fourth.setClickListener {
            IxiBottomSheetHelper.showBlankBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    toolbarTitle = "Main title sentence",
                    view = fragment.view,
                    primaryButtonText = "Button",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Button",
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                    disableDragging = true,
                    closeActionAlignment = IxiBottomSheetView.ActionIconAlignment.START,
                    toolbarCloseIcon = R.drawable.left_arrow
                ), childFragmentManager
            )
        }
    }
}