package com.wpfl.heatmap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wpfl.heatmap.databinding.RowHeatmapBinding
import com.wpfl.heatmap.model.HeatMapData


class HeatMapAdapter(

) : ListAdapter<HeatMapData, RecyclerView.ViewHolder>(DiffObj) {

    companion object DiffObj : DiffUtil.ItemCallback<HeatMapData>() {
        override fun areItemsTheSame(oldItem: HeatMapData, newItem: HeatMapData): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: HeatMapData, newItem: HeatMapData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            R.layout.row_heatmap -> {
                val heatMap = getItem(position)
                (holder as HeatMapAdapter.HeatMapViewHolder).bind(heatMap)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            R.layout.row_heatmap -> HeatMapViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.row_heatmap,
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return R.layout.row_heatmap
    }


    inner class HeatMapViewHolder constructor(private val binding: RowHeatmapBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HeatMapData) {
            binding.apply {
                heatmap = item
            }
        }
    }

}