package com.ixigo.design.sdk.components.imageutils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.ixigo.design.sdk.utils.DrawablePainter

data class ImageData(
    @DrawableRes val drawableRes: Int?,
    val drawable: Drawable?,
    val drawableBitmap: Bitmap?,
    val url: String?,
    val height: Dp?,
    val width: Dp?
)

@Composable
fun ImageData.getPainterForImage(): Painter? {
    return if (drawable != null) {
        DrawablePainter(drawable)
    } else if (drawableRes != null) {
        painterResource(id = drawableRes)
    } else if (drawableBitmap != null) {
        BitmapPainter(drawableBitmap.asImageBitmap())
    } else {
        null
    }
}