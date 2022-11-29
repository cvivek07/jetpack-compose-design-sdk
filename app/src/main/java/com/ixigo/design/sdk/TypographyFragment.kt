package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentTypographyBinding

public class TypographyFragment : Fragment() {
    private var _binding: FragmentTypographyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTypographyBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            displayText900.setText("Display Text 900")
            displayText900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.DisplayLarge900)
            displayText700.setText("Display Text 700")
            displayText700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.DisplayLarge700)
            displayText500.setText("Display Text 500")
            displayText500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.DisplayLarge500)

            h1900.setText("H1 900")
            h1900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h1_900)
            h1700.setText("H1 700")
            h1700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h1_700)
            h1500.setText("H1 500")
            h1500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h1_500)

            h2900.setText("Header2 900")
            h2900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h2_900)
            h2700.setText("Header2 700")
            h2700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h2_700)
            h2500.setText("Header2 500")
            h2500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h2_500)

            h3900.setText("Header3 900")
            h3900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h3_900)
            h3700.setText("Header3 700")
            h3700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h3_700)
            h3500.setText("Header3 500")
            h3500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h3_500)

            h4900.setText("Header4 900")
            h4900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h4_900)
            h4700.setText("Header4 700")
            h4700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h4_700)
            h4500.setText("Header4 500")
            h4500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h4_500)

            h5900.setText("Header5 900")
            h5900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h5_900)
            h5700.setText("Header5 700")
            h5700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h5_700)
            h5500.setText("Header5 500")
            h5500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h5_500)

            h6900.setText("Header6 900")
            h6900.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h6_900)
            h6700.setText("Header6 700")
            h6700.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h6_700)
            h6500.setText("Header6 500")
            h6500.setTypography(com.ixigo.design_sdk.components.styles.Typography.Heading.h6_500)


            bodyLargeBold.setText("Body Large Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeBold.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.bold)
            bodyLargeItalic.setText("Body Large Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeItalic.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.italics)
            bodyLargeMed.setText("Body Large Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeMed.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.medium)
            bodyLargeReg.setText("Body Large Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeReg.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.regular)
            bodyLargeUnderlined.setText("Body large Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeUnderlined.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.underline)
            bodyLargeStrike.setText("Body large strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeStrike.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Large.strikeThrough)



            bodyMediumBold.setText("Body Medium Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumBold.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.bold)
            bodyMediumItalic.setText("Body Medium Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumItalic.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.italics)
            bodyMediumMed.setText("Body Medium Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumMed.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.medium)
            bodyMediumReg.setText("Body Medium Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumReg.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.regular)
            bodyMediumUnderlined.setText("Body Medium Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumUnderlined.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.underline)
            bodyMediumStrike.setText("Body Medium strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumStrike.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Medium.strikeThrough)



            bodySmallBold.setText("Body Small Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallBold.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.bold)
            bodySmallItalic.setText("Body Small Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallItalic.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.italics)
            bodySmallMed.setText("Body Small Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallMed.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.medium)
            bodySmallReg.setText("Body Small Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallReg.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.regular)
            bodySmallUnderlined.setText("Body Small Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallUnderlined.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.underline)
            bodySmallStrike.setText("Body Small strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallStrike.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.Small.strikeThrough)



            bodyXSmallBold.setText("Body XSmall Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallBold.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.bold)
            bodyXSmallItalic.setText("Body XSmall Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallItalic.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.italics)
            bodyXSmallMed.setText("Body XSmall Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallMed.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.medium)
            bodyXSmallReg.setText("Body XSmall Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallReg.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.regular)
            bodyXSmallUnderlined.setText("Body XSmall Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallUnderlined.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.underline)
            bodyXSmallStrike.setText("Body XSmall strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallStrike.setTypography(com.ixigo.design_sdk.components.styles.Typography.Body.XSmall.strikeThrough)
        }
    }
}
