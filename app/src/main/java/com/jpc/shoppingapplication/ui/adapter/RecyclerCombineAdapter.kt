package com.jpc.shoppingapplication.ui.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jpc.shoppingapplication.MyApplication
import com.jpc.shoppingapplication.NewsInfo
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.utils.UnitUtil

class RecyclerCombineAdapter(private val context: Context, private val itemList: List<NewsInfo>): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_combine, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewHolder = holder as ItemViewHolder
        viewHolder.ivPic.setImageResource(itemList[position].pic_id)
        viewHolder.tvTitle.text = itemList[position].title
        val ivParams = viewHolder.ivPic.layoutParams
        if (position == 0 || position == 1){
            ivParams.height = UnitUtil.dip2px(MyApplication.context, 130f)
        }else{
            ivParams.height = UnitUtil.dip2px(MyApplication.context, 60f)
        }
        viewHolder.ivPic.layoutParams = ivParams
    }

    override fun getItemCount() = itemList.size

    inner class ItemViewHolder(view: View): ViewHolder(view){
        val ivPic: ImageView = view.findViewById(R.id.iv_pic)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }
}