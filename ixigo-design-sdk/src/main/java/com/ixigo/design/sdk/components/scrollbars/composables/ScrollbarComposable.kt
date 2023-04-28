package com.ixigo.design.sdk.components.scrollbars.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R

@Composable
fun ScrollBar(
    itemCount: Int,
    position: Int,
    minKnobWidth: Float
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(10.dp), color = colorResource(id = R.color.n80))
    ) {
        val calculatedKnobWidth = maxWidth / itemCount
        val knobSize = minKnobWidth.coerceAtLeast(calculatedKnobWidth.value)
        val knobPosition = position * calculatedKnobWidth.value
        val offset = knobPosition.coerceIn(0f, (maxWidth - knobSize.dp).value).apply {
            animateDpAsState(targetValue = this.dp)
        }

        Box(
            modifier = Modifier
                .width(knobSize.dp)
                .fillMaxHeight()
                .offset(x = offset.dp)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = colorResource(id = R.color.b500)
                )
        )
    }
}