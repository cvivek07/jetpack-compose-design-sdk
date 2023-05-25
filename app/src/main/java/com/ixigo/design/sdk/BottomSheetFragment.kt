package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.dp
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
            val fragment = IxiBottomSheetHelper.getImageBottomSheet(
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
                    inlineAlertText = "This is a placeholder",
                    secondaryButtonHelperText = "Hello",
                    primaryButtonHelperText = "Hey!"
                    )
            )
            fragment.show(childFragmentManager, "Tag")
        }

//        //variant 2
        binding.second.setClickListener {
            val fragment = IxiBottomSheetHelper.getFeatureIconBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    titleText = "Main title sentence",
                    bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    image = R.drawable.sample_logo,
                    primaryButtonText = "Button",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Button",
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                )
            )
            fragment.show(childFragmentManager, "Tag")

        }

        //variant 3
        binding.third.setClickListener {
            val fragment = IxiBottomSheetHelper.getNoIconBottomSheet(
                IxiBottomSheetHelper.IxiBottomSheetUiModel(
                    titleText = "Main title sentence",
                    bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                    primaryButtonText = "No",
                    primaryActionListener = { "Primary Button".toToast(requireContext()) },
                    secondaryButtonText = "Yes, Delete",
                    buttonMinWidth = 150.dp,
                    buttonMaxWidth = 300.dp,
                    secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                )
            )
            fragment.show(childFragmentManager, "Tag")

        }

        binding.fourth.setClickListener {
            val fragment = NestedViewFragment()
            val fragmentTransaction = childFragmentManager.beginTransaction().add(fragment, "Test")
            fragmentTransaction.commit()
            fragmentTransaction.runOnCommit {
                IxiBottomSheetHelper.getBlankBottomSheet(
                    IxiBottomSheetHelper.IxiBottomSheetUiModel(
                        toolbarTitle = "Main title sentence",
                        view = fragment.view,
                        primaryButtonText = "Button",
                        primaryActionListener = { "Primary Button".toToast(requireContext()) },
                        secondaryButtonText = "Button",
                        secondaryActionListener = { "Secondary Button".toToast(requireContext()) },
                        disableDragging = true,
                        closeActionAlignment = IxiBottomSheetView.ActionIconAlignment.START,
                        closeActionListener = {
                            val childFragment = childFragmentManager.findFragmentByTag("Test")
                            childFragmentManager.beginTransaction().remove(
                                childFragment!!
                            ).commit()
                            "Closed".toToast(requireContext())
                        },
                        toolbarCloseIcon = R.drawable.left_arrow
                    )
                ).show(childFragmentManager, "Tag")
            }
        }
    }
}