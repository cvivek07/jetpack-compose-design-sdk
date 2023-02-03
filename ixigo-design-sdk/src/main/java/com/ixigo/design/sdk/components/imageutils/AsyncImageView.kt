package com.ixigo.design.sdk.components.imageutils


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun AsyncImageView(
    modifier: Modifier,
    url: String,
    @DrawableRes placeholder: Int?,
    @StringRes contentDes: Int?,
    shape: Shape = RectangleShape,
    scale: ContentScale = ContentScale.Crop
) {
    // Using Coil Image Loading Library. In case we want to use Any other Image Loading Library call it here
    CoilImage(
        modifier = modifier,
        url = url,
        placeholder = placeholder,
        contentDes = contentDes,
        shape = shape,
        scale = scale
    )
}


@Composable
fun CoilImage(
    modifier: Modifier,
    url: String,
    @DrawableRes placeholder: Int?,
    @StringRes contentDes: Int?,
    shape: Shape = RectangleShape,
    scale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        placeholder = placeholder?.let { painterResource(it) },
        contentDescription = contentDes?.let { stringResource(it) },
        contentScale = scale,
        modifier = modifier.clip(shape = shape)
    )
}
