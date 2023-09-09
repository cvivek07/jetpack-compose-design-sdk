package com.ixigo.design.sdk.components.switchcomponent.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

private val pillShape = RoundedCornerShape(20.dp)
private val pillPadding = 5.dp
private val selectedPillElevation = 10.dp
private val textHorizontalPadding = 8.dp
private val textVerticalPadding = 4.dp

@Composable
fun SelectionSwitch(
    options: List<SwitchOption>,
    switchPaletteColor: Color,
    selectedSwitchColor: Color,
    selectedLabelTextColor: Color,
    unselectedLabelTextColor: Color,
    onSwitchChanged: (selectedOption: String) -> Unit
) {
    val selectedOption = getSelectedOption(options)
    val selectedState = remember { mutableStateOf(selectedOption) }

    Row(
        modifier = Modifier
            .padding(pillPadding)
            .clip(pillShape)
            .background(switchPaletteColor)
    ) {
        options.forEach { option ->

            val switchBackground =
                if (selectedState.value == option) selectedSwitchColor else switchPaletteColor
            val labelTextColor =
                if (selectedState.value == option) selectedLabelTextColor else unselectedLabelTextColor

            Box(
                modifier = Modifier
                    .shadow(
                        if (selectedState.value == option) selectedPillElevation else 0.dp,
                        pillShape
                    )
                    .padding(pillPadding)
                    .clip(pillShape)
                    .background(switchBackground)
                    .clickableWithoutEffect {
                        selectedState.value = option
                        onSwitchChanged.invoke(option.title)
                    }
            ) {
                TypographyText(
                    modifier = Modifier.padding(textHorizontalPadding, textVerticalPadding),
                    text = option.title,
                    textStyle = IxiTypography.Body.Medium.regular,
                    color = labelTextColor
                )
            }
        }
    }
}

private fun getSelectedOption(options: List<SwitchOption>): SwitchOption {
    for (option in options) {
        if (option.isSelected) return option
    }
    return options[0]
}

fun Modifier.clickableWithoutEffect(func: () -> Unit): Modifier {
    return this.clickable(
        interactionSource = MutableInteractionSource(),
        indication = null
    ) {
        func.invoke()
    }
}

data class SwitchOption(
    val title: String,
    val isSelected: Boolean
)

@Preview
@Composable
fun Preview() {
    SelectionSwitch(
        options = listOf(SwitchOption("One Way", true), SwitchOption("Round Trip", false)),
        switchPaletteColor = colorResource(id = R.color.n60),
        selectedSwitchColor = colorResource(id = R.color.n0),
        selectedLabelTextColor = colorResource(id = R.color.n800),
        unselectedLabelTextColor = colorResource(id = R.color.n800),
        onSwitchChanged = {}
    )
}