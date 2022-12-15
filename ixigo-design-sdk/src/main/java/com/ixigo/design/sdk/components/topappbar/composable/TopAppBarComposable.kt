package com.ixigo.design.sdk.components.topappbar.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.core.view.MenuProvider
import com.ixigo.design.sdk.R
import com.ixigo.design.sdk.components.search.IxiSearchView
import com.ixigo.design.sdk.components.search.composables.SearchViewComposable
import com.ixigo.design.sdk.components.segmentedcontrol.composable.SegmentedControl
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.components.topappbar.menu.IxiMenuProvider

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