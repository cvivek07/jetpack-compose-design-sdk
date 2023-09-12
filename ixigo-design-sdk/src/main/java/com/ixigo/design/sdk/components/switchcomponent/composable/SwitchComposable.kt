package com.ixigo.design.sdk.components.switchcomponent.composable

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
    selectedId: String,
    switchPaletteColor: Color,
    selectedSwitchColor: Color,
    selectedLabelTextColor: Color,
    unselectedLabelTextColor: Color,
    onSwitchChanged: (selectedOptionId: String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(pillPadding)
            .clip(pillShape)
            .background(switchPaletteColor)
    ) {
        options.forEach { option ->
            val isOptionSelected = isOptionSelected(selectedId, option)
            val switchBackground =
                if (isOptionSelected) selectedSwitchColor else switchPaletteColor
            val labelTextColor =
                if (isOptionSelected) selectedLabelTextColor else unselectedLabelTextColor

            Box(
                modifier = Modifier
                    .shadow(
                        if (isOptionSelected) selectedPillElevation else 0.dp,
                        pillShape
                    )
                    .padding(pillPadding)
                    .clip(pillShape)
                    .background(switchBackground)
                    .clickableWithoutEffect {
                        if (!isOptionSelected) {
                            onSwitchChanged.invoke(option.id)
                        }
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

@Composable
fun SelectionSwitchWithState(
    options: List<SwitchOption>,
    switchPaletteColor: Color,
    selectedSwitchColor: Color,
    selectedLabelTextColor: Color,
    unselectedLabelTextColor: Color,
    onSwitchChanged: (selectedOptionId: String) -> Unit
) {
    val selectedOption = options.filter { it.isSelected }[0]
    val selectedIdState = remember {
        mutableStateOf(selectedOption.id)
    }

    Row(
        modifier = Modifier
            .padding(pillPadding)
            .clip(pillShape)
            .background(switchPaletteColor)
    ) {
        options.forEach { option ->
            val isOptionSelected = isOptionSelected(selectedIdState, option)
            val switchBackground =
                if (isOptionSelected) selectedSwitchColor else switchPaletteColor
            val labelTextColor =
                if (isOptionSelected) selectedLabelTextColor else unselectedLabelTextColor

            Box(
                modifier = Modifier
                    .shadow(
                        if (isOptionSelected) selectedPillElevation else 0.dp,
                        pillShape
                    )
                    .padding(pillPadding)
                    .clip(pillShape)
                    .background(switchBackground)
                    .clickableWithoutEffect {
                        if (!isOptionSelected) {
                            selectedIdState.value = option.id
                            onSwitchChanged.invoke(option.id)
                        }
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

private fun isOptionSelected(selectedId: String, option: SwitchOption): Boolean {
    return selectedId == option.id
}

private fun isOptionSelected(selectedIdState: MutableState<String>, option: SwitchOption): Boolean {
    return selectedIdState.value == option.id
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
    val id: String,
    val title: String,
    val isSelected: Boolean
)

@Preview
@Composable
fun Preview() {
    val oneWaySwitch = SwitchOption("ONE_WAY", "One Way", true)
    val roundTripSwitch = SwitchOption("ROUND_TRIP", "Round Trip", false)
    val context = LocalContext.current
    SelectionSwitchWithState(
        options = listOf(oneWaySwitch, roundTripSwitch),
        switchPaletteColor = colorResource(id = R.color.n60),
        selectedSwitchColor = colorResource(id = R.color.n0),
        selectedLabelTextColor = colorResource(id = R.color.n800),
        unselectedLabelTextColor = colorResource(id = R.color.n800),
        onSwitchChanged = {
            when(it) {
                oneWaySwitch.title -> {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
                roundTripSwitch.title -> Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    )
}