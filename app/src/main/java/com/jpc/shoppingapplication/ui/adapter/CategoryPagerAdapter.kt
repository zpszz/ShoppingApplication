package com.jpc.shoppingapplication.ui.adapter

import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jpc.shoppingapplication.ui.fragment.AppliancesFragment
import com.jpc.shoppingapplication.ui.fragment.ClothesFragment

/**
 * ViewPager2的Adapter
 */
class CategoryPagerAdapter(fa: FragmentActivity, private val titleList: ArrayList<String>): FragmentStateAdapter(fa){
    // 获取Fragment碎片的个数，也就是页面个数
    override fun getItemCount() = titleList.size

    /**
     * 创建指定位置的Fragment
     */
    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            ClothesFragment()
        }else{
            AppliancesFragment()
        }
    }
}