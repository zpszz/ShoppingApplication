package com.jpc.shoppingapplication
import com.jpc.shoppingapplication.R

class NewsInfo(// 图片的资源编号
    var pic_id: Int, // 标题
    var title: String, // 描述
    var desc: String?
) {
    var isPressed = false // 是否按下
    var id: Int = seq // 商品信息编号

    init {
        seq++
    }

    companion object {
        private var seq = 0 // 序号
        private val newsImageArray = intArrayOf(
            R.drawable.public_01,
            R.drawable.public_02,
            R.drawable.public_03,
            R.drawable.public_04,
            R.drawable.public_05
        )
        private val newsTitleArray = arrayOf(
            "首都日报", "海峡时报", "东方周末", "参照消息", "挨踢杂志"
        )
        private val newsDescArray = arrayOf(
            "北京冬奥精彩纷呈，中外健儿各显神通",
            "庆祝伟大统一，闽台两地合办中秋晚会",
            "日本新娘仰慕中土，纷纷跨海嫁往上海",
            "雅万高铁建成通车，中国标准再下一城",
            "Mate40大战iPhone12，两大豪机争上游"
        )
        val defaultList: List<NewsInfo>
            get() {
                val newsList: MutableList<NewsInfo> = ArrayList()
                for (i in newsImageArray.indices) {
                    newsList.add(
                        NewsInfo(
                            newsImageArray[i],
                            newsTitleArray[i], newsDescArray[i]
                        )
                    )
                }
                return newsList
            }
        private val gridImageArray = intArrayOf(
            R.drawable.pic_01,
            R.drawable.pic_02,
            R.drawable.pic_03,
            R.drawable.pic_04,
            R.drawable.pic_05,
            R.drawable.pic_06,
            R.drawable.pic_07,
            R.drawable.pic_08,
            R.drawable.pic_09,
            R.drawable.pic_10
        )
        private val gridTitleArray = arrayOf(
            "商场", "超市", "百货", "便利店",
            "地摊", "食杂店", "饭店", "餐厅", "会所", "菜市场"
        )
        val defaultGrid: List<NewsInfo>
            get() {
                val gridList: MutableList<NewsInfo> = ArrayList()
                for (i in gridImageArray.indices) {
                    gridList.add(
                        NewsInfo(
                            gridImageArray[i],
                            gridTitleArray[i], null
                        )
                    )
                }
                return gridList
            }
        private val stagImageArray = intArrayOf(
            R.drawable.skirt01,
            R.drawable.skirt02,
            R.drawable.skirt03,
            R.drawable.skirt04,
            R.drawable.skirt05,
            R.drawable.skirt06,
            R.drawable.skirt07,
            R.drawable.skirt08,
            R.drawable.skirt09,
            R.drawable.skirt10,
            R.drawable.skirt11,
            R.drawable.skirt12,
            R.drawable.skirt13,
            R.drawable.skirt14,
            R.drawable.skirt15,
            R.drawable.skirt16,
            R.drawable.skirt17,
            R.drawable.skirt18,
            R.drawable.skirt19,
            R.drawable.skirt20,
            R.drawable.skirt21,
            R.drawable.skirt22,
            R.drawable.skirt23
        )
        private val stagTitleArray = arrayOf(
            "促销价", "惊爆价", "跳楼价", "白菜价", "清仓价", "割肉价",
            "实惠价", "一口价", "满意价", "打折价", "腰斩价", "无人问津", "算了吧", "大声点",
            "嘘嘘", "嗯嗯", "呼呼", "呵呵", "哈哈", "嘿嘿", "嘻嘻", "嗷嗷", "喔喔"
        )
        val defaultStag: MutableList<NewsInfo>
            get() {
                val stagList: MutableList<NewsInfo> = ArrayList()
                for (i in stagImageArray.indices) {
                    stagList.add(
                        NewsInfo(
                            stagImageArray[i],
                            stagTitleArray[i], null
                        )
                    )
                }
                return stagList
            }
        private val combineImageArray = intArrayOf(
            R.drawable.cainixihuan,
            R.drawable.dapaijiadao,
            R.drawable.trip_01,
            R.drawable.trip_02,
            R.drawable.trip_03,
            R.drawable.trip_04
        )
        private val combineTitleArray = arrayOf(
            "猜你喜欢", "大牌驾到", "买哪个", "别想了", "先下单", "包你满意"
        )
        val defaultCombine: List<NewsInfo>
            get() {
                val combineList: MutableList<NewsInfo> = ArrayList()
                for (i in combineImageArray.indices) {
                    combineList.add(
                        NewsInfo(
                            combineImageArray[i],
                            combineTitleArray[i], null
                        )
                    )
                }
                return combineList
            }
        private val appiImageArray = intArrayOf(
            R.drawable.dian01,
            R.drawable.dian02,
            R.drawable.dian03,
            R.drawable.dian04,
            R.drawable.dian05,
            R.drawable.dian06,
            R.drawable.dian07,
            R.drawable.dian08,
            R.drawable.dian09,
            R.drawable.dian10,
            R.drawable.dian11,
            R.drawable.dian12,
            R.drawable.dian13,
            R.drawable.dian14,
            R.drawable.dian15
        )
        private val appiTitleArray = arrayOf(
            "双十一", "大聚惠", "爆款价",
            "就一次", "手慢无", "快点击", "付定金", "享特权", "包安装", "再返券",
            "白送你", "想得美", "干活去", "好好学", "才有钱"
        )
        val defaultAppi: MutableList<NewsInfo>
            get() {
                val appiList: MutableList<NewsInfo> = ArrayList()
                for (i in appiImageArray.indices) {
                    appiList.add(
                        NewsInfo(
                            appiImageArray[i],
                            appiTitleArray[i], null
                        )
                    )
                }
                return appiList
            }
    }
}
