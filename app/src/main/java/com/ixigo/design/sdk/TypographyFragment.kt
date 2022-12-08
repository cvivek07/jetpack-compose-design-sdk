package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentTypographyBinding
import com.ixigo.design_sdk.components.styles.IxiTypography

class TypographyFragment : Fragment() {
    private var _binding: FragmentTypographyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTypographyBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            displayText900.setText("Display Text 900")
            displayText900.setTypography(IxiTypography.Heading.DisplayLarge.bold)
            displayText700.setText("Display Text 700")
            displayText700.setTypography(IxiTypography.Heading.DisplayLarge.semiBold)
            displayText500.setText("Display Text 500")
            displayText500.setTypography(IxiTypography.Heading.DisplayLarge.regular)

            h1900.setText("Header1 900")
            h1900.setTypography(IxiTypography.Heading.H1.bold)
            h1700.setText("Header1 700")
            h1700.setTypography(IxiTypography.Heading.H1.semiBold)
            h1500.setText("Header1 500")
            h1500.setTypography(IxiTypography.Heading.H1.regular)

            h2900.setText("Header2 900")
            h2900.setTypography(IxiTypography.Heading.H2.bold)
            h2700.setText("Header2 700")
            h2700.setTypography(IxiTypography.Heading.H2.semiBold)
            h2500.setText("Header2 500")
            h2500.setTypography(IxiTypography.Heading.H2.regular)

            h3900.setText("Header3 900")
            h3900.setTypography(IxiTypography.Heading.H3.bold)
            h3700.setText("Header3 700")
            h3700.setTypography(IxiTypography.Heading.H3.semiBold)
            h3500.setText("Header3 500")
            h3500.setTypography(IxiTypography.Heading.H3.regular)

            h4900.setText("Header4 900")
            h4900.setTypography(IxiTypography.Heading.H4.bold)
            h4700.setText("Header4 700")
            h4700.setTypography(IxiTypography.Heading.H4.semiBold)
            h4500.setText("Header4 500")
            h4500.setTypography(IxiTypography.Heading.H4.regular)

            h5900.setText("Header5 900")
            h5900.setTypography(IxiTypography.Heading.H5.bold)
            h5700.setText("Header5 700")
            h5700.setTypography(IxiTypography.Heading.H5.semiBold)
            h5500.setText("Header5 500")
            h5500.setTypography(IxiTypography.Heading.H5.regular)

            h6900.setText("Header6 900")
            h6900.setTypography(IxiTypography.Heading.H6.bold)
            h6700.setText("Header6 700")
            h6700.setTypography(IxiTypography.Heading.H6.semiBold)
            h6500.setText("Header6 500")
            h6500.setTypography(IxiTypography.Heading.H6.regular)


            bodyLargeBold.setText("Body Large Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeBold.setTypography(IxiTypography.Body.Large.bold)
            bodyLargeItalic.setText("Body Large Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeItalic.setTypography(IxiTypography.Body.Large.italics)
            bodyLargeMed.setText("Body Large Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeMed.setTypography(IxiTypography.Body.Large.medium)
            bodyLargeReg.setText("Body Large Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeReg.setTypography(IxiTypography.Body.Large.regular)
            bodyLargeUnderlined.setText("Body large Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeUnderlined.setTypography(IxiTypography.Body.Large.underline)
            bodyLargeStrike.setText("Body large strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeStrike.setTypography(IxiTypography.Body.Large.strikeThrough)



            bodyMediumBold.setText("Body Medium Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumBold.setTypography(IxiTypography.Body.Medium.bold)
            bodyMediumItalic.setText("Body Medium Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumItalic.setTypography(IxiTypography.Body.Medium.italics)
            bodyMediumMed.setText("Body Medium Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumMed.setTypography(IxiTypography.Body.Medium.medium)
            bodyMediumReg.setText("Body Medium Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumReg.setTypography(IxiTypography.Body.Medium.regular)
            bodyMediumUnderlined.setText("Body Medium Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumUnderlined.setTypography(IxiTypography.Body.Medium.underline)
            bodyMediumStrike.setText("Body Medium strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyMediumStrike.setTypography(IxiTypography.Body.Medium.strikeThrough)



            bodySmallBold.setText("Body Small Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallBold.setTypography(IxiTypography.Body.Small.bold)
            bodySmallItalic.setText("Body Small Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallItalic.setTypography(IxiTypography.Body.Small.italics)
            bodySmallMed.setText("Body Small Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallMed.setTypography(IxiTypography.Body.Small.medium)
            bodySmallReg.setText("Body Small Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallReg.setTypography(IxiTypography.Body.Small.regular)
            bodySmallUnderlined.setText("Body Small Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallUnderlined.setTypography(IxiTypography.Body.Small.underline)
            bodySmallStrike.setText("Body Small strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodySmallStrike.setTypography(IxiTypography.Body.Small.strikeThrough)



            bodyXSmallBold.setText("Body XSmall Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallBold.setTypography(IxiTypography.Body.XSmall.bold)
            bodyXSmallItalic.setText("Body XSmall Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallItalic.setTypography(IxiTypography.Body.XSmall.italics)
            bodyXSmallMed.setText("Body XSmall Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallMed.setTypography(IxiTypography.Body.XSmall.medium)
            bodyXSmallReg.setText("Body XSmall Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallReg.setTypography(IxiTypography.Body.XSmall.regular)
            bodyXSmallUnderlined.setText("Body XSmall Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallUnderlined.setTypography(IxiTypography.Body.XSmall.underline)
            bodyXSmallStrike.setText("Body XSmall strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyXSmallStrike.setTypography(IxiTypography.Body.XSmall.strikeThrough)
        }
    }
}
