package com.jpc.shoppingapplication.ui.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.jpc.shoppingapplication.MyApplication
import com.jpc.shoppingapplication.NewsInfo
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.databinding.FragmentClothesBinding
import com.jpc.shoppingapplication.ui.adapter.RecyclerStageAdapter
import com.jpc.shoppingapplication.ui.widget.SpacesDecoration
import java.util.Collections
import java.util.stream.Collectors.toList

class ClothesFragment: Fragment(), OnRefreshListener {
    private lateinit var binding: FragmentClothesBinding
    private lateinit var clothesList: MutableList<NewsInfo>
    private lateinit var recyclerStageAdapter: RecyclerStageAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentClothesBinding.inflate(inflater, container, false)
        // 获取对应的视图对象
        val view = inflater.inflate(R.layout.fragment_clothes, container, false)
        val srlClothes = binding.srlClothes
        val rvClothes = binding.rvClothes
        // 设置下拉布局的下拉刷新器
        srlClothes.setOnRefreshListener(this)
        // 颜色变化
        srlClothes.setColorSchemeResources(R.color.red, R.color.orange, R.color.blue)
        // 创建一个垂直方向的瀑布流管理器
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
        rvClothes.layoutManager = staggeredGridLayoutManager
        // 服装信息列表
        clothesList = NewsInfo.defaultStag
        recyclerStageAdapter = RecyclerStageAdapter(MyApplication.context, clothesList)
        rvClothes.adapter = recyclerStageAdapter
        rvClothes.itemAnimator = DefaultItemAnimator()
        rvClothes.addItemDecoration(SpacesDecoration(3))
        return binding.root
    }

    private val handler = Looper.myLooper()?.let { Handler(it) }
    private val refresh = Runnable {
        // 模拟刷新
        (clothesList.size - 1 downTo clothesList.size - 5).forEach{ i ->
            clothesList[i].also {
                clothesList.removeAt(i)
                clothesList.add(0, it)
            }}
        binding.srlClothes.isRefreshing = false // 结束刷新
        // 通知数据变化
        recyclerStageAdapter.notifyDataSetChanged()
        // 移到第一项位置
        binding.rvClothes.scrollToPosition(0)
    }
    override fun onRefresh() {
        // 模拟网络延时
        handler?.postDelayed(refresh, 2000)
    }

}