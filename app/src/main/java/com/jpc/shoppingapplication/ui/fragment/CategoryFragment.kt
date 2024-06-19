package com.jpc.shoppingapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.databinding.FragmentCategoryBinding
import com.jpc.shoppingapplication.ui.adapter.CategoryPagerAdapter

class CategoryFragment: Fragment(){
    private lateinit var binding: FragmentCategoryBinding
    private val titleList = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as AppCompatActivity
        // 在Fragment中获取ViewBinding对象
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        // 获取toolBar
        val tlHead = binding.tlHead
        // 替换系统自带的ActionBar
        activity.setSupportActionBar(tlHead)
        titleList.add("服装")
        titleList.add("电器")
        val tabTitle = binding.tabTitle
        val vp2Content = binding.vp2Content
        // 创建一个分类页面下的适配器
        val categoryPagerAdapter = CategoryPagerAdapter(activity, titleList)
        // 设置ViewPager2的翻页适配器
        vp2Content.adapter = categoryPagerAdapter
        // 将标签布局与翻页视图通过指定策略连为一体，实现联动
        TabLayoutMediator(tabTitle, vp2Content) { tab, position -> tab.text = titleList[position] }.attach()
        return binding.root
    }
}