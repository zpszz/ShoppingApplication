package com.jpc.shoppingapplication.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Looper
import android.text.TextPaint
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RelativeLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.databinding.BannerPagerBinding
import com.jpc.shoppingapplication.utils.UnitUtil
import java.util.logging.Handler

/**
 * 自定义轮播图控件
 */
class BannerPager : RelativeLayout, View.OnClickListener {
    private lateinit var binding: BannerPagerBinding
    // 轮播图播放时间
    private val mInterval = 2000
    // viewBinding
    private lateinit var mContext: Context
    // 视图对象
    private lateinit var vpBanner: ViewPager
    private lateinit var rgBanner: RadioGroup
    // ImageView 视图对象列表
    private val mViewList =  ArrayList<ImageView>()
    // 声明一个处理器对象
    // Looper.myLooper() 获取当前线程的 Looper 对象，Looper 是一个消息循环对象
    private var mHandler = Looper.myLooper()?.let { android.os.Handler(it) }
    private var mListener: BannerClickListener? = null // 声明一个广告图点击的监听器对象

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        binding = BannerPagerBinding.inflate(LayoutInflater.from(mContext), this, true)
        initView() // 初始化视图
    }


    /**
     * 初始化视图
     */
    private fun initView() {
        // 根据布局文件生成对应的视图对象
        val view = LayoutInflater.from(mContext).inflate(R.layout.banner_pager, this)
        // 获取布局文件中的控件
        vpBanner = binding.vpBanner
        rgBanner = binding.rgBanner
    }

    /**
     * 设置广告图片列表
     */
    fun setImages(imageList: List<Int>){
        // 将 15dp转换为对应的像素
        val dip_15 = UnitUtil.dip2px(mContext, 15f)
        // 根据图片生成对应的ImageView视图对象
        for (imageId in imageList){
            val view = ImageView(mContext)
            view.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            view.scaleType = ImageView.ScaleType.FIT_XY
            view.setImageResource(imageId)
            view.setOnClickListener(this)
            mViewList.add(view)
        }
        // 设置翻页视图的图像翻页适配器
        val imageAdapter = ImageAdapter()
        vpBanner.adapter = imageAdapter
        // 给翻页视图对象添加简单的页面变更监听器
        // 当页面变更时，更新底部的圆点指示器
        // object 表示创建一个匿名内部类
        vpBanner.setOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            // onPageSelected 表示页面被选中时调用
            override fun onPageSelected(position: Int) {
                setButton(position)
            }
        })
        // 根据图片列表生成对应的指示按钮列表
        for (i in mViewList.indices){
            val radioButton = RadioButton(mContext)
            // 传入像素值
            radioButton.layoutParams = LayoutParams(dip_15, dip_15)
            radioButton.gravity = Gravity.CENTER
            radioButton.buttonDrawable = AppCompatResources.getDrawable(mContext, R.drawable.indicator_selector)
            rgBanner.addView(radioButton)
        }
        // 设置翻页视图显示第一页
        vpBanner.currentItem = 0
        setButton(0)
    }

    private fun setButton(position: Int) {
        // 选中状态
        (rgBanner.getChildAt(position) as RadioButton).isChecked = true
    }

    /**
     * 定义一个滚动任务
     */
    private val mScroll = object: Runnable{
        // object 表示创建一个匿名内部类，实现了 Runnable 接口
        // 重写 run 方法，创建一个任务
        override fun run() {
            scrollToNext() // 滚动广告图片
            // 通过 Handler 发送一个延迟消息
            mHandler?.postDelayed(this, mInterval.toLong())
        }
    }

    fun scrollToNext(){
        // 下一张轮播图的位置
        var nextPosition = vpBanner.currentItem + 1
        if(nextPosition >= mViewList.size){
            nextPosition = 0
        }
        vpBanner.currentItem = nextPosition
    }

    /**
     * 设置轮播图的点击事件
     */
    override fun onClick(v: View?) {
        // 获取当前展示的轮播图序号
        val position = vpBanner.currentItem
        mListener?.onBannerClick(position) // 触发点击监听器的onBannerClick方法
    }
    // 设置广告图的点击监听器
    fun setOnBannerListener(listener: BannerClickListener) {
        mListener = listener
    }

    fun start() {
        mHandler?.postDelayed(mScroll, 2000)
    }

    // 定义一个广告图片的点击监听器接口
    interface BannerClickListener {
        fun onBannerClick(position: Int)
    }

    private inner class ImageAdapter: PagerAdapter(){
        override fun getCount() = mViewList.size

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            // == 比较两个对象的内容是否相等
            // === 比较两个对象是否指向内存中的同一个地址
            return view === `object`
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(mViewList[position])
            return mViewList[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(mViewList[position])
        }
    }
}