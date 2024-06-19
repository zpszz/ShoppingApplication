package com.jpc.shoppingapplication.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.jpc.shoppingapplication.MyApplication
import com.jpc.shoppingapplication.NewsInfo
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.databinding.FragmentHomeBinding
import com.jpc.shoppingapplication.model.GoodsInfo
import com.jpc.shoppingapplication.ui.adapter.RecyclerCombineAdapter
import com.jpc.shoppingapplication.ui.adapter.RecyclerGridAdapter
import com.jpc.shoppingapplication.ui.adapter.RecyclerPhoneAdapter
import com.jpc.shoppingapplication.ui.widget.BannerPager
import com.jpc.shoppingapplication.ui.widget.SpacesDecoration
import com.jpc.shoppingapplication.utils.UnitUtil

class HomeFragment : Fragment(), BannerPager.BannerClickListener{
    private val TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mActivity: AppCompatActivity
    private fun getImageList(): List<Int> {
        return ArrayList<Int>().apply {
            add(R.drawable.banner_1)
            add(R.drawable.banner_2)
            add(R.drawable.banner_3)
            add(R.drawable.banner_4)
            add(R.drawable.banner_5)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mActivity = activity as AppCompatActivity
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // val view = inflater.inflate(R.layout.fragment_home, container, false)
        val tlHead = binding.tlHead
        tlHead.title = "商城首页"
        mActivity.setSupportActionBar(tlHead)
        // 初始化各个小布局
        initBanner() // 初始化广告轮播条
        initGrid() // 初始化市场网格列表
        initCombine() // 初始化猜你喜欢的商品展示网格
        initPhone() // 初始化手机网格列表
        Log.d(TAG, "HomeFragment初始化")
        return binding.root
    }

    private fun initPhone() {
        val rvPhone = binding.rvPhone
        val gridLayoutManager = GridLayoutManager(MyApplication.context, 3)
        rvPhone.layoutManager = gridLayoutManager
        // 设置Adapter
        val recyclerPhoneAdapter = RecyclerPhoneAdapter(MyApplication.context, GoodsInfo.defaultList)
        rvPhone.adapter = recyclerPhoneAdapter
        rvPhone.itemAnimator = DefaultItemAnimator()
        rvPhone.addItemDecoration(SpacesDecoration(1))
    }

    private fun initCombine() {
        val rvCombine = binding.rvCombine
        // 创建一个4列的Grid布局
        val gridLayoutManager = GridLayoutManager(MyApplication.context, 4)
        // 设置网格布局管理器的占位规则
        // 以下占位规则的意思是：第一项和第二项占两列，其它项占一列；
        // 如果网格的列数为四，那么第一项和第二项平分第一行，第二行开始每行有四项。
        gridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0 || position == 1) { // 为第一项或者第二项
                    2 // 占据两列
                } else { // 为其它项
                    1 // 占据一列
                }
            }
        }
        rvCombine.layoutManager = gridLayoutManager
        // 设置Adapter
        val recyclerCombineAdapter = RecyclerCombineAdapter(MyApplication.context, NewsInfo.defaultCombine)
        rvCombine.adapter = recyclerCombineAdapter
        rvCombine.itemAnimator = DefaultItemAnimator()
        rvCombine.addItemDecoration(SpacesDecoration(1))
    }

    private fun initGrid() {
        val rvGrid = binding.rvGrid
        // 创建一个Grid布局管理器
        val gridLayoutManager = GridLayoutManager(MyApplication.context, 5)
        rvGrid.layoutManager = gridLayoutManager
        // 创建适配器
        val recyclerGridAdapter = RecyclerGridAdapter(MyApplication.context, NewsInfo.defaultGrid)
        rvGrid.adapter = recyclerGridAdapter
        // 设置点击事件

        // 设置动画效果
        rvGrid.itemAnimator = DefaultItemAnimator()
        // 设置每一项之间的间距
        rvGrid.addItemDecoration(SpacesDecoration(1))
    }

    private fun initBanner() {
        val bannerPager = binding.bannerPager
        val params = bannerPager.layoutParams as LinearLayout.LayoutParams
        params.height = (UnitUtil.getScreenWidth(mActivity) * 250f / 640f).toInt()
        // 设置轮播图的布局参数
        bannerPager.layoutParams = params
        // 设置图片列表
        bannerPager.setImages(getImageList())
        // 设置点击监听器
        bannerPager.setOnBannerListener(this)
        // 开启轮播图
        bannerPager.start()
    }

    override fun onBannerClick(position: Int) {
        Toast.makeText(mActivity, "点击了第 ${position +1} 张轮播图", Toast.LENGTH_SHORT).show()
    }
}