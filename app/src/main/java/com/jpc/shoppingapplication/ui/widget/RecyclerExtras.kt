package com.jpc.shoppingapplication.ui.widget

import android.view.View

object RecyclerExtras {

    // 定义一个循环视图列表项的点击监听器接口
    fun interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    // 定义一个循环视图列表项的长按监听器接口
    fun interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    // 定义一个循环视图列表项的删除监听器接口
    fun interface OnItemDeleteClickListener {
        fun onItemDeleteClick(view: View, position: Int)
    }

}
