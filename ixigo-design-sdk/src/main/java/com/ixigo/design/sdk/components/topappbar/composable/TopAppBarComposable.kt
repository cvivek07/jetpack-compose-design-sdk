package com.ixigo.design.sdk.components.topappbar.composable

import android.content.Context
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.imageutils.getPainterForImage
import com.ixigo.design.sdk.components.segmentedcontrol.composable.SegmentedControl
import com.ixigo.design.sdk.components.srp.composables.SrpComposable
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.tabs.IxiTabLayout
import com.ixigo.design.sdk.components.tabs.TabType
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.topappbar.TabDataItem
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider


@Composable
fun MainToolBar(
    homeIcon: ImageData? = ImageData.createFromRes(R.drawable.left_arrow),
    title: String? = null,
    subTitle: String? = null,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int> = listOf()
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider,
        disabledIds = disabledIds
    ) {
        Column(Modifier.weight(1f)) {
            if (title != null) {
                TypographyText(
                    text = title,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textStyle = if (subTitle.isNullOrEmpty()) {
                        IxiTypography.Heading.H5.regular
                    } else {
                        IxiTypography.Heading.H6.regular
                    }
                )
            }
            if (!subTitle.isNullOrBlank()) {
                TypographyText(
                    text = subTitle,
                    textStyle = IxiTypography.Body.XSmall.regular,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                )
            }
        }
        if (menuProvider == null || menuProvider.provideMenu().isEmpty()) {
            Spacer(modifier = Modifier.width(40.dp))
        }
    }
}

@Composable
fun SearchBar(
    homeIcon: ImageData = ImageData.createFromRes(R.drawable.left_arrow),
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int> = listOf(),
    content: @Composable RowScope.() -> Unit
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider,
        disabledIds = disabledIds,
    ) {
        content()
    }
}

@Composable
fun AutoCompleteTextField(
    content: @Composable RowScope.() -> Unit
) {
    Row {
        content()
    }

}

@Composable
fun SegmentedControlBar(
    homeIcon: ImageData? = ImageData.createFromRes(R.drawable.left_arrow),
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int> = listOf(),
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    onItemSelection: (selectedItemIndex: Int) -> Unit
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider,
        disabledIds = disabledIds
    ) {
        SegmentedControl(
            items = items,
            defaultSelectedItemIndex = defaultSelectedItemIndex,
            modifier = Modifier
                .height(36.dp)
                .weight(1f)
                .padding(
                    end = 15.dp
                ),
            onItemSelection = onItemSelection

        )
    }
}

@Composable
fun SrpBar(
    homeIcon: ImageData? = ImageData.createFromRes(R.drawable.left_arrow),
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int> = listOf(),
    data: SrpModel?,
    onClick: () -> Unit
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider,
        disabledIds = disabledIds
    ) {
        if (data != null) {
            SrpComposable(
                data = data,
                onClick = onClick,
                modifier = Modifier
                    .height(36.dp)
                    .weight(1f)
                    .padding(
                        end = 15.dp
                    ),
            )
        }
    }
}

fun getRoundRect(context: Context, @ColorRes color: Int): Drawable {
    val rectShape = RectShape()
    val shapeDrawable = ShapeDrawable(rectShape)
    shapeDrawable.paint.color = ContextCompat.getColor(context, color)
    shapeDrawable.paint.style = Paint.Style.FILL
    shapeDrawable.paint.isAntiAlias = true
    shapeDrawable.paint.flags = Paint.ANTI_ALIAS_FLAG
    return shapeDrawable
}

@Composable
fun TabbedBar(
    modifier: Modifier = Modifier,
    homeIcon: ImageData? = ImageData.createFromRes(R.drawable.left_arrow),
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int> = listOf(),
    data: List<TabDataItem>,
    adapter: FragmentStateAdapter?,
    viewPager: ViewPager2,
    tabType: TabType = TabType.LINE
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider,
        modifier = modifier,
        disabledIds = disabledIds
    ) {

        AndroidView(factory = {
            val tabLayout = IxiTabLayout(it)
            tabLayout.tabMode = MODE_SCROLLABLE
            tabLayout.tabType = tabType
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager2(viewPager, data)
            tabLayout
        })
    }
}


@Composable
fun BasicToolbar(
    modifier: Modifier = Modifier,
    homeIcon: ImageData? = ImageData.createFromRes(R.drawable.left_arrow),
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    disabledIds: List<Int>,
    content: @Composable RowScope.() -> Unit
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.n0),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(10.dp)
            .zIndex(10.dp.value),
        elevation = elevation,
        contentPadding = PaddingValues(0.dp)
    ) {
        if (homeIcon != null) {
            homeIcon.getPainterForImage()?.let {
                IconButton(onClick = { menuProvider?.onMenuItemClick(android.R.id.home) }) {
                    Image(
                        painter = it,
                        contentDescription = "Image",
                    )
                }
            }
        }
        content()


        if (menuProvider != null && menuProvider.provideMenu().isNotEmpty()) {

            menuProvider.provideMenu().forEach {
                if (it.icon != null) {
                    IconButton(onClick = { menuProvider.onMenuItemClick(it.id) }) {
                        Image(
                            painter = painterResource(id = it.icon),
                            contentDescription = "Image",
                        )
                    }
                } else {
                    TextButton(onClick = {
                        if (!disabledIds.contains(it.id)) {
                            menuProvider.onMenuItemClick(it.id)
                        }
                    }) {
                        Text(
                            text = it.text ?: "",
                        )
                    }
                }
            }

        }
    }
}

@Preview(showSystemUi = true, backgroundColor = 0xD9FF00FF)
@Composable
fun PreviewToolBar() {
    MainToolBar(
        title = "Title",
        subTitle = "Subtitle",
        elevation = 10.dp,
    )
}