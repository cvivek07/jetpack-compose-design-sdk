package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.bottomsheets.IxiBottomSheetDialogFragment
import com.ixigo.design.sdk.components.bottomsheets.base.BottomSheetState
import com.ixigo.design.sdk.components.buttons.IxiPrimaryButton
import com.ixigo.design.sdk.components.buttons.IxiSecondaryButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonShape
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.styles.IxiColor
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
        val primaryButton = IxiPrimaryButton(requireContext())
        primaryButton.setText("Button")
        primaryButton.setStyle(ButtonShape.RegularShape, IxiColor.Orange, ButtonSize.Large)
        primaryButton.setClickListener {
            context?.let { it1 -> "Button1 Clicked Change".toToast(it1) }
        }

        val secondaryButton = IxiSecondaryButton(requireContext())
        secondaryButton.setText("Button")
        secondaryButton.setStyle(ButtonShape.RegularShape, IxiColor.Orange, ButtonSize.Large)
        secondaryButton.setClickListener {
            context?.let { it1 -> "Button2 Clicked Change".toToast(it1) }
        }

        //variant 1
        binding.first.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                image = R.drawable.ic_launcher_background,
                imageBackgroundColor = R.color.r50,
                primaryButton = primaryButton,
                secondaryButton = secondaryButton
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 2
        binding.second.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                image = R.drawable.ic_launcher_background,
                primaryButton = primaryButton,
                secondaryButton = secondaryButton
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 3
        binding.third.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                primaryButton = primaryButton,
                secondaryButton = secondaryButton
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 4
        binding.fourth.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                image = R.drawable.ic_launcher_background,
                imageBackgroundColor = R.color.r50,
                primaryButton = primaryButton,
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 5
        binding.fifth.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                image = R.drawable.ic_launcher_background,
                primaryButton = primaryButton,
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 6
        binding.sixth.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                primaryButton = primaryButton,
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }

        //variant 7
        binding.seventh.setClickListener {
            IxiBottomSheetDialogFragment.newInstance(BottomSheetState(
                toolbarText = "Title",
                headerText = "Main title sentence",
                bodyText = "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum",
                primaryButton = primaryButton,
                isToolbarCentered = true
            )
            ).show(childFragmentManager, IxiBottomSheetDialogFragment.TAG)
        }
    }
}