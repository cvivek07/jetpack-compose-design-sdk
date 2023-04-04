package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText
import com.ixigo.design.sdk.databinding.FragmentTopAppBarBinding

class TopAppBarFragment : BaseFragment() {

    private val componentList: MutableList<String> = mutableListOf(
        "Basic Tool Bar (Title Only)",
        "Basic Tool Bar (With Sub-title)",
        "SearchBar",
        "Segment Control Toolbar",
        "SRP Toolbar",
        "Tabbed Toolbar",
        "AutoComplete Text Field"
    )
    private var _binding: FragmentTopAppBarBinding? = null

    private val title = "Very Very Long Title"
    private val subTitle = "Very Very Long Sub Title"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    ShowList()
                }
            }
        }
    }

    @Composable
    fun ShowList() {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(componentList.size) { index ->
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clickable(onClick = {
                            updateToolBar(index)
                        }),
                ) {
                    TypographyText(
                        text = componentList[index],
                        textStyle = IxiTypography.Heading.H6.regular
                    )
                }
                Divider(color = Color.Black)
            }
        }
    }

    private fun updateToolBar(index: Int) {
        when (index) {
            0 -> {
                context?.let { ToolBarActivity.startActivity(it, ToolBarActivity.BASIC_TOOLBAR) }
            }
            1 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.SUBTITLED_TOOLBAR)
                }
            }
            2 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.SEARCH_TOOLBAR)
                }
            }
            3 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.SEGMENT_CONTROL_TOOLBAR)
                }
            }
            4 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.SRP_TOOLBAR)
                }
            }
            5 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.TABBED_TOOLBAR)
                }
            }
            6 -> {
                context?.let {
                    ToolBarActivity.startActivity(it, ToolBarActivity.AUTOCOMPLETE_TEXT_FIELD)
                }
            }

        }
    }

}