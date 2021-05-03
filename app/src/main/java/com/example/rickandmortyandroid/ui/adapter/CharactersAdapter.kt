package com.example.rickandmortyandroid.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyandroid.R
import com.example.rickandmortyandroid.databinding.ItemCharactersBinding
import com.example.rickandmortyandroid.model.Info

class CharactersAdapter(
    private val listCharacter: List<Info>
) : RecyclerView.Adapter<CharactersAdapter.RickAndMortyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharactersAdapter.RickAndMortyViewHolder {
        return RickAndMortyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_characters, parent, false)
        )
    }

    override fun getItemCount() = listCharacter.count()

    override fun onBindViewHolder(
        holder: CharactersAdapter.RickAndMortyViewHolder,
        position: Int
    ) {
        holder.bind(listCharacter[position])
    }

    inner class RickAndMortyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCharactersBinding.bind(itemView)
        fun bind(item: Info) {
            binding.textName.text = item.name
            Glide.with(itemView)
                .load(item.image)
                .into(binding.imageProfile)
        }
    }

}