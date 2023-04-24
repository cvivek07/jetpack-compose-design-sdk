package com.ixigo.design.sdk

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.databinding.FragmentNestedViewBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NestedViewFragment : BaseFragment() {

    private lateinit var listView: ListView
    private var _binding: FragmentNestedViewBinding? = null
    var tutorials = arrayOf(
        "Algorithms", "Data Structures",
        "Languages", "Interview Corner",
        "GATE", "ISRO CS",
        "UGC NET CS", "CS Subjects",
        "Web Technologies",
        "Algorithms", "Data Structures",
        "Languages", "Interview Corner",
        "GATE", "ISRO CS",
        "UGC NET CS", "CS Subjects",
        "Web Technologies",
        "Algorithms", "Data Structures",
        "Languages", "Interview Corner",
        "GATE", "ISRO CS",
        "UGC NET CS", "CS Subjects",
        "Web Technologies",
        "Algorithms", "Data Structures",
        "Languages", "Interview Corner",
        "GATE", "ISRO CS",
        "UGC NET CS", "CS Subjects",
        "Web Technologies"
    )
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNestedViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = binding.listview
        val arr: ArrayAdapter<String> = ArrayAdapter<String>(
            requireContext(),
            R.layout.simple_list_item_1,
            tutorials
        )
        listView.adapter = arr
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}