package com.example.edu.videotesttask.presentation.list.adapter

import android.content.Context
import android.media.MediaMetadataRetriever
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.edu.videotesttask.data.VideoItem
import com.example.edu.videotesttask.databinding.ItemVideoBinding

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val context: Context
):RecyclerView.ViewHolder(binding.root) {

    fun bind(item: VideoItem){
        binding.itemName.text = item.name
        Glide.with(context)
            .asBitmap()
            .load(item.url)
            .into(binding.itemThumbnail)
    }

}