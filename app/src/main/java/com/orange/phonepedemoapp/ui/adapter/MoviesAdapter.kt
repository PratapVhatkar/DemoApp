package com.orange.phonepedemoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.orange.phonepedemoapp.R
import com.orange.phonepedemoapp.base.Constants
import com.orange.phonepedemoapp.databinding.ItemMovieBinding
import com.orange.phonepedemoapp.entity.Movies

class MoviesAdapter(private val item: Movies, context: Context) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMovieBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        )
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = item.results.get(position).title
        Glide.with(context)
            .load(Constants.BASE_IMAGE_URL + item.results.get(position).posterPath)
            .centerCrop()
            .into(holder.imgView);
    }

    override fun getItemCount(): Int {
        return item.results.size
    }
}

class CustomViewHolder(itemViewBinding: ItemMovieBinding) :
    RecyclerView.ViewHolder(itemViewBinding.root) {
    var imgView = itemViewBinding.src
    var name = itemViewBinding.name
}
