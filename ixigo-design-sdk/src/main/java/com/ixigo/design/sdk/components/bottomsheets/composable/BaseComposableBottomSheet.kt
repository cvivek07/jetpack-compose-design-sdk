package com.ixigo.design.sdk.components.bottomsheets.composable

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
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
import com.ixigo.design.sdk.SdkManager
import com.ixigo.design.sdk.components.buttons.composable.ComposablePrimaryButton
import com.ixigo.design.sdk.components.buttons.composable.ComposableSecondaryButton
import com.ixigo.design.sdk.components.buttons.styles.ButtonSize
import com.ixigo.design.sdk.components.inlinealert.composable.ComposableInlineAlert
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.components.styles.IxiShape
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

@Composable
fun BaseBottomSheetComposable(
    @DrawableRes image: Int? = null,
    titleText: String? = null,
    @ColorRes imageBackgroundColor: Int? = null,
    titleStyle: TextStyle = IxiTypography.Heading.H5.regular.copy(color = colorResource(id = R.color.black)),
    bodyText: String? = null,
    bodyStyle: TextStyle = IxiTypography.Body.Medium.regular,
    masterTitleText: String? = null,
    masterSubtitleText: String? = null,
    primaryButtonText: String? = null,
    secondaryButtonText: String? = null,
    closeActionListener: (() -> Unit)? = null,
    iconSize: Dp? = 80.dp,
    secondaryActionListener: (() -> Unit)? = null,
    primaryActionListener: (() -> Unit)? = null,
    view: View? = null,
    enablePointer: Boolean = false,
    inlineAlertText: String? = null,
    inlineAlertIxiColor: IxiColor? = null,
    closeActionAlignment: Alignment? = Alignment.CenterEnd
) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier
        .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(colorResource(id = R.color.white))) {
            Box() {
                Column {
                    masterTitleText?.let {
                        MasterTitle(
                            modifier = Modifier.padding(top = 21.dp),
                            text = masterTitleText,
                            subtitleText = masterSubtitleText,
                            closeActionListener = closeActionListener,
                            alignment = Alignment.Center,
                            closeActionAlignment = closeActionAlignment ?: Alignment.CenterEnd
                        )
                    }
                    image?.let {
                        if(imageBackgroundColor==null && masterTitleText==null){
                            Spacer(modifier = Modifier.height(26.dp))
                        }
                        BannerImage(
                            logo = it,
                            backgroundColor = imageBackgroundColor,
                            iconSize = iconSize
                        )
                    }
                }
                if(enablePointer) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Pointer(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
            Box(modifier = Modifier
                .verticalScroll(scrollState)
                .weight(1f, false)
                .padding(top = 30.dp, bottom = 15.dp)) {
                if(view!=null){
                    AndroidView(
                        factory = {
                            view
                        }, modifier = Modifier
                            .fillMaxWidth())
                } else {
                    BottomSheetContent(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        heading = { BottomSheetTextComposable(titleText, style = titleStyle) },
                        subtitle = { BottomSheetTextComposable(text = bodyText, style = bodyStyle) },
                        inlineAlertText = inlineAlertText,
                        inlineAlertIxiColor = inlineAlertIxiColor?: IxiColor.Neutral
                    )
                }
            }
            if(masterTitleText!=null){
                Divider(modifier = Modifier.fillMaxWidth(),thickness = 1.dp, color = colorResource(id = R.color.n100))
            }
            Spacer(modifier = Modifier.height(15.dp))
            Box() {
                BottomSheetButtons(
                    primaryButtonText = primaryButtonText,
                    secondaryButtonText = secondaryButtonText,
                    primaryActionListener = primaryActionListener,
                    secondaryActionListener = secondaryActionListener,
                    spacedButtons = masterTitleText!=null
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
private fun BottomSheetTextComposable(text: String?, style: TextStyle) {
    if (text != null && text.isNotEmpty()) {
        TypographyText(
            text = text, textStyle = style, textAlign = TextAlign.Center
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
    inlineAlertText: String? = null,
    inlineAlertIxiColor: IxiColor = IxiColor.Neutral,
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
        inlineAlertText?.let {
            Spacer(modifier = Modifier.height(20.dp))
            ComposableInlineAlert(text = it, ixiColor = inlineAlertIxiColor.mapIxiColorToInlineAlertColor(inlineAlertIxiColor), textAlignment = TextAlign.Center)
        }
    }
}

@Composable
private fun BottomSheetButtons(
    secondaryButtonText: String? = null,
    secondaryActionListener: (() -> Unit)? = null,
    primaryButtonText: String? = null,
    primaryActionListener: (() -> Unit)? = null,
    spacedButtons: Boolean = false
) {
    Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        secondaryButtonText?.let {
            Box(
                modifier = Modifier
                    .then(if (spacedButtons) Modifier else Modifier.weight(1f))
                    .padding(start = 20.dp)
            ) {
                Box(
                    modifier = if (primaryButtonText == null) Modifier.align(Alignment.Center) else Modifier.align(
                        Alignment.TopEnd
                    )
                ) {
                    ComposableSecondaryButton(
                        text = secondaryButtonText,
                        color = SdkManager.getConfig().project.color,
                        shape = IxiShape.RegularShape,
                        size = ButtonSize.Large,
                        width = -2,
                        onClick = secondaryActionListener ?: {})
                }
            }
            Spacer(modifier = Modifier.width(30.dp))
        }
        primaryButtonText?.let {
            Box(
                modifier = Modifier
                    .then(if (spacedButtons) Modifier else Modifier.weight(1f))
                    .padding(end = 20.dp)
            ) {
                Box(
                    modifier = Modifier.then(
                        if (secondaryButtonText == null) Modifier.align(
                            Alignment.Center
                        ) else Modifier.align(Alignment.TopStart)
                    )
                ) {
                    ComposablePrimaryButton(
                        text = primaryButtonText,
                        color = SdkManager.getConfig().project.color,
                        shape = IxiShape.RegularShape,
                        size = ButtonSize.Large,
                        width = -2,
                        onClick = primaryActionListener ?: {})
                }
            }
        }
    }
}

@Composable
private fun MasterTitle(modifier: Modifier = Modifier, alignment: Alignment  = Alignment.Center, text:String, subtitleText:String?= null, closeActionListener: (() -> Unit)? = null, closeActionAlignment: Alignment = Alignment.CenterEnd){
    Column {
        Box(modifier = modifier.fillMaxWidth(), contentAlignment = alignment){
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                .fillMaxWidth()){
                TypographyText(text = text, textAlign = TextAlign.Center, textStyle = IxiTypography.Heading.H6.regular, modifier = Modifier.padding(horizontal = 56.dp))
            }
            closeActionListener?.let {
                Box(modifier = Modifier
                    .align(closeActionAlignment)
                    .padding(start = 26.dp, end = 26.dp, top = 4.dp)
                    .clickable {
                        closeActionListener.invoke()
                    }){
                    Icon(imageVector = Icons.Filled.Close, contentDescription = null, modifier = Modifier.size(22.dp))
                }
            }
        }
        subtitleText?.let {
            TypographyText(
                text = it,
                textAlign = TextAlign.Center,
                textStyle = IxiTypography.Body.Small.regular,
                modifier = Modifier.padding(horizontal = 48.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(modifier = Modifier.height(1.dp), color = colorResource(id = R.color.n100))
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
        inlineAlertText = "This is a placeholder",
        masterTitleText = "Test",
        masterSubtitleText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer s",
        closeActionListener = {},
        closeActionAlignment = Alignment.CenterStart
    )
}
