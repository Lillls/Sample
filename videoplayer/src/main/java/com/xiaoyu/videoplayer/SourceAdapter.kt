package com.xiaoyu.videoplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xiaoyu.videoplayer.viewmodel.SourceModelItem
import kotlinx.android.synthetic.main.item_source.view.*

class SourceAdapter : RecyclerView.Adapter<SourceAdapter.VH>() {
    private val data = mutableListOf<SourceModelItem>()

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: SourceModelItem) {
            itemView.sourceName.text = item.name
        }

    }

    fun setData(data: List<SourceModelItem>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_source, parent, false)
        return VH(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position])
    }

}
