package com.ixigo.design_sdk.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ixigo.design_sdk.IxiTypography

@Composable
fun IxigoButton(text: String = "Compose  Button", onClick: () -> Unit = {}) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .padding(all = Dp(10F))
                .fillMaxWidth(),
            enabled = true,
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),
            shape = MaterialTheme.shapes.medium,
        )
        {
            Text(
                text = text,
                style = IxiTypography.h1.toTextStyle()
            )
        }

}

fun ComposeView.setContent() {
    setContent {
        IxigoButton()
    }
}

fun ComposeView.setTextContent() {
    setContent {
        Text(text = "This is the textview in Compose", color = Color.Blue)
    }
}