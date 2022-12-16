package com.ixigo.design.sdk.components.topappbar.composable

import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.zIndex
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.MODE_SCROLLABLE
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.search.composables.SearchViewComposable
import com.ixigo.design.sdk.components.segmentedcontrol.composable.SegmentedControl
import com.ixigo.design.sdk.components.srp.composables.SrpComposable
import com.ixigo.design.sdk.components.srp.composables.SrpModel
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.tabs.IxiPillTabItem
import com.ixigo.design.sdk.components.tabs.base.IxiTabLayout
import com.ixigo.design.sdk.components.tabs.base.TabType
import com.ixigo.design.sdk.components.tabs.composables.ToolbarTabsComposable
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.topappbar.TabItem
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider
import com.ixigo.design.sdk.utils.DimensionUtils.dpToPx

@Composable
fun MainToolBar(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    title: String? = null,
    subTitle: String? = null,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null
) {
    BasicToolbar(
        homeIcon = R.drawable.left_arrow,
        elevation = 10.dp,
        menuProvider = menuProvider
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
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider
    ) {
        SearchViewComposable(
            query = TextFieldValue(),
            onQueryChange = {},
            onSearchFocusChange = {},
            onClearQuery = { },
            hint = "Search",
            modifier = Modifier
                .weight(1f)
                .padding(
                    end = 15.dp
                )
        )
    }
}

@Composable
fun SegmentedControlBar(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    onItemSelection: (selectedItemIndex: Int) -> Unit
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider
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
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    data: SrpModel?,
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider
    ) {
        if (data != null) {
            SrpComposable(
                data = data,
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

@Composable
fun TabbedBar(
    modifier: Modifier = Modifier,
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    data: List<TabItem>,
    adapter: FragmentStateAdapter?,
    onItemSelection: (selectedItemIndex: Int) -> Unit,
    viewPager: ViewPager2,
    tabType: TabType = TabType.LINED
) {
    BasicToolbar(
        homeIcon = homeIcon,
        elevation = elevation,
        menuProvider = menuProvider
    ) {
        AndroidView(factory = {
            val tabLayout = IxiTabLayout(it)
            if (tabType == TabType.PILL) {
                tabLayout.setSelectedTabIndicator(null)
            }
            tabLayout.tabMode = MODE_SCROLLABLE
            tabLayout.tabRippleColor = null
            viewPager.adapter = adapter
            TabLayoutMediator(
                tabLayout, viewPager
            ) { tab, position ->
                if (tabType == TabType.PILL) {
                    val tabItem = IxiPillTabItem(it)
                    tabItem.setEndDrawable(data[position].endIcon)
                    tabItem.setStartDrawable(data[position].startIcon)
                    tabItem.setTitle(data[position].title ?: "")
                    tab.customView = tabItem
                } else {
                    val tabItem = TextView(it)
                    tabItem.text = data[position].title
                    tabItem.compoundDrawablePadding = it.dpToPx(10).toInt()
                    tabItem.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        data[position].startIcon,
                        0,
                        data[position].endIcon,
                        0
                    )
                    tab.customView = tabItem
                }
            }.attach()
            tabLayout
        })
//        ToolbarTabsComposable(
//            data = data,
//            menuProvider = menuProvider,
//            onItemSelection = onItemSelection,
//            modifier = modifier
//                .height(36.dp)
//                .weight(1f)
//                .padding(
//                    end = 15.dp
//                ),
//        )
    }
}


@Composable
fun BasicToolbar(
    @DrawableRes homeIcon: Int = R.drawable.left_arrow,
    elevation: Dp = 10.dp,
    menuProvider: IxiMenuProvider? = null,
    content: @Composable RowScope.() -> Unit
) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.n0),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(10.dp)
            .zIndex(10.dp.value),
        elevation = elevation,
        contentPadding = PaddingValues(0.dp)
    ) {
        if (homeIcon != 0) {
            IconButton(onClick = { menuProvider?.onMenuItemClick(android.R.id.home) }) {
                Image(
                    painter = painterResource(id = homeIcon),
                    contentDescription = "Image",
                )
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
                    TextButton(onClick = { menuProvider.onMenuItemClick(it.id) }) {
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