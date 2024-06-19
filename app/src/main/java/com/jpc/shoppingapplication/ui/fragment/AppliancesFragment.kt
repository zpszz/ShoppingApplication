package com.jpc.shoppingapplication.ui.fragment

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
import com.jpc.shoppingapplication.databinding.FragmentAppliancesBinding
import com.jpc.shoppingapplication.ui.adapter.RecyclerStageAdapter
import com.jpc.shoppingapplication.ui.widget.SpacesDecoration

class AppliancesFragment: Fragment(), OnRefreshListener{
    private lateinit var binding: FragmentAppliancesBinding
    private lateinit var appliancesList: MutableList<NewsInfo>
    private lateinit var recyclerStageAdapter: RecyclerStageAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppliancesBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_appliances, container, false)
        val srlAppliances = binding.srlAppliances
        val rvAppliances = binding.rvAppliances
        // 设置下拉刷新监听器
        srlAppliances.setOnRefreshListener(this)
        srlAppliances.setColorSchemeResources(R.color.red, R.color.orange, R.color.blue)
        // 创建一个瀑布流布局管理器
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, RecyclerView.VERTICAL)
        rvAppliances.layoutManager = staggeredGridLayoutManager
        appliancesList = NewsInfo.defaultAppi
        // 设置Adapter
        recyclerStageAdapter = RecyclerStageAdapter(MyApplication.context, appliancesList)
        rvAppliances.adapter = recyclerStageAdapter
        rvAppliances.itemAnimator = DefaultItemAnimator()
        rvAppliances.addItemDecoration(SpacesDecoration(3))
        return binding.root
    }

    // 创建一个处理器对象
    private val handler = Looper.myLooper()?.let { Handler(it) }
    // 创建一个刷新任务
    private val refresh = Runnable{
        (appliancesList.size - 1 downTo appliancesList.size - 5).forEach{ i ->
            appliancesList[i].also {
                appliancesList.removeAt(i)
                appliancesList.add(0, it)
            }
        }
        binding.srlAppliances.isRefreshing = false
        recyclerStageAdapter.notifyDataSetChanged()
        binding.rvAppliances.scrollToPosition(0)
    }
    override fun onRefresh() {
        handler?.postDelayed(refresh, 2000)
    }
}