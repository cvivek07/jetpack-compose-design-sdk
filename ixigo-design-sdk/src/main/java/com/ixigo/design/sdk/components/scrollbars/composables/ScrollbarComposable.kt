package com.ixigo.design.sdk.components.scrollbars.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.R

@Composable
fun ScrollBar(
    itemCount: Int,
    position: Int
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(10.dp), color = colorResource(id = R.color.n80))
    ) {
        val knobSize = maxWidth.value / itemCount
        val knobPosition = position * knobSize

        val offset by animateDpAsState(knobPosition.dp)

        Box(
            modifier = Modifier
                .width(knobSize.dp)
                .fillMaxHeight()
                .offset(x = offset)
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = colorResource(id = R.color.b500)
                )
        )
    }
}