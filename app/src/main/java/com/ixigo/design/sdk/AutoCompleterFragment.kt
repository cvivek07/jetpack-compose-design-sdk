package com.ixigo.design.sdk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import androidx.recyclerview.widget.DividerItemDecoration
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.Adapter
//import com.ixigo.design.sdk.components.listitems.IxiAutoCompleter
import com.ixigo.design.sdk.databinding.FragmentAutoCompleterBinding

class AutoCompleterFragment : BaseFragment() {

    private var _binding: FragmentAutoCompleterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAutoCompleterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = listOf<AutoCompleterData>(
            AutoCompleterData("Nearest Railway Station", null, R.drawable.ic_search, R.drawable.ic_search),
            AutoCompleterData("Nearest Airport", null, R.drawable.ic_search, R.drawable.ic_search),
            AutoCompleterData("Palam, Delhi, India", "Indra Gandhi International Airport", R.drawable.ic_search, R.drawable.ic_search),
            AutoCompleterData("Delhi ➔ Mumbai", "Indra Gandhi International Airport", R.drawable.ic_search, R.drawable.ic_search),
        )
//        binding.recyclerView.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = RecyclerAdapter(context,list)
//            addItemDecoration(
//                DividerItemDecoration(
//                    context,DividerItemDecoration.VERTICAL
//                )
//            )
//        }
    }
}

//class RecyclerAdapter(val context: Context, private val list: List<AutoCompleterData>) :
//    Adapter<RecyclerAdapter.MyViewHolder>() {
//
//    class MyViewHolder(itemView: IxiAutoCompleter) : RecyclerView.ViewHolder(itemView) {
//
//        fun bind(data: AutoCompleterData) {
//            (itemView as? IxiAutoCompleter)?.apply {
//                setTitle(data.title)
//                setSubTitle(data.subTitle)
//                setEndIcon(R.drawable.ic_baseline_cancel_24)
//                setIcon(R.drawable.ic_search)
//                setOnClickListener {
//                    "ItemClick".toToast(context)
//                }
//                onStartIconClick{
//                    "Start".toToast(context)
//                }
//                onEndIconClick{
//                    "End".toToast(context)
//                }
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val autoCompleter = IxiAutoCompleter(context = context)
//        return MyViewHolder(autoCompleter)
//    }

//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//}

data class AutoCompleterData(
    val title: String,
    val subTitle: String?,
    val startIcon: Int?,
    val endIcon: Int?
)

