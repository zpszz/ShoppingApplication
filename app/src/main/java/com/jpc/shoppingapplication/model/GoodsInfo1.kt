package com.jpc.shoppingapplication.model

import com.jpc.shoppingapplication.R

class GoodsInfo {
    var rowid // 行号
            = 0L
    var xuhao // 序号
            = 0
    var name // 名称
            = ""
    var desc // 描述
            = ""
    var price // 价格
            = 0f
    var pic_path // 大图的保存路径
            = ""
    var pic // 大图的资源编号
            = 0

    companion object {
        // 声明一个手机商品的名称数组
        private val mNameArray = arrayOf(
            "iPhone11", "Mate30", "小米10", "OPPO Reno3", "vivo X30", "荣耀30S"
        )

        // 声明一个手机商品的描述数组
        private val mDescArray = arrayOf(
            "Apple iPhone11 256GB 绿色 4G全网通手机",
            "华为 HUAWEI Mate30 8GB+256GB 丹霞橙 5G全网通 全面屏手机",
            "小米 MI10 8GB+128GB 钛银黑 5G手机 游戏拍照手机",
            "OPPO Reno3 8GB+128GB 蓝色星夜 双模5G 拍照游戏智能手机",
            "vivo X30 8GB+128GB 绯云 5G全网通 美颜拍照手机",
            "荣耀30S 8GB+128GB 蝶羽红 5G芯片 自拍全面屏手机"
        )

        // 声明一个手机商品的价格数组
        private val mPriceArray = floatArrayOf(6299f, 4999f, 3999f, 2999f, 2998f, 2399f)

        // 声明一个手机商品的大图数组
        private val mPicArray = intArrayOf(
            R.drawable.iphone, R.drawable.huawei, R.drawable.xiaomi,
            R.drawable.oppo, R.drawable.vivo, R.drawable.rongyao
        )
        val defaultList: ArrayList<GoodsInfo>
            // 获取默认的手机信息列表
            get() {
                val goodsList = ArrayList<GoodsInfo>()
                for (i in mNameArray.indices) {
                    val info = GoodsInfo()
                    info.name = mNameArray[i]
                    info.desc = mDescArray[i]
                    info.price = mPriceArray[i]
                    info.pic = mPicArray[i]
                    goodsList.add(info)
                }
                return goodsList
            }
    }
}
