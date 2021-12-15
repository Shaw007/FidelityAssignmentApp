package com.srmstudios.fidelity.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.srmstudios.fidelity.databinding.ItemSeasonBinding
import com.srmstudios.fidelity.ui.model.Season
import com.srmstudios.fidelity.util.loadHttpsUrl

class HomeAdapter : ListAdapter<Season, HomeAdapter.HomeViewHolder>(SeasonDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder.from(parent)

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val season = getItem(position)
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(season)
            }
        }
    }

    class HomeViewHolder(private val binding: ItemSeasonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(season: Season) {
            binding.txtSeasonTitle.text = season.title ?: ""
            season.imageUrl?.let { url ->
                binding.imgSeason.loadHttpsUrl(url)
            }
        }

        companion object {
            fun from(parent: ViewGroup) =
                HomeViewHolder(
                    ItemSeasonBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    class SeasonDiffUtil : DiffUtil.ItemCallback<Season>() {
        override fun areItemsTheSame(oldItem: Season, newItem: Season) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Season, newItem: Season) = oldItem == newItem
    }
}