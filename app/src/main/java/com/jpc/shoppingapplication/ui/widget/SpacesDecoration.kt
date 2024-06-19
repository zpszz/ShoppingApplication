package com.jpc.shoppingapplication.ui.widget

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpacesDecoration(// 空白间隔
    private val space: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        v: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = space // 左边空白间隔
        outRect.right = space // 右边空白间隔
        outRect.bottom = space // 上方空白间隔
        outRect.top = space // 下方空白间隔
    }
}
