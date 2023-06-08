package com.ixigo.design.sdk.components.bottomsheets.composable

import android.text.SpannableString
import android.text.Spanned
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
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
    primaryButtonHelperText: String? = null,
    secondaryButtonHelperText: String? = null,
    buttonMinWidth: Dp,
    buttonMaxWidth: Dp,
    closeActionListener: (() -> Unit)? = null,
    iconSize: Int? = 80,
    secondaryActionListener: (() -> Unit)? = null,
    primaryActionListener: (() -> Unit)? = null,
    view: View? = null,
    enablePointer: Boolean = false,
    inlineAlertText: String? = null,
    inlineAlertIxiColor: IxiColor? = null,
    closeActionAlignment: Alignment? = Alignment.CenterEnd,
    showBottomDivider: Boolean = false,
    @DrawableRes closeIcon: Int? = null,
    showFullWidthButtons: Boolean = false
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp, 30.dp, 0.dp, 0.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(colorResource(id = R.color.white))
        ) {
            Box() {
                Column {
                    masterTitleText?.let {
                        MasterTitle(
                            modifier = Modifier.padding(top = 21.dp),
                            text = masterTitleText,
                            subtitleText = masterSubtitleText,
                            closeActionListener = closeActionListener,
                            alignment = Alignment.Center,
                            closeActionAlignment = closeActionAlignment ?: Alignment.CenterEnd,
                            closeIcon = closeIcon
                        )
                    }
                    image?.let {
                        if (imageBackgroundColor == null && masterTitleText == null) {
                            Spacer(modifier = Modifier.height(26.dp))
                        }
                        BannerImage(
                            logo = it,
                            backgroundColor = imageBackgroundColor,
                            iconSize = iconSize
                        )
                    }
                }
                if (enablePointer) {
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
                .weight(1f, false)
                .padding(top = 20.dp, bottom = 20.dp)) {
                if(view!=null){
                    AndroidView(
                        factory = {
                            view
                        }, modifier = Modifier
                            .fillMaxWidth()
                    )
                } else {
                    BottomSheetContent(
                        modifier = Modifier.padding(horizontal = 20.dp),
                        heading = { BottomSheetTextComposable(titleText, style = titleStyle) },
                        subtitle = {
                            BottomSheetTextComposable(
                                text = bodyText,
                                style = bodyStyle
                            )
                        },
                        inlineAlertText = inlineAlertText,
                        inlineAlertIxiColor = inlineAlertIxiColor ?: IxiColor.Neutral
                    )
                }
            }
            if (showBottomDivider) {
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = colorResource(id = R.color.n100)
                )
            }
            Box() {
                BottomSheetButtons(
                    buttonMaxWidth = buttonMaxWidth,
                    buttonMinWidth = buttonMinWidth,
                    primaryButtonText = primaryButtonText,
                    secondaryButtonText = secondaryButtonText,
                    primaryActionListener = primaryActionListener,
                    secondaryActionListener = secondaryActionListener,
                    primaryButtonHelperText = primaryButtonHelperText,
                    secondaryButtonHelperText = secondaryButtonHelperText,
                    showFullWidthButtons = showFullWidthButtons
                )
            }
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
    iconSize: Int? = null
) {
    Box(
        modifier = modifier.then(
            if (backgroundColor != null)
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
                .then(if (iconSize == null) Modifier.size(25.dp) else Modifier.size(iconSize * 1.dp))
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun BottomSheetContent(
    modifier: Modifier = Modifier,
    heading: @Composable (() -> Unit)?,
    subtitle: @Composable (() -> Unit)?,
    inlineAlertText: String? = null,
    inlineAlertIxiColor: IxiColor = IxiColor.Neutral
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
            ComposableInlineAlert(text = SpannableString(it), ixiColor = inlineAlertIxiColor.mapIxiColorToInlineAlertColor(inlineAlertIxiColor), textAlignment = TextAlign.Center)
            ComposableInlineAlert(
                text = SpannableString(it),
                ixiColor = inlineAlertIxiColor.mapIxiColorToInlineAlertColor(inlineAlertIxiColor),
                textAlignment = TextAlign.Center
            )
        }
    }
}

@Composable
private fun BottomSheetButtons(
    buttonMinWidth: Dp,
    buttonMaxWidth: Dp,
    secondaryButtonText: String? = null,
    secondaryButtonHelperText: String? = null,
    secondaryActionListener: (() -> Unit)? = null,
    primaryButtonText: String? = null,
    primaryButtonHelperText: String? = null,
    primaryActionListener: (() -> Unit)? = null,
    showFullWidthButtons: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = if (primaryButtonText == null || secondaryButtonText == null) Arrangement.Center else Arrangement.SpaceBetween
    ) {
        secondaryButtonText?.let {
            Box(
                modifier = if(showFullWidthButtons) {
                    Modifier.weight(1f)
                } else {
                    Modifier
                }
            ) {
                Box(
                    modifier = if (primaryButtonText == null) Modifier.align(Alignment.Center) else Modifier
                        .align(
                            Alignment.TopEnd
                        )
                        .padding(vertical = 15.dp)
                ) {
                    Column() {
                        ComposableSecondaryButton(
                            text = secondaryButtonText,
                            color = SdkManager.getConfig().project.color,
                            shape = IxiShape.RegularShape,
                            size = ButtonSize.Large,
                            minWidth = buttonMinWidth,
                            maxWidth = buttonMaxWidth,
                            onClick = secondaryActionListener ?: {}, fullWidth = showFullWidthButtons)

                        secondaryButtonHelperText?.let {
                            TypographyText(
                                text = it,
                                textStyle = IxiTypography.Body.XSmall.regular,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                color = colorResource(id = R.color.n600)
                            )
                        }
                    }
                }
            }
        }

        if(primaryButtonText != null && secondaryButtonText != null) {
            Spacer(modifier = Modifier.width(20.dp))
        }

        primaryButtonText?.let {
            Box(
                modifier = if(showFullWidthButtons) {
                    Modifier.weight(1f)
                } else {
                    Modifier
                }
            ) {
                Box(
                    modifier = Modifier
                        .then(
                            if (secondaryButtonText == null) Modifier.align(
                                Alignment.Center
                            ) else Modifier.align(Alignment.TopStart)
                        )
                        .padding(vertical = 15.dp)
                ) {
                    Column() {
                        ComposablePrimaryButton(
                            text = primaryButtonText,
                            color = SdkManager.getConfig().project.color,
                            shape = IxiShape.RegularShape,
                            size = ButtonSize.Large,
                            minWidth = buttonMinWidth,
                            maxWidth = buttonMaxWidth,
                            onClick = primaryActionListener ?: {}, fullWidth = showFullWidthButtons)

                        primaryButtonHelperText?.let {
                            TypographyText(
                                text = primaryButtonHelperText,
                                textStyle = IxiTypography.Body.XSmall.regular,
                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                color = colorResource(id = R.color.n600)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun MasterTitle(
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    text: String,
    subtitleText: String? = null,
    closeActionListener: (() -> Unit)? = null,
    closeActionAlignment: Alignment = Alignment.CenterEnd,
    @DrawableRes closeIcon: Int? = null
) {
    Column {
        Box(modifier = modifier.fillMaxWidth(), contentAlignment = alignment) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxWidth()
            ) {
                TypographyText(
                    text = text,
                    textAlign = TextAlign.Center,
                    textStyle = IxiTypography.Heading.H6.regular,
                    modifier = Modifier.padding(horizontal = 56.dp)
                )
            }
            closeActionListener?.let {
                Box(modifier = Modifier
                    .align(closeActionAlignment)
                    .padding(start = 26.dp, end = 26.dp, top = 4.dp)
                    .clickable {
                        closeActionListener.invoke()
                    }) {
                    if (closeIcon != null) {
                        Icon(
                            painter = painterResource(id = closeIcon),
                            contentDescription = null,
                            Modifier.size(22.dp)
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = null,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
        }
        subtitleText?.let {
            TypographyText(
                text = it,
                textAlign = TextAlign.Center,
                textStyle = IxiTypography.Body.Small.regular,
                modifier = Modifier
                    .padding(start = 48.dp, end = 48.dp, top = 5.dp)
                    .align(Alignment.CenterHorizontally)
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
        closeActionAlignment = Alignment.CenterStart,
        buttonMinWidth = 150.dp,
        buttonMaxWidth = 300.dp,
        secondaryButtonText = "Hello",
        secondaryButtonHelperText = "Hey!"
    )
}
