package com.ixigo.design.sdk.components.text.composable

import androidx.annotation.ColorRes
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun ClickableTextComposable(
    text: String,
    highlights: List<Highlight>,
    modifier: Modifier = Modifier,
    textStyle: TextStyle,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    @ColorRes highlightColor: Int,
) {
    val textData = textData(highlights, text)
    val annotatedString = annotatedString(textData, highlightColor)

    ClickableText(
        text = annotatedString,
        style = textStyle.copy(letterSpacing = 0.sp, textAlign = textAlign),
        onClick = { offset ->
            textData.forEach { annotatedStringData ->
                if (annotatedStringData.tag != null) {
                    annotatedString.getStringAnnotations(
                        tag = annotatedStringData.tag,
                        start = offset,
                        end = offset,
                    ).firstOrNull()?.let {
                        annotatedStringData.onClick?.invoke(it)
                    }
                }
            }
        },
        modifier = modifier,
        softWrap = softWrap,
        overflow = overflow,
        maxLines = maxLines
    )
}

private fun textData(
    highlights: List<Highlight>,
    text: String
): List<TextData> {
    val textData = mutableListOf<TextData>()
    if (highlights.isEmpty()) {
        textData.add(
            TextData(
                text = text
            )
        )
    } else {
        var startIndex = 0
        highlights.forEachIndexed { i, link ->
            val endIndex = text.indexOf(link.text)
            if (endIndex == -1) {
                throw Exception("Highlighted text mismatch")
            }
            textData.add(
                TextData(
                    text = text.substring(startIndex, endIndex)
                )
            )
            textData.add(
                TextData(
                    text = link.text,
                    tag = link.text,
                    onClick = {
                        link.onClick(it.item)
                    }
                )
            )
            startIndex = endIndex + link.text.length
            if (i == highlights.lastIndex && startIndex < text.length) {
                textData.add(
                    TextData(
                        text = text.substring(startIndex, text.length)
                    )
                )
            }
        }
    }
    return textData
}

@Composable
private fun annotatedString(
    textData: List<TextData>,
    highlightColor: Int
) = buildAnnotatedString {
    textData.forEach { linkTextData ->
        if (linkTextData.tag != null) {
            pushStringAnnotation(
                tag = linkTextData.tag,
                annotation = linkTextData.text,
            )
            withStyle(
                style = SpanStyle(
                    color = colorResource(id = highlightColor),
                    textDecoration = TextDecoration.Underline
                ),
            ) {
                append(linkTextData.text)
            }
            pop()
        } else {
            append(linkTextData.text)
        }
    }
}

data class Highlight(
    val text: String,
    val onClick: (data: String) -> Unit
)

data class TextData(
    val text: String,
    val tag: String? = null,
    val onClick: ((data: AnnotatedString.Range<String>) -> Unit)? = null
)