package com.ixigo.design.sdk

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ixigo.design.sdk.components.styles.IxiTypography
import com.ixigo.design.sdk.components.text.composable.TypographyText

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ComponentsFragment : Fragment() {

    private val componentList: MutableList<Pair<String, Int>> = mutableListOf(
        Pair("Buttons", R.id.action_ComponentFragment_to_ButtonsFragment),
        Pair("Input Fields", R.id.action_ComponentFragment_to_inputFieldFragment),
        Pair("Typography", R.id.action_componentFragment_to_typographyFragment),
        Pair("Progress Step", R.id.action_componentFragment_to_progressStepFragment),
        Pair("TopAppBar", R.id.action_componentFragment_to_topAppBarFragment),
        Pair("TabBar", R.id.action_componentFragment_to_tabBarFragment),
        Pair("AutoCompleter", R.id.action_componentFragment_to_autoCompleterFragment),
        Pair("ListItem", R.id.action_componentFragment_to_listItemFragment),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    ShowList()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.subtitle = ""
        activity?.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    0 -> {
                        true
                    }
                    else -> {
                        false
                    }

                }

            }
        })

    }

    @Composable
    fun ShowList() {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(items = componentList) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clickable(onClick = { findNavController().navigate(it.second) }),
                ) {
                    TypographyText(
                        text = it.first,
                        textStyle = IxiTypography.Heading.H6.regular,
                    )
                }
                Divider(color = Color.Black)
            }
        }
    }
}