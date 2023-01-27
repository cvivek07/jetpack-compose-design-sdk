package com.ixigo.design.sdk

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavbar.IxiBottomNavBar
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.IxiBottomNavItem
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavitem.composable.BadgeType
import com.ixigo.design.sdk.components.styles.IxiColor
import com.ixigo.design.sdk.databinding.FragmentBottomNavBinding


class BottomNavFragment : Fragment() {

    private var _binding: FragmentBottomNavBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val buttonFragment = ButtonsFragment()
    val typographyFragment = TypographyFragment()
    val editTextFragment = InputFieldsFragment()
    val progressStepFragment = ProgressStepFragment()
    val topAppBarFragment = TopAppBarFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBottomNavBinding.inflate(inflater, container, false)

        context?.let {
            binding.bottomNav.setIxiBottomNavItemProvider(object : IxiBottomNavBar.IxiBottomNavItemProvider {
                override fun provideMenu(): List<IxiBottomNavItem> {
                    return mutableListOf(
                        getIxiBottomNavItem(
                            id = 0,
                            context = it,
                            label = "Home",
                            icon = R.drawable.ic_home,
                            selectedIcon = R.drawable.ic_home_filled
                        ),
                        getIxiBottomNavItem(
                            id = 1,
                            context = it,
                            label = "Ixigomoney",
                            icon = R.drawable.ic_iximoney,
                            selectedIcon = R.drawable.ic_iximoney_filled,
                            badgeType = BadgeType.LARGE,
                            badgeContent = "2"
                        ),
                        getIxiBottomNavItem(
                            id = 2,
                            context = it,
                            label = "My Trips",
                            icon = R.drawable.ic_trips,
                            selectedIcon = R.drawable.ic_trips_filled
                        ),
                        getIxiBottomNavItem(
                            id = 3,
                            context = it,
                            label = "Contact us",
                            icon = R.drawable.ic_contact,
                            selectedIcon = R.drawable.ic_contact_filled
                        ),
                        getIxiBottomNavItem(
                            id = 4,
                            context = it,
                            label = "More",
                            icon = R.drawable.ic_more,
                            selectedIcon = R.drawable.ic_more_filled,
                            badgeType = BadgeType.SMALL
                        )
                    )
                }

                override fun onIxiNavItemSelected(id: Int) {
                    when (id) {
                        0 -> {
                            setCurrentFragment(buttonFragment)
                        }
                        1 -> {
                            setCurrentFragment(typographyFragment)
                        }
                        2 -> {
                            binding.bottomNav.setBadge(0, BadgeType.SMALL)
                            setCurrentFragment(editTextFragment)

                        }
                        3 -> {
                            binding.bottomNav.setBadge(0, BadgeType.LARGE, "8")
                            setCurrentFragment(progressStepFragment)

                        }
                        4 -> {
                            binding.bottomNav.clearBadge(0)
                            setCurrentFragment(topAppBarFragment)

                        }
                    }
                }
            })
            binding.bottomNav.updatedSelectedIxiItem(0, true)
        }

        return binding.root
    }

    private fun setCurrentFragment(fragment: Fragment) =
        childFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }


    private fun getIxiBottomNavItem(
        context: Context,
        label: String,
        badgeType: BadgeType? = null,
        badgeContent: String? = null,
        @DrawableRes icon: Int,
        @DrawableRes selectedIcon: Int,
        id: Int
    ): IxiBottomNavItem {
        val item = IxiBottomNavItem(context)
        item.id = id
        item.setLabel(label)
        badgeType?.let {
            item.setBadgeType(it)
        }
        badgeContent?.let {
            item.setBadgeContent(badgeContent)
        }
        item.onClick {
            Toast.makeText(context, "Test $label", Toast.LENGTH_SHORT).show()
        }
        item.setIxiColor(IxiColor.Orange)
        item.setIcon(icon)
        item.setSelectedIcon(selectedIcon)
        return item
    }
}