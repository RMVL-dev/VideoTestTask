package com.example.edu.videotesttask.presentation.list.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.videotesttask.GlideApp
import com.example.edu.videotesttask.data.VideoItem
import com.example.edu.videotesttask.databinding.ItemVideoBinding

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val context: Context
):RecyclerView.ViewHolder(binding.root) {

    fun bind(item: VideoItem, navigation:() -> Unit){
        binding.itemName.text = item.name
        GlideApp.with(context)
            .asBitmap()
            .load(item.url)
            .into(binding.itemThumbnail)
        binding.root.setOnClickListener {
            navigation()
        }
    }

}