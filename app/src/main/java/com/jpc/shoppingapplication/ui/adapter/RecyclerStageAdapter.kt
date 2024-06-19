package com.jpc.shoppingapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jpc.shoppingapplication.NewsInfo
import com.jpc.shoppingapplication.R

class RecyclerStageAdapter(private val context: Context, private val goodsList: List<NewsInfo>):
    RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staggered, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = goodsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder = holder as ItemViewHolder
        viewHolder.ivPic.setImageResource(goodsList[position].pic_id)
        viewHolder.tvTitle.text = goodsList[position].title

        // 实现点击事件
    }

    private inner class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val ivPic: ImageView = view.findViewById(R.id.iv_pic)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
        val clItemStaggered = view.findViewById<ConstraintLayout>(R.id.cl_item_staggered)
    }

}