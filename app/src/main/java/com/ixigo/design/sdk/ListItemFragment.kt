package com.ixigo.design.sdk

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ixigo.design.sdk.components.imageutils.ImageData
import com.ixigo.design.sdk.components.listitems.IxiListItem
import com.ixigo.design.sdk.components.listitems.base.BaseListItem
import com.ixigo.design.sdk.components.styles.IxiColor
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
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                startRadioButton = true,

                ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIcon = ImageData.createFromRes(R.drawable.ic_search),
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startLogo = ImageData.createFromUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"),
                endRadioButton = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = null,
                endIcon = ImageData.createFromDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_search
                    )
                ),
                startCheckBox = false,
                color = IxiColor.Extension,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "My subtitle is Very long in order to test the lengthy url. It can be a very large description. To add more description please continue to write vague content",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                meta = "Delhi",
                endCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = true,
                switchChangeListener = {},
                color = IxiColor.Error,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = false
            ),
            ListItemData(
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Orange,
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Success,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Railway Station complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Warning,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIcon = ImageData.createFromRes(R.drawable.ic_search),
                endIcon = ImageData.createFromDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_search
                    )
                ),
                startLogo = ImageData.createFromUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIcon = null,
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startCheckBox = false,
                color = IxiColor.Extension,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "My subtitle is Very long in order to test the lengthy url. It can be a very large description. To add more description please continue to write vague content",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                meta = "Delhi",
                endCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = true,
                switchChangeListener = {},
                color = IxiColor.Error,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = false
            ),
            ListItemData(
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Orange,
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Success,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Railway Station complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Warning,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIcon = ImageData.createFromRes(R.drawable.ic_search),
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startLogo = ImageData.createFromUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIcon = null,
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startCheckBox = false,
                color = IxiColor.Extension,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "My subtitle is Very long in order to test the lengthy url. It can be a very large description. To add more description please continue to write vague content",
                startIcon = null,
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                meta = "Delhi",
                endCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = true,
                switchChangeListener = {},
                color = IxiColor.Error,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = false
            ),
            ListItemData(
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Orange,
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Success,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Railway Station complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Warning,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                startIcon = ImageData.createFromRes(R.drawable.ic_search, 100.dp, 100.dp),
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startLogo = ImageData.createFromUrl("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = null,
                startIcon = null,
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                startCheckBox = false,
                color = IxiColor.Extension,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "My subtitle is Very long in order to test the lengthy url. It can be a very large description. To add more description please continue to write vague content",
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                meta = "Delhi",
                endCheckBox = false
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = true,
                switchChangeListener = {},
                color = IxiColor.Error,
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                switch = false
            ),
            ListItemData(
                endIcon = ImageData.createFromRes(R.drawable.ic_search),
                title = "Nearest Railway Station",
                subTitle = "SubTtle",
                endCheckBox = true,
                endCheckChangeListener = {
                    context?.let { it1 -> "RightCheckAdded".toToast(it1) }
                }
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Orange,
                endCheckBox = true
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Airport complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Success,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            ),
            ListItemData(
                title = "Nearest Railway Station",
                subTitle = "Railway Station complete name",
                textButton = "Action",
                avatar = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                color = IxiColor.Warning,
                endCheckBox = true,
                startCheckBox = true,
                switch = false,
                startLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp"),
                endLogo = ImageData.createFromUrl("https://pixlr.com/images/index/remove-bg.webp")
            )
        )
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ListRecyclerAdapter(context, list.toMutableList())
            addItemDecoration(
                DividerItemDecoration(
                    context, DividerItemDecoration.VERTICAL
                )
            )
        }
    }
}

class ListRecyclerAdapter(val context: Context, val list: MutableList<ListItemData>) :
    RecyclerView.Adapter<ListRecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: IxiListItem) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: ListItemData, position: Int) {
            (itemView as? BaseListItem)?.apply {
                data.title?.let { setTitle(it) }
                setSubTitle(data.subTitle)
                setAvatar(data.avatar)
                setMetaText(data.meta)
                setActionText(data.textButton)
                data.startCheckBox?.let { setStartCheckedValue(it) }
                setStartCheckedChangeListener(data.startCheckChangeListener)
                data.endCheckBox?.let { setEndCheckedValue(it) }
                setEndCheckedChangeListener(data.endCheckChangeListener)
                data.endIcon?.let { setEndIcon(it) }
                data.startIcon?.let { setStartIcon(it) }
                setSwitchCheckedValue(data.switch)
                setSwitchCheckedChangeListener(data.switchChangeListener)

                setStartRadioValue(data.startRadioButton)
                setEndRadioValue(data.endRadioButton)
                setThemeColor(data.color)

                setOnClickListener { listItem ->
                    Log.e(
                        "LIST_ITEM",
                        (listItem as? IxiListItem)?.getEndRadioValue()?.toString() ?: "null"
                    )
                    val newStartCheckBoxValue = getStartCheckedValue()?.not()
                    val newEndCheckBoxValue = getEndCheckedValue()?.not()
                    val newStartRadioBoxValue = getStartRadioValue()?.not()
                    val newEndRadioBoxValue = getEndRadioValue()?.not()
                    val newSwitchValue = getSwitchCheckedValue()?.not()


                    setStartRadioValue(newStartRadioBoxValue)
                    setStartCheckedValue(newStartCheckBoxValue)
                    setEndCheckedValue(newEndCheckBoxValue)
                    setEndRadioValue(newEndRadioBoxValue)
                    setSwitchCheckedValue(newSwitchValue)

                    val data1 = data.copy(
                        startCheckBox = newStartCheckBoxValue,
                        endCheckBox = newEndCheckBoxValue,
                        startRadioButton = newStartRadioBoxValue,
                        endRadioButton = newEndRadioBoxValue,
                        switch = newSwitchValue
                    )
                    list[position] = data1
                    notifyItemChanged(position)
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
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

data class ListItemData(
    val startIcon: ImageData? = null,
    val endIcon: ImageData? = null,
    val title: String?,
    val meta: String? = null,
    val textButton: String? = null,
    val subTitle: String? = null,
    val avatar: ImageData? = null,
    val startLogo: ImageData? = null,
    val endLogo: ImageData? = null,
    val switch: Boolean? = null,
    val switchChangeListener: (Boolean) -> Unit = {},
    val startCheckChangeListener: (Boolean) -> Unit = {},
    val endCheckChangeListener: (Boolean) -> Unit = {},
    val startCheckBox: Boolean? = null,
    val endCheckBox: Boolean? = null,
    val startRadioButton: Boolean? = null,
    val endRadioButton: Boolean? = null,
    val color: IxiColor = IxiColor.Blue
)