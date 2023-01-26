package com.ixigo.design.sdk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ixigo.design.sdk.components.listitems.IxiListItem
import com.ixigo.design.sdk.components.listitems.base.BaseAutoCompleter
import com.ixigo.design.sdk.components.listitems.base.BaseListItem
import com.ixigo.design.sdk.databinding.FragmentListItemBinding

class ListItemFragment : BaseFragment() {

    private var _binding: FragmentListItemBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListItemBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = listOf(
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                endIconRes = R.drawable.ic_search,
                avatar = "https://pixlr.com/images/index/remove-bg.webp"
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIconRes = R.drawable.ic_search,
                endIconRes = R.drawable.ic_search,
                startLogo = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIconRes = null,
                endIconRes = R.drawable.ic_search,
                leftCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "My subtitle is Very long in order to test the lengthy url. It can be a very large description. To add more description please continue to write vague content",
                startIconRes = null,
                endIconRes = R.drawable.ic_search,
                meta = "Delhi",
                rightCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = true,
                switchChangeListener = {}
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = false
            ),
            ListItemData(
                endIconRes = R.drawable.ic_search,
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                rightCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = "https://pixlr.com/images/index/remove-bg.webp"
            ),
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListRecyclerAdapter(context, list)
            addItemDecoration(
                DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}

class ListRecyclerAdapter(val context: Context, private val list: List<ListItemData>) :
    RecyclerView.Adapter<ListRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: IxiListItem) : RecyclerView.ViewHolder(itemView) {

        fun bind(data: ListItemData) {
            (itemView as? BaseListItem)?.apply {
                data.title?.let { setTitle(it) }
                setSubTitle(data.subTitle)
                setAvatarUrl(data.avatar)
                setMetaText(data.meta)
                setActionText(data.textButton)
                data.leftCheckBox?.let { setStartCheckedValue(it) }
                data.rightCheckBox?.let { setEndCheckedValue(it) }
                data.endIconRes?.let { setEndIcon(it) }
                data.startIconRes?.let { setStartIcon(it) }
                data.switch?.let {
                    setSwitchCheckedValue(it)
                    setSwitchCheckedChangeListener(data.switchChangeListener)
                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(IxiListItem(parent.context))
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

data class ListItemData(
    val startIconRes: Int? = null,
    val title: String?,
    val meta: String? = null,
    val textButton: String? = null,
    val subTitle: String? = null,
    val avatar: String? = null,
    val startLogo: String? = null,
    val endLogo: String? = null,
    val endIconRes: Int? = null,
    val switch: Boolean? = null,
    val switchChangeListener: (Boolean) -> Unit = {},
    val leftCheckBox: Boolean? = null,
    val rightCheckBox: Boolean? = null
)