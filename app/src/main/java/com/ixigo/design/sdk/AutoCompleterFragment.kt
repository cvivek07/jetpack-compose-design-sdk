package com.ixigo.design.sdk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.listitems.base.BaseAutoCompleter
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
        val list = listOf(
            AutoCompleterData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIconRes = ImageData(
                    drawableRes = R.drawable.ic_baseline_cancel_24,
                    null,
                    null,
                    "https://images.template.net/101912/location-icon-clipart-5z262.jpg",
                    null,
                    null
                ),
                endIconRes = ImageData(
                    drawableRes = R.drawable.ic_baseline_cancel_24,
                    null,
                    null,
                    null,
                    null,
                    null
                ),
                to = "Delhi",
                from = "Mumbai",
                code = null
            ),
            AutoCompleterData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIconRes = null,
                endIconRes = ImageData(
                    drawableRes = null,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_cancel_24),
                    null,
                    null,
                    null,
                    null
                ),
                to = "Delhi",
                from = "Mumbai",
                code = "12111"
            ),
            AutoCompleterData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIconRes = null,
                endIconRes = ImageData(
                    drawableRes = R.drawable.ic_baseline_cancel_24,
                    null,
                    null,
                    null,
                    null,
                    null
                ),
                to = "Delhi",
                from = "Mumbai",
                code = "12111"
            ),
            AutoCompleterData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIconRes = null,
                endIconRes = ImageData(
                    drawableRes = null,
                    ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_cancel_24),
                    null,
                    "https://images.template.net/101912/location-icon-clipart-5z262.jpg",
                    100.dp,
                    100.dp
                ),
                to = "Delhi",
                from = "Mumbai",
                code = "12111"
            ),

        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = RecyclerAdapter(context, list)
            addItemDecoration(
                DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}

class RecyclerAdapter(val context: Context, private val list: List<AutoCompleterData>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: BaseAutoCompleter) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: AutoCompleterData) {
            (itemView as? BaseAutoCompleter)?.apply {
                data.title?.let { setTitle(it) }
                setSubTitle(data.subTitle)
                data.endIconRes?.let { setEndIcon(it) }
                data.startIconRes?.let { setIcon(it) }
                data.from?.let { setFromValue(it) }
                data.to?.let { setToValue(it) }
                setIconCode(data.code)
                setOnClickListener {
                    "ItemClick".toToast(context)
                }
                onStartIconClick {
                    "Start".toToast(context)
                }
                onEndIconClick {
                    "End".toToast(context)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val autoCompleter: BaseAutoCompleter = if (viewType % 3 == 0) {
            layoutInflater.inflate(R.layout.station_or_airport, parent, false) as BaseAutoCompleter
        } else if (viewType % 2 == 0) {
            layoutInflater.inflate(R.layout.destination, parent, false) as BaseAutoCompleter

        } else {
            layoutInflater.inflate(R.layout.recent, parent, false) as BaseAutoCompleter

        }
        return MyViewHolder(autoCompleter)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

data class AutoCompleterData(
    val startIconRes: ImageData?,
    val title: String?,
    val from: String?,
    val to: String?,
    val subTitle: String?,
    val code: String?,
    val endIconRes: ImageData?,
)

