package com.ixigo.design.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.ixigo.design.sdk.components.bottomnavigation.bottomnavbar.IxiBottomNavBar
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
            binding.bottomNav.setColor(IxiColor.Orange)
            binding.bottomNav.setIxiBottomNavItemProvider(object : IxiBottomNavBar.IxiBottomNavItemProvider {
                override fun provideMenu(): List<IxiBottomNavBar.IxiBottomNavItemModel> {
                    return mutableListOf(
                        IxiBottomNavBar.IxiBottomNavItemModel(
                            id = 0,
                            label = "Home",
                            icon = R.drawable.ic_home,
                            selectedIcon = R.drawable.ic_home_filled
                        ),
                        IxiBottomNavBar.IxiBottomNavItemModel(
                            id = 1,
                            label = "Ixigomoney",
                            icon = R.drawable.ic_iximoney,
                            selectedIcon = R.drawable.ic_iximoney_filled,
                            badgeType = BadgeType.LARGE,
                            badgeContent = "999k"
                        ),
                        IxiBottomNavBar.IxiBottomNavItemModel(
                            id = 2,
                            label = "My Trips",
                            icon = R.drawable.ic_trips,
                            selectedIcon = R.drawable.ic_trips_filled
                        ),
                        IxiBottomNavBar.IxiBottomNavItemModel(
                            id = 3,
                            label = "Contact us",
                            icon = R.drawable.ic_contact,
                            selectedIcon = R.drawable.ic_contact_filled
                        ),
                        IxiBottomNavBar.IxiBottomNavItemModel(
                            id = 4,
                            label = "More",
                            icon = R.drawable.ic_more,
                            selectedIcon = R.drawable.ic_more_filled,
                            badgeType = BadgeType.SMALL
                        ),
                    )
                }

                override fun onIxiNavItemSelected(id: Int) {
                    Toast.makeText(context, "Test $id", Toast.LENGTH_SHORT).show()
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
                            ResourcesCompat.getDrawable(resources, R.drawable.ic_search, null)?.let {
                                binding.bottomNav.setDrawableAtPosition(2, it)
                            }

                        }
                        4 -> {
                            binding.bottomNav.clearBadge(0)
                            setCurrentFragment(topAppBarFragment)
                            ResourcesCompat.getDrawable(resources, R.drawable.ic_search, null)?.let {
                                binding.bottomNav.setSelectedDrawableAtPosition(2, it)
                            }
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

}