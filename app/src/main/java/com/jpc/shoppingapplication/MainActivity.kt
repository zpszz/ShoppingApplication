package com.jpc.shoppingapplication

import android.os.Bundle
import android.util.LruCache
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener
import com.jpc.shoppingapplication.databinding.ActivityMainBinding
import com.jpc.shoppingapplication.ui.adapter.TabBarPagerAdapter
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val vpContent = binding.vpContent
        val rgTabBar = binding.rgTabBar
        // 设置翻页视图的适配器Adapter
        val tabBarPagerAdapter = TabBarPagerAdapter(supportFragmentManager)
        vpContent.adapter = tabBarPagerAdapter
        // 添加页面变更监听器
        vpContent.addOnPageChangeListener(object: SimpleOnPageChangeListener(){
            // 实现匿名内部类中的方法
            override fun onPageSelected(position: Int) {
                rgTabBar.check(rgTabBar.getChildAt(position).id)
            }
        })
        // 设置单选组的选中监听器
        rgTabBar.setOnCheckedChangeListener { group, checkedId ->
            for (index in 0 until rgTabBar.childCount){
                if ((rgTabBar.getChildAt(index) as RadioButton).id == checkedId){
                    vpContent.currentItem = index
                    break
                }
            }
        }
    }
}