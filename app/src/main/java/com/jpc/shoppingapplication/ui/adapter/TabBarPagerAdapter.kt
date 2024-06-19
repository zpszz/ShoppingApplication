package com.jpc.shoppingapplication.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jpc.shoppingapplication.ui.fragment.CartFragment
import com.jpc.shoppingapplication.ui.fragment.CategoryFragment
import com.jpc.shoppingapplication.ui.fragment.HomeFragment

/**
 * ViewPager的Adapter
 */
class TabBarPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getCount() = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment()
            }
            1 -> {
                CategoryFragment()
            }
            2 -> {
                CartFragment()
            }
            else -> {
                HomeFragment()
            }
        }
    }
}