package com.ixigo.design.sdk.components.bottomsheets.composable

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.buttons.IxiPrimaryButton
import com.ixigo.design.sdk.components.buttons.IxiSecondaryButton
import com.ixigo.design.sdk.components.styles.IxiTypography

@Composable
fun BaseBottomSheetComposable(
    @DrawableRes image: Int? = null,
    titleText: String? = null,
    @ColorRes imageBackgroundColor: Int? = null,
    titleStyle: TextStyle = IxiTypography.Heading.H5.regular.copy(color = colorResource(id = R.color.black)),
    bodyText: String? = null,
    bodyStyle: TextStyle = IxiTypography.Body.Medium.regular,
    masterTitleText: String? = null,
    primaryButton: IxiPrimaryButton? = null,
    secondaryButton: IxiSecondaryButton? = null,
    closeActionListener: (() -> Unit)? = null,
    isToolbarCentered:Boolean? = false,
    iconSize: Dp? = 80.dp
) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(colorResource(id = R.color.white))) {
            Box {
                Column {
                    masterTitleText?.let {
                        if(isToolbarCentered == true){
                            MasterTitle(modifier = Modifier.padding(top = 21.dp), text = masterTitleText, closeActionListener = closeActionListener, alignment = Alignment.Center)
                        } else if(isToolbarCentered == false){
                            MasterTitle(modifier = Modifier.padding(top = 21.dp), text = masterTitleText, closeActionListener = closeActionListener, alignment = Alignment.TopStart)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                    image?.let {
                        if(imageBackgroundColor==null && masterTitleText==null){
                            Spacer(modifier = Modifier.height(45.dp))
                        }
                        BannerImage(
                            logo = it,
                            backgroundColor = imageBackgroundColor,
                            iconSize = iconSize
                        )
                    }
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    Pointer(modifier = Modifier
                        .padding(vertical = 10.dp)
                        .align(Alignment.Center))
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            BottomSheetContent(
                modifier = Modifier.padding(horizontal = 20.dp),
                heading = { BottomSheetTextComposable(titleText, style = titleStyle) },
                subtitle = { BottomSheetTextComposable(text = bodyText, style = bodyStyle) }
            )
            Spacer(modifier = Modifier.height(30.dp))
            BottomSheetButtons(
                positiveAction = primaryButton,
                negativeAction = secondaryButton
            ) {

            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
private fun BottomSheetTextComposable(text: String?, style: TextStyle) {
    if (text != null) {
        Text(
            text = text, style = style, textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Pointer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(30.dp)
            .height(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(id = R.color.n300))
    )
}

@Composable
private fun BannerImage(
    modifier: Modifier = Modifier,
    @ColorRes backgroundColor: Int? = R.color.r50,
    @DrawableRes logo: Int,
    iconSize: Dp? = null
) {
    Box(
        modifier = modifier.then(
            if (backgroundColor!=null)
                Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 250.dp)
                    .background(colorResource(id = backgroundColor))
            else
                Modifier
                    .clipToBounds()
                    .fillMaxWidth()
        ), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logo),
            contentDescription = null,
            Modifier
                .then(if (iconSize == null) Modifier.size(25.dp) else Modifier.size(iconSize))
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun BottomSheetContent(
    heading: @Composable (() -> Unit)?,
    subtitle: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()) {
        heading?.let {
            heading()
        }
        subtitle?.let {
            Spacer(
                modifier = modifier
                    .height(20.dp)
                    .clipToBounds()
            )
            subtitle()
        }
    }
}

@Composable
private fun BottomSheetButtons(
    negativeAction: IxiSecondaryButton? = null,
    negativeActionListener: (() -> Unit)? = null,
    positiveAction: IxiPrimaryButton? = null,
    positiveActionListener: (() -> Unit)? = null
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        negativeAction?.let {
            Box(modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp)) {
                AndroidView(
                    factory = {
                        negativeAction.apply {
                            setOnClickListener {
                                negativeActionListener?.invoke()
                            }
                        }
                    }, modifier = Modifier.align(Alignment.TopEnd)
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
        }
        positiveAction?.let {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 20.dp)
            ) {
                AndroidView(
                    factory = {
                        positiveAction.apply {
                            setOnClickListener {
                                positiveActionListener?.invoke()
                            }
                        }
                    }, modifier = Modifier.then(if(negativeAction==null) Modifier.align(Alignment.Center) else Modifier.align(Alignment.TopStart))
                )
            }
        }
    }
}

@Composable
private fun MasterTitle(modifier: Modifier = Modifier, alignment: Alignment  = Alignment.Center, text:String, closeActionListener: (() -> Unit)? = null){
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = alignment){
        Text(text = text, textAlign = TextAlign.Center, style = IxiTypography.Heading.H6.regular, modifier = Modifier.padding(horizontal = 20.dp))
        closeActionListener?.let {
            Box(modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .clickable {
                    closeActionListener.invoke()
                }){
                Icon(imageVector = Icons.Filled.Close, contentDescription = null, modifier = Modifier.size(22.dp))
            }
        }
    }
}


@Preview(showBackground = false)
@Composable
fun BottomSheetView() {
    BaseBottomSheetComposable(
        titleText = "Example",
        bodyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer venenatis volutpat tortor quis ultrices. Proin posuere dictum aliquet. In quis tempor sapien, eget faucibus nisl. Maecenas non nibh ultricies dui iaculis fringilla ac nec mauris. Sed eget aliquam ante. Nunc ex",
        image = R.drawable.ic_launcher_background,
        imageBackgroundColor = R.color.r50,
    )
}
