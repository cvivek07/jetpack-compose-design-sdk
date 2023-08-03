package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.IxiText
import com.ixigo.design.sdk.components.text.composable.Highlight
import com.ixigo.design.sdk.databinding.FragmentTypographyBinding

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
            clickableText.setOriginalText(getString(R.string.disclaimer))
            clickableText.setOriginalTextColor(ContextCompat.getColor(requireContext(), R.color.y600))
            clickableText.setHighlightedText(listOf(Highlight("privacy policy", onClick = {
                Toast.makeText(requireContext(), "privacy", Toast.LENGTH_SHORT).show()
            }), Highlight("terms of use", onClick = {
                Toast.makeText(requireContext(), "terms", Toast.LENGTH_SHORT).show()
            })))
            clickableText.setHighlightColor(R.color.b500)
            displayText900.setTypography(IxiTypography.Heading.DisplayLarge.bold)
            displayText900.setText("Display Text Bold")
            displayText900.setOnClickListener{
                (it as? IxiText)?.getText()?.toToast(requireContext())
            }

            displayText700.setText("Display Text SemiBold")
            displayText700.setTypography(IxiTypography.Heading.DisplayLarge.semiBold)

            displayText500.setHtmlText(R.string.hello_world)
            displayText500.setTypography(IxiTypography.Heading.DisplayLarge.regular)
            displayText500.setTextColor(ContextCompat.getColor(requireContext(),R.color.g300))


            h1900.setText("H1 Bold")
            h1900.setTypography(IxiTypography.Heading.H1.bold)
            h1700.setHtmlText(R.string.app_name)
            h1700.setTypography(IxiTypography.Heading.H1.medium)
            h1500.setHtmlText("<html><b><i><u>Trusted by</u></i></b> <font color=\"#FEB900\">2 crore+ </font>Indian travellers &#127470;&#127475;</html>")
            h1500.setTypography(IxiTypography.Heading.H1.regular)

            h2900.setText("H2 Bold")
            h2900.setTypography(IxiTypography.Heading.H2.bold)
            h2700.setText("H2 SemiBold")
            h2700.setTypography(IxiTypography.Heading.H2.medium)
            h2500.setText("H2 Regular")
            h2500.setTypography(IxiTypography.Heading.H2.regular)

            h3900.setText("H3 Bold")
            h3900.setTypography(IxiTypography.Heading.H3.bold)
            h3700.setText("H3 SemiBold")
            h3700.setTypography(IxiTypography.Heading.H3.medium)
            h3500.setText("H3 Regular")
            h3500.setTypography(IxiTypography.Heading.H3.regular)

            h4900.setText("H4 Bold")
            h4900.setTypography(IxiTypography.Heading.H4.bold)
            h4700.setText("H4 SemiBold")
            h4700.setTypography(IxiTypography.Heading.H4.medium)
            h4500.setText("H4 Regular")
            h4500.setTypography(IxiTypography.Heading.H4.regular)

            h5900.setText("H5 Bold")
            h5900.setTypography(IxiTypography.Heading.H5.bold)
            h5700.setText("H5 SemiBold")
            h5700.setTypography(IxiTypography.Heading.H5.medium)
            h5500.setText("H5 Regular")
            h5500.setTypography(IxiTypography.Heading.H5.regular)

            h6900.setText("H6 Bold")
            h6900.setTypography(IxiTypography.Heading.H6.bold)
            h6700.setText("H6 SemiBold")
            h6700.setTypography(IxiTypography.Heading.H6.medium)
            h6500.setText("H6 Regular")
            h6500.setTypography(IxiTypography.Heading.H6.regular)


            bodyLargeBold.setText("Body Large Bold -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
//            bodyLargeBold.setTypography(IxiTypography.Body.Large.bold)
            bodyLargeItalic.setText("Body Large Italic ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
//            bodyLargeItalic.setTypography(IxiTypography.Body.Large.italics)
            bodyLargeMed.setText("Body Large Medium ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            bodyLargeMed.setTypography(IxiTypography.Body.Large.medium)
            bodyLargeReg.setText("Body Large Regular ->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
//            bodyLargeReg.setTypography(IxiTypography.Body.Large.regular)
            bodyLargeUnderlined.setText("Body large Underlined->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
//            bodyLargeUnderlined.setTypography(IxiTypography.Body.Large.underline)
            bodyLargeStrike.setText("Body large strikethrough->Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
//            bodyLargeStrike.setTypography(IxiTypography.Body.Large.strikeThrough)



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
            textMaxLines1.setText("Text with maxlines set to 1 -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            textMaxLines1.setTypography(IxiTypography.Body.Medium.medium)
            textMaxLines2.setText("Text with maxlines set to 2 -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            textMaxLines2.setTypography(IxiTypography.Body.Medium.medium)
            textOverflowClip.setText("Text Overflow clip -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            textOverflowClip.setTypography(IxiTypography.Body.Medium.medium)
            textOverflowVisible.setText("Text Overflow Visible -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            textOverflowVisible.setTypography(IxiTypography.Body.Medium.medium)
            textOverflowEllipsis.setText("Text Overflow Ellipsis -> Glide is going to be an epic Design system and we all are gonna need to follow it with utter most disipline")
            textOverflowEllipsis.setTypography(IxiTypography.Body.Medium.medium)
        }
    }
}
