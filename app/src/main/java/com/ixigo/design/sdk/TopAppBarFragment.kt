package com.ixigo.design.sdk

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.MenuProvider
import com.ixigo.design.sdk.components.topappbar.menu.MenuBuilder
import com.ixigo.design.sdk.components.topappbar.menu.addMenuItems
import com.ixigo.design.sdk.databinding.FragmentTopAppBarBinding
import com.ixigo.design.sdk.utils.DimensionUtils.dpToPx

class TopAppBarFragment : BaseFragment() {

    private val componentList: MutableList<String> = mutableListOf(
        "Basic Tool Bar (Title Only)",
        "Basic Tool Bar (With Sub-title)",
        "Basic Tool Bar (With Sub-title and Action)",
    )
    private var _binding: FragmentTopAppBarBinding? = null

    private val title = "Very Very Long Title"
    private val subTitle = "Very Very Long Sub Title"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        _binding = FragmentTopAppBarBinding.inflate(inflater, container, false)
//        return binding.root
//    }

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
                    Text(
                        text = componentList[index],
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
                Divider(color = Color.Black)
            }
        }
    }

    private fun updateToolBar(index: Int) {
        when (index) {
            0 -> {
                basicToolBar()
            }
            1 -> {
                toolbarWithSubTitleAndTwoIcons()
            }
            2 -> {
                toolbarWithSubTitleAndOneIconAndActionText()


            }

        }
    }

    private fun toolbarWithSubTitleAndOneIconAndActionText() {
        (activity as AppCompatActivity).supportActionBar?.title = title
        (activity as AppCompatActivity).supportActionBar?.subtitle = subTitle

        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                listOf(
                    MenuBuilder(0, "Send"),
                ).addMenuItems(menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    0 -> {
                        return true
                    }
                    else -> {
                        return false
                    }

                }

            }
        })

    }

    private fun toolbarWithSubTitleAndTwoIcons() {
        (activity as AppCompatActivity).supportActionBar?.title = title
        (activity as AppCompatActivity).supportActionBar?.subtitle = subTitle

        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                listOf(
                    MenuBuilder(0, null, R.drawable.ic_filter_24),
                    MenuBuilder(1, null, R.drawable.ic_baseline_share_24),
                ).addMenuItems(menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    0 -> {
                        return true
                    }
                    else -> {
                        return false
                    }

                }

            }
        })
    }

    private fun basicToolBar() {
        (activity as AppCompatActivity).supportActionBar?.title = title
        (activity as AppCompatActivity).supportActionBar?.subtitle = null
        (activity as AppCompatActivity).supportActionBar?.elevation = context?.dpToPx(10) ?: 0F
        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                listOf(
                    MenuBuilder(0, null, R.drawable.ic_baseline_cancel_24),
                    MenuBuilder(3, "Done")
                ).addMenuItems(menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    0 -> {
                        return true
                    }

                }
                return false

            }
        })
    }

}