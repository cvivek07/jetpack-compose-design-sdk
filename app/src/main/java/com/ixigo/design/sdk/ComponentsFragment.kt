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
import androidx.compose.foundation.lazy.items
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
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ComponentsFragment : Fragment() {

    private val componentList: MutableList<Pair<String, Int>> = mutableListOf(
        Pair("Buttons", R.id.action_ComponentFragment_to_ButtonsFragment),
        Pair("Input Fields", R.id.action_ComponentFragment_to_inputFieldFragment),
        Pair("Typography", R.id.action_componentFragment_to_typographyFragment),
        Pair("Separator", R.id.action_componentFragment_to_separatorFragment)
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
                    Text(
                        text = it.first,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
                Divider(color = Color.Black)
            }
        }
    }
}