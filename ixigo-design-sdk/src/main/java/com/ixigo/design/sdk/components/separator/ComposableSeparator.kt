package com.ixigo.design.sdk.components.separator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.ixigo.design.sdk.R

@Composable
fun ComposableSeparator(){
    Divider(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = colorResource(id = R.color.n100)))
}