package com.bignerdranch.android.marvelpetproject.presentation.marvel.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.marvelpetproject.databinding.ItemHeroBinding
import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.squareup.picasso.Picasso.*

class MarvelListAdapter(val clickListener: OnHeroClickListener) :
    RecyclerView.Adapter<MarvelListAdapter.HeroVH>() {

    private var items: List<MarvelData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroVH {
        val binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return HeroVH(binding)
    }

    override fun onBindViewHolder(holder: HeroVH, position: Int) {
        holder.bind(items[position])
    }

    override  fun getItemCount() = items.size

    inner class HeroVH(private val binding: ItemHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: MarvelData) {

            with(binding) {

                itemView.setOnClickListener {
                    clickListener.onHeroClick(model)
                }

                nameTV.text = model.name

                get()
                    .load(model.imageUrl)
                    .into(binding.imageMovie)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newList: List<MarvelData>) {
        items = newList
        notifyDataSetChanged()
    }

    interface OnHeroClickListener {

        fun onHeroClick(hero: MarvelData)
    }
}